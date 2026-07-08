package team.lookingglass.elsewhere;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorResolverRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.level.GrassColor;
import team.lookingglass.elsewhere.entity.EEntityRenderers;
import team.lookingglass.elsewhere.registry.EBlocks;
import team.lookingglass.elsewhere.registry.ERenderer;

import java.util.List;

public class ElsewhereClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ERenderer.register();
        EEntityRenderers.register();
    }
}
