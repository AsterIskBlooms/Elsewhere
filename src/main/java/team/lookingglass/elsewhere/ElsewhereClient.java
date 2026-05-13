package team.lookingglass.elsewhere;

import net.fabricmc.api.ClientModInitializer;
import team.lookingglass.elsewhere.entity.EEntityRenderer;
import team.lookingglass.elsewhere.entity.EModelLayers;
import team.lookingglass.elsewhere.registry.ERenderer;

public class ElsewhereClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ERenderer.initialize();
        EEntityRenderer.initialize();
        EModelLayers.initialize();
    }
}
