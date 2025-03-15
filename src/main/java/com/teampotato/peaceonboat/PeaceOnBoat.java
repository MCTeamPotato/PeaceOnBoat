package com.teampotato.peaceonboat;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PeaceOnBoat.MODID)
public class PeaceOnBoat {
    public static final String MODID = "peaceonboat";

    public PeaceOnBoat(FMLJavaModLoadingContext context) {
        Logger logger = LogManager.getLogger();
        logger.warn("Hello from PeaceOnBoat!");
        MinecraftForge.EVENT_BUS.addListener((LivingAttackEvent event) -> {
            Entity entity = event.getSource().getEntity();
            if (entity instanceof LivingEntity source && !entity.level().isClientSide() && source.getVehicle() != null) {
                event.setCanceled(true);
            }
        });
    }
}