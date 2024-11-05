package net.juceinuse.way_down_low.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.juceinuse.way_down_low.WayDownLow;
import net.juceinuse.way_down_low.entity.effect.ModStatusEffects;
import net.juceinuse.way_down_low.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static RegistryEntry<Potion> PUNGENT = registerPotion("pungent",new Potion("pungent"));
    public static RegistryEntry<Potion> DENSITY = registerPotion("density",new Potion("density", new StatusEffectInstance(ModStatusEffects.DENSITY, 3600)));
    public static RegistryEntry<Potion> LONG_DENSITY = registerPotion("long_density",new Potion("density", new StatusEffectInstance(ModStatusEffects.DENSITY, 9600)));
    public static RegistryEntry<Potion> STRONG_DENSITY = registerPotion("strong_density",new Potion("density", new StatusEffectInstance(ModStatusEffects.DENSITY, 1800,1)));

    private static RegistryEntry<Potion> registerPotion(String id, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(WayDownLow.MOD_ID,id), potion);
    }

    protected static void registerRecipes() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.WATER, ModItems.TUNGSTEN_TEAR, ModPotions.PUNGENT);
            builder.registerRecipes(ModItems.TUNGSTEN_TEAR,ModPotions.DENSITY);
            builder.registerPotionRecipe(ModPotions.DENSITY, Items.REDSTONE, ModPotions.LONG_DENSITY);
            builder.registerPotionRecipe(ModPotions.DENSITY, Items.GLOWSTONE_DUST, ModPotions.STRONG_DENSITY);
        });
    }

    public static void registerPotions() {
        WayDownLow.LOGGER.info("Registering potions for {}", WayDownLow.MOD_ID);
        registerRecipes();
    }
}
