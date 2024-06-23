package net.elzbietkadev.elzbietkamod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SUT = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.2f).build();
    public static final FoodProperties SUTINKA = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.4f).build();
}
