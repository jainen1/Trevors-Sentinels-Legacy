package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

public class GoldenRiceCropBlock extends CropBlock {
    public static final IntProperty AGE = IntProperty.of("age",0,7);
    public GoldenRiceCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem(){
        return ModItems.GOLDEN_RICE;
    }

    @Override
    public int getMaxAge(){
        return 7;
    }

    @Override
    public IntProperty getAgeProperty(){
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(AGE);
    }
}
