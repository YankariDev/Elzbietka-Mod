package net.elzbietkadev.elzbietkamod.datagen;

import net.elzbietkadev.elzbietkamod.ElzbietkaMod;
import net.elzbietkadev.elzbietkamod.block.ModBlocks;
import net.elzbietkadev.elzbietkamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider
{
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElzbietkaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SUT);
        simpleItem(ModItems.SUTINKA_SEEDS);
        simpleItem(ModItems.CUM_MODELECZKI);
        simpleItem(ModItems.SUTINKA);
        simpleItem(ModItems.ZJEBUSKA_MUSIC_DISC);
        saplingItem(ModBlocks.SUTINKA_SAPLING);

        simpleBlockItem(ModBlocks.SUTINKA_PLANKS_DOOR);
        fenceItem(ModBlocks.SUTINKA_PLANKS_FENCE, ModBlocks.SUTINKA_PLANKS);
        buttonItem(ModBlocks.SUTINKA_PLANKS_BUTTON, ModBlocks.SUTINKA_PLANKS);
        trapdoorItem(ModBlocks.SUTINKA_PLANKS_TRAPDOOR);
        wallItem(ModBlocks.SUPER_SUT_STONE_BRICKS_WALL, ModBlocks.SUPER_SUT_STONE_BRICKS);

        evenSimplerBlockItem(ModBlocks.SUTINKA_PLANKS_STAIRS);
        evenSimplerBlockItem(ModBlocks.SUTINKA_PLANKS_SLAB);
        evenSimplerBlockItem(ModBlocks.SUTINKA_PLANKS_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.SUTINKA_PLANKS_FENCE_GATE);

        evenSimplerBlockItem(ModBlocks.SUPER_SUT_STONE_BRICKS_STAIRS);
        evenSimplerBlockItem(ModBlocks.SUPER_SUT_STONE_BRICKS_SLAB);

        handheldItem(ModItems.SUT_AXE);
        handheldItem(ModItems.SUT_HOE);
        handheldItem(ModItems.SUT_PICKAXE);
        handheldItem(ModItems.SUT_SWORD);
        handheldItem(ModItems.SUT_SHOVEL);

        trimmedArmorItem(ModItems.SUT_HELMET);
        trimmedArmorItem(ModItems.SUT_CHESTPLATE);
        trimmedArmorItem(ModItems.SUT_LEGGINGS);
        trimmedArmorItem(ModItems.SUT_BOOTS);

        simpleBlockItemBlockTexture(ModBlocks.SUTINKA_FLOWER);


        simpleItem(ModItems.SUPER_SUT);

        trimmedArmorItem(ModItems.SUPER_SUT_HELMET);
        trimmedArmorItem(ModItems.SUPER_SUT_CHESTPLATE);
        trimmedArmorItem(ModItems.SUPER_SUT_LEGGINGS);
        trimmedArmorItem(ModItems.SUPER_SUT_BOOTS);

        handheldItem(ModItems.SUPER_SUT_AXE);
        handheldItem(ModItems.SUPER_SUT_HOE);
        handheldItem(ModItems.SUPER_SUT_PICKAXE);
        handheldItem(ModItems.SUPER_SUT_SWORD);
        handheldItem(ModItems.SUPER_SUT_SHOVEL);
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(ElzbietkaMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElzbietkaMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElzbietkaMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ElzbietkaMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ElzbietkaMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ElzbietkaMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ElzbietkaMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElzbietkaMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElzbietkaMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ElzbietkaMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
