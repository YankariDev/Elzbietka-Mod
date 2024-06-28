package net.elzbietkadev.elzbietkamod.compat;

import com.mojang.blaze3d.systems.RenderSystem;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.recipe.SutUpgraderRecipe;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class SutUpgraderCategory implements IRecipeCategory<SutUpgraderRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(ElzbietkaMod.MOD_ID, "sut_upgrader");
    public static final ResourceLocation TEXTURE = new ResourceLocation(ElzbietkaMod.MOD_ID,
            "textures/gui/sut_upgrader_gui.png");

    public static final RecipeType<SutUpgraderRecipe> SUT_UPGRADER_TYPE =
            new RecipeType<>(UID, SutUpgraderRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SutUpgraderCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SUT_UPGRADER_STATION.get()));
    }

    @Override
    public RecipeType<SutUpgraderRecipe> getRecipeType() {
        return SUT_UPGRADER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.elzbietkamod.sut_upgrader_station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SutUpgraderRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 76, 11).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 76, 47).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 140, 29).addItemStack(recipe.getResultItem(null));
    }
}