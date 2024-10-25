package net.juceinuse.way_down_low.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.juceinuse.way_down_low.block.ModBlocks;
import net.juceinuse.way_down_low.item.ModItems;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup,recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> TUNGSTEN_BLASTABLES = List.of(ModItems.RAW_TUNGSTEN, ModBlocks.TUNGSTEN_ORE, ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
                List<ItemConvertible> RAW_TUNGSTEN_SMELTABLES = List.of(ModBlocks.TUNGSTEN_ORE, ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
                RegistryEntryLookup<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModBlocks.TUNGSTEN_BLOCK)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModItems.TUNGSTEN_INGOT)
                        .criterion(hasItem(ModItems.TUNGSTEN_INGOT), conditionsFromItem(ModItems.TUNGSTEN_INGOT))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModBlocks.RAW_TUNGSTEN_BLOCK)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModItems.RAW_TUNGSTEN)
                        .criterion(hasItem(ModItems.RAW_TUNGSTEN), conditionsFromItem(ModItems.RAW_TUNGSTEN))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModItems.TUNGSTEN_NUGGET)
                        .criterion(hasItem(ModItems.TUNGSTEN_NUGGET), conditionsFromItem(ModItems.TUNGSTEN_NUGGET))
                        .offerTo(exporter,"tungsten_ingot_from_nuggets");

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BREWING, ModItems.TUNGSTEN_TEAR)
                        .pattern(" # ")
                        .pattern("###")
                        .pattern("## ")
                        .input('#', ModItems.TUNGSTEN_NUGGET)
                        .criterion(hasItem(ModItems.TUNGSTEN_NUGGET), conditionsFromItem(ModItems.TUNGSTEN_NUGGET))
                        .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT, 9)
                        .input(ModBlocks.TUNGSTEN_BLOCK)
                        .criterion(hasItem(ModBlocks.TUNGSTEN_BLOCK), conditionsFromItem(ModBlocks.TUNGSTEN_BLOCK))
                        .offerTo(exporter,"tungsten_ingot_from_tungsten_block");

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.RAW_TUNGSTEN, 9)
                        .input(ModBlocks.RAW_TUNGSTEN_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_TUNGSTEN_BLOCK), conditionsFromItem(ModBlocks.RAW_TUNGSTEN_BLOCK))
                        .offerTo(exporter,"raw_tungsten_from_raw_tungsten_block");

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.TUNGSTEN_NUGGET, 9)
                        .input(ModItems.TUNGSTEN_INGOT)
                        .criterion(hasItem(ModItems.TUNGSTEN_INGOT), conditionsFromItem(ModItems.TUNGSTEN_INGOT))
                        .offerTo(exporter);

                offerSmelting(RAW_TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_TUNGSTEN, 0.75f, 200, "raw_tungsten");
                offerBlasting(TUNGSTEN_BLASTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT, 1.5f, 200, "tungsten");
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
