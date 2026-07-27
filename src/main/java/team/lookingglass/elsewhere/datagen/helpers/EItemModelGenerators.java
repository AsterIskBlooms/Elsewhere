package team.lookingglass.elsewhere.datagen.helpers;

import net.minecraft.client.color.item.Dye;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import team.lookingglass.elsewhere.registry.trim.EEquipmentAssets;
import team.lookingglass.elsewhere.registry.trim.ETrimMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class EItemModelGenerators extends ItemModelGenerators {
    public EItemModelGenerators(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }
    private static final List<TrimMaterialData> CUSTOM_TRIM_MATERIAL_MODELS =
            Stream.concat(
                    ItemModelGenerators.TRIM_MATERIAL_MODELS.stream(),
                    Stream.of(
                            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.create("tin"), ETrimMaterials.TIN),
                            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.create("silver"), ETrimMaterials.SILVER),
                            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.create("bronze", Map.of(EEquipmentAssets.BRONZE, "bronze_darker")), ETrimMaterials.BRONZE),
                            new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.create("soulsteel", Map.of(EEquipmentAssets.SOULSTEEL, "soulsteel_darker")), ETrimMaterials.SOULSTEEL)
                    )
            ).toList();

    public final void customGenerateTrimmableItem(Item armor, ResourceKey<EquipmentAsset> equipmentAssetId,
                                                  Identifier slotTrimPrefix, boolean hasDyedLayer) {
        Identifier modelLocation = ModelLocationUtils.getModelLocation(armor);
        Material itemTexture = TextureMapping.getItemTexture(armor);
        Material overlayTexture = TextureMapping.getItemTexture(armor, "_overlay");
        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> cases = new ArrayList<>(CUSTOM_TRIM_MATERIAL_MODELS.size());

        for (ItemModelGenerators.TrimMaterialData material : CUSTOM_TRIM_MATERIAL_MODELS) {
            Identifier trimModelLocation = modelLocation.withSuffix("_" + material.assets().base().suffix() + "_trim");
            Material trimOverlayTexture = new Material(slotTrimPrefix.withSuffix("_" + material.assets().assetId(equipmentAssetId).suffix()));
            ItemModel.Unbaked trimModel;
            if (hasDyedLayer) {
                this.generateLayeredItem(trimModelLocation, itemTexture, overlayTexture, trimOverlayTexture);
                trimModel = ItemModelUtils.tintedModel(trimModelLocation, new Dye(-6265536));
            } else {
                this.generateLayeredItem(trimModelLocation, itemTexture, trimOverlayTexture);
                trimModel = ItemModelUtils.plainModel(trimModelLocation);
            }
            cases.add(ItemModelUtils.when(material.materialKey(), trimModel));
        }

        ItemModel.Unbaked untrimmedModel;
        if (hasDyedLayer) {
            ModelTemplates.TWO_LAYERED_ITEM.create(modelLocation, TextureMapping.layered(itemTexture, overlayTexture), this.modelOutput);
            untrimmedModel = ItemModelUtils.tintedModel(modelLocation, new Dye(-6265536));
        } else {
            ModelTemplates.FLAT_ITEM.create(modelLocation, TextureMapping.layer0(itemTexture), this.modelOutput);
            untrimmedModel = ItemModelUtils.plainModel(modelLocation);
        }

        this.itemModelOutput.accept(armor, ItemModelUtils.select(new TrimMaterialProperty(), untrimmedModel, cases));
    }
}
