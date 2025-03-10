package net.elzbietkadev.elzbietkamod.datagen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.elzbietkadev.elzbietkamod.util.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static final List<ItemLike> SUT_FOOD = List.of(ModItems.SUT_MEAT.get());
    public ModRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, SUT_FOOD, RecipeCategory.FOOD, ModItems.COOKED_SUT_MEAT.get(), 0.25f, 200, "sut_meat");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUT_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SUT_SPAWN_EGG.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', ModItems.SUT.get())
                .define('B', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_WOOD.get())
                .pattern("AA ")
                .pattern("AA ")
                .pattern("   ")
                .define('A', ModBlocks.SUTINKA_LOG.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_LOG.get()), has(ModBlocks.SUTINKA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_SUTINKA_WOOD.get())
                .pattern("AA ")
                .pattern("AA ")
                .pattern("   ")
                .define('A', ModBlocks.STRIPPED_SUTINKA_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_SUTINKA_LOG.get()), has(ModBlocks.STRIPPED_SUTINKA_LOG.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SUTINKA.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', ModItems.SUT.get())
                .define('B', Items.SUGAR)
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_PLANKS_STAIRS.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.SUTINKA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUTINKA_PLANKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUPER_SUT_STONE_BRICKS_STAIRS.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.SUPER_SUT_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.SUPER_SUT_STONE_BRICKS.get()), has(ModBlocks.SUPER_SUT_STONE_BRICKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUPER_SUT_STONE_BRICKS_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("AAA")
                .define('A', ModBlocks.SUPER_SUT_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.SUPER_SUT_STONE_BRICKS.get()), has(ModBlocks.SUPER_SUT_STONE_BRICKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUPER_SUT_STONE_BRICKS_WALL.get(), 6)
                .pattern("   ")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.SUPER_SUT_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.SUPER_SUT_STONE_BRICKS.get()), has(ModBlocks.SUPER_SUT_STONE_BRICKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_PLANKS_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("AAA")
                .define('A', ModBlocks.SUTINKA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUTINKA_PLANKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_PLANKS_PRESSURE_PLATE.get())
                .pattern("AA ")
                .define('A', ModBlocks.SUTINKA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUPER_SUT_STONE_BRICKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_PLANKS_FENCE.get(), 6)
                .pattern("   ")
                .pattern("ABA")
                .pattern("ABA")
                .define('A', ModBlocks.SUTINKA_PLANKS.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUTINKA_PLANKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_PLANKS_FENCE_GATE.get(), 6)
                .pattern("   ")
                .pattern("ABA")
                .pattern("ABA")
                .define('A', Items.STICK)
                .define('B', ModBlocks.SUTINKA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUTINKA_PLANKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_PLANKS_DOOR.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("AAA")
                .define('A', ModBlocks.SUTINKA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUTINKA_PLANKS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUTINKA_PLANKS_TRAPDOOR.get())
                .pattern("   ")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.SUTINKA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUTINKA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_HOE.get())
                .pattern("BB ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_SHOVEL.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_SWORD.get())
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_AXE.get())
                .pattern("BB ")
                .pattern("BA ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_PICKAXE.get())
                .pattern("BBB")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUT_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ModItems.SUT.get(), 9)
                .requires(ModBlocks.SUT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SUT_BLOCK.get()), has(ModBlocks.SUT_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SUTINKA_PLANKS_BUTTON.get())
                .requires(ModBlocks.SUTINKA_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.SUTINKA_PLANKS.get()), has(ModBlocks.SUTINKA_PLANKS.get()))
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SUTINKA_SEEDS.get(), 2)
                .requires(ModItems.SUTINKA.get())
                .unlockedBy(getHasName(ModItems.SUTINKA.get()), has(ModItems.SUTINKA.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OGIEN_SIE_PALI.get(), 1)
                .requires(Items.FLINT)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .save(consumer);



        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_HOE.get())
                .pattern("BB ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_SHOVEL.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_SWORD.get())
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_AXE.get())
                .pattern("BB ")
                .pattern("BA ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_PICKAXE.get())
                .pattern("BBB")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SUPER_SUT_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUT_UPGRADER_STATION.get())
                .pattern("ACA")
                .pattern("BCB")
                .pattern("ACA")
                .define('A', ModItems.SUT.get())
                .define('B', Blocks.OBSIDIAN)
                .define('C', ModItems.SUPER_SUT.get())
                .unlockedBy(getHasName(ModItems.SUPER_SUT.get()), has(ModItems.SUPER_SUT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GLOWING_SUT_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.GLOWING_SUT.get())
                .unlockedBy(getHasName(ModItems.GLOWING_SUT.get()), has(ModItems.GLOWING_SUT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLOWING_SUT.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', ModItems.SUT.get())
                .define('B', Items.GLOWSTONE_DUST)
                .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ZJEBUSKA_MUSIC_DISC.get())
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.REDSTONE)
                .define('B', ModItems.SUT.get())
                .unlockedBy(getHasName(ModItems.SUT.get()), has(ModItems.SUT.get()))
                .save(consumer);

        planksFromLogs(consumer, ModBlocks.SUTINKA_PLANKS.get(), ModTags.Items.SUTINKA_LOGS, 4);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  ElzbietkaMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
