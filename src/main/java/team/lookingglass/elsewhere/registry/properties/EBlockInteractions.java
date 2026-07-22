package team.lookingglass.elsewhere.registry.properties;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Blocks;
import team.lookingglass.elsewhere.registry.EBlocks;

public class EBlockInteractions {
    public static void initialize() {
        ShovelItem.FLATTENABLES.put(EBlocks.RED_GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState());
    }
}
