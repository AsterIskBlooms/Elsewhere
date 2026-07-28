package team.lookingglass.elsewhere.worldgen.features.placement;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import team.lookingglass.elsewhere.Elsewhere;

public interface EPlacementModifiers {
    PlacementModifierType<SeaLevelFilter> SEA_LEVEL_FILTER = Registry.register(
            BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "sea_level_filter"),
            () -> SeaLevelFilter.CODEC);

    static void initialize() {}
}
