package team.lookingglass.elsewhere.registry.render;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.particle.BreakingItemParticle;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.SimpleParticleType;
import team.lookingglass.elsewhere.datagen.render.ParticleProvider;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.render.particles.*;

import java.util.List;

public class ERenderer {

    public static void register() {
        ParticleProviderRegistry.getInstance().register(EParticles.SULFUR_BUBBLES, SulfurBubbleParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.NOXIOUS_GAS, NoxiousGasParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.NOXIOUS_GAS_CLOUD, NoxiousGasCloudParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER, _ -> new GeyserEruptionParticle.Provider());
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER_BASE, GeyserBaseParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER_POOF, GeyserBaseParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER_PLUME, GeyserPlumeParticle.Provider::new);

        ParticleProviderRegistry.getInstance().register(EParticles.RED_POPLAR_LEAVES, FallingLeavesParticle.CherryProvider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.ORANGE_POPLAR_LEAVES, FallingLeavesParticle.PaleOakProvider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.YELLOW_POPLAR_LEAVES, FallingLeavesParticle.PaleOakProvider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.GILDED_BIRCH_LEAVES, FallingLeavesParticle.PaleOakProvider::new);

        ParticleProviderRegistry.getInstance().register(EParticles.SULFUR_CUBE_PARTICLE, CubeParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.SUBSLIME_PARTICLE, CubeParticle.Provider::new);

        BlockColorRegistry.register(List.of(BlockTintSources.grassBlock()), EBlocks.ARID_GRASS_BLOCK);
        BlockColorRegistry.register(List.of(BlockTintSources.foliage()), EBlocks.CEDAR_LEAVES);
        BlockColorRegistry.register(List.of(BlockTintSources.foliage()), EBlocks.MAHOGANY_LEAVES);
    }
}
