package net.elzbietkadev.elzbietkamod.sound;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElzbietkaMod.MOD_ID);

    public static final RegistryObject<SoundEvent> ZJEBUSKA = registerSoundEvents("zjebuska");

    public static final RegistryObject<SoundEvent> SUT_HURT = registerSoundEvents("sut.hurt");
    public static final RegistryObject<SoundEvent> SUT_DEATH = registerSoundEvents("sut.death");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ElzbietkaMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}