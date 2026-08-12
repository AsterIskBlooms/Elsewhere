package team.lookingglass.elsewhere.entity.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.mob.SulfurCube;
import team.lookingglass.elsewhere.entity.model.SulfurCubeModel;
import team.lookingglass.elsewhere.entity.renderer.states.SulfurCubeRenderState;

public class SulfurCubeRenderer extends MobRenderer<SulfurCube, SulfurCubeRenderState, SulfurCubeModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/sulfur_cube/sulfur_cube.png");

    public SulfurCubeRenderer(EntityRendererProvider.Context context) {
        super(context, new SulfurCubeModel(context.bakeLayer(SulfurCubeModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public SulfurCubeRenderState createRenderState() { return new SulfurCubeRenderState(); }

    @Override
    public Identifier getTextureLocation(SulfurCubeRenderState state) { return TEXTURE; }

    @Override
    public void extractRenderState(SulfurCube entity, SulfurCubeRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.squish = entity.squish;
        state.size = entity.getSize();
    }

    @Override
    public RenderType getRenderType(SulfurCubeRenderState state, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderTypes.entityTranslucent(TEXTURE);
    }
}