package net.asterisk.elsewhere.worldgen.tree;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.worldgen.EConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public interface ESaplingGenerators {
     TreeGrower BRIAR = new TreeGrower(Elsewhere.MODID + "briar",
             Optional.empty(), Optional.of(EConfiguredFeatures.BRIAR), Optional.empty());

     // Initialize
     static void initialize() {}
}