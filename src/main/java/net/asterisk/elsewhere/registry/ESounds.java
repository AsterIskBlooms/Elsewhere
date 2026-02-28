package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ESounds {
    private void CustomSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    // Sounds
    public static final SoundEvent OBSIDIAN = registerSound("obsidian");







    // Method
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(Elsewhere.MODID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }
    // Initialize
    public static void initialize() {}
}
