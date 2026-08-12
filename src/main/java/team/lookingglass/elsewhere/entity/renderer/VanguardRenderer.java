package team.lookingglass.elsewhere.entity.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ShieldItem;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.mob.Vanguard;
import team.lookingglass.elsewhere.entity.model.VanguardModel;

public class VanguardRenderer extends HumanoidMobRenderer<Vanguard, HumanoidRenderState, VanguardModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "textures/entity/vanguard/vanguard.png");

    public VanguardRenderer(EntityRendererProvider.Context context) {
        super(context, new VanguardModel(context.bakeLayer(VanguardModel.LAYER_LOCATION)), 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(
                this, ArmorModelSet.bake(VanguardModel.ARMOR_LAYERS, context.getModelSet(), VanguardModel::new),
                context.getEquipmentRenderer()));
    }

    @Override
    public void extractRenderState(Vanguard entity, HumanoidRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);

        if (entity.isUsingItem() && entity.getUseItem().getItem() instanceof ShieldItem) {
            if (entity.getUsedItemHand() == InteractionHand.OFF_HAND) {
                if (entity.getMainArm() == HumanoidArm.RIGHT) { state.leftArmPose = HumanoidModel.ArmPose.BLOCK; }
                else { state.rightArmPose = HumanoidModel.ArmPose.BLOCK; }
            }
            else {
                if (entity.getMainArm() == HumanoidArm.RIGHT) { state.rightArmPose = HumanoidModel.ArmPose.BLOCK; }
                else { state.leftArmPose = HumanoidModel.ArmPose.BLOCK; }
            }
        }
    }

    @Override
    public Identifier getTextureLocation(HumanoidRenderState state) {
        return TEXTURE;
    }

    @Override
    public HumanoidRenderState createRenderState() {
        return new HumanoidRenderState();
    }
}