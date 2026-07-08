package team.lookingglass.elsewhere.registry;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Blocks;

public class EBlockInteractions {
    public static void initialize() {
        ShovelItem.FLATTENABLES.put(EBlocks.RED_GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState());
    }
}
