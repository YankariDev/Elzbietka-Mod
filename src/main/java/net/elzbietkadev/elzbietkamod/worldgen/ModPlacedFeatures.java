package net.elzbietkadev.elzbietkamod.worldgen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class ModPlacedFeatures
{
    public static final ResourceKey<PlacedFeature> SUT_ORE_PLACED = registerKey("sut_ore_placed");
    //public static final ResourceKey<PlacedFeature> NETHER_SUT_ORE_PLACED = registerKey("nether_sut_ore_placed");
    //public static final ResourceKey<PlacedFeature> END_SUT_ORE_PLACED = registerKey("end_sut_ore_placed");

    public static final ResourceKey<PlacedFeature> SUTINKA_TREE_PLACED = registerKey("sutinka_tree_placed");
    public static final ResourceKey<PlacedFeature> SUTINKA_FLOWER_PLACED = registerKey("sutinka_flower_placed");

    public static void boostrap(BootstapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SUT_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SUT_ORE),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        //register(context, NETHER_SUT_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SUT_ORE),
                //ModOrePlacement.commonOrePlacement(12,
                        //HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        //register(context, END_SUT_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SUT_ORE),
                //ModOrePlacement.commonOrePlacement(12,
                        //HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, SUTINKA_TREE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUTINKA_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f, 2), ModBlocks.SUTINKA_SAPLING.get()));
        register(context, SUTINKA_FLOWER_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUTINKA_FLOWER_KEY),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(16), ModBlocks.SUTINKA_FLOWER.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ElzbietkaMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
