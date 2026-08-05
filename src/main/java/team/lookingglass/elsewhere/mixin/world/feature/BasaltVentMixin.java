package team.lookingglass.elsewhere.mixin.world.feature;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.BasaltPillarFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import team.lookingglass.elsewhere.registry.EBlocks;

@Mixin(BasaltPillarFeature.class)
public class BasaltVentMixin {
    @WrapOperation(method = "place", at = @At(
            value = "INVOKE", target = "Lnet/minecraft/world/level/WorldGenLevel;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z")
    )
    private boolean custom$replaceTopBlock(WorldGenLevel level, BlockPos pos, BlockState state, int flags, Operation<Boolean> original, FeaturePlaceContext<NoneFeatureConfiguration> context) {
        if (pos.equals(context.origin()) && state.is(Blocks.BASALT)) {
            if (context.random().nextFloat() < 0.15f) {
                return original.call(level, pos, EBlocks.BASALT_VENT.defaultBlockState(), flags);
            }
        }
        return original.call(level, pos, state, flags);
    }
}