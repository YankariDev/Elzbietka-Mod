package net.elzbietkadev.elzbietkamod.event;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.entity.client.ElzbietkaModel;
import net.elzbietkadev.elzbietkamod.entity.client.ModModelLayers;
import net.elzbietkadev.elzbietkamod.entity.client.SutEntityModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElzbietkaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SUT_ENTITY_LAYER, SutEntityModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ELZBIETKA_ENTITY_LAYER, ElzbietkaModel::createBodyLayer);
    }
}