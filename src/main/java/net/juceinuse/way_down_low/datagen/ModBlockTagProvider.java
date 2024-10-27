package net.juceinuse.way_down_low.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.juceinuse.way_down_low.block.ModBlocks;
import net.juceinuse.way_down_low.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Vanilla Tags
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TUNGSTEN_BLOCK)
                .add(ModBlocks.RAW_TUNGSTEN_BLOCK)
                .add(ModBlocks.TUNGSTEN_ORE)
                .add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TUNGSTEN_BLOCK)
                .add(ModBlocks.RAW_TUNGSTEN_BLOCK)
                .add(ModBlocks.TUNGSTEN_ORE)
                .add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.TUNGSTEN_BLOCK);

        // Way Down Low Tags
        getOrCreateTagBuilder(ModTags.Blocks.TUNGSTEN_ORES)
                .add(ModBlocks.TUNGSTEN_ORE)
                .add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_TUNGSTEN_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        // Conventional Tags
        getOrCreateTagBuilder(ModTags.Blocks.ORES)
                .add(ModBlocks.TUNGSTEN_ORE)
                .add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        getOrCreateTagBuilder(ModTags.Blocks.STORAGE_BLOCKS)
                .add(ModBlocks.TUNGSTEN_BLOCK)
                .add(ModBlocks.RAW_TUNGSTEN_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.STORAGE_BLOCKS_TUNGSTEN)
                .add(ModBlocks.TUNGSTEN_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.STORAGE_BLOCKS_RAW_TUNGSTEN)
                .add(ModBlocks.RAW_TUNGSTEN_BLOCK);
    }
}
