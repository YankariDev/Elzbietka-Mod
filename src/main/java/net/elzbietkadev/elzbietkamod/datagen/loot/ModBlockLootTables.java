package net.elzbietkadev.elzbietkamod.datagen.loot;

import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.block.custom.SutinkaCropBlock;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SUT_BLOCK.get());
        this.dropSelf(ModBlocks.SUTINKA_LOG.get());
        this.dropSelf(ModBlocks.SUTINKA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SUTINKA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_SUTINKA_WOOD.get());
        this.dropSelf(ModBlocks.SUTINKA_PLANKS.get());
        this.dropSelf(ModBlocks.SUTINKA_SAPLING.get());

        this.add(ModBlocks.SUTINKA_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.SUTINKA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.SUT_ORE.get(),
                block -> createCooperLikeOreDrops(ModBlocks.SUT_ORE.get(), ModItems.SUT.get()));
        this.add(ModBlocks.DEEPSLATE_SUT_ORE.get(),
                block -> createCooperLikeOreDrops(ModBlocks.DEEPSLATE_SUT_ORE.get(), ModItems.SUT.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SUTINKA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SutinkaCropBlock.AGE, 7));

        this.add(ModBlocks.SUTINKA_CROP.get(), createCropDrops(ModBlocks.SUTINKA_CROP.get(), ModItems.SUTINKA.get(),
                ModItems.SUTINKA_SEEDS.get(), lootitemcondition$builder));
    }

    protected LootTable.Builder createCooperLikeOreDrops(Block pBlock, Item item)
    {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4f,5f)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
