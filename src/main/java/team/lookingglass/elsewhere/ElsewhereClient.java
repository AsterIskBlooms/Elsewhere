package team.lookingglass.elsewhere;

import net.fabricmc.api.ClientModInitializer;
import team.lookingglass.elsewhere.entity.EEntityRenderers;
import team.lookingglass.elsewhere.registry.render.ERenderer;

public class ElsewhereClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ERenderer.register();
        EEntityRenderers.register();
    }
}
