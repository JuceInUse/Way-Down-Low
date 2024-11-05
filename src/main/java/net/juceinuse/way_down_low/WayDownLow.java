package net.juceinuse.way_down_low;

import net.fabricmc.api.ModInitializer;

import net.juceinuse.way_down_low.block.ModBlocks;
import net.juceinuse.way_down_low.block.entity.ModBlockEntityTypes;
import net.juceinuse.way_down_low.entity.effect.ModStatusEffects;
import net.juceinuse.way_down_low.item.ModArmorMaterials;
import net.juceinuse.way_down_low.item.ModItems;
import net.juceinuse.way_down_low.item.ModToolMaterials;
import net.juceinuse.way_down_low.particle.ModParticleTypes;
import net.juceinuse.way_down_low.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WayDownLow implements ModInitializer {
	public static final String MOD_ID = "way_down_low";
	public static final String MOD_ID_READABLE = "Way Down Low";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID_READABLE);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModStatusEffects.registerEffects();
		ModPotions.registerPotions();
		ModToolMaterials.registerModToolMaterials();
		ModArmorMaterials.registerModArmorMaterials();
		ModBlockEntityTypes.registerModBlockEntityTypes();
		ModParticleTypes.registerModParticleTypes();
	}
}