package team.lookingglass.elsewhere.entity.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.renderer.states.SulfurCubeRenderState;

public class SulfurCubeModel extends EntityModel<SulfurCubeRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cube"), "main");

    private final ModelPart cube;
    private final ModelPart innerCube;
    private final ModelPart outerCube;

    public SulfurCubeModel(ModelPart root) {
        super(root);
        this.cube = root.getChild("cube");
        this.innerCube = cube.getChild("inner_cube");
        this.outerCube = cube.getChild("outer_cube");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition cube = root.addOrReplaceChild("cube", CubeListBuilder.create(), PartPose.ZERO);
        cube.addOrReplaceChild("inner_cube", CubeListBuilder.create()
                        .texOffs(0, 36)
                        .addBox(-8.0F, -17.0F, -8.0F, 16.0F, 16.0F, 16.0F),
                PartPose.ZERO
        );
        cube.addOrReplaceChild("outer_cube", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-9.0F, -18.0F, -9.0F, 18.0F, 18.0F, 18.0F),
                PartPose.ZERO
        );

        return LayerDefinition.create(mesh, 96, 96);
    }


    @Override
    public void setupAnim(SulfurCubeRenderState state) {
        float squish = state.squish;
        float yScale = 1.0F + squish * 0.5F;
        float xzScale = 1.0F - squish * 0.25F;
        float sizeCorrection = switch (state.size) {
            case 1 -> 0.5F;
            case 4 -> 2.0F;
            default -> 1.0F;
        };
        cube.y = 24.0F;
        cube.yScale = yScale * sizeCorrection;
        cube.xScale = xzScale * sizeCorrection;
        cube.zScale = xzScale * sizeCorrection;
    }
}