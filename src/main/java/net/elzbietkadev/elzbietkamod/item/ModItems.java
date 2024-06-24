package net.elzbietkadev.elzbietkamod.item;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.sound.ModSounds;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> SUT_SWORD = ITEMS.register("sut_sword",
            () -> new SwordItem(ModToolTiers.SUT, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> SUT_HOE = ITEMS.register("sut_hoe",
            () -> new HoeItem(ModToolTiers.SUT, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> SUT_SHOVEL = ITEMS.register("sut_shovel",
            () -> new ShovelItem(ModToolTiers.SUT, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> SUT_AXE = ITEMS.register("sut_axe",
            () -> new AxeItem(ModToolTiers.SUT, 6, 2, new Item.Properties()));
    public static final RegistryObject<Item> SUT_PICKAXE = ITEMS.register("sut_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SUT, 1, 1, new Item.Properties()));

    public static final RegistryObject<Item> SUT_HELMET = ITEMS.register("sut_helmet",
            () -> new ArmorItem(ModArmorMaterials.SUT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SUT_CHESTPLATE = ITEMS.register("sut_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SUT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SUT_LEGGINGS = ITEMS.register("sut_leggings",
            () -> new ArmorItem(ModArmorMaterials.SUT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SUT_BOOTS = ITEMS.register("sut_boots",
            () -> new ArmorItem(ModArmorMaterials.SUT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
