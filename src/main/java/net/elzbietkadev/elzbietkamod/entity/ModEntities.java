package net.elzbietkadev.elzbietkamod.entity;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.entity.custom.SutEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<EntityType<SutEntity>> SUT =
            ENTITY_TYPES.register("sut_entity", () -> EntityType.Builder.of(SutEntity::new, MobCategory.MONSTER)
                    .sized(1f, 1f).build("sut_entity"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}