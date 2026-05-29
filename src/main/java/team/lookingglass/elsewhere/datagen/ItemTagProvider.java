package team.lookingglass.elsewhere.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.EItems;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Item> REPAIRS_SILVER_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_silver_armor"));
    public static final TagKey<Item> REPAIRS_SOULSTEEL_ARMOR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "repairs_soulsteel_armor"));

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
    valueLookupBuilder(REPAIRS_SILVER_ARMOR).add(EItems.SILVER_INGOT);
    valueLookupBuilder(REPAIRS_SOULSTEEL_ARMOR).add(EItems.SOULSTEEL_INGOT);

















    }

}