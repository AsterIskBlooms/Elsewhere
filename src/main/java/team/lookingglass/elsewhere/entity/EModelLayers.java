package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.model.SulfurCubeModel;

public class EModelLayers {

    public static final ModelLayerLocation SULFUR_CUBE_OUTER = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cube"), "outer");
    public static final ModelLayerLocation SULFUR_CUBE_INNER = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sulfur_cube"), "inner");

    public static void initialize() {
        ModelLayerRegistry.registerModelLayer(SULFUR_CUBE_OUTER, SulfurCubeModel::createOuterBodyLayer);
        ModelLayerRegistry.registerModelLayer(SULFUR_CUBE_INNER, SulfurCubeModel::createInnerBodyLayer);
    }
}
