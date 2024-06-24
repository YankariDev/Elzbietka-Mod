package net.elzbietkadev.elzbietkamod.worldgen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SUT_ORE = registerKey("sut_ore");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SUT_ORE = registerKey("nether_sut_ore");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> END_SUT_ORE = registerKey("end_sut_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SUTINKA_TREE_KEY = registerKey("sutinka_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUTINKA_FLOWER_KEY = registerKey("sutinka_flower");

    public static void boostrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        //RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        //RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldSutOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.SUT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SUT_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_SUT_ORE, Feature.ORE, new OreConfiguration(overworldSutOres, 9));
        //register(context, NETHER_SUT_ORE, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                //ModBlocks.SUT_BLOCK.get().defaultBlockState(), 9));
        //register(context, END_SUT_ORE, Feature.ORE, new OreConfiguration(endReplaceables,
                //ModBlocks.SUT_BLOCK.get().defaultBlockState(), 9));

        register(context, SUTINKA_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.SUTINKA_LOG.get()),
                new StraightTrunkPlacer(2, 2, 2),

                BlockStateProvider.simple(ModBlocks.SUTINKA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 2, 1)).build());

        register(context, SUTINKA_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(150, 6, 2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider
                        .simple(ModBlocks.SUTINKA_FLOWER.get())))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ElzbietkaMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
