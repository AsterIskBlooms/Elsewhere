package team.lookingglass.elsewhere.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import team.lookingglass.elsewhere.entity.EEntities;
import team.lookingglass.elsewhere.registry.tags.EEntityTags;

import java.util.concurrent.CompletableFuture;

public class EntityTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public EntityTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(EntityTypeTags.ZOMBIES).add(EEntities.FROSTBITE);
        valueLookupBuilder(EntityTypeTags.SKELETONS);
        valueLookupBuilder(EntityTypeTags.UNDEAD).add(EEntities.FROSTBITE, EEntities.VANGUARD, EEntities.WEREWOLF);

        valueLookupBuilder(EEntityTags.POSSESSABLE)
                .add(
                        EntityType.ZOMBIE, EntityType.HUSK, EntityType.DROWNED, EEntities.FROSTBITE,
                        EntityType.SKELETON, EntityType.PARCHED, EntityType.BOGGED, EntityType.STRAY,
                        EntityType.CREEPER, EEntities.SWEEPER, EntityType.ENDERMAN
                );

        valueLookupBuilder(EntityTypeTags.BURN_IN_DAYLIGHT).add(EEntities.FROSTBITE);
        valueLookupBuilder(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES).add(EEntities.FROSTBITE, EEntities.VANGUARD, EEntities.WEREWOLF);

        valueLookupBuilder(EntityTypeTags.AQUATIC).add(EEntities.PERCH);
        valueLookupBuilder(EntityTypeTags.NOT_SCARY_FOR_PUFFERFISH).add(EEntities.PERCH);
        valueLookupBuilder(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(EEntities.PERCH);
    }
}
