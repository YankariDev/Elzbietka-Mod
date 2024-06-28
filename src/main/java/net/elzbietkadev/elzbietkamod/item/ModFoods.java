package net.elzbietkadev.elzbietkamod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SUT = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.2f).build();
    public static final FoodProperties SUTINKA = new FoodProperties.Builder()
            .nutrition(6).saturationMod(1.2f).build();

    public static final FoodProperties SUT_MEAT = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.6f).build();
    public static final FoodProperties COOKED_SUT_MEAT = new FoodProperties.Builder()
            .nutrition(8).saturationMod(1.6f).build();
}
