package net.juceinuse.way_down_low;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.juceinuse.way_down_low.block.ModBlocks;
import net.juceinuse.way_down_low.particle.ModParticleTypes;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;

public class WayDownLowClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUNGSTEN_FIRE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUNGSTEN_CAMPFIRE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUNGSTEN_LANTERN, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.TUNGSTEN_FIRE_FLAME, FlameParticle.Factory::new);
    }
}
