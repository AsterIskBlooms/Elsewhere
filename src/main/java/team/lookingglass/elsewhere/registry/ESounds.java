package team.lookingglass.elsewhere.registry;

import net.minecraft.world.level.block.SoundType;
import team.lookingglass.elsewhere.Elsewhere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ESounds {
    private void CustomSounds() {
        // private empty constructor to avoid accidental instantiation
    }

    // Sounds
    public static final SoundEvent END_STONE_BREAK = registerSound("end_stone_break");
    public static final SoundEvent END_STONE_PLACE = registerSound("end_stone_place");
    public static final SoundEvent END_STONE_HIT = registerSound("end_stone_hit");
    public static final SoundType END_STONE = new SoundType(1F, 1F,
            END_STONE_BREAK, END_STONE_HIT, END_STONE_PLACE, END_STONE_HIT, END_STONE_PLACE);

    public static final SoundEvent SULFUR_BREAK = registerSound("sulfur_break");
    public static final SoundEvent SULFUR_STEP = registerSound("sulfur_step");
    public static final SoundEvent SULFUR_PLACE = registerSound("sulfur_place");
    public static final SoundEvent SULFUR_HIT = registerSound("sulfur_hit");
    public static final SoundType SULFUR = new SoundType(1F, 1F,
            SULFUR_BREAK, SULFUR_STEP, SULFUR_PLACE, SULFUR_HIT, SULFUR_PLACE);

    public static final SoundEvent CINNABAR_BREAK = registerSound("cinnabar_break");
    public static final SoundEvent CINNABAR_STEP = registerSound("cinnabar_step");
    public static final SoundEvent CINNABAR_PLACE = registerSound("cinnabar_place");
    public static final SoundEvent CINNABAR_HIT = registerSound("cinnabar_hit");
    public static final SoundType CINNABAR = new SoundType(1F, 1F,
            CINNABAR_BREAK, CINNABAR_STEP, CINNABAR_PLACE, CINNABAR_HIT, CINNABAR_PLACE);

    public static final SoundEvent NOXIOUS_GAS = registerSound("noxious_gas");
    public static final SoundEvent GEYSER_ERUPTION_START = registerSound("geyser_eruption_start");
    public static final SoundEvent GEYSER_ERUPTION_ACTIVE = registerSound("geyser_eruption_active");






    // Method
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(Elsewhere.MODID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }
    // Initialize
    public static void initialize() {}
}
