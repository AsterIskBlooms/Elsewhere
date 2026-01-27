package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public interface EBlockSetTypes {
    BlockSetType TAUTWOOD = new BlockSetType(Elsewhere.MODID + "tautwood");
    BlockSetType BRIAR = new BlockSetType(Elsewhere.MODID + "briar");
}