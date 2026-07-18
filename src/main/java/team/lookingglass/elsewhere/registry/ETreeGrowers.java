package team.lookingglass.elsewhere.registry;

import net.minecraft.world.level.block.grower.TreeGrower;
import team.lookingglass.elsewhere.worldgen.EConfiguredFeatures;

import java.util.Optional;

public interface ETreeGrowers {

    TreeGrower POPLAR = new TreeGrower("poplar", Optional.empty(), Optional.of(EConfiguredFeatures.RANDOM_POPLAR_KEY), Optional.empty());

    static void initialize() {
    }
}