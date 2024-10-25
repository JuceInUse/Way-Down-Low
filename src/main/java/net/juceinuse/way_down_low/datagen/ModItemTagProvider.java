package net.juceinuse.way_down_low.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.juceinuse.way_down_low.item.ModItems;
import net.juceinuse.way_down_low.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Vanilla Tags
        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.TUNGSTEN_INGOT);

        // Way Down Low Tags
        getOrCreateTagBuilder(ModTags.Items.TUNGSTEN_TOOL_MATERIALS)
                .add(ModItems.TUNGSTEN_INGOT);
        getOrCreateTagBuilder(ModTags.Items.REPAIRS_TUNGSTEN_ARMOR)
                .add(ModItems.TUNGSTEN_INGOT);
        getOrCreateTagBuilder(ModTags.Items.INGOTS_TUNGSTEN)
                .add(ModItems.TUNGSTEN_INGOT);
        getOrCreateTagBuilder(ModTags.Items.RAW_MATERIALS_TUNGSTEN)
                .add(ModItems.RAW_TUNGSTEN);
        getOrCreateTagBuilder(ModTags.Items.NUGGETS_TUNGSTEN)
                .add(ModItems.TUNGSTEN_NUGGET);

        // Conventional Tags
        getOrCreateTagBuilder(ModTags.Items.INGOTS)
                .add(ModItems.TUNGSTEN_INGOT);
        getOrCreateTagBuilder(ModTags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_TUNGSTEN);
        getOrCreateTagBuilder(ModTags.Items.NUGGETS)
                .add(ModItems.TUNGSTEN_NUGGET);
    }
}
