package team.lookingglass.elsewhere.worldgen.features.spike;

import com.mojang.serialization.Codec;
import java.util.Optional;
import java.util.OptionalInt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeBlockSet;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeClusterConfiguration;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeHelper;

public class SpikeClusterFeature extends Feature<SpikeClusterConfiguration> {

    private final SpikeBlockSet blocks;

    public SpikeClusterFeature(Codec<SpikeClusterConfiguration> codec, SpikeBlockSet blocks) {
        super(codec);
        this.blocks = blocks;
    }

    @Override
    public boolean place(FeaturePlaceContext<SpikeClusterConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        SpikeClusterConfiguration config = context.config();
        RandomSource random = context.random();

        if (!SpikeHelper.isEmptyOrWater(level, origin)) return false;

        int height  = config.height().sample(random);
        float wetness = config.wetness().sample(random);
        float density = config.density().sample(random);
        int xRadius = config.radius().sample(random);
        int zRadius = config.radius().sample(random);

        for (int dx = -xRadius; dx <= xRadius; dx++) {
            for (int dz = -zRadius; dz <= zRadius; dz++) {
                double chance = getChanceOfStalagmiteOrStalactite(xRadius, zRadius, dx, dz, config);
                placeColumn(level, random, origin.offset(dx, 0, dz), dx, dz, wetness, chance, height, density, config);
            }
        }
        return true;
    }

    private void placeColumn(WorldGenLevel level, RandomSource random, BlockPos pos,
                             int dx, int dz, float chanceOfWater,
                             double chanceOfStalagmiteOrStalactite,
                             int clusterHeight, float density,
                             SpikeClusterConfiguration config) {

        Optional<Column> baseColumn = Column.scan(level, pos,
                config.floorToCeilingSearchRange(),
                SpikeHelper::isEmptyOrWater,
                SpikeHelper::isNeitherEmptyNorWater);
        if (baseColumn.isEmpty()) return;

        OptionalInt ceiling  = baseColumn.get().getCeiling();
        OptionalInt baseFloor = baseColumn.get().getFloor();
        if (ceiling.isEmpty() && baseFloor.isEmpty()) return;

        boolean wantPool = random.nextFloat() < chanceOfWater;
        Column column;
        if (wantPool && baseFloor.isPresent() && canPlacePool(level, pos.atY(baseFloor.getAsInt()))) {
            int floorY = baseFloor.getAsInt();
            column = baseColumn.get().withFloor(OptionalInt.of(floorY - 1));
            level.setBlock(pos.atY(floorY), Blocks.WATER.defaultBlockState(), 2);
        } else {
            column = baseColumn.get();
        }

        OptionalInt floor = column.getFloor();

        boolean wantStalactite = random.nextDouble() < chanceOfStalagmiteOrStalactite;
        int stalactiteHeight = 0;
        if (ceiling.isPresent() && wantStalactite && !isLava(level, pos.atY(ceiling.getAsInt()))) {
            int thickness = config.dripstoneBlockLayerThickness().sample(random);
            replaceWithBaseBlocks(level, pos.atY(ceiling.getAsInt()), thickness, Direction.UP);
            int maxH = floor.isPresent()
                    ? Math.min(clusterHeight, ceiling.getAsInt() - floor.getAsInt())
                    : clusterHeight;
            stalactiteHeight = getSpikeHeight(random, dx, dz, density, maxH, config);
        }

        boolean wantStalagmite = random.nextDouble() < chanceOfStalagmiteOrStalactite;
        int stalagmiteHeight = 0;
        if (floor.isPresent() && wantStalagmite && !isLava(level, pos.atY(floor.getAsInt()))) {
            int thickness = config.dripstoneBlockLayerThickness().sample(random);
            replaceWithBaseBlocks(level, pos.atY(floor.getAsInt()), thickness, Direction.DOWN);
            stalagmiteHeight = ceiling.isPresent()
                    ? Math.max(0, stalactiteHeight + Mth.randomBetweenInclusive(random,
                    -config.maxStalagmiteStalactiteHeightDiff(),
                    config.maxStalagmiteStalactiteHeightDiff()))
                    : getSpikeHeight(random, dx, dz, density, clusterHeight, config);
        }

        int actualStalactiteHeight;
        int actualStalagmiteHeight;
        if (ceiling.isPresent() && floor.isPresent()
                && ceiling.getAsInt() - stalactiteHeight <= floor.getAsInt() + stalagmiteHeight) {
            int floorY   = floor.getAsInt();
            int ceilingY = ceiling.getAsInt();
            int lowestBottom = Math.max(ceilingY - stalactiteHeight, floorY + 1);
            int highestTop   = Math.min(floorY + stalagmiteHeight, ceilingY - 1);
            int actualBottom = Mth.randomBetweenInclusive(random, lowestBottom, highestTop + 1);
            actualStalactiteHeight = ceilingY - actualBottom;
            actualStalagmiteHeight = (actualBottom - 1) - floorY;
        } else {
            actualStalactiteHeight = stalactiteHeight;
            actualStalagmiteHeight = stalagmiteHeight;
        }

        boolean mergeTips = random.nextBoolean()
                && actualStalactiteHeight > 0 && actualStalagmiteHeight > 0
                && column.getHeight().isPresent()
                && actualStalactiteHeight + actualStalagmiteHeight == column.getHeight().getAsInt();

        if (ceiling.isPresent())
            SpikeHelper.growSpike(level, blocks, pos.atY(ceiling.getAsInt() - 1), Direction.DOWN, actualStalactiteHeight, mergeTips);
        if (floor.isPresent())
            SpikeHelper.growSpike(level, blocks, pos.atY(floor.getAsInt() + 1), Direction.UP, actualStalagmiteHeight, mergeTips);
    }

    private boolean isLava(LevelReader level, BlockPos pos) {
        return level.getBlockState(pos).is(Blocks.LAVA);
    }

    private int getSpikeHeight(RandomSource random, int dx, int dz, float density, int maxHeight, SpikeClusterConfiguration config) {
        if (random.nextFloat() > density) return 0;
        int dist = Math.abs(dx) + Math.abs(dz);
        float mean = (float) Mth.clampedMap(dist, 0,
                config.maxDistanceFromCenterAffectingHeightBias(),
                maxHeight / 2.0, 0.0);
        return (int) ClampedNormalFloat.sample(random, mean, config.heightDeviation(), 0, maxHeight);
    }

    private boolean canPlacePool(WorldGenLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.is(Blocks.WATER) || state.is(blocks.baseBlock()) || state.is(blocks.spikeBlock())) return false;
        if (level.getBlockState(pos.above()).getFluidState().is(FluidTags.WATER)) return false;
        for (Direction dir : Plane.HORIZONTAL)
            if (!canBeAdjacentToWater(level, pos.relative(dir))) return false;
        return canBeAdjacentToWater(level, pos.below());
    }

    private boolean canBeAdjacentToWater(LevelAccessor level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return state.is(BlockTags.BASE_STONE_OVERWORLD) || state.getFluidState().is(FluidTags.WATER);
    }

    private void replaceWithBaseBlocks(WorldGenLevel level, BlockPos firstPos, int maxCount, Direction direction) {
        BlockPos.MutableBlockPos pos = firstPos.mutable();
        for (int i = 0; i < maxCount; i++) {
            if (!SpikeHelper.placeBaseBlockIfPossible(level, blocks, pos)) return;
            pos.move(direction);
        }
    }

    private double getChanceOfStalagmiteOrStalactite(int xRadius, int zRadius, int dx, int dz, SpikeClusterConfiguration config) {
        int xDist = xRadius - Math.abs(dx);
        int zDist = zRadius - Math.abs(dz);
        int dist  = Math.min(xDist, zDist);
        return Mth.clampedMap(dist, 0,
                config.maxDistanceFromEdgeAffectingChanceOfColumn(),
                config.chanceOfColumnAtMaxDistanceFromCenter(), 1.0f);
    }
}