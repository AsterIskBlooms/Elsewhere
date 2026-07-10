package team.lookingglass.elsewhere.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import team.lookingglass.elsewhere.Elsewhere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public interface ESounds {

    // End Stone
    SoundEvent END_STONE_BREAK = register("block.end_stone.break");
    SoundEvent END_STONE_STEP = register("block.end_stone.step");
    SoundEvent END_STONE_PLACE = register("block.end_stone.place");
    SoundEvent END_STONE_HIT = register("block.end_stone.hit");
    SoundEvent END_STONE_FALL = register("block.end_stone.fall");
    SoundType END_STONE = new SoundType(1F, 1F,
            END_STONE_BREAK, END_STONE_STEP, END_STONE_PLACE, END_STONE_HIT, END_STONE_FALL);

    // Sulfur Caves
    SoundEvent SULFUR_BREAK = register("block.sulfur.break");
    SoundEvent SULFUR_STEP = register("block.sulfur.step");
    SoundEvent SULFUR_PLACE = register("block.sulfur.place");
    SoundEvent SULFUR_HIT = register("block.sulfur.hit");
    SoundEvent SULFUR_FALL = register("block.sulfur.fall");
    SoundType SULFUR = new SoundType(1F, 1F,
            SULFUR_BREAK, SULFUR_STEP, SULFUR_PLACE, SULFUR_HIT, SULFUR_FALL);
    SoundEvent SULFUR_SPIKE_LAND = register("block.sulfur.spike_land");

    SoundEvent CINNABAR_BREAK = register("block.cinnabar.break");
    SoundEvent CINNABAR_STEP = register("block.cinnabar.step");
    SoundEvent CINNABAR_PLACE = register("block.cinnabar.place");
    SoundEvent CINNABAR_HIT = register("block.cinnabar.hit");
    SoundEvent CINNABAR_FALL = register("block.cinnabar.fall");
    SoundType CINNABAR = new SoundType(1F, 1F,
            CINNABAR_BREAK, CINNABAR_STEP, CINNABAR_PLACE, CINNABAR_HIT, CINNABAR_FALL);

    SoundEvent NOXIOUS_GAS = register("block.sulfur.noxious_gas");
    SoundEvent GEYSER_ERUPTION_START = register("block.geyser.eruption_start");
    SoundEvent GEYSER_ERUPTION_ACTIVE = register("block.geyser.eruption_active");


    // Stone Bricks & Tiles
    SoundEvent STONE_BRICKS_BREAK = register("block.stone_bricks.break");
    SoundEvent STONE_BRICKS_STEP = register("block.stone_bricks.step");
    SoundEvent STONE_BRICKS_PLACE = register("block.stone_bricks.place");
    SoundEvent STONE_BRICKS_HIT = register("block.stone_bricks.hit");
    SoundEvent STONE_BRICKS_FALL = register("block.stone_bricks.fall");
    SoundType STONE_BRICKS = new SoundType(1F, 1F,
            STONE_BRICKS_BREAK, STONE_BRICKS_STEP, STONE_BRICKS_PLACE, STONE_BRICKS_HIT, STONE_BRICKS_FALL);
    SoundType STONE_TILES = new SoundType(1F, 1.2F,
            STONE_BRICKS_BREAK, STONE_BRICKS_STEP, STONE_BRICKS_PLACE, STONE_BRICKS_HIT, STONE_BRICKS_FALL);
    SoundType SHALE_TILES = new SoundType(1F, 1.2F,
            SoundEvents.TUFF_BRICKS_BREAK, SoundEvents.TUFF_BRICKS_STEP, SoundEvents.TUFF_BRICKS_PLACE, SoundEvents.TUFF_BRICKS_HIT, SoundEvents.TUFF_BRICKS_FALL);


    // Frostbite
    SoundEvent FROSTBITE_IDLE = register("entity.frostbite.idle");
    SoundEvent FROSTBITE_HURT = register("entity.frostbite.hurt");
    SoundEvent FROSTBITE_DEATH = register("entity.frostbite.death");

    SoundEvent PERCH_FLOP = register("entity.perch.flop");
    SoundEvent PERCH_HURT = register("entity.perch.hurt");
    SoundEvent PERCH_DEATH = register("entity.perch.death");





    // Method
    private static SoundEvent register(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(Elsewhere.MODID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }
    // Initialize
    static void initialize() {}
}
