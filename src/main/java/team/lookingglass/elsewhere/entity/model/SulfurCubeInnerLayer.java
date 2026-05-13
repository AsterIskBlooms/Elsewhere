package team.lookingglass.elsewhere.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.EModelLayers;

public class SulfurCubeInnerLayer extends RenderLayer<SulfurCubeRenderState, SulfurCubeModel> {

    private static final Identifier INNER_TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID,
            "textures/entity/sulfur_cube/sulfur_cube_inner.png");
    private final SulfurCubeModel model;

    public SulfurCubeInnerLayer(RenderLayerParent<SulfurCubeRenderState, SulfurCubeModel> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new SulfurCubeModel(modelSet.bakeLayer(EModelLayers.SULFUR_CUBE_INNER));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords,
                       SulfurCubeRenderState state, float yRot, float xRot) {
        if (!state.isInvisible) {
            RenderType renderType = RenderTypes.entityTranslucent(INNER_TEXTURE);
            submitNodeCollector.order(-1).submitModel(this.model, state, poseStack, renderType,
                    lightCoords, LivingEntityRenderer.getOverlayCoords(state, 0.0F), -1, null, state.outlineColor, null);
        }
    }
}
