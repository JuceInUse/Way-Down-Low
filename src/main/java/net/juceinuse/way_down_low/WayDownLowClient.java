package net.juceinuse.way_down_low;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.juceinuse.way_down_low.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class WayDownLowClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUNGSTEN_FIRE, RenderLayer.getCutout());
    }
}
