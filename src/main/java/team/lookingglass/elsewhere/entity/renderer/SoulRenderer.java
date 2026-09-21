package team.lookingglass.elsewhere.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.mob.monster.Soul;
import team.lookingglass.elsewhere.entity.model.SoulModel;
import team.lookingglass.elsewhere.entity.renderer.states.CubeRenderState;
import team.lookingglass.elsewhere.entity.renderer.states.SoulRenderState;

public class SoulRenderer extends MobRenderer<Soul, SoulRenderState, SoulModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/soul/soul.png");
    private static final double SOFT_TURN_SPEED = 0.05;
    private static final double ROCKET_TURN_SPEED = 0.35;
    private static final float SOFT_TURN_FACTOR = 0.1F;
    private static final float ROCKET_TURN_FACTOR = 0.6F;

    public SoulRenderer(final EntityRendererProvider.Context context) {
        super(context, new SoulModel(context.bakeLayer(SoulModel.LAYER_LOCATION)), 0.25F);
    }

    public Identifier getTextureLocation(final SoulRenderState state) {
        return TEXTURE;
    }

    public SoulRenderState createRenderState() {
        return new SoulRenderState();
    }

    @Override
    public void extractRenderState(final Soul entity, final SoulRenderState state, final float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.possessing = entity.isPossessing();

        Vec3 velocity = entity.getDeltaMovement();
        double horizontalSpeed = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z);
        double totalSpeed = velocity.length();

        float targetYaw = state.facingYaw;
        float targetPitch = state.facingPitch;
        if (totalSpeed > 1.0E-4) {
            targetYaw = (float) Math.atan2(velocity.x, velocity.z);
            targetPitch = (float) Math.atan2(horizontalSpeed, velocity.y);
        }

        double speedFraction = Mth.clamp(
                (totalSpeed - SOFT_TURN_SPEED) / (ROCKET_TURN_SPEED - SOFT_TURN_SPEED), 0.0, 1.0
        );
        float turnFactor = Mth.lerp((float) speedFraction, SOFT_TURN_FACTOR, ROCKET_TURN_FACTOR);

        state.facingYaw = Mth.lerp(turnFactor, state.facingYaw, targetYaw);
        state.facingPitch = Mth.lerp(turnFactor, state.facingPitch, targetPitch);
    }

    @Override
    protected boolean isBodyVisible(final SoulRenderState state) {
        return !state.possessing;
    }

    @Override
    public RenderType getRenderType(final SoulRenderState state, final boolean bodyVisible, final boolean translucent, final boolean glowing) {
        if (state.isInvisible && !glowing) {
            return null;
        }
        return RenderTypes.entityTranslucent(getTextureLocation(state));
    }

    @Override
    protected int getBlockLightLevel(Soul entity, BlockPos pos) {
        return 15;
    }
}