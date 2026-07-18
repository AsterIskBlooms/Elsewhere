package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.model.PerchModel;
import team.lookingglass.elsewhere.entity.renderer.FrostbiteRenderer;
import team.lookingglass.elsewhere.entity.renderer.PerchRenderer;

import static team.lookingglass.elsewhere.entity.EEntities.POPLAR_BOAT_KEY;

public class EEntityRenderers {
    public static void register() {
        EntityRenderers.register(EEntities.FROSTBITE, FrostbiteRenderer::new);

        ModelLayerRegistry.registerModelLayer(PerchModel.LAYER_LOCATION, PerchModel::createBodyLayer);
        EntityRenderers.register(EEntities.PERCH, PerchRenderer::new);

        ModelLayerLocation POPLAR_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "boat/poplar"), "main");
        ModelLayerLocation POPLAR_CHEST_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "chest_boat/poplar"), "main");
        ModelLayerRegistry.registerModelLayer(POPLAR_BOAT_LAYER, BoatModel::createBoatModel);
        EntityRenderers.register(EEntities.POPLAR_BOAT, context -> new BoatRenderer(context, POPLAR_BOAT_LAYER));
        ModelLayerRegistry.registerModelLayer(POPLAR_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
        EntityRenderers.register(EEntities.POPLAR_CHEST_BOAT, context -> new BoatRenderer(context, POPLAR_CHEST_BOAT_LAYER));

        ModelLayerLocation AZALEA_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "boat/azalea"), "main");
        ModelLayerLocation AZALEA_CHEST_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "chest_boat/azalea"), "main");
        ModelLayerRegistry.registerModelLayer(AZALEA_BOAT_LAYER, BoatModel::createBoatModel);
        EntityRenderers.register(EEntities.AZALEA_BOAT, context -> new BoatRenderer(context, AZALEA_BOAT_LAYER));
        ModelLayerRegistry.registerModelLayer(AZALEA_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
        EntityRenderers.register(EEntities.AZALEA_CHEST_BOAT, context -> new BoatRenderer(context, AZALEA_CHEST_BOAT_LAYER));
    }
}