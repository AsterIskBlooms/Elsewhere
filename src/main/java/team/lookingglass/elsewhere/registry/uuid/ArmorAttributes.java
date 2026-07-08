package team.lookingglass.elsewhere.registry.uuid;

import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;

public interface ArmorAttributes {
    Identifier SOULSTEEL_HELMET_HEALTH_ID = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel_helmet_health");
    Identifier SOULSTEEL_CHESTPLATE_HEALTH_ID = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel_chestplate_health");
    Identifier SOULSTEEL_LEGGINGS_HEALTH_ID = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel_leggings_health");
    Identifier SOULSTEEL_BOOTS_HEALTH_ID = Identifier.fromNamespaceAndPath(Elsewhere.MODID, "soulsteel_boots_health");

}
