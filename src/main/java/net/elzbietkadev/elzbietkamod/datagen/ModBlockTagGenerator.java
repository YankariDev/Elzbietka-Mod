package net.elzbietkadev.elzbietkamod.datagen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider
{
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ElzbietkaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SUT_ORE.get(),
                        ModBlocks.SUT_BLOCK.get(),
                        ModBlocks.DEEPSLATE_SUT_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SUT_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SUT_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SUT_ORE.get(), ModBlocks.DEEPSLATE_SUT_ORE.get()).addTag(Tags.Blocks.ORES);
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SUT_BLOCK.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SUTINKA_LOG.get())
                .add(ModBlocks.SUTINKA_WOOD.get())
                .add(ModBlocks.STRIPPED_SUTINKA_LOG.get())
                .add(ModBlocks.STRIPPED_SUTINKA_WOOD.get());
    }
}
