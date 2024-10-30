package net.juceinuse.way_down_low.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.juceinuse.way_down_low.WayDownLow;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item RAW_TUNGSTEN = register("raw_tungsten");
    public static final Item TUNGSTEN_INGOT = register("tungsten_ingot");
    public static final Item TUNGSTEN_NUGGET = register("tungsten_nugget");
    public static final Item TUNGSTEN_TEAR = register("tungsten_tear");
    public static final Item TUNGSTEN_AXE = register("tungsten_axe", settings -> new AxeItem(ModToolMaterials.TUNGSTEN, 6.0F, -3.1F, settings));
    public static final Item TUNGSTEN_PICKAXE = register("tungsten_pickaxe", settings -> new PickaxeItem(ModToolMaterials.TUNGSTEN, 1.0F, -2.8F, settings));
    public static final Item TUNGSTEN_SHOVEL = register("tungsten_shovel", settings -> new ShovelItem(ModToolMaterials.TUNGSTEN, 1.5F, -3.0F, settings));
    public static final Item TUNGSTEN_HOE = register("tungsten_hoe", settings -> new HoeItem(ModToolMaterials.TUNGSTEN, -2.0F, -1.0F, settings));
    public static final Item TUNGSTEN_SWORD = register("tungsten_sword", settings -> new SwordItem(ModToolMaterials.TUNGSTEN, 3.0F, -2.4F, settings));
    public static final Item TUNGSTEN_HELMET = register("tungsten_helmet", settings -> new ArmorItem(ModArmorMaterials.TUNGSTEN, EquipmentType.HELMET, settings.fireproof()));
    public static final Item TUNGSTEN_CHESTPLATE = register("tungsten_chestplate", settings -> new ArmorItem(ModArmorMaterials.TUNGSTEN, EquipmentType.CHESTPLATE, settings.fireproof()));
    public static final Item TUNGSTEN_LEGGINGS = register("tungsten_leggings", settings -> new ArmorItem(ModArmorMaterials.TUNGSTEN, EquipmentType.LEGGINGS, settings.fireproof()));
    public static final Item TUNGSTEN_BOOTS = register("tungsten_boots", settings -> new ArmorItem(ModArmorMaterials.TUNGSTEN, EquipmentType.BOOTS, settings.fireproof()));

    private static Item register(String id) {
        return Registry.register(Registries.ITEM, keyOf(id), new Item(new Item.Settings().registryKey(keyOf(id))));
    }

    private static Item register(String id, Function<Item.Settings, Item> factory) {
        return register(keyOf(id), factory, new Item.Settings());
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WayDownLow.MOD_ID,id));
    }

    public static void registerModItems() {
        WayDownLow.LOGGER.info("Registering items for "+WayDownLow.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_TUNGSTEN);
            entries.add(TUNGSTEN_INGOT);
            entries.add(TUNGSTEN_NUGGET);
            entries.add(TUNGSTEN_TEAR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
                entries.add(TUNGSTEN_AXE);
                entries.add(TUNGSTEN_PICKAXE);
                entries.add(TUNGSTEN_SHOVEL);
                entries.add(TUNGSTEN_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
                entries.add(TUNGSTEN_SWORD);
                entries.add(TUNGSTEN_HELMET);
                entries.add(TUNGSTEN_CHESTPLATE);
                entries.add(TUNGSTEN_LEGGINGS);
                entries.add(TUNGSTEN_BOOTS);
        });
    }
}
