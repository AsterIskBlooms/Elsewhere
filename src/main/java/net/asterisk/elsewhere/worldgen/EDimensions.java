package net.asterisk.elsewhere.worldgen;

import net.asterisk.elsewhere.Elsewhere;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.minecraft.resources.Identifier;
import net.minecraft.world.timeline.Timeline;

import java.util.Optional;
import java.util.OptionalLong;

public class EDimensions {
    public static final ResourceKey<Level> TANGLEROOT_KEY = ResourceKey.create(Registries.DIMENSION,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tangleroot"));
    public static final ResourceKey<LevelStem> TANGLEROOT_STEM = ResourceKey.create(Registries.LEVEL_STEM,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tangleroot"));
    public static final ResourceKey<NoiseGeneratorSettings> TANGLEROOT_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tangleroot"));
    public static final ResourceKey<DimensionType> TANGLEROOT_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "tangleroot"));

    public static void bootstrapType(BootstrapContext<DimensionType> bootstrapContext) {
        bootstrapContext.register(TANGLEROOT_TYPE, new DimensionType(
                true,
                false,
                true,
                4.0,
                -64,
                160,
                96,
                BlockTags.INFINIBURN_OVERWORLD,
                0.2F,
                new DimensionType.MonsterSettings(ConstantInt.of(7), 7),
                DimensionType.Skybox.NONE,
                DimensionType.CardinalLightType.DEFAULT,
                EnvironmentAttributeMap.EMPTY,
                HolderSet.direct(),
                Optional.empty()
        ));
    }

}
