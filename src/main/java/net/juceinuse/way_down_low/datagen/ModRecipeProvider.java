package net.juceinuse.way_down_low.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.juceinuse.way_down_low.block.ModBlocks;
import net.juceinuse.way_down_low.item.ModItems;
import net.juceinuse.way_down_low.util.ModTags;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

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

                createCompressibleOre(itemLookup, ModItems.TUNGSTEN_NUGGET, ModItems.TUNGSTEN_INGOT, ModBlocks.TUNGSTEN_BLOCK.asItem());
                createCompressibleOre(itemLookup, ModItems.RAW_TUNGSTEN, ModBlocks.RAW_TUNGSTEN_BLOCK.asItem());
                createToolSet(itemLookup, ModTags.Items.TUNGSTEN_TOOL_MATERIALS, ModItems.TUNGSTEN_INGOT, ModItems.TUNGSTEN_AXE, ModItems.TUNGSTEN_HOE, ModItems.TUNGSTEN_PICKAXE, ModItems.TUNGSTEN_SHOVEL, ModItems.TUNGSTEN_SWORD);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BREWING, ModItems.TUNGSTEN_TEAR)
                        .pattern(" # ")
                        .pattern("###")
                        .pattern("## ")
                        .input('#', ModItems.TUNGSTEN_NUGGET)
                        .criterion(hasItem(ModItems.TUNGSTEN_NUGGET), conditionsFromItem(ModItems.TUNGSTEN_NUGGET))
                        .offerTo(exporter);

                offerSmelting(RAW_TUNGSTEN_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_TUNGSTEN, 0.75f, 200, "raw_tungsten");
                offerBlasting(TUNGSTEN_BLASTABLES, RecipeCategory.MISC, ModItems.TUNGSTEN_INGOT, 1.5f, 200, "tungsten");
            }

            public void createCompressibleOre(RegistryEntryLookup<Item> itemLookup, Item nugget, Item ingot, Item block) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ingot)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', nugget)
                        .criterion(hasItem(nugget), conditionsFromItem(nugget))
                        .offerTo(exporter,getId(ingot)+"_from_nuggets");

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, block)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ingot)
                        .criterion(hasItem(ingot), conditionsFromItem(ingot))
                        .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ingot, 9)
                        .input(block)
                        .criterion(hasItem(block), conditionsFromItem(block))
                        .offerTo(exporter,getId(ingot)+"_from_"+getId(block));

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, nugget, 9)
                        .input(ingot)
                        .criterion(hasItem(ingot), conditionsFromItem(ingot))
                        .offerTo(exporter);
            }

            public void createCompressibleOre(RegistryEntryLookup<Item> itemLookup, Item ingot, Item block) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, block)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ingot)
                        .criterion(hasItem(ingot), conditionsFromItem(ingot))
                        .offerTo(exporter);

                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ingot, 9)
                        .input(block)
                        .criterion(hasItem(block), conditionsFromItem(block))
                        .offerTo(exporter,getId(ingot)+"_from_"+getId(block));
            }

            public void createToolSet(RegistryEntryLookup<Item> itemLookup, TagKey<Item> items, Item icon, Item axe, Item hoe, Item pickaxe, Item shovel, Item sword) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, axe)
                        .pattern("XX ")
                        .pattern("X# ")
                        .pattern(" # ")
                        .input('#', Items.STICK)
                        .input('X', items)
                        .criterion("has_"+getId(icon), conditionsFromTag(items))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, hoe)
                        .pattern("XX ")
                        .pattern(" # ")
                        .pattern(" # ")
                        .input('#', Items.STICK)
                        .input('X', items)
                        .criterion("has_"+getId(icon), conditionsFromTag(items))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, pickaxe)
                        .pattern("XXX")
                        .pattern(" # ")
                        .pattern(" # ")
                        .input('#', Items.STICK)
                        .input('X', items)
                        .criterion("has_"+getId(icon), conditionsFromTag(items))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.TOOLS, shovel)
                        .pattern(" X ")
                        .pattern(" # ")
                        .pattern(" # ")
                        .input('#', Items.STICK)
                        .input('X', items)
                        .criterion("has_"+getId(icon), conditionsFromTag(items))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.COMBAT, sword)
                        .pattern(" X ")
                        .pattern(" X ")
                        .pattern(" # ")
                        .input('#', Items.STICK)
                        .input('X', items)
                        .criterion("has_"+getId(icon), conditionsFromTag(items))
                        .offerTo(exporter);
            }

            public String getId(Item item) {
                String str = item.toString();
                return str.substring(str.indexOf(':')+1);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
