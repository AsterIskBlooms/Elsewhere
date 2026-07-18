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

public interface EParticles {
    SimpleParticleType SULFUR_BUBBLES = register("sulfur_bubbles", false);
    SimpleParticleType NOXIOUS_GAS = register("noxious_gas", false);
    SimpleParticleType NOXIOUS_GAS_CLOUD = register("noxious_gas_cloud", false);
    ParticleType<GeyserParticleOptions> GEYSER = register("geyser", true, GeyserParticleOptions::codec, GeyserParticleOptions::streamCodec);
    ParticleType<GeyserBaseParticleOptions> GEYSER_BASE = register(
            "geyser_base", true, GeyserBaseParticleOptions::codec, GeyserBaseParticleOptions::streamCodec
    );
    ParticleType<GeyserBaseParticleOptions> GEYSER_POOF = register(
            "geyser_poof", true, GeyserBaseParticleOptions::codec, GeyserBaseParticleOptions::streamCodec
    );
    ParticleType<GeyserParticleOptions> GEYSER_PLUME = register(
            "geyser_plume", true, GeyserParticleOptions::codec, GeyserParticleOptions::streamCodec
    );

    SimpleParticleType RED_POPLAR_LEAVES = register("red_poplar_leaves", false);
    SimpleParticleType ORANGE_POPLAR_LEAVES = register("orange_poplar_leaves", false);
    SimpleParticleType YELLOW_POPLAR_LEAVES = register("yellow_poplar_leaves", false);

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

    static void initialize() {}
}