package team.lookingglass.elsewhere.registry.sets;

import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorResolverRegistry;
import net.fabricmc.fabric.impl.client.rendering.BlockColorRegistryImpl;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EBlocks;

import java.util.List;

public interface EWoodTypes {
    WoodType POPLAR = WoodType.register(new WoodType(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "poplar").toString(),
            EBlockSets.POPLAR,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    ));

    WoodType AZALEA = WoodType.register(new WoodType(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "azalea").toString(),
            EBlockSets.AZALEA,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    ));

    WoodType CEDAR = WoodType.register(new WoodType(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cedar").toString(),
            EBlockSets.CEDAR,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    ));

    WoodType MAHOGANY = WoodType.register(new WoodType(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "mahogany").toString(),
            EBlockSets.MAHOGANY,
            SoundType.CHERRY_WOOD,
            SoundType.CHERRY_WOOD_HANGING_SIGN,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    ));


    static void initialize() {}
}
