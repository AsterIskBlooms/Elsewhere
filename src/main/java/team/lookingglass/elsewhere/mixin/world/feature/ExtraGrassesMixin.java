package team.lookingglass.elsewhere.mixin.world.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowyBlock;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.Optional;

@Mixin(SpreadingSnowyBlock.class)
abstract class ExtraGrassesMixin extends SnowyBlock {

    protected ExtraGrassesMixin(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Shadow
    @Final
    private ResourceKey<Block> baseBlock;

    @Shadow
    private static boolean canStayAlive(BlockState state, LevelReader level, BlockPos pos) {
        throw new AssertionError();
    }

    @Shadow
    private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
        throw new AssertionError();
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void elsewhere$crossFamilySpread(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        Registry<Block> blocks = level.registryAccess().lookupOrThrow(Registries.BLOCK);
        Optional<Block> base = blocks.getOptional(this.baseBlock);
        if (base.isEmpty()) {
            ci.cancel();
            return;
        }

        if (!canStayAlive(state, level, pos)) {
            level.setBlockAndUpdate(pos, base.get().defaultBlockState());
            ci.cancel();
            return;
        }

        if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            for (int i = 0; i < 4; ++i) {
                BlockPos testPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                Block targetBlock = level.getBlockState(testPos).getBlock();
                Block grassResult = EBlocks.DIRT_TO_GRASS.get(targetBlock);
                if (grassResult != null) {
                    BlockState placedDefault = grassResult.defaultBlockState();
                    if (canPropagate(placedDefault, level, testPos)) {
                        level.setBlockAndUpdate(testPos, placedDefault.setValue(SNOWY, isSnowySetting(level.getBlockState(testPos.above()))));
                    }
                }
            }
        }

        ci.cancel();
    }
}