package team.lookingglass.elsewhere.registry.properties;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Blocks;
import team.lookingglass.elsewhere.registry.EBlocks;

public class EBlockInteractions {
    public static void initialize() {
        AxeItem.STRIPPABLES.put(EBlocks.AZALEA_LOG, EBlocks.STRIPPED_AZALEA_LOG);
        AxeItem.STRIPPABLES.put(EBlocks.AZALEA_WOOD, EBlocks.STRIPPED_AZALEA_WOOD);
        AxeItem.STRIPPABLES.put(EBlocks.POPLAR_LOG, EBlocks.STRIPPED_POPLAR_LOG);
        AxeItem.STRIPPABLES.put(EBlocks.POPLAR_WOOD, EBlocks.STRIPPED_POPLAR_WOOD);
        AxeItem.STRIPPABLES.put(EBlocks.CEDAR_LOG, EBlocks.STRIPPED_CEDAR_LOG);
        AxeItem.STRIPPABLES.put(EBlocks.CEDAR_WOOD, EBlocks.STRIPPED_CEDAR_WOOD);
        AxeItem.STRIPPABLES.put(EBlocks.MAHOGANY_LOG, EBlocks.STRIPPED_MAHOGANY_LOG);
        AxeItem.STRIPPABLES.put(EBlocks.MAHOGANY_WOOD, EBlocks.STRIPPED_MAHOGANY_WOOD);
        AxeItem.STRIPPABLES.put(EBlocks.BAMBOO_STEM, EBlocks.STRIPPED_BAMBOO_STEM);

        ShovelItem.FLATTENABLES.put(EBlocks.RED_GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState());
        HoeItem.TILLABLES.put(EBlocks.RED_GRASS_BLOCK, Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(Blocks.FARMLAND.defaultBlockState())));
    }
}
