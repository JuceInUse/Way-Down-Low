package net.juceinuse.way_down_low.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.juceinuse.way_down_low.WayDownLow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_TUNGSTEN = registerItem("raw_tungsten");
    public static final Item TUNGSTEN_INGOT = registerItem("tungsten_ingot");
    public static final Item TUNGSTEN_NUGGET = registerItem("tungsten_nugget");

    private static Item registerItem(String name) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM,Identifier.of(WayDownLow.MOD_ID, name));
        Item.Settings settings = new Item.Settings().registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    public static void registerModItems() {
        WayDownLow.LOGGER.info("Registering items for "+WayDownLow.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_TUNGSTEN);
            entries.add(TUNGSTEN_INGOT);
            entries.add(TUNGSTEN_NUGGET);
        });
    }
}