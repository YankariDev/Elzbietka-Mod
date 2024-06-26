package net.elzbietkadev.elzbietkamod;

import com.mojang.logging.LogUtils;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.entity.ModEntities;
import net.elzbietkadev.elzbietkamod.entity.client.SutRenderer;
import net.elzbietkadev.elzbietkamod.item.ModCreativeModeTabs;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.elzbietkadev.elzbietkamod.loot.ModLootModifiers;
import net.elzbietkadev.elzbietkamod.sound.ModSounds;
import net.elzbietkadev.elzbietkamod.worldgen.biome.ModBiomes;
import net.elzbietkadev.elzbietkamod.worldgen.biome.ModTerrablender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ElzbietkaMod.MOD_ID)
public class ElzbietkaMod
{
    public static final String MOD_ID = "elzbietkamod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ElzbietkaMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModTerrablender.registerBiomes();
        ModEntities.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SUTINKA_FLOWER.getId(), ModBlocks.POTTED_SUTINKA_FLOWER);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.SUT.get(), SutRenderer::new);
        }
    }
}
