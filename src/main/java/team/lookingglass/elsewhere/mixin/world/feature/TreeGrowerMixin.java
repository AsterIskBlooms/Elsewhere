package team.lookingglass.elsewhere.mixin.world.feature;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lookingglass.elsewhere.worldgen.EConfiguredFeatures;

import java.util.Optional;

@Mixin(TreeGrower.class)
public class TreeGrowerMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void elsewhere$treeChanges(CallbackInfo ci) {
        TreeGrower.ACACIA = new TreeGrower("acacia", Optional.of(EConfiguredFeatures.MEGA_ACACIA_KEY), Optional.of(TreeFeatures.ACACIA), Optional.empty());
        TreeGrower.BIRCH = new TreeGrower("birch", Optional.empty(), Optional.of(EConfiguredFeatures.RANDOM_BIRCH), Optional.empty());
    }
}