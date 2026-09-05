package team.lookingglass.elsewhere.registry.blocktypes;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.List;
import java.util.Optional;

public class AridGrassBlock extends SpreadingSnowyBlock implements BonemealableBlock {
    public static final MapCodec<AridGrassBlock> CODEC = simpleCodec(AridGrassBlock::new);
    public AridGrassBlock(BlockBehaviour.Properties properties) {
        super(properties, EBlocks.ARID_DIRT_KEY);
    }

    @Override
    protected MapCodec<AridGrassBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.above()).isAir() && level.isInsideBuildHeight(pos.above());
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(final ServerLevel level, final RandomSource random, final BlockPos pos, final BlockState state) {
        BlockPos above = pos.above();
        BlockState grass = Blocks.SHORT_GRASS.defaultBlockState();
        Optional<Holder.Reference<PlacedFeature>> grassFeature = level.registryAccess().lookupOrThrow(Registries.PLACED_FEATURE).get(VegetationPlacements.GRASS_BONEMEAL);

        grow:
        for(int j = 0; j < 128; ++j) {
            BlockPos testPos = above;

            for(int i = 0; i < j / 16; ++i) {
                testPos = testPos.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!level.getBlockState(testPos.below()).is(this) || level.getBlockState(testPos).isCollisionShapeFullBlock(level, testPos)) {
                    continue grow;
                }
            }

            BlockState testState = level.getBlockState(testPos);
            if (testState.is(grass.getBlock()) && random.nextInt(10) == 0) {
                BonemealableBlock bonemealableBlock = (BonemealableBlock)grass.getBlock();
                if (bonemealableBlock.isValidBonemealTarget(level, testPos, testState)) {
                    bonemealableBlock.performBonemeal(level, random, testPos, testState);
                }
            }

            if (testState.isAir() && !level.isOutsideBuildHeight(testPos)) {
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> features = (level.getBiome(testPos).value()).getGenerationSettings().getBoneMealFeatures();
                    if (!features.isEmpty()) {
                        ConfiguredFeature<?, ?> placementFeature = Util.getRandom(features, random);
                        placementFeature.place(level, level.getChunkSource().getGenerator(), random, testPos);
                    }
                } else if (grassFeature.isPresent()) {
                    ((grassFeature.get()).value()).place(level, level.getChunkSource().getGenerator(), random, testPos);
                }
            }
        }
    }
}