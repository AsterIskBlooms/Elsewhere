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

        middleB[3][0] = EBiomes.OUTBACK;

        middleA[4][3] = EBiomes.LUSH_DESERT;
        middleA[4][4] = EBiomes.LUSH_DESERT;
        plateauA[4][3] = EBiomes.LUSH_DESERT;
        plateauA[4][4] = EBiomes.LUSH_DESERT;

        middleA[0][0] = EBiomes.TUNDRA;
        plateauA[0][0] = EBiomes.TUNDRA;

        plateauB[0][1] = Biomes.ICE_SPIKES;
        plateauB[1][1] = Biomes.CHERRY_GROVE;

        middleB[1][2] = EBiomes.DAPPLED_FOREST;
        plateauB[1][2] = EBiomes.DAPPLED_FOREST;
        plateauB[1][3] = EBiomes.DAPPLED_FOREST;

        ocean[0][4] = EBiomes.STONY_TIDEPOOLS;

    }

    // Desert Beaches
    @Inject(method = "pickBeachBiome", at = @At("HEAD"), cancellable = true)
    private void elsewhere$desertBeachVariants(int temperatureIndex, int humidityIndex, CallbackInfoReturnable<ResourceKey<Biome>> cir) {
        if (temperatureIndex >= 3) {
            if (humidityIndex >= 3 || temperatureIndex == 4) {
                cir.setReturnValue(EBiomes.SANDY_TIDEPOOLS);
            } else cir.setReturnValue(EBiomes.STONY_TIDEPOOLS);
        }
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
                Climate.Parameter.span(0.03F, 0.8F),
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
}