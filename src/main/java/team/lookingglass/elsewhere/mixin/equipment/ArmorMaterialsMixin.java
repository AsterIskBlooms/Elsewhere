package team.lookingglass.elsewhere.mixin.equipment;

import com.google.common.collect.Maps;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ArmorMaterials.class)
public interface ArmorMaterialsMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void patchMaterials(CallbackInfo ci) {
        mutate(ArmorMaterials.COPPER, 6, makeDefense(1, 2, 2, 1, 5), 18, 0.0F, 0.0F);
        mutate(ArmorMaterials.LEATHER, 5, makeDefense(1, 2, 2, 1, 5), 6, 0.0F, 0.0F);
        mutate(ArmorMaterials.CHAINMAIL, 22, makeDefense(3, 5, 4, 2, 12), 24, 0.0F, 0.1F);
        mutate(ArmorMaterials.IRON, 42, makeDefense(4, 6, 5, 3, 16), 10, 1.0F, 0.05F);
        mutate(ArmorMaterials.GOLD, 18, makeDefense(3, 5, 4, 2, 12), 22, 2.0F, 0.0F);
        mutate(ArmorMaterials.DIAMOND, 80, makeDefense(4, 7, 6, 3, 20), 18, 2.0F, 0.0F);
        mutate(ArmorMaterials.NETHERITE, 125, makeDefense(4, 7, 6, 3, 20), 12, 3.0F, 0.1F);
    }

    @Unique
    private static void mutate(ArmorMaterial mat, int durability, Map<ArmorType, Integer> defense, int enchantmentValue, float toughness, float knockbackResistance) {
        mat.durability = durability;
        mat.defense = defense;
        mat.enchantmentValue = enchantmentValue;
        mat.toughness = toughness;
        mat.knockbackResistance = knockbackResistance;
    }

    @Unique
    private static Map<ArmorType, Integer> makeDefense( int helm, int chest, int legs, int boots, int body) {
        return Maps.newEnumMap(Map.of(
                ArmorType.BOOTS, boots,
                ArmorType.LEGGINGS, legs,
                ArmorType.CHESTPLATE, chest,
                ArmorType.HELMET, helm,
                ArmorType.BODY, body));
    }
}