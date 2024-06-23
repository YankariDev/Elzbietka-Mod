package net.elzbietkadev.elzbietkamod.item;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<Item> SUT = ITEMS.register("sut",
            () -> new Item(new Item.Properties().food(ModFoods.SUT)));
    public static final RegistryObject<Item> SUTINKA = ITEMS.register("sutinka",
            () -> new Item(new Item.Properties().food(ModFoods.SUTINKA)));

    public static final RegistryObject<Item> CUM_MODELECZKI = ITEMS.register("cum_modeleczki",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUTINKA_SEEDS = ITEMS.register("sutinka_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SUTINKA_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> ZJEBUSKA_MUSIC_DISC = ITEMS.register("zjebuska_music_disc",
            () -> new RecordItem(6, ModSounds.ZJEBUSKA, new Item.Properties().stacksTo(1), 1490));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
