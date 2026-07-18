package team.lookingglass.elsewhere.registry;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;
import team.lookingglass.elsewhere.Elsewhere;

public interface EWoodTypes {
    WoodType POPLAR = WoodType.register(new WoodType(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar").toString(),
            EBlockSets.POPLAR,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    ));

    WoodType AZALEA = WoodType.register(new WoodType(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar").toString(),
            EBlockSets.POPLAR,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    ));


    static void initialize() {}
}
