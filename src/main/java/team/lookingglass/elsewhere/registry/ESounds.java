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

    // Sulfur Cave Blocks
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

    // Shale & Shale Tiles
    SoundEvent SHALE_BREAK = register("block.shale.break");
    SoundEvent SHALE_STEP = register("block.shale.step");
    SoundEvent SHALE_PLACE = register("block.shale.place");
    SoundEvent SHALE_HIT = register("block.shale.hit");
    SoundEvent SHALE_FALL = register("block.shale.fall");
    SoundType SHALE = new SoundType(1F, 1F,
            SHALE_BREAK, SHALE_STEP, SHALE_PLACE, SHALE_HIT, SHALE_FALL);

    SoundEvent SHALE_BRICKS_BREAK = register("block.shale_bricks.break");
    SoundEvent SHALE_BRICKS_STEP = register("block.shale_bricks.step");
    SoundEvent SHALE_BRICKS_PLACE = register("block.shale_bricks.place");
    SoundEvent SHALE_BRICKS_HIT = register("block.shale_bricks.hit");
    SoundEvent SHALE_BRICKS_FALL = register("block.shale_bricks.fall");
    SoundType SHALE_BRICKS = new SoundType(1F, 1F,
            SHALE_BRICKS_BREAK, SHALE_BRICKS_STEP, SHALE_BRICKS_PLACE, SHALE_BRICKS_HIT, SHALE_BRICKS_FALL);
    SoundType SHALE_TILES = new SoundType(1F, 1.2F,
            SHALE_BRICKS_BREAK, SHALE_BRICKS_STEP, SHALE_BRICKS_PLACE, SHALE_BRICKS_HIT, SHALE_BRICKS_FALL);

    SoundEvent CACTUS_BREAK = register("block.cactus.break");
    SoundEvent CACTUS_STEP = register("block.cactus.step");
    SoundEvent CACTUS_PLACE = register("block.cactus.place");
    SoundEvent CACTUS_HIT = register("block.cactus.hit");
    SoundEvent CACTUS_FALL = register("block.cactus.fall");
    SoundType CACTUS = new SoundType(0.2F, 1F,
            CACTUS_BREAK, CACTUS_STEP, CACTUS_PLACE, CACTUS_HIT, CACTUS_FALL);

    SoundEvent ROCKWEED_BASALT_BREAK = register("block.rockweed_basalt.break");
    SoundEvent ROCKWEED_BASALT_STEP = register("block.rockweed_basalt.step");
    SoundEvent ROCKWEED_BASALT_PLACE = register("block.rockweed_basalt.place");
    SoundEvent ROCKWEED_BASALT_HIT = register("block.rockweed_basalt.hit");
    SoundEvent ROCKWEED_BASALT_FALL = register("block.rockweed_basalt.fall");
    SoundType ROCKWEED_BASALT = new SoundType(1F, 1F,
            ROCKWEED_BASALT_BREAK, ROCKWEED_BASALT_STEP, ROCKWEED_BASALT_PLACE, ROCKWEED_BASALT_HIT, ROCKWEED_BASALT_FALL);


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
