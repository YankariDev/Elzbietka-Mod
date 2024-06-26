package net.elzbietkadev.elzbietkamod.datagen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.entity.ModEntities;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.elzbietkadev.elzbietkamod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ElzbietkaMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("sut_from_horse", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/horse")).build() }, ModItems.SUT.get()));

        add("sut_from_cow", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/cow")).build() }, ModItems.SUT.get()));



        add("sut_from_sut_entity", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sut_entity")).build() }, ModItems.SUT.get()));
    }
}