package team.lookingglass.elsewhere.worldgen.features.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import team.lookingglass.elsewhere.worldgen.EFeatures;

import java.util.function.Function;

public class PoplarFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PoplarFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((i) -> foliagePlacerParts(i).and(i.group(
            IntProviders.codec(5, 16).fieldOf("height").forGetter((p) -> p.height),
            Codec.floatRange(0.0F, 1.0F).fieldOf("side_hole_chance").forGetter((p) -> p.sideHoleChance)
    )).apply(i, PoplarFoliagePlacer::new));

    private final IntProvider height;
    private final float sideHoleChance;

    public PoplarFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height, float sideHoleChance) {
        super(radius, offset);
        this.height = height;
        this.sideHoleChance = sideHoleChance;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EFeatures.POPLAR_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(WorldGenLevel level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int treeHeight, FoliageAttachment attachment, int foliageHeight, int leafRadius, int offset) {
        boolean doubleTrunk = attachment.doubleTrunk();
        BlockPos foliagePos = attachment.pos().above(offset);
        int currentRadius = leafRadius + attachment.radiusOffset() - 1;
        boolean flip = random.nextBoolean();

        this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius - 2, foliageHeight - 1, doubleTrunk, foliageHeight, flip);
        this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius - 1, foliageHeight - 2, doubleTrunk, foliageHeight, flip);
        this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius - 1, foliageHeight - 3, doubleTrunk, foliageHeight, flip);

        for (int y = foliageHeight - 4; y >= 1; --y) {
            this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius, y, doubleTrunk, foliageHeight, flip);
        }

        this.replaceLeavesWithLog(level, foliageSetter, config, random, foliagePos, currentRadius, foliageHeight - 4, doubleTrunk, foliageHeight, flip);
        this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, currentRadius - 1, 0, doubleTrunk, foliageHeight, flip);
        this.placeLeavesRow(level, foliageSetter, random, config, foliagePos, Mth.clamp(currentRadius - 2, 1, 2), -1, doubleTrunk, foliageHeight, flip);
    }

    private void replaceLeavesWithLog(WorldGenLevel level, FoliageSetter foliageSetter, TreeConfiguration config, RandomSource random, BlockPos origin, int currentRadius, int y, boolean doubleTrunk, int foliageHeight, boolean flip) {
        int offset = doubleTrunk ? 1 : 0;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int dx = -currentRadius; dx <= currentRadius + offset; ++dx) {
            for (int dz = -currentRadius; dz <= currentRadius + offset; ++dz) {
                int absDx = Math.abs(dx);
                int absDz = Math.abs(dz);
                if (isWithinRhombusShape(currentRadius, absDx, absDz, this.getCornerBlocksToCutForRhombusShape(dx, dz, currentRadius, this.shouldRowBePartialRhombusShape(foliageHeight, y), flip), 2)
                        && (absDz == 0 && currentRadius - absDx >= 4 || absDx == 0 && currentRadius - absDz >= 4)) {
                    pos.setWithOffset(origin, dx, y, dz);
                    tryPlaceLog(level, foliageSetter, random, config, pos, getSidewaysStateModifier(Direction.fromAxisAndDirection(absDz == 0 ? Direction.Axis.X : Direction.Axis.Z, Direction.AxisDirection.POSITIVE)));
                }
            }
        }
    }

    private static void tryPlaceLog(WorldGenLevel level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, BlockPos pos, Function<BlockState, BlockState> stateModifier) {
        if (level.isStateAtPosition(pos, (state) -> state.equals(config.foliageProvider.getState(level, random, pos)))) {
            foliageSetter.set(pos, stateModifier.apply(config.trunkProvider.getState(level, random, pos)));
        }
    }

    private static Function<BlockState, BlockState> getSidewaysStateModifier(Direction branchDirection) {
        return (state) -> state.hasProperty(BlockStateProperties.AXIS) ? state.setValue(BlockStateProperties.AXIS, branchDirection.getAxis()) : state;
    }

    @Override
    public int foliageHeight(RandomSource random, int treeHeight, TreeConfiguration config) {
        return this.height.sample(random);
    }

    private void placeLeavesRow(WorldGenLevel level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, BlockPos origin, int currentRadius, int y, boolean doubleTrunk, int foliageHeight, boolean flip) {
        int offset = doubleTrunk ? 1 : 0;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int dx = -currentRadius; dx <= currentRadius + offset; ++dx) {
            for (int dz = -currentRadius; dz <= currentRadius + offset; ++dz) {
                if (!this.shouldSkipLocation(random, dx, y, dz, currentRadius, doubleTrunk, foliageHeight, flip)) {
                    pos.setWithOffset(origin, dx, y, dz);
                    tryPlaceLeaf(level, foliageSetter, random, config, pos);
                }
            }
        }
    }

    private boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk, int foliageHeight, boolean flip) {
        boolean partial = this.shouldRowBePartialRhombusShape(foliageHeight, y);
        int cornerCut = this.getCornerBlocksToCutForRhombusShape(dx, dz, currentRadius, partial, flip);
        int absDx = Math.abs(dx);
        int absDz = Math.abs(dz);
        boolean isEdge = absDx == currentRadius || absDz == currentRadius;

        if (partial && isEdge) return true;
        int additionalSideRemoval = random.nextFloat() <= this.sideHoleChance ? 1 : 0;
        return !isWithinRhombusShape(currentRadius, absDx, absDz, cornerCut, additionalSideRemoval);
    }

    @Override
    protected boolean shouldSkipLocationSigned(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        throw new IllegalStateException("Overridden method needs more context");
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        throw new IllegalStateException("Overridden method needs more context");
    }

    private int getCornerBlocksToCutForRhombusShape(int dx, int dz, int currentRadius, boolean partial, boolean flip) {
        boolean isSmallCorner = flip ? isLeftTopOrRightLowerCorner(dx, dz) : isLeftLowerOrRightTopCorner(dx, dz);
        return isSmallCorner ? currentRadius - 1 : (partial ? currentRadius + 1 : currentRadius);
    }

    private static boolean isWithinRhombusShape(int currentRadius, int absDx, int absDz, int cornerCut, int additionalSideRemoval) {
        return absDx + absDz <= currentRadius * 2 - (cornerCut + additionalSideRemoval);
    }

    private static boolean isLeftLowerOrRightTopCorner(int dx, int dz) {
        return dx > 0 && dz < 0 || dz > 0 && dx < 0;
    }

    private static boolean isLeftTopOrRightLowerCorner(int dx, int dz) {
        return dx > 0 && dz > 0 || dz < 0 && dx < 0;
    }

    private boolean shouldRowBePartialRhombusShape(int foliageHeight, int y) {
        return foliageHeight - 1 == y || foliageHeight - 2 == y;
    }
}