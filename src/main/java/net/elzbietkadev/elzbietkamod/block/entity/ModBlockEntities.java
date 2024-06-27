package net.elzbietkadev.elzbietkamod.block.entity;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SutUpgraderStationBlockEntity>> SUT_UPGRADER_BE =
            BLOCK_ENTITIES.register("sut_upgrader_be", () ->
                    BlockEntityType.Builder.of(SutUpgraderStationBlockEntity::new,
                            ModBlocks.SUT_UPGRADER_STATION.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}