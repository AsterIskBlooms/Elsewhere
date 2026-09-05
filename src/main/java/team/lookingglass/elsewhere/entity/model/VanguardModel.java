package team.lookingglass.elsewhere.entity.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;

import java.util.function.Function;

public class VanguardModel extends HumanoidModel<HumanoidRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "main");
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart rightArm;
    public final ModelPart leftArm;
    public final ModelPart rightLeg;
    public final ModelPart leftLeg;

    public VanguardModel(final ModelPart root) {
        this(root, RenderTypes::entityCutout);
    }

    public VanguardModel(final ModelPart root, final Function<Identifier, RenderType> renderType) {
        super(root, renderType);
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
    }

    public static MeshDefinition createMesh(final CubeDeformation g, final float yOffset) {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, g), PartPose.offset(0.0F, 0.0F + yOffset, 0.0F));
        head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        head.addOrReplaceChild("right_antler", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(3.0F, -16.0F, 0.0F, 5.0F, 10.0F, 0.0F, CubeDeformation.NONE).mirror(false), PartPose.ZERO);
        head.addOrReplaceChild("left_antler", CubeListBuilder.create().texOffs(32, 6).addBox(-8.0F, -16.0F, 0.0F, 5.0F, 10.0F, 0.0F, CubeDeformation.NONE), PartPose.ZERO);
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, g), PartPose.offset(0.0F, 0.0F + yOffset, 0.0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 14).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, g), PartPose.offset(-5.0F, 2.0F + yOffset, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 14).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, g).mirror(false), PartPose.offset(5.0F, 2.0F + yOffset, 0.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, g), PartPose.offset(-1.9F, 12.0F + yOffset, 0.0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, g), PartPose.offset(1.9F, 12.0F + yOffset, 0.0F));
        return mesh;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = createMesh(CubeDeformation.NONE, 0.0F);
        return LayerDefinition.create(mesh, 64, 32);
    }

    public static final ModelLayerLocation ARMOR_HEAD = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_head");
    public static final ModelLayerLocation ARMOR_CHEST = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_chest");
    public static final ModelLayerLocation ARMOR_LEGS = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_legs");
    public static final ModelLayerLocation ARMOR_FEET = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_feet");

    public static final ArmorModelSet<ModelLayerLocation> ARMOR_LAYERS = new ArmorModelSet<>(ARMOR_HEAD, ARMOR_CHEST, ARMOR_LEGS, ARMOR_FEET);

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition mesh = createMesh(deformation, 0.0F);
        return LayerDefinition.create(mesh, 64, 32);
    }

}