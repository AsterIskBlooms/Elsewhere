package net.asterisk.elsewhere.worldgen.tree;

import net.asterisk.elsewhere.Elsewhere;
import net.asterisk.elsewhere.worldgen.EConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public interface ESaplingGenerators {
     TreeGrower TAUTWOOD = new TreeGrower(Elsewhere.MODID + "tautwood",
             Optional.of(EConfiguredFeatures.MEGA_TAUTWOOD), Optional.of(EConfiguredFeatures.TAUTWOOD), Optional.empty());

     // Initialize
     static void initialize() {}
}