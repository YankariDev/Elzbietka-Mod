package net.elzbietkadev.elzbietkamod.datagen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider
{
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ElzbietkaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.ZJEBUSKA_MUSIC_DISC.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SUTINKA_LOG.get().asItem())
                .add(ModBlocks.SUTINKA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SUTINKA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_SUTINKA_WOOD.get().asItem());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SUT_HELMET.get())
                .add(ModItems.SUT_CHESTPLATE.get())
                .add(ModItems.SUT_LEGGINGS.get())
                .add(ModItems.SUT_BOOTS.get())
                .add(ModItems.SUPER_SUT_HELMET.get())
                .add(ModItems.SUPER_SUT_CHESTPLATE.get())
                .add(ModItems.SUPER_SUT_LEGGINGS.get())
                .add(ModItems.SUPER_SUT_BOOTS.get());
    }
}
