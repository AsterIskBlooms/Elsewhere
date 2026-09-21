package team.lookingglass.elsewhere.mixin.entity;

import net.minecraft.world.entity.monster.Slime;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Slime.class)
public class SlimeMixin {
    @ModifyVariable(method = "checkSlimeSpawnRules", at = @At("STORE"), name = "slimeChunk")
    private static boolean elsewhere$removeSlimeChunkCheck(boolean slimeChunk) {
        return true;
    }
}
