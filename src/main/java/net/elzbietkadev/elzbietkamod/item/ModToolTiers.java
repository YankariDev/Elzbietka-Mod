package net.elzbietkadev.elzbietkamod.item;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers
{
    public static final Tier SUT = TierSortingRegistry.registerTier(
            new ForgeTier(2, 350, 6.5f, 2f, 17,
                    ModTags.Blocks.NEEDS_SUT_TOOL, () -> Ingredient.of(ModItems.SUT.get())),
            new ResourceLocation(ElzbietkaMod.MOD_ID, "sut"), List.of(Tiers.IRON), List.of());
    public static final Tier SUPER_SUT = TierSortingRegistry.registerTier(
            new ForgeTier(2, 1900, 9.5f, 5f, 6,
                    ModTags.Blocks.NEEDS_SUT_TOOL, () -> Ingredient.of(ModItems.SUT.get())),
            new ResourceLocation(ElzbietkaMod.MOD_ID, "sut"), List.of(Tiers.IRON), List.of());

}
