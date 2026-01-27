package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;

public interface EWoodTypes {
    WoodType TAUTWOOD = new WoodType(
            Elsewhere.MODID + "tautwood",
            EBlockSetTypes.TAUTWOOD,
            SoundType.WOOD,
            SoundType.HANGING_SIGN,
            SoundEvents.FENCE_GATE_CLOSE,
            SoundEvents.FENCE_GATE_OPEN
    );
    WoodType BRIAR = new WoodType(
            Elsewhere.MODID + "briar",
            EBlockSetTypes.BRIAR,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    );
}
