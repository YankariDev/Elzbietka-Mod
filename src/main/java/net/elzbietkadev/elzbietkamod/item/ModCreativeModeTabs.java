package net.elzbietkadev.elzbietkamod.item;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ELZBIETKA_TAB = TABS.register("elzbietka_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SUT.get()))
                    .title(Component.translatable("creativetab.elzbietka_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SUT_ORE.get());
                        output.accept(ModBlocks.SUT_BLOCK.get());
                        output.accept(ModItems.SUT.get());
                        output.accept(ModItems.SUTINKA.get());
                        output.accept(ModItems.CUM_MODELECZKI.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        TABS.register(eventBus);
    }
}
