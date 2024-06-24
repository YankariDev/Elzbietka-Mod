package net.elzbietkadev.elzbietkamod.datagen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
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
                .add(ModBlocks.SUPER_SUT_STONE.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS_STAIRS.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS_SLAB.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS_WALL.get())
                .add(ModBlocks.SUT_ORE.get())
                .add(ModBlocks.SUT_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_SUT_ORE.get())
                .add(ModBlocks.SUPER_SUT_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SUTINKA_LOG.get())
                .add(ModBlocks.SUTINKA_WOOD.get())
                .add(ModBlocks.STRIPPED_SUTINKA_LOG.get())
                .add(ModBlocks.STRIPPED_SUTINKA_WOOD.get())
                .add(ModBlocks.SUT_BLOCK.get())
                .add(ModBlocks.SUTINKA_PLANKS.get())
                .add(ModBlocks.SUTINKA_PLANKS_STAIRS.get())
                .add(ModBlocks.SUTINKA_PLANKS_SLAB.get())
                .add(ModBlocks.SUTINKA_PLANKS_FENCE.get())
                .add(ModBlocks.SUTINKA_PLANKS_FENCE_GATE.get())
                .add(ModBlocks.SUTINKA_PLANKS_BUTTON.get())
                .add(ModBlocks.SUTINKA_PLANKS_DOOR.get())
                .add(ModBlocks.SUTINKA_PLANKS_PRESSURE_PLATE.get())
                .add(ModBlocks.SUTINKA_PLANKS_TRAPDOOR.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SUT_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SUPER_SUT_STONE.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS_STAIRS.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS_SLAB.get())
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS_WALL.get())
                .add(ModBlocks.SUPER_SUT_ORE.get()).addTag(Tags.Blocks.ORES);
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SUT_ORE.get(), ModBlocks.DEEPSLATE_SUT_ORE.get()).addTag(Tags.Blocks.ORES);
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SUT_BLOCK.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SUTINKA_LOG.get())
                .add(ModBlocks.SUTINKA_WOOD.get())
                .add(ModBlocks.STRIPPED_SUTINKA_LOG.get())
                .add(ModBlocks.STRIPPED_SUTINKA_WOOD.get())
                .add(ModBlocks.SUTINKA_PLANKS.get())
                .add(ModBlocks.SUTINKA_PLANKS_STAIRS.get())
                .add(ModBlocks.SUTINKA_PLANKS_SLAB.get())
                .add(ModBlocks.SUTINKA_PLANKS_FENCE.get())
                .add(ModBlocks.SUTINKA_PLANKS_FENCE_GATE.get())
                .add(ModBlocks.SUTINKA_PLANKS_BUTTON.get())
                .add(ModBlocks.SUTINKA_PLANKS_DOOR.get())
                .add(ModBlocks.SUTINKA_PLANKS_TRAPDOOR.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SUTINKA_PLANKS_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SUTINKA_PLANKS_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SUPER_SUT_STONE_BRICKS_WALL.get());
    }
}
