package net.juceinuse.way_down_low.entity.effect;

import net.juceinuse.way_down_low.WayDownLow;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static RegistryEntry<StatusEffect> DENSITY = registerStatusEffect("density",
            new DensityStatusEffect(StatusEffectCategory.NEUTRAL,0xD1C57C)
                    .addAttributeModifier(EntityAttributes.GRAVITY,Identifier.of(WayDownLow.MOD_ID,"effect.density"),0.25f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.FALL_DAMAGE_MULTIPLIER,Identifier.of(WayDownLow.MOD_ID,"effect.density"),0.25f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE,Identifier.of(WayDownLow.MOD_ID,"effect.density"),-0.25f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );
    private static RegistryEntry<StatusEffect> registerStatusEffect(String id, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(WayDownLow.MOD_ID,id), effect);
    }

    public static void registerEffects() {
        WayDownLow.LOGGER.info("Registering effects for {}", WayDownLow.MOD_ID);
    }
}