package net.juceinuse.way_down_low.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.juceinuse.way_down_low.WayDownLow;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block RAW_TUNGSTEN_BLOCK = registerBlock("raw_tungsten_block", AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).strength(50.0F, 1200.0F));
    public static final Block TUNGSTEN_BLOCK = registerBlock("tungsten_block", AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(50.0F, 1200.0F));
    public static final Block TUNGSTEN_ORE = registerBlock("tungsten_ore", AbstractBlock.Settings.copy(Blocks.IRON_ORE).strength(50.0F, 1200.0F));
    public static final Block DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore", AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).strength(50.0F, 1200.0F));

    private static Block registerBlock(String id, AbstractBlock.Settings options) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(WayDownLow.MOD_ID, id));
        Block block = new Block(options.registryKey(key));
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String id, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WayDownLow.MOD_ID, id));
        Registry.register(Registries.ITEM, key,
                new BlockItem(block, new Item.Settings().registryKey(key).useBlockPrefixedTranslationKey())
        );
    }

    public static void registerModBlocks() {
        WayDownLow.LOGGER.info("Registering blocks for "+WayDownLow.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
                entries.add(RAW_TUNGSTEN_BLOCK);
                entries.add(TUNGSTEN_ORE);
                entries.add(DEEPSLATE_TUNGSTEN_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
                entries.add(TUNGSTEN_BLOCK)
        );
    }
}
