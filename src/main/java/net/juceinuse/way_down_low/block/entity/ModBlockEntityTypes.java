package net.juceinuse.way_down_low.block.entity;

import net.juceinuse.way_down_low.WayDownLow;
import net.juceinuse.way_down_low.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;

public class ModBlockEntityTypes {
    public static void registerModBlockEntityTypes() {
        WayDownLow.LOGGER.info("Registering Block Entity Types for {}",WayDownLow.MOD_ID_READABLE);

        BlockEntityType.CAMPFIRE.addSupportedBlock(ModBlocks.TUNGSTEN_CAMPFIRE);
    }
}
