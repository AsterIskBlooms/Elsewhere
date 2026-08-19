package team.lookingglass.elsewhere.dimension;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.attribute.*;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.timeline.Timeline;
import net.minecraft.world.timeline.Timelines;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.dimension.worldgen.VeilrootBiomes;
import team.lookingglass.elsewhere.dimension.worldgen.VeilrootWorldgen;
import team.lookingglass.elsewhere.worldgen.EBiomes;

import java.util.List;
import java.util.Optional;

public class EDimensions {
    public static final ResourceKey<Level> VEILROOT = ResourceKey.create(
            Registries.DIMENSION, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "veilroot"));

    public static final ResourceKey<DimensionType> VEILROOT_TYPE = ResourceKey.create(
            Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "veilroot"));

    public static void bootstrapType(BootstrapContext<DimensionType> ctx) {
        ctx.register(VEILROOT_TYPE, new DimensionType(
                true,
                false,
                true,
                false,
                4.0,
                0, 192, 96,
                BlockTags.INFINIBURN_OVERWORLD,
                0.2F,
                new DimensionType.MonsterSettings(
                        ConstantInt.of(7),
                        15),
                DimensionType.Skybox.NONE,
                CardinalLighting.Type.NETHER,
                EnvironmentAttributeMap.builder()
                        .set(EnvironmentAttributes.BED_RULE, BedRule.EXPLODES)
                        .set(EnvironmentAttributes.CAN_START_RAID, false)
                        .set(EnvironmentAttributes.RESPAWN_ANCHOR_WORKS, true)
                        .set(EnvironmentAttributes.SNOW_GOLEM_MELTS, false)
                        .set(EnvironmentAttributes.WATER_EVAPORATES, false)

                        .set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, 0x2d331d)
                        .set(EnvironmentAttributes.SKY_LIGHT_FACTOR, 0.5F)
                        .set(EnvironmentAttributes.SKY_LIGHT_COLOR, 0xb8ff36)
                        .set(EnvironmentAttributes.FOG_START_DISTANCE, -60F)
                        .build(),
                HolderSet.empty(),
                Optional.empty()
        ));
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> ctx) {
        var dimTypes = ctx.lookup(Registries.DIMENSION_TYPE);
        var noiseSettings = ctx.lookup(Registries.NOISE_SETTINGS);
        var biomes = ctx.lookup(Registries.BIOME);

        BiomeSource biomeSource = VeilrootBiomes.biomeSource(biomes);

        ChunkGenerator gen = new NoiseBasedChunkGenerator(
                biomeSource,
                noiseSettings.getOrThrow(VeilrootWorldgen.VEILROOT_NOISE_SETTINGS));

        ctx.register(ResourceKey.create(Registries.LEVEL_STEM, VEILROOT_TYPE.identifier()),
                new LevelStem(dimTypes.getOrThrow(VEILROOT_TYPE), gen));
    }
}
