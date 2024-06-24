package net.elzbietkadev.elzbietkamod.datagen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.block.custom.SutinkaCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ElzbietkaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SUT_BLOCK);
        blockWithItem(ModBlocks.SUT_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SUT_ORE);
        blockWithItem(ModBlocks.SUTINKA_PLANKS);

        logBlock(((RotatedPillarBlock) ModBlocks.SUTINKA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.SUTINKA_WOOD.get()), blockTexture(ModBlocks.SUTINKA_LOG.get()), blockTexture(ModBlocks.SUTINKA_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SUTINKA_LOG.get()), blockTexture(ModBlocks.STRIPPED_SUTINKA_LOG.get()),
                new ResourceLocation(ElzbietkaMod.MOD_ID, "block/stripped_sutinka_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SUTINKA_WOOD.get()), blockTexture(ModBlocks.STRIPPED_SUTINKA_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_SUTINKA_LOG.get()));

        blockItem(ModBlocks.SUTINKA_LOG);
        blockItem(ModBlocks.SUTINKA_WOOD);
        blockItem(ModBlocks.STRIPPED_SUTINKA_LOG);
        blockItem(ModBlocks.STRIPPED_SUTINKA_WOOD);

        leavesBlock(ModBlocks.SUTINKA_LEAVES);
        saplingBlock(ModBlocks.SUTINKA_SAPLING);

        makeSutinkaCrop((CropBlock) ModBlocks.SUTINKA_CROP.get(), "sutinki_stage", "sutinki_stage");
    }

    public void makeSutinkaCrop(CropBlock block, String modelName, String textureName)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> sutinkaStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] sutinkaStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SutinkaCropBlock) block).getAgeProperty()),
                new ResourceLocation(ElzbietkaMod.MOD_ID, "block/" + textureName + state.getValue(((SutinkaCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(ElzbietkaMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
