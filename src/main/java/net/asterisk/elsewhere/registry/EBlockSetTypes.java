package net.asterisk.elsewhere.registry;

import net.asterisk.elsewhere.Elsewhere;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public interface EBlockSetTypes {
    BlockSetType TAUTOLITH = new BlockSetType(Elsewhere.MODID + "tautolith");
    BlockSetType BRIAR = new BlockSetType(Elsewhere.MODID + "briar");

    BlockSetType XYLOITE = new BlockSetType(Elsewhere.MODID + "xyloite");
}