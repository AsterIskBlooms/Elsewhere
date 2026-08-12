package team.lookingglass.elsewhere.entity;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.entity.model.VanguardModel;
import team.lookingglass.elsewhere.entity.model.PerchModel;
import team.lookingglass.elsewhere.entity.model.SulfurCubeModel;
import team.lookingglass.elsewhere.entity.renderer.*;

public class EEntityRenderers {
    public static void register() {
        EntityRenderers.register(EEntities.FROSTBITE, FrostbiteRenderer::new);

        EntityRenderers.register(EEntities.WEREWOLF, WerewolfRenderer::new);

        ModelLayerRegistry.registerModelLayer(VanguardModel.LAYER_LOCATION, VanguardModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(VanguardModel.ARMOR_HEAD, () -> VanguardModel.createArmorLayer(new CubeDeformation(0.5F)));
        ModelLayerRegistry.registerModelLayer(VanguardModel.ARMOR_CHEST, () -> VanguardModel.createArmorLayer(new CubeDeformation(0.5F)));
        ModelLayerRegistry.registerModelLayer(VanguardModel.ARMOR_LEGS, () -> VanguardModel.createArmorLayer(new CubeDeformation(0.25F)));
        ModelLayerRegistry.registerModelLayer(VanguardModel.ARMOR_FEET, () -> VanguardModel.createArmorLayer(new CubeDeformation(0.5F)));

        EntityRenderers.register(EEntities.VANGUARD, VanguardRenderer::new);

        ModelLayerRegistry.registerModelLayer(SulfurCubeModel.LAYER_LOCATION, SulfurCubeModel::createBodyLayer);
        EntityRenderers.register(EEntities.SULFUR_CUBE, SulfurCubeRenderer::new);

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

        ModelLayerLocation CEDAR_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "boat/cedar"), "main");
        ModelLayerLocation CEDAR_CHEST_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "chest_boat/cedar"), "main");
        ModelLayerRegistry.registerModelLayer(CEDAR_BOAT_LAYER, BoatModel::createBoatModel);
        EntityRenderers.register(EEntities.CEDAR_BOAT, context -> new BoatRenderer(context, CEDAR_BOAT_LAYER));
        ModelLayerRegistry.registerModelLayer(CEDAR_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
        EntityRenderers.register(EEntities.CEDAR_CHEST_BOAT, context -> new BoatRenderer(context, CEDAR_CHEST_BOAT_LAYER));

        ModelLayerLocation MAHOGANY_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "boat/mahogany"), "main");
        ModelLayerLocation MAHOGANY_CHEST_BOAT_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Elsewhere.MODID, "chest_boat/mahogany"), "main");
        ModelLayerRegistry.registerModelLayer(MAHOGANY_BOAT_LAYER, BoatModel::createBoatModel);
        EntityRenderers.register(EEntities.MAHOGANY_BOAT, context -> new BoatRenderer(context, MAHOGANY_BOAT_LAYER));
        ModelLayerRegistry.registerModelLayer(MAHOGANY_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
        EntityRenderers.register(EEntities.MAHOGANY_CHEST_BOAT, context -> new BoatRenderer(context, MAHOGANY_CHEST_BOAT_LAYER));
    }
}