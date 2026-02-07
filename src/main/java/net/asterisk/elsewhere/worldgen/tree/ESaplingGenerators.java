package net.asterisk.elsewhere.worldgen.tree;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.worldgen.EConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public interface ESaplingGenerators {
     TreeGrower TAUTOLITH = new TreeGrower(Elsewhere.MODID + "tautolith",
             Optional.of(EConfiguredFeatures.MEGA_TAUTOLITH), Optional.of(EConfiguredFeatures.TAUTOLITH), Optional.empty());

     TreeGrower BRIAR = new TreeGrower(Elsewhere.MODID + "briar",
             Optional.empty(), Optional.of(EConfiguredFeatures.BRIAR), Optional.empty());

     // Initialize
     static void initialize() {}
}