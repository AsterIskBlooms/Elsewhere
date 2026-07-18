package team.lookingglass.elsewhere.registry.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import team.lookingglass.elsewhere.Elsewhere;

public interface EBiomeTags {

    TagKey<Biome> IS_CAVE = TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Elsewhere.MODID, "is_cave"));

    static void initialize() {}
}
