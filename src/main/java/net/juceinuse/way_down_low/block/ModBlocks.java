package net.juceinuse.way_down_low.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.juceinuse.way_down_low.WayDownLow;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block RAW_TUNGSTEN_BLOCK = register("raw_tungsten_block", AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).strength(50.0F, 1200.0F));
    public static final Block TUNGSTEN_BLOCK = register("tungsten_block", AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(50.0F, 1200.0F));
    public static final Block TUNGSTEN_ORE = register("tungsten_ore", AbstractBlock.Settings.copy(Blocks.IRON_ORE).strength(50.0F, 1200.0F));
    public static final Block DEEPSLATE_TUNGSTEN_ORE = register("deepslate_tungsten_ore", AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).strength(50.0F, 1200.0F));

    public static final Block TUNGSTEN_FIRE = register(
            "tungsten_fire",
            TungstenFireBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIME)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .luminance(state -> 10)
                    .sounds(BlockSoundGroup.WOOL)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings options) {
        return register(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(WayDownLow.MOD_ID, id)), factory, options);
    }

    private static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static Block register(String id, AbstractBlock.Settings settings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(WayDownLow.MOD_ID, id));
        Block block = new Block(settings.registryKey(key));
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
