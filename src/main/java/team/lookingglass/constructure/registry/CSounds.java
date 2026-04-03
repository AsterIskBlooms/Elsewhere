package team.lookingglass.constructure.registry;

import net.minecraft.world.level.block.SoundType;
import team.lookingglass.constructure.Constructure;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class CSounds {
    private void CustomSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    // Sounds
    public static final SoundEvent END_STONE_BREAK = registerSound("end_stone_break");
    public static final SoundEvent END_STONE_PLACE = registerSound("end_stone_place");
    public static final SoundEvent END_STONE_HIT = registerSound("end_stone_hit");
    public static final SoundType END_STONE = new SoundType(1F, 1F,
            END_STONE_BREAK, END_STONE_HIT, END_STONE_PLACE, END_STONE_HIT, END_STONE_PLACE);






    // Method
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(Constructure.MODID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }
    // Initialize
    public static void initialize() {}
}
