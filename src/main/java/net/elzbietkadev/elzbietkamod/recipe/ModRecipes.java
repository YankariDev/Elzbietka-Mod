package net.elzbietkadev.elzbietkamod.recipe;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ElzbietkaMod.MOD_ID);


    public static final RegistryObject<RecipeSerializer<SutUpgraderRecipe>> SUT_UPGRADER_SERIALIZER =
            SERIALIZERS.register("sut_upgrader", () -> SutUpgraderRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus)
    {
        SERIALIZERS.register(eventBus);
    }
}
