package team.lookingglass.elsewhere.mixin.world;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.lookingglass.elsewhere.worldgen.EBiomes;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeGenMixin {

    // Surface Biomes
    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectCustomWorldgen(CallbackInfo ci) {
        OverworldBiomeGenAccessor accessor = (OverworldBiomeGenAccessor) this;

        // Array is [0-4] row, [0-4] column

        ResourceKey<Biome>[][] middleA = accessor.getMiddleBiomes();
        ResourceKey<Biome>[][] middleB = accessor.getMiddleBiomesVariant();
        ResourceKey<Biome>[][] plateauA = accessor.getPlateauBiomes();
        ResourceKey<Biome>[][] plateauB = accessor.getPlateauBiomes();
        ResourceKey<Biome>[][] shattered = accessor.getShatteredBiomes();
        ResourceKey<Biome>[][] ocean = accessor.getOceans();

        // Desert
        middleA[4][0] = EBiomes.GLASS_DESERT;
        middleB[4][0] = Biomes.DESERT;

        middleA[4][3] = EBiomes.LUSH_DESERT;
        middleA[4][4] = EBiomes.LUSH_DESERT;

        // Warm
        middleB[3][0] = EBiomes.OUTBACK;
        middleB[3][1] = EBiomes.OUTBACK;

        middleA[3][2] = EBiomes.CEDAR_FOREST;
        middleB[3][2] = EBiomes.SHRUBLAND;
        middleA[3][3] = EBiomes.CEDAR_FOREST;
        middleB[3][3] = Biomes.SPARSE_JUNGLE;
        plateauA[3][2] = EBiomes.CEDAR_FOREST;
        plateauA[3][3] = EBiomes.CEDAR_FOREST;

        middleB[3][3] = EBiomes.RAINFOREST;
        middleB[3][4] = EBiomes.RAINFOREST;
        plateauA[3][3] = Biomes.BAMBOO_JUNGLE;
        plateauA[3][4] = Biomes.BAMBOO_JUNGLE;

        // Temperate
        plateauA[2][3] = Biomes.OLD_GROWTH_BIRCH_FOREST;
        plateauB[2][3] = Biomes.OLD_GROWTH_BIRCH_FOREST;

        // Cold
        plateauB[1][3] = Biomes.TAIGA;

        middleB[1][2] = EBiomes.DAPPLED_FOREST;
        plateauB[1][2] = EBiomes.DAPPLED_FOREST;

        // Frozen
        middleA[0][0] = EBiomes.TUNDRA;
        plateauA[0][0] = EBiomes.TUNDRA;
        plateauA[0][1] = EBiomes.TUNDRA;
        plateauB[0][1] = Biomes.ICE_SPIKES;

        // Misc Variants
        plateauA[1][2] = Biomes.MEADOW;
        plateauA[2][2] = Biomes.MEADOW;
        plateauA[2][3] = Biomes.MEADOW;
        plateauB[2][3] = Biomes.FLOWER_FOREST;
        plateauB[1][1] = Biomes.CHERRY_GROVE;

    }

    // Desert Beaches
    @Inject(method = "pickBeachBiome", at = @At("HEAD"), cancellable = true)
    private void elsewhere$pickBeachBiome(int temperatureIndex, int humidityIndex, CallbackInfoReturnable<ResourceKey<Biome>> cir) {
        if (temperatureIndex >= 2) { cir.setReturnValue(humidityIndex >= 3 ? EBiomes.TIDEPOOLS : Biomes.BEACH); }
        else if (temperatureIndex == 1) { cir.setReturnValue(humidityIndex >= 3 ? EBiomes.TIDEPOOLS : EBiomes.COLD_BEACH); }
        else if (temperatureIndex == 0) { cir.setReturnValue(humidityIndex >= 3 ? Biomes.SNOWY_BEACH : EBiomes.FROZEN_BEACH); }
        else { cir.setReturnValue(Biomes.BEACH); }
    }

    // Cave Biomes
    @Inject(method = "addUndergroundBiomes", at = @At("TAIL"))
    private void injectCustomCaveBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomes, CallbackInfo ci) {
        OverworldBiomeGenAccessor accessor = (OverworldBiomeGenAccessor) this;

        accessor.invokeAddUndergroundBiome(biomes,
                accessor.getFULL_RANGE(),
                Climate.Parameter.span(-1.0F, 0.7F),
                Climate.Parameter.span(-1.05F, 0.8F),
                Climate.Parameter.span(0.775F, 1.0F),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.CRYSTAL_CAVERNS
        );
        accessor.invokeAddUndergroundBiome(biomes,
                Climate.Parameter.span(-1.0F, 0.2F),
                accessor.getFULL_RANGE(),
                Climate.Parameter.span(-0.11F, 0.8F),
                Climate.Parameter.span(0.45F, 0.55F),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.SULFUR_CAVES
        );
        accessor.invokeAddUndergroundBiome(biomes,
                Climate.Parameter.span(-1.0F, -0.45F),
                Climate.Parameter.span(-1.0F, 0.1F),
                Climate.Parameter.span(0.3F, 0.8F),
                Climate.Parameter.span(-1.0F, 0.45F),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.FRIGID_CAVES
        );
        accessor.invokeAddUndergroundBiome(biomes,
                Climate.Parameter.span(-0.45F, -0.15F),
                Climate.Parameter.span(-1.0F, -0.35F),
                accessor.getFULL_RANGE(),
                accessor.getFULL_RANGE(),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.PALE_GROTTO
        );

        addDeepUndergroundBiome(biomes,
                Climate.Parameter.span(0.2F, 1.0F),
                Climate.Parameter.span(0.1F, 1.0F),
                Climate.Parameter.span(-0.455F, 0.3F),
                Climate.Parameter.span(-0.375F, 1.0F),
                accessor.getFULL_RANGE(),
                0.0F,
                EBiomes.VOLCANIC_DEPTHS
        );
    }

    // River Biomes
    @SuppressWarnings("unchecked")
    @Redirect(method = "addValleys", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/OverworldBiomeBuilder;addSurfaceBiome(Ljava/util/function/Consumer;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;FLnet/minecraft/resources/ResourceKey;)V"))
    private void elsewhere$splitRiverTemperatures(OverworldBiomeBuilder builder,
                                                  Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomes,
                                                  Climate.Parameter temperature,
                                                  Climate.Parameter humidity,
                                                  Climate.Parameter continentalness,
                                                  Climate.Parameter erosion,
                                                  Climate.Parameter weirdness,
                                                  float offset,
                                                  ResourceKey<Biome> biome
    ) {
        OverworldBiomeGenAccessor accessor = (OverworldBiomeGenAccessor)(Object) builder;
        if (biome == Biomes.RIVER && temperature == accessor.getUnfrozenRange()) {
            Climate.Parameter[] temperatures = accessor.getTemperatures();
            ResourceKey<Biome>[] rivers = new ResourceKey[]{Biomes.FROZEN_RIVER, EBiomes.COLD_RIVER, Biomes.RIVER, EBiomes.LUKEWARM_RIVER, EBiomes.WARM_RIVER};
            for (int i = 1; i < temperatures.length; i++) {
                accessor.invokeAddSurfaceBiome(biomes, temperatures[i], humidity, continentalness, erosion, weirdness, offset, rivers[i]);
            }
        } else {
            accessor.invokeAddSurfaceBiome(biomes, temperature, humidity, continentalness, erosion, weirdness, offset, biome);
        }
    }

    private void addDeepUndergroundBiome(
            final Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> biomes,
            final Climate.Parameter temperature,
            final Climate.Parameter humidity,
            final Climate.Parameter continentalness,
            final Climate.Parameter erosion,
            final Climate.Parameter weirdness,
            final float offset,
            final ResourceKey<Biome> biome
    ) {
        biomes.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.9F, 1.1F), weirdness, offset), biome));
    }
}