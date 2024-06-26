package net.elzbietkadev.elzbietkamod.datagen.loot;

import net.elzbietkadev.elzbietkamod.entity.ModEntities;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.packs.VanillaEntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Stream;

public class ModEntityLootTable extends EntityLootSubProvider
{
    public ModEntityLootTable()
    {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.add(ModEntities.SUT.get(), LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.SUT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2)).when(LootItemKilledByPlayerCondition.killedByPlayer())))));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get);
    }
}
