package net.elzbietkadev.elzbietkamod.worldgen.biome;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(ElzbietkaMod.MOD_ID, "overworld"), 15));
    }
}