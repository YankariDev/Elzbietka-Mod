package net.elzbietkadev.elzbietkamod.block.custom;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SutinkaCropBlock extends CropBlock
{
    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public SutinkaCropBlock(Properties p_52247_) {
        super(p_52247_);
    }
}
