package team.lookingglass.elsewhere.dimension.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import team.lookingglass.elsewhere.Elsewhere;

public class VeilrootDensityFunctions {
    public static final ResourceKey<DensityFunction> CONTINENTALNESS = register("veilroot/continentalness");
    public static final ResourceKey<DensityFunction> EROSION = register("veilroot/erosion");
    public static final ResourceKey<DensityFunction> TEMPERATURE = register("veilroot/temperature");
    public static final ResourceKey<DensityFunction> HUMIDITY = register("veilroot/humidity");
    public static final ResourceKey<DensityFunction> DEPTH = register("veilroot/depth");
    public static final ResourceKey<DensityFunction> BASE_TERRAIN = register("veilroot/base_terrain");

    public static void bootstrap(BootstrapContext<DensityFunction> ctx) {
        HolderGetter<NormalNoise.NoiseParameters> noises = ctx.lookup(Registries.NOISE);

        DensityFunction continentalnessRaw = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.CONTINENTALNESS), 1.0 / 16.0, 0.0);
        DensityFunction continentalness = NoiseRouterData.registerAndWrap(ctx, CONTINENTALNESS,
                DensityFunctions.mul(DensityFunctions.constant(1.0), continentalnessRaw).clamp(-1.0, 1.0));

        DensityFunction erosionRaw = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.EROSION), 1.0 / 12.0, 0.0);
        DensityFunction erosion = NoiseRouterData.registerAndWrap(ctx, EROSION,
                DensityFunctions.mul(DensityFunctions.constant(1.0), erosionRaw).clamp(-1.0, 1.0));

        NoiseRouterData.registerAndWrap(ctx, TEMPERATURE,
                DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.TEMPERATURE), 1.0 / 400.0, 0.0));

        NoiseRouterData.registerAndWrap(ctx, HUMIDITY,
                DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.HUMIDITY), 1.0 / 400.0, 0.0));

        DensityFunction offset = NoiseRouterData.remap(continentalness, -1.0, 1.0, -0.48, 0.48).clamp(-0.6, 0.6);
        DensityFunction depth = NoiseRouterData.registerAndWrap(ctx, DEPTH,
                DensityFunctions.add(DensityFunctions.yClampedGradient(0, 96, 1.5, -1.5), offset));

        DensityFunction erosionAlpha = NoiseRouterData.remap(erosion, -1.0, 1.0, 0.0, 1.0).clamp(0.0, 1.0);

        DensityFunction tightCaves = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.CAVE_TIGHT), 1.0 / 14.0, 1.0 / 14.0);
        DensityFunction tightCarve = DensityFunctions.mul(DensityFunctions.constant(4.0),
                DensityFunctions.add(tightCaves, DensityFunctions.constant(-0.2)));

        DensityFunction cavernCaves = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.CAVE_CAVERN), 1.0 / 50.0, 1.0 / 50.0);
        DensityFunction cavernCarve = DensityFunctions.mul(DensityFunctions.constant(2.5),
                DensityFunctions.add(cavernCaves, DensityFunctions.constant(-0.15)));

        DensityFunction caveCarve = DensityFunctions.lerp(erosionAlpha, tightCarve, cavernCarve);
        DensityFunction cavesTerrain = DensityFunctions.min(depth, caveCarve);

        DensityFunction peaksNoise = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.PEAKS), 1.0 / 20.0, 1.0 / 20.0);
        DensityFunction peaksShape = DensityFunctions.mul(DensityFunctions.constant(3.0), peaksNoise.abs());
        DensityFunction peaksTerrain = DensityFunctions.add(depth, peaksShape);
        DensityFunction plateauTerrain = DensityFunctions.lerp(erosionAlpha, depth, peaksTerrain);

        DensityFunction hillsNoise = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.HILLS), 1.0 / 60.0, 1.0 / 30.0);
        DensityFunction hillsShape = DensityFunctions.add(depth, DensityFunctions.mul(DensityFunctions.constant(2.0), hillsNoise));
        DensityFunction flatlandsTerrain = DensityFunctions.lerp(erosionAlpha, depth, hillsShape);

        DensityFunction layerBias = DensityFunctions.yClampedGradient(20, 70, -0.48, 0.48);
        DensityFunction effectiveContinentalness = DensityFunctions.add(continentalness, layerBias);

        DensityFunction flatlandsToPlateauAlpha = NoiseRouterData.remap(effectiveContinentalness, -0.14, -0.02, 0.0, 1.0).clamp(0.0, 1.0);
        DensityFunction plateauToCavesAlpha = NoiseRouterData.remap(effectiveContinentalness, 0.1, 0.22, 0.0, 1.0).clamp(0.0, 1.0);

        DensityFunction lowerBlend = DensityFunctions.lerp(flatlandsToPlateauAlpha, flatlandsTerrain, plateauTerrain);
        DensityFunction terrain = DensityFunctions.lerp(plateauToCavesAlpha, lowerBlend, cavesTerrain);

        DensityFunction canyonNoiseA = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.CANYONS), 1.0 / 6.0, 1.0 / 6.0);
        DensityFunction canyonNoiseB = DensityFunctions.noise(noises.getOrThrow(VeilrootNoises.CANYONS), 1.0 / 22.0, 1.0 / 22.0);
        DensityFunction canyonShape = DensityFunctions.add(
                DensityFunctions.mul(DensityFunctions.constant(9.0), canyonNoiseA),
                DensityFunctions.mul(DensityFunctions.constant(4.0), canyonNoiseB));
        DensityFunction canyonTerrain = DensityFunctions.add(depth, canyonShape);

        DensityFunction lowErosionChaosAlpha = NoiseRouterData.remap(erosion, -0.75, -0.55, 1.0, 0.0).clamp(0.0, 1.0);
        DensityFunction highErosionChaosAlpha = NoiseRouterData.remap(erosion, 0.55, 0.75, 0.0, 1.0).clamp(0.0, 1.0);
        DensityFunction canyonAlpha = DensityFunctions.max(lowErosionChaosAlpha, highErosionChaosAlpha);

        DensityFunction finalTerrain = DensityFunctions.lerp(canyonAlpha, terrain, canyonTerrain);

        NoiseRouterData.registerAndWrap(ctx, BASE_TERRAIN, finalTerrain);
    }

    private static ResourceKey<DensityFunction> register(String name) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }
}