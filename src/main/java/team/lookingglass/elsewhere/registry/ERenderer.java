package team.lookingglass.elsewhere.registry;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.level.GrassColor;
import team.lookingglass.elsewhere.registry.particles.*;

import java.util.List;

public class ERenderer {

    public static void register()

    {
        ParticleProviderRegistry.getInstance().register(EParticles.SULFUR_BUBBLES, SulfurBubbleParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.NOXIOUS_GAS, NoxiousGasParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.NOXIOUS_GAS_CLOUD, NoxiousGasCloudParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER, _ -> new GeyserEruptionParticle.Provider());
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER_BASE, GeyserBaseParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER_POOF, GeyserBaseParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(EParticles.GEYSER_PLUME, GeyserPlumeParticle.Provider::new);

        BlockColorRegistry.register(List.of(BlockTintSources.grassBlock()), EBlocks.ARID_GRASS_BLOCK);
    }
}
