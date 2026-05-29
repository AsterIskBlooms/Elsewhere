package team.lookingglass.elsewhere.worldgen.features.spike;

import com.mojang.serialization.Codec;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeBlockSet;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeConfiguration;
import team.lookingglass.elsewhere.worldgen.features.spike.utils.SpikeHelper;

public class SpikeFeature extends Feature<SpikeConfiguration> {

    private final SpikeBlockSet blocks;

    public SpikeFeature(Codec<SpikeConfiguration> codec, SpikeBlockSet blocks) {
        super(codec);
        this.blocks = blocks;
    }

    @Override
    public boolean place(FeaturePlaceContext<SpikeConfiguration> context) {
        LevelAccessor level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        SpikeConfiguration config = context.config();

        Optional<Direction> tipDirection = getTipDirection(level, pos, random);
        if (tipDirection.isEmpty()) return false;

        BlockPos rootPos = pos.relative(tipDirection.get().getOpposite());
        createPatchOfBaseBlocks(level, random, rootPos, config);

        float roll = random.nextFloat();
        int height = roll < 0.3f ? 1
                : roll < 0.7f ? 3
                  : SpikeHelper.isEmptyOrWater(level.getBlockState(pos.relative(tipDirection.get()))) ? 4 : 2;

        SpikeHelper.growSpike(level, blocks, pos, tipDirection.get(), height, false);
        return true;
    }

    private Optional<Direction> getTipDirection(LevelAccessor level, BlockPos pos, RandomSource random) {
        boolean above = SpikeHelper.isSpikeBase(level.getBlockState(pos.above()), blocks);
        boolean below = SpikeHelper.isSpikeBase(level.getBlockState(pos.below()), blocks);
        if (above && below) return Optional.of(random.nextBoolean() ? Direction.DOWN : Direction.UP);
        if (above)          return Optional.of(Direction.DOWN);
        if (below)          return Optional.of(Direction.UP);
        return Optional.empty();
    }

    private void createPatchOfBaseBlocks(LevelAccessor level, RandomSource random, BlockPos pos, SpikeConfiguration config) {
        SpikeHelper.placeBaseBlockIfPossible(level, blocks, pos);
        for (Direction direction : Plane.HORIZONTAL) {
            if (random.nextFloat() > config.chanceOfDirectionalSpread()) continue;
            BlockPos pos1 = pos.relative(direction);
            SpikeHelper.placeBaseBlockIfPossible(level, blocks, pos1);
            if (random.nextFloat() > config.chanceOfSpreadRadius2()) continue;
            BlockPos pos2 = pos1.relative(Direction.getRandom(random));
            SpikeHelper.placeBaseBlockIfPossible(level, blocks, pos2);
            if (random.nextFloat() > config.chanceOfSpreadRadius3()) continue;
            BlockPos pos3 = pos2.relative(Direction.getRandom(random));
            SpikeHelper.placeBaseBlockIfPossible(level, blocks, pos3);
        }
    }
}