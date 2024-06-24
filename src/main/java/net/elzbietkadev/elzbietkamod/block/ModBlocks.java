package net.elzbietkadev.elzbietkamod.block;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.custom.ModFlammableRotatedPillarBlock;
import net.elzbietkadev.elzbietkamod.block.custom.SutinkaCropBlock;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.elzbietkadev.elzbietkamod.worldgen.tree.SutinkaTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public  static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<Block> SUT_BLOCK = registerBlock("sut_block",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).sound(SoundType.METAL).strength(0.5f))));

    public static final RegistryObject<Block> SUT_ORE = registerBlock("sut_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops(), UniformInt.of(4,5)));

    public static final RegistryObject<Block> DEEPSLATE_SUT_ORE = registerBlock("deepslate_sut_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(4,5)));

    public static final RegistryObject<Block> SUTINKA_LOG = registerBlock("sutinka_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> SUTINKA_WOOD = registerBlock("sutinka_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_SUTINKA_LOG = registerBlock("stripped_sutinka_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_SUTINKA_WOOD = registerBlock("stripped_sutinka_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));


    public static final RegistryObject<Block> SUTINKA_LEAVES = registerBlock("sutinka_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> SUTINKA_SAPLING = registerBlock("sutinka_sapling",
            () -> new SaplingBlock(new SutinkaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> SUTINKA_CROP = BLOCKS.register("sutinka_crop",
            () -> new SutinkaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

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
