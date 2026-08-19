package team.lookingglass.elsewhere.worldgen.noise;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import team.lookingglass.elsewhere.Elsewhere;

public class ENoise {

    public static final ResourceKey<NormalNoise.NoiseParameters> CAVE_GRADIENT_3D = ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "cave_gradient_3d"));


    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        context.register(CAVE_GRADIENT_3D,
                new NormalNoise.NoiseParameters(-5, 1.0, 0.0, 1.0));
    }

    public static void initialize() {
        Registry.register(BuiltInRegistries.MATERIAL_CONDITION,
                Identifier.fromNamespaceAndPath(Elsewhere.MODID, "noise_3d"),
                NoiseCondition3D.CODEC.codec());
    }
}
