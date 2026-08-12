package team.lookingglass.elsewhere.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import team.lookingglass.elsewhere.entity.EEntities;

import java.util.concurrent.CompletableFuture;

public class EntityTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public EntityTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(EntityTypeTags.ZOMBIES).add(EEntities.FROSTBITE);
        valueLookupBuilder(EntityTypeTags.UNDEAD).add(EEntities.FROSTBITE, EEntities.VANGUARD, EEntities.WEREWOLF);

        valueLookupBuilder(EntityTypeTags.BURN_IN_DAYLIGHT).add(EEntities.FROSTBITE);
        valueLookupBuilder(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES).add(EEntities.FROSTBITE, EEntities.VANGUARD, EEntities.WEREWOLF);

        valueLookupBuilder(EntityTypeTags.AQUATIC).add(EEntities.PERCH);
        valueLookupBuilder(EntityTypeTags.NOT_SCARY_FOR_PUFFERFISH).add(EEntities.PERCH);
        valueLookupBuilder(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(EEntities.PERCH);
    }
}
