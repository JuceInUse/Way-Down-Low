package net.juceinuse.way_down_low.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.juceinuse.way_down_low.WayDownLow;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticleTypes {
    public static final SimpleParticleType TUNGSTEN_FIRE_FLAME = register("tungsten_fire_flame");

    private static SimpleParticleType register(String id) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(WayDownLow.MOD_ID, id), FabricParticleTypes.simple());
    }

    public static void registerModParticleTypes() {
        WayDownLow.LOGGER.info("Registering Particle Types for {}",WayDownLow.MOD_ID_READABLE);
    }
}
