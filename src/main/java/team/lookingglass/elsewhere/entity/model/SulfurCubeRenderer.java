package team.lookingglass.elsewhere.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.EModelLayers;
import team.lookingglass.elsewhere.entity.model.cubetemplate.AbstractCubeMobRenderer;
import team.lookingglass.elsewhere.entity.type.SulfurCube;

public class SulfurCubeRenderer extends AbstractCubeMobRenderer<SulfurCube, SulfurCubeRenderState, SulfurCubeModel> {

    private static final Identifier OUTER_TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID,
            "textures/entity/sulfur_cube/sulfur_cube_outer.png");

    public SulfurCubeRenderer(EntityRendererProvider.Context context) {
        super(context, new SulfurCubeModel(context.bakeLayer(EModelLayers.SULFUR_CUBE_OUTER)));
        this.addLayer(new SulfurCubeInnerLayer(this, context.getModelSet()));
    }

    @Override
    protected float getShadowRadius(SulfurCubeRenderState state) {
        return state.size * 0.25F;
    }

    @Override
    protected void scale(SulfurCubeRenderState state, PoseStack poseStack) {
        poseStack.scale(0.999F, 0.999F, 0.999F);
        poseStack.translate(0.0F, 0.001F, 0.0F);

        float size = state.size;
        float ss = state.squish / (size * 0.5F + 1.0F);
        float w = 1.0F / (ss + 1.0F);
        poseStack.scale(w * size, 1.0F / w * size, w * size);

        poseStack.scale(0.5F, 0.5F, 0.5F);
        poseStack.translate(0.0F, 0.98F, 0.0F);
    }

    @Override
    public void extractRenderState(SulfurCube entity, SulfurCubeRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.squish = Mth.lerp(partialTicks, entity.oSquish, entity.squish);
        state.size = entity.getSize();
    }

    @Override
    public Identifier getTextureLocation(SulfurCubeRenderState state) {
        return OUTER_TEXTURE;
    }

    @Override
    public SulfurCubeRenderState createRenderState() {
        return new SulfurCubeRenderState();
    }
}
