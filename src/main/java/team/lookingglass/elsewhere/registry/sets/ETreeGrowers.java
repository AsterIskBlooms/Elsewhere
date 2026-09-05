package team.lookingglass.elsewhere.registry.sets;

import net.minecraft.world.level.block.grower.TreeGrower;
import team.lookingglass.elsewhere.worldgen.EConfiguredFeatures;

import java.util.Optional;

public interface ETreeGrowers {

    TreeGrower POPLAR = new TreeGrower("poplar", Optional.empty(), Optional.of(EConfiguredFeatures.RANDOM_POPLAR_KEY), Optional.empty());
    TreeGrower CEDAR = new TreeGrower("cedar", Optional.empty(), Optional.of(EConfiguredFeatures.CEDAR_TREE), Optional.empty());
    TreeGrower MAHOGANY = new TreeGrower("mahogany", Optional.empty(), Optional.of(EConfiguredFeatures.MAHOGANY_TREE), Optional.empty());

    static void initialize() {
    }
}