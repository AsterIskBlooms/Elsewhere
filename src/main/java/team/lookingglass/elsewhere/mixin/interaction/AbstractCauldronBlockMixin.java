package team.lookingglass.elsewhere.mixin.interaction;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import team.lookingglass.elsewhere.registry.blocktypes.SpikeBlock;

@Mixin(AbstractCauldronBlock.class)
public abstract class AbstractCauldronBlockMixin {

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/PointedDripstoneBlock;findStalactiteTipAboveCauldron(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/core/BlockPos;"))
    private BlockPos elsewhere$findStalactiteTipAboveCauldron(Level level, BlockPos cauldronPos) {
        BlockPos vanillaTip = PointedDripstoneBlock.findStalactiteTipAboveCauldron(level, cauldronPos);
        if (vanillaTip != null) {
            return vanillaTip;
        }
        return SpikeBlock.findStalactiteTipAboveCauldron(level, cauldronPos);
    }

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/PointedDripstoneBlock;getCauldronFillFluidType(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/material/Fluid;"))
    private Fluid elsewhere$getCauldronFillFluidType(ServerLevel level, BlockPos stalactitePos) {
        BlockState state = level.getBlockState(stalactitePos);
        if (state.getBlock() instanceof SpikeBlock spike) {
            return SpikeBlock.getCauldronFillFluidType(level, stalactitePos, spike);
        }
        return PointedDripstoneBlock.getCauldronFillFluidType(level, stalactitePos);
    }
}