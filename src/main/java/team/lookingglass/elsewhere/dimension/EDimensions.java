package team.lookingglass.elsewhere.dimension;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import team.lookingglass.elsewhere.Elsewhere;

import java.util.Optional;

public class EDimensions {
    public static final ResourceKey<Level> VEILROOT = ResourceKey.create(
            Registries.DIMENSION, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "veilroot"));

    public static final ResourceKey<DimensionType> VEILROOT_TYPE = ResourceKey.create(
            Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "veilroot"));

    public static void bootstrapType(BootstrapContext<DimensionType> ctx) {
        ctx.register(VEILROOT_TYPE, new DimensionType(
                true,
                true,
                true,
                false,
                4.0,
                0, 192, 192,
                BlockTags.INFINIBURN_OVERWORLD,
                0.0f,
                new DimensionType.MonsterSettings(
                        ConstantInt.of(7),
                        0),
                DimensionType.Skybox.NONE,
                CardinalLighting.Type.DEFAULT,
                EnvironmentAttributeMap.EMPTY,
                HolderSet.empty(),
                Optional.empty()
        ));
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> ctx) {
        var dimTypes = ctx.lookup(Registries.DIMENSION_TYPE);
        var noiseSettings = ctx.lookup(Registries.NOISE_SETTINGS);
        var biomes = ctx.lookup(Registries.BIOME);

        BiomeSource biomeSource = new FixedBiomeSource(biomes.getOrThrow(Biomes.LUSH_CAVES));

        ChunkGenerator gen = new NoiseBasedChunkGenerator(
                biomeSource,
                noiseSettings.getOrThrow(NoiseGeneratorSettings.NETHER));

        ctx.register(ResourceKey.create(Registries.LEVEL_STEM, VEILROOT_TYPE.identifier()),
                new LevelStem(dimTypes.getOrThrow(VEILROOT_TYPE), gen));
    }
}
