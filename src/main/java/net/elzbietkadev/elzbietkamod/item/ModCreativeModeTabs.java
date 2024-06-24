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
                        output.accept(ModBlocks.DEEPSLATE_SUT_ORE.get());
                        output.accept(ModBlocks.SUTINKA_LOG.get());
                        output.accept(ModBlocks.STRIPPED_SUTINKA_LOG.get());
                        output.accept(ModBlocks.SUTINKA_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_SUTINKA_WOOD.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_STAIRS.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_SLAB.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_FENCE.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_FENCE_GATE.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_BUTTON.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_DOOR.get());
                        output.accept(ModBlocks.SUTINKA_PLANKS_TRAPDOOR.get());
                        output.accept(ModBlocks.SUTINKA_LEAVES.get());
                        output.accept(ModBlocks.SUTINKA_FLOWER.get());
                        output.accept(ModItems.CUM_MODELECZKI.get());
                        output.accept(ModItems.SUTINKA_SEEDS.get());
                        output.accept(ModBlocks.SUTINKA_SAPLING.get());
                        output.accept(ModItems.ZJEBUSKA_MUSIC_DISC.get());
                        output.accept(ModBlocks.SUT_BLOCK.get());
                        output.accept(ModItems.SUT.get());
                        output.accept(ModItems.SUTINKA.get());
                        output.accept(ModItems.SUT_HOE.get());
                        output.accept(ModItems.SUT_SWORD.get());
                        output.accept(ModItems.SUT_SHOVEL.get());
                        output.accept(ModItems.SUT_AXE.get());
                        output.accept(ModItems.SUT_PICKAXE.get());
                        output.accept(ModItems.SUT_HELMET.get());
                        output.accept(ModItems.SUT_CHESTPLATE.get());
                        output.accept(ModItems.SUT_LEGGINGS.get());
                        output.accept(ModItems.SUT_BOOTS.get());



                        output.accept(ModBlocks.SUPER_SUT_STONE.get());
                        output.accept(ModBlocks.SUPER_SUT_STONE_BRICKS.get());
                        output.accept(ModBlocks.SUPER_SUT_STONE_BRICKS_STAIRS.get());
                        output.accept(ModBlocks.SUPER_SUT_STONE_BRICKS_SLAB.get());
                        output.accept(ModBlocks.SUPER_SUT_STONE_BRICKS_WALL.get());
                        output.accept(ModItems.SUPER_SUT.get());
                        output.accept(ModItems.SUPER_SUT_HOE.get());
                        output.accept(ModItems.SUPER_SUT_SWORD.get());
                        output.accept(ModItems.SUPER_SUT_SHOVEL.get());
                        output.accept(ModItems.SUPER_SUT_AXE.get());
                        output.accept(ModItems.SUPER_SUT_PICKAXE.get());
                        output.accept(ModItems.SUPER_SUT_HELMET.get());
                        output.accept(ModItems.SUPER_SUT_CHESTPLATE.get());
                        output.accept(ModItems.SUPER_SUT_LEGGINGS.get());
                        output.accept(ModItems.SUPER_SUT_BOOTS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        TABS.register(eventBus);
    }
}
