package net.elzbietkadev.elzbietkamod.util;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SUT_TOOL = tag("needs_sut_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ElzbietkaMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SUTINKA_LOGS = tag("sutinka_logs");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ElzbietkaMod.MOD_ID, name));
        }
    }
}