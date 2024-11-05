package net.juceinuse.way_down_low.item;

import net.juceinuse.way_down_low.WayDownLow;
import net.juceinuse.way_down_low.util.ModTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial TUNGSTEN = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_TUNGSTEN_TOOL,2031,6.0F,2.0F,18,ModTags.Items.TUNGSTEN_TOOL_MATERIALS);



    public static void registerModToolMaterials() {
        WayDownLow.LOGGER.info("Registering tool materials for {}", WayDownLow.MOD_ID);
    }
}
