package team.lookingglass.constructure.registry;

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
    public static final SoundEvent OBSIDIAN = registerSound("obsidian");







    // Method
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(Constructure.MODID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }
    // Initialize
    public static void initialize() {}
}
