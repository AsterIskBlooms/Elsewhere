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
import team.lookingglass.elsewhere.entity.renderer.states.CubeRenderState;

public class SulfurCubeModel extends EntityModel<CubeRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cube"), "main");

    protected final ModelPart cube;
    protected final ModelPart innerCube;
    protected final ModelPart outerCube;

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
    public void setupAnim(CubeRenderState state) {
        float squish = springEase(state.squish);

        float yScale = 1.0F + squish * 0.65F;
        float xzScale = 1.0F - squish * 0.30F;

        cube.y = 24.0F;
        cube.yScale = yScale;
        cube.xScale = xzScale;
        cube.zScale = xzScale;
    }

    private static float springEase(float t) {
        float c1 = 1.5F;
        float c3 = c1 + 1.0F;
        float t1 = t - 1.0F;
        return 1.0F + c3 * t1 * t1 * t1 + c1 * t1 * t1;
    }

    public static class SulfurCubeSmallModel extends SulfurCubeModel {
        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cube_small"), "main");

        public SulfurCubeSmallModel(ModelPart root) {
            super(root);
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition mesh = new MeshDefinition();
            PartDefinition root = mesh.getRoot();

            PartDefinition cube = root.addOrReplaceChild("cube", CubeListBuilder.create(), PartPose.ZERO);
            cube.addOrReplaceChild("inner_cube", CubeListBuilder.create()
                            .texOffs(0, 20)
                            .addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F),
                    PartPose.ZERO
            );
            cube.addOrReplaceChild("outer_cube", CubeListBuilder.create()
                            .texOffs(0, 0)
                            .addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F),
                    PartPose.ZERO
            );

            return LayerDefinition.create(mesh, 64, 64);
        }
    }
}