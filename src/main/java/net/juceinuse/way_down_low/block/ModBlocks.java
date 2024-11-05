package net.juceinuse.way_down_low.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.juceinuse.way_down_low.WayDownLow;
import net.juceinuse.way_down_low.particle.ModParticleTypes;
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
    public static final Block RAW_TUNGSTEN_BLOCK = register(
            "raw_tungsten_block",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).strength(50.0F, 1200.0F),
            new Item.Settings().fireproof()
    );
    public static final Block TUNGSTEN_BLOCK = register(
            "tungsten_block",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(50.0F, 1200.0F),
            new Item.Settings().fireproof()
    );
    public static final Block TUNGSTEN_ORE = register(
            "tungsten_ore",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.IRON_ORE).strength(50.0F, 1200.0F),
            new Item.Settings().fireproof()
    );
    public static final Block DEEPSLATE_TUNGSTEN_ORE = register(
            "deepslate_tungsten_ore",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).strength(50.0F, 1200.0F),
            new Item.Settings().fireproof()
    );

    public static final Block TUNGSTEN_TORCH = register(
            "tungsten_torch",
            settings -> new TorchBlock(ModParticleTypes.TUNGSTEN_FIRE_FLAME, settings),
            AbstractBlock.Settings.copy(Blocks.TORCH).luminance(state -> 12),
            false
    );

    public static final Block TUNGSTEN_WALL_TORCH = register(
            "tungsten_wall_torch",
            settings -> new WallTorchBlock(ModParticleTypes.TUNGSTEN_FIRE_FLAME, settings),
            copyLootTable(TUNGSTEN_TORCH, true).noCollision().breakInstantly().luminance(state -> 12).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY),
            false
    );

    public static final Block TUNGSTEN_LANTERN = register(
            "tungsten_lantern",
            LanternBlock::new,
            AbstractBlock.Settings.copy(Blocks.LANTERN).luminance(state -> 12),
            new Item.Settings().fireproof()
    );

    public static final Block TUNGSTEN_CAMPFIRE = register(
            "tungsten_campfire",
            settings -> new CampfireBlock(false, 3, settings),
            AbstractBlock.Settings.copy(Blocks.CAMPFIRE).luminance(Blocks.createLightLevelFromLitBlockState(12)),
            new Item.Settings().fireproof()
    );

    public static final Block TUNGSTEN_FIRE = register(
            "tungsten_fire",
            TungstenFireBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIME)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .luminance(state -> 12)
                    .sounds(BlockSoundGroup.WOOL)
                    .pistonBehavior(PistonBehavior.DESTROY),
            false
    );
    public static final Block PYRITE_BLOCK = register(
            "pyrite_block",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(Blocks.GOLD_BLOCK.getDefaultMapColor()),
            true
    );

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, Item.Settings itemSettings) {
        return register(id, factory, settings, itemSettings, true);
    }

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, Boolean hasItem) {
        return register(id, factory, settings, new Item.Settings(), hasItem);
    }

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, Item.Settings itemSettings, Boolean hasItem) {
        Block block = factory.apply(settings.registryKey(keyOf(id)));
        if (hasItem) {
            registerBlockItem(id, block, itemSettings);
        }
        return Registry.register(Registries.BLOCK, keyOf(id), block);
    }

    private static void registerBlockItem(String id, Block block, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WayDownLow.MOD_ID, id));
        Registry.register(Registries.ITEM, key,
                new BlockItem(block, itemSettings.registryKey(key).useBlockPrefixedTranslationKey())
        );
    }

    private static AbstractBlock.Settings copyLootTable(Block block, boolean copyTranslationKey) {
        AbstractBlock.Settings settings2 = AbstractBlock.Settings.create().lootTable(block.getLootTableKey());
        if (copyTranslationKey) {
            settings2 = settings2.overrideTranslationKey(block.getTranslationKey());
        }

        return settings2;
    }

    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(WayDownLow.MOD_ID,id));
    }

    public static void registerModBlocks() {
        WayDownLow.LOGGER.info("Registering blocks for {}",WayDownLow.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
                entries.add(RAW_TUNGSTEN_BLOCK);
                entries.add(TUNGSTEN_ORE);
                entries.add(DEEPSLATE_TUNGSTEN_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
                entries.add(TUNGSTEN_BLOCK);
                entries.add(PYRITE_BLOCK);
    });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(TUNGSTEN_CAMPFIRE);
            entries.add(TUNGSTEN_LANTERN);
        });
    }
}
