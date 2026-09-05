package team.lookingglass.elsewhere.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.renderer.states.SweeperRenderState;

@Environment(EnvType.CLIENT)
public class SweeperModel extends EntityModel<SweeperRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "seeper"), "main");
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;

    public SweeperModel(final ModelPart root) {
        super(root);
        this.torso = root.getChild("torso");
        this.head = this.torso.getChild("head");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.rightHindLeg = root.getChild("rightHindLeg");
        this.leftHindLeg = root.getChild("leftHindLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -20.0F, -2.0F, 8.0F, 20.0F, 5.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 15.0F, 0.0F));
        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -8.0F, -5.0F, 12.0F, 8.0F, 10.0F, CubeDeformation.NONE), PartPose.offset(0.0F, -20.0F, 0.5F));
        PartDefinition nub = head.addOrReplaceChild("nub", CubeListBuilder.create().texOffs(44, 14).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, CubeDeformation.NONE)
                .texOffs(44, 6).addBox(0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 8.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(26, 18).mirror().addBox(-3.0F, 0.0F, -5.0F, 6.0F, 10.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 14.0F, -1.0F));
        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(26, 18).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 10.0F, 5.0F, CubeDeformation.NONE), PartPose.offset(4.0F, 14.0F, -1.0F));
        PartDefinition rightHindLeg = partdefinition.addOrReplaceChild("rightHindLeg", CubeListBuilder.create().texOffs(26, 18).mirror().addBox(-3.0F, 0.0F, -2.5F, 6.0F, 10.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 14.0F, 4.5F));
        PartDefinition leftHindLeg = partdefinition.addOrReplaceChild("leftHindLeg", CubeListBuilder.create().texOffs(26, 18).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 10.0F, 5.0F, CubeDeformation.NONE), PartPose.offset(4.0F, 14.0F, 4.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void setupAnim(final SweeperRenderState state) {
        super.setupAnim(state);
        this.head.yRot = state.yRot * ((float)Math.PI / 180F);
        this.head.xRot = state.xRot * ((float)Math.PI / 180F);
        float speed = state.walkAnimationSpeed;
        float pos = state.walkAnimationPos;

        if (state.chasing) {
            this.animateChase(pos, speed);
        } else {
            this.animateWalk(pos, speed);
        }
    }

    private void animateWalk(final float pos, final float speed) {
        this.rightHindLeg.xRot = Mth.cos(pos * 0.6662F) * 1.4F * speed;
        this.leftHindLeg.xRot = Mth.cos(pos * 0.6662F + (float)Math.PI) * 1.4F * speed;
        this.rightFrontLeg.xRot = Mth.cos(pos * 0.6662F + (float)Math.PI) * 1.4F * speed;
        this.leftFrontLeg.xRot = Mth.cos(pos * 0.6662F) * 1.4F * speed;
        this.torso.xRot += 0.14F * speed;
    }

    private void animateChase(final float pos, final float speed) {
        float cycle = pos * 0.1F;

        this.animateLeg(this.leftFrontLeg, cycle, speed, 0.0F);
        this.animateLeg(this.rightFrontLeg, cycle, speed, 0.03F);
        this.animateLeg(this.leftHindLeg, cycle, speed, 0.47F);
        this.animateLeg(this.rightHindLeg, cycle, speed, 0.53F);

        float bodyPhase = (cycle - Mth.floor(cycle)) * 2.0F;
        this.torso.y += Mth.abs(Mth.sin(bodyPhase * (float)Math.PI)) * -2.2F * speed;
        this.torso.xRot += 0.42F * speed;
    }

    private void animateLeg(final ModelPart leg, final float cycle, final float speed, final float phaseOffset) {
        float t = cycle + phaseOffset;
        t -= Mth.floor(t);
        float angle = 0.65F * speed;
        if (t < 0.4F) {
            float swingT = t / 0.4F;
            float eased = swingT * swingT * (3.0F - 2.0F * swingT);
            leg.xRot = Mth.lerp(eased, angle, -angle);
            leg.y -= Mth.sin(swingT * (float)Math.PI) * 2.5F * speed;
        } else {
            float stanceT = (t - 0.4F) / 0.6F;
            leg.xRot = Mth.lerp(stanceT, -angle, angle);
        }
    }
}