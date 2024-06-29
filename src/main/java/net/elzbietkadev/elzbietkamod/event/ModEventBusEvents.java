package net.elzbietkadev.elzbietkamod.event;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.entity.ModEntities;
import net.elzbietkadev.elzbietkamod.entity.custom.ElzbietkaEntity;
import net.elzbietkadev.elzbietkamod.entity.custom.SutEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElzbietkaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SUT.get(), SutEntity.createAttributes().build());
        event.put(ModEntities.ELZBIETKA.get(), ElzbietkaEntity.createAttributes().build());
    }
}