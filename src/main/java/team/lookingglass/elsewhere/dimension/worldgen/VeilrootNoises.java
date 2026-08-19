package team.lookingglass.elsewhere.dimension.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import team.lookingglass.elsewhere.Elsewhere;

public class VeilrootNoises {
    public static final ResourceKey<NormalNoise.NoiseParameters> CONTINENTALNESS = register("veilroot/continentalness");
    public static final ResourceKey<NormalNoise.NoiseParameters> EROSION = register("veilroot/erosion");
    public static final ResourceKey<NormalNoise.NoiseParameters> TEMPERATURE = register("veilroot/temperature");
    public static final ResourceKey<NormalNoise.NoiseParameters> HUMIDITY = register("veilroot/humidity");
    public static final ResourceKey<NormalNoise.NoiseParameters> CAVE_TIGHT = register("veilroot/cave_tight");
    public static final ResourceKey<NormalNoise.NoiseParameters> CAVE_CAVERN = register("veilroot/cave_cavern");
    public static final ResourceKey<NormalNoise.NoiseParameters> HILLS = register("veilroot/hills");
    public static final ResourceKey<NormalNoise.NoiseParameters> PEAKS = register("veilroot/peaks");
    public static final ResourceKey<NormalNoise.NoiseParameters> PILLARS = register("veilroot/pillars");
    public static final ResourceKey<NormalNoise.NoiseParameters> CANYONS = register("veilroot/canyons");

    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> ctx) {
        ctx.register(CONTINENTALNESS, new NormalNoise.NoiseParameters(-3, 1.0, 1.0, 1.0, 1.0));
        ctx.register(EROSION, new NormalNoise.NoiseParameters(-3, 1.0, 1.0, 1.0));
        ctx.register(TEMPERATURE, new NormalNoise.NoiseParameters(-1, 1.5, 1.0, 1.0));
        ctx.register(HUMIDITY, new NormalNoise.NoiseParameters(0, 1.5, 1.0, 1.0));
        ctx.register(CAVE_TIGHT, new NormalNoise.NoiseParameters(-3, 1.0, 1.0, 1.0));
        ctx.register(CAVE_CAVERN, new NormalNoise.NoiseParameters(-5, 1.0, 1.0, 1.0));
        ctx.register(HILLS, new NormalNoise.NoiseParameters(-4, 1.0, 1.0, 1.0));
        ctx.register(PEAKS, new NormalNoise.NoiseParameters(-3, 1.0, 1.0, 1.0));
        ctx.register(PILLARS, new NormalNoise.NoiseParameters(-5, 1.0, 1.0));
        ctx.register(CANYONS, new NormalNoise.NoiseParameters(-3, 1.0, 1.0, 1.0, 1.0));
    }

    private static ResourceKey<NormalNoise.NoiseParameters> register(String name) {
        return ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, name));
    }
}