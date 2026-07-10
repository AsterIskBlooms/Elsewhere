package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityRenderLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import team.lookingglass.elsewhere.entity.model.PerchModel;
import team.lookingglass.elsewhere.entity.renderer.FrostbiteRenderer;
import team.lookingglass.elsewhere.entity.renderer.PerchRenderer;

public class EEntityRenderers {
    public static void register() {
        EntityRenderers.register(EEntities.FROSTBITE, FrostbiteRenderer::new);

        ModelLayerRegistry.registerModelLayer(PerchModel.LAYER_LOCATION, PerchModel::createBodyLayer);
        EntityRenderers.register(EEntities.PERCH, PerchRenderer::new);
    }
}