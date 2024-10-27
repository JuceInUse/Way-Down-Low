package net.juceinuse.way_down_low.mixin;

import net.juceinuse.way_down_low.entity.effect.ModStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.MaceItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MaceItem.class)
public abstract class MaceItemMixin {
    @ModifyVariable(method = "getBonusAttackDamage", at = @At("STORE"), ordinal = 3)
    private float injected(float h, Entity target, float baseAttackDamage, DamageSource damageSource) {
        if (damageSource.getSource() instanceof LivingEntity livingEntity && livingEntity.getActiveStatusEffects().containsKey(ModStatusEffects.DENSITY)) {
            int amplifier = livingEntity.getActiveStatusEffects().get(ModStatusEffects.DENSITY).getAmplifier()+1;
            return h+(h*0.25f*amplifier);
        }
        return h;
    }
}