package net.elzbietkadev.elzbietkamod.item;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<Item> SUT_FOOD = ITEMS.register("sut",
            () -> new Item(new Item.Properties().food(ModFoods.SUT)));

    public static final RegistryObject<Item> CUM_MODELECZKI = ITEMS.register("cum_modeleczki",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
