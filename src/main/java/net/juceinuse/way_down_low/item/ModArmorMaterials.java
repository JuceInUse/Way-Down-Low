package net.juceinuse.way_down_low.item;

import net.juceinuse.way_down_low.WayDownLow;
import net.juceinuse.way_down_low.util.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static final ArmorMaterial TUNGSTEN = registerMaterial(37, 2, 5, 6, 2, 5, 18, 3.0F, 0.1F, ModTags.Items.REPAIRS_TUNGSTEN_ARMOR, Identifier.of(WayDownLow.MOD_ID,"tungsten"));


    public static ArmorMaterial registerMaterial(int durabilityMultiplier, int boots, int leggings, int chestplate, int helmet, int animal, int enchantability, float toughness, float knockbackResistance, TagKey<Item> repairTag, Identifier model) {
        return new ArmorMaterial(durabilityMultiplier, Util.make(new EnumMap<>(EquipmentType.class), map -> {
            map.put(EquipmentType.BOOTS, boots);
            map.put(EquipmentType.LEGGINGS, leggings);
            map.put(EquipmentType.CHESTPLATE, chestplate);
            map.put(EquipmentType.HELMET, helmet);
            map.put(EquipmentType.BODY, animal);
        }),enchantability, SoundEvents.ITEM_ARMOR_EQUIP_IRON, toughness, knockbackResistance, repairTag, model);
    }



    public static void registerModArmorMaterials() {
        WayDownLow.LOGGER.info("Registering armor materials for " + WayDownLow.MOD_ID);
    }
}
