package net.elzbietkadev.elzbietkamod.block;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public  static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<Block> SUT_BLOCK = registerBlock("sut_block",
            () -> new Block((BlockBehaviour.Properties.ofFullCopy(Blocks.COBWEB).sound(SoundType.METAL))));

    public static final RegistryObject<Block> SUT_ORE = registerBlock("sut_ore",
            () -> new Block((BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE))));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
