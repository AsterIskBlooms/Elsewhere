package team.lookingglass.elsewhere.entity;

import net.minecraft.client.renderer.entity.EntityRenderers;
import team.lookingglass.elsewhere.entity.model.SulfurCubeModel;
import team.lookingglass.elsewhere.entity.model.SulfurCubeRenderer;

public class EEntityRenderer {

    public static void initialize() {
        EntityRenderers.register(EEntityType.SULFUR_CUBE, SulfurCubeRenderer::new);
    }
}
