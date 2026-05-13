package team.lookingglass.elsewhere.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import team.lookingglass.elsewhere.Elsewhere;

public class ENoise {

    public static final ResourceKey<NormalNoise.NoiseParameters> CRYSTALLINE_CAVE_GRADIENT =
            ResourceKey.create(Registries.NOISE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "crystalline_cave_gradient"));
    public static final ResourceKey<NormalNoise.NoiseParameters> SULFUR_CAVE_GRADIENT =
            ResourceKey.create(Registries.NOISE,
                    Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cave_gradient"));


    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        context.register(CRYSTALLINE_CAVE_GRADIENT,
                new NormalNoise.NoiseParameters(-4, 1.0, 0.0, 1.0));
        context.register(SULFUR_CAVE_GRADIENT,
                new NormalNoise.NoiseParameters(-5, 1.0, 0.0, 1.0));
    }
}
