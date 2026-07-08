package team.lookingglass.elsewhere.entity;

import net.minecraft.client.renderer.entity.EntityRenderers;
import team.lookingglass.elsewhere.entity.render.FrostbiteRenderer;

public class EEntityRenderers {
    public static void register() {
        EntityRenderers.register(EEntities.FROSTBITE, FrostbiteRenderer::new);
    }
}
