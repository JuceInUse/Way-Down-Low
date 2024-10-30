package net.juceinuse.way_down_low.util;

import net.juceinuse.way_down_low.WayDownLow;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> TUNGSTEN_TOOL_MATERIALS = createTag("tungsten_tool_materials");
        public static final TagKey<Item> REPAIRS_TUNGSTEN_ARMOR = createTag("repairs_tungsten_armor");
        public static final TagKey<Item> INGOTS_TUNGSTEN = createTag("ingots/tungsten");
        public static final TagKey<Item> RAW_MATERIALS_TUNGSTEN = createTag("raw_materials/tungsten");
        public static final TagKey<Item> NUGGETS_TUNGSTEN = createTag("nuggets/tungsten");
        public static final TagKey<Item> INGOTS = createConventionalTag("ingots");
        public static final TagKey<Item> RAW_MATERIALS = createConventionalTag("raw_materials");
        public static final TagKey<Item> NUGGETS = createConventionalTag("nuggets");
        public static final TagKey<Item> TOOLS_MELEE_WEAPONS = createConventionalTag("tools/melee_weapons");
        public static final TagKey<Item> TOOLS_MINING_TOOLS = createConventionalTag("tools/mining_tools");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(WayDownLow.MOD_ID, name));
        }
        private static TagKey<Item> createConventionalTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> NEEDS_TUNGSTEN_TOOL = createTag("needs_tungsten_tool");
        public static final TagKey<Block> INCORRECT_FOR_TUNGSTEN_TOOL = createTag("incorrect_for_tungsten_tool");
        public static final TagKey<Block> TUNGSTEN_ORES = createTag("tungsten_ores");
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_TUNGSTEN = createTag("storage_blocks/raw_tungsten");
        public static final TagKey<Block> STORAGE_BLOCKS_TUNGSTEN = createTag("storage_blocks/tungsten");
        public static final TagKey<Block> TUNGSTEN_FIRE_BASE_BLOCKS = createTag("tungsten_fire_base_blocks");
        public static final TagKey<Block> ORES = createConventionalTag("ores");
        public static final TagKey<Block> STORAGE_BLOCKS = createConventionalTag("storage_blocks");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(WayDownLow.MOD_ID, name));
        }
        private static TagKey<Block> createConventionalTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
        }
    }
}
