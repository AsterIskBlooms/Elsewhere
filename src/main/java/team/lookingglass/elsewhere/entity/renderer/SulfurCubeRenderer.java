package team.lookingglass.elsewhere.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.mob.monster.SulfurCube;
import team.lookingglass.elsewhere.entity.model.SulfurCubeModel;
import team.lookingglass.elsewhere.entity.renderer.states.CubeRenderState;

public class SulfurCubeRenderer extends MobRenderer<SulfurCube, CubeRenderState, SulfurCubeModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/sulfur_cube/sulfur_cube.png");
    private static final Identifier SMALL_TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/sulfur_cube/sulfur_cube_small.png");

    private final SulfurCubeModel normalModel;
    private final SulfurCubeModel.SulfurCubeSmallModel smallModel;

    public SulfurCubeRenderer(EntityRendererProvider.Context context) {
        super(context, new SulfurCubeModel(context.bakeLayer(SulfurCubeModel.LAYER_LOCATION)), 0.25F);
        this.normalModel = (SulfurCubeModel) this.model;
        this.smallModel = new SulfurCubeModel.SulfurCubeSmallModel(context.bakeLayer(SulfurCubeModel.SulfurCubeSmallModel.LAYER_LOCATION));
    }

    @Override
    public CubeRenderState createRenderState() { return new CubeRenderState(); }

    @Override
    public Identifier getTextureLocation(CubeRenderState state) {
        return state.size == 1 ? SMALL_TEXTURE : TEXTURE;
    }

    @Override
    public void extractRenderState(SulfurCube entity, CubeRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.squish = Mth.lerp(partialTicks, entity.oSquish, entity.squish);
        state.size = entity.getSize();
    }

    @Override
    public void submit(CubeRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        this.model = (state.size == 1 ? smallModel : normalModel);
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    @Override
    public RenderType getRenderType(CubeRenderState state, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderTypes.entityTranslucent(getTextureLocation(state));
    }
}