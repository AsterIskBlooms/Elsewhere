package team.lookingglass.elsewhere.entity.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;

public class VanguardModel extends HumanoidModel<HumanoidRenderState> {
    public VanguardModel(ModelPart root) {
        super(root);
    }

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "main");

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        return LayerDefinition.create(mesh, 64, 64);
    }

    public static final ModelLayerLocation ARMOR_HEAD = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_head");
    public static final ModelLayerLocation ARMOR_CHEST = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_chest");
    public static final ModelLayerLocation ARMOR_LEGS = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_legs");
    public static final ModelLayerLocation ARMOR_FEET = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "vanguard"), "armor_feet");

    public static final ArmorModelSet<ModelLayerLocation> ARMOR_LAYERS = new ArmorModelSet<>(ARMOR_HEAD, ARMOR_CHEST, ARMOR_LEGS, ARMOR_FEET);

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition mesh = HumanoidModel.createMesh(deformation, 0.0F);
        return LayerDefinition.create(mesh, 64, 32);
    }

}