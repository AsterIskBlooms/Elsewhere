package team.lookingglass.constructure.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.lookingglass.constructure.registry.CSounds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Mixin(BlockBehaviour.class)
public class SoundMixin {

    private static final Map<SoundType, Set<String>> SOUND_OVERRIDES;
    static {
        Map<SoundType, Set<String>> map = new HashMap<>();
        map.put(SoundType.DRIPSTONE_BLOCK, Set.of(
                "blackstone",
                "blackstone_stairs",
                "blackstone_slab",
                "blackstone_wall",
                "polished_blackstone",
                "polished_blackstone_stairs",
                "polished_blackstone_slab",
                "polished_blackstone_wall",
                "polished_blackstone_bricks",
                "polished_blackstone_brick_slab",
                "polished_blackstone_brick_stairs",
                "polished_blackstone_brick_wall",
                "cracked_polished_blackstone_bricks",
                "chiseled_polished_blackstone",
                "gilded_blackstone"
        ));
        map.put(CSounds.END_STONE, Set.of(
                "end_stone",
                "end_stone_bricks",
                "end_stone_brick_stairs",
                "end_stone_brick_slab",
                "end_stone_brick_wall"
        ));
        SOUND_OVERRIDES = Map.copyOf(map);
    }

    @Inject(method = "getSoundType", at = @At("RETURN"), cancellable = true)
    private void modifyBlockSoundType(BlockState state, CallbackInfoReturnable<SoundType> cir) {
        Identifier id = BuiltInRegistries.BLOCK.getKey(state.getBlock());
        if (id == null || !id.getNamespace().equals("minecraft")) return;

        for (Map.Entry<SoundType, Set<String>> entry : SOUND_OVERRIDES.entrySet()) {
            if (entry.getValue().contains(id.getPath())) {
                cir.setReturnValue(entry.getKey());
                return;
            }
        }
    }
}