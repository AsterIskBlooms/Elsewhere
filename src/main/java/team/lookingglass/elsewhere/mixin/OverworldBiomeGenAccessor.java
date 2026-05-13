package team.lookingglass.elsewhere.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public interface OverworldBiomeGenAccessor {

    @Accessor("MIDDLE_BIOMES")
    ResourceKey<Biome>[][] getMiddleBiomes();

    @Accessor("PLATEAU_BIOMES")
    ResourceKey<Biome>[][] getPlateauBiomes();

    @Accessor("FULL_RANGE")
    Climate.Parameter getFULL_RANGE();

    @Invoker("addUndergroundBiome")
    void invokeAddUndergroundBiome(
            Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomes,
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter weirdness,
            float offset,
            ResourceKey<Biome> biome
    );
}