package team.lookingglass.elsewhere.worldgen.features;

import com.mojang.serialization.Codec;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import team.lookingglass.elsewhere.worldgen.features.utils.SulfurSpikeConfiguration;
import team.lookingglass.elsewhere.worldgen.features.utils.SulfurUtils;

public class SulfurSpikeFeature extends Feature<SulfurSpikeConfiguration> {
    public SulfurSpikeFeature(final Codec<SulfurSpikeConfiguration> codec) {
        super(codec);
    }

    public boolean place(final FeaturePlaceContext<SulfurSpikeConfiguration> context) {
        LevelAccessor level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        SulfurSpikeConfiguration config = (SulfurSpikeConfiguration)context.config();
        Optional<Direction> tipDirection = getTipDirection(level, pos, random);
        if (tipDirection.isEmpty()) {
            return false;
        } else {
            BlockPos rootPos = pos.relative(((Direction)tipDirection.get()).getOpposite());
            createPatchOfSulfurBlocks(level, random, rootPos, config);
            float roll = random.nextFloat();
            int height = roll < 0.3f ? 1
                    : roll < 0.7f ? 3
                    : SulfurUtils.isEmptyOrWater(level.getBlockState(pos.relative((Direction)tipDirection.get()))) ? 4 : 2;
            SulfurUtils.growSulfurSpike(level, pos, (Direction)tipDirection.get(), height, false);
            return true;
        }
    }

    private static Optional<Direction> getTipDirection(final LevelAccessor level, final BlockPos pos, final RandomSource random) {
        boolean canPlaceAbove = SulfurUtils.isSulfurBase(level.getBlockState(pos.above()));
        boolean canPlaceBelow = SulfurUtils.isSulfurBase(level.getBlockState(pos.below()));
        if (canPlaceAbove && canPlaceBelow) {
            return Optional.of(random.nextBoolean() ? Direction.DOWN : Direction.UP);
        } else if (canPlaceAbove) {
            return Optional.of(Direction.DOWN);
        } else {
            return canPlaceBelow ? Optional.of(Direction.UP) : Optional.empty();
        }
    }

    private static void createPatchOfSulfurBlocks(final LevelAccessor level, final RandomSource random, final BlockPos pos, final SulfurSpikeConfiguration config) {
        SulfurUtils.placeSulfurBlockIfPossible(level, pos);

        for(Direction direction : Plane.HORIZONTAL) {
            if (!(random.nextFloat() > config.chanceOfDirectionalSpread())) {
                BlockPos pos1 = pos.relative(direction);
                SulfurUtils.placeSulfurBlockIfPossible(level, pos1);
                if (!(random.nextFloat() > config.chanceOfSpreadRadius2())) {
                    BlockPos pos2 = pos1.relative(Direction.getRandom(random));
                    SulfurUtils.placeSulfurBlockIfPossible(level, pos2);
                    if (!(random.nextFloat() > config.chanceOfSpreadRadius3())) {
                        BlockPos pos3 = pos2.relative(Direction.getRandom(random));
                        SulfurUtils.placeSulfurBlockIfPossible(level, pos3);
                    }
                }
            }
        }

    }
}

