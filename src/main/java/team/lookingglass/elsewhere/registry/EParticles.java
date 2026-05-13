package team.lookingglass.elsewhere.registry;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.particles.*;

import java.util.function.Function;

public class EParticles {
    public static final SimpleParticleType SULFUR_BUBBLES = register("sulfur_bubbles", false);
    public static final SimpleParticleType NOXIOUS_GAS = register("noxious_gas", false);
    public static final SimpleParticleType NOXIOUS_GAS_CLOUD = register("noxious_gas_cloud", false);
    public static final ParticleType<GeyserParticleOptions> GEYSER = register("geyser", true, GeyserParticleOptions::codec, GeyserParticleOptions::streamCodec);
    public static final ParticleType<GeyserBaseParticleOptions> GEYSER_BASE = register(
            "geyser_base", true, GeyserBaseParticleOptions::codec, GeyserBaseParticleOptions::streamCodec
    );
    public static final ParticleType<GeyserBaseParticleOptions> GEYSER_POOF = register(
            "geyser_poof", true, GeyserBaseParticleOptions::codec, GeyserBaseParticleOptions::streamCodec
    );
    public static final ParticleType<GeyserParticleOptions> GEYSER_PLUME = register(
            "geyser_plume", true, GeyserParticleOptions::codec, GeyserParticleOptions::streamCodec
    );

    private static SimpleParticleType register(String name, boolean overrideLimiter) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(Elsewhere.MODID, name),
                FabricParticleTypes.simple(overrideLimiter));
    }
    private static <T extends ParticleOptions> ParticleType<T> register(
            String name,
            boolean overrideLimiter,
            Function<ParticleType<T>, MapCodec<T>> codec,
            Function<ParticleType<T>, StreamCodec<? super RegistryFriendlyByteBuf, T>> streamCodec) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(Elsewhere.MODID, name),
                FabricParticleTypes.complex(overrideLimiter, codec, streamCodec));
    }

    public static void initialize() {}
}