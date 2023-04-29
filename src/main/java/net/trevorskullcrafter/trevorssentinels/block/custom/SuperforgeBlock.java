package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.trevorskullcrafter.trevorssentinels.block.entity.SuperforgeBlockEntity;
import org.jetbrains.annotations.Nullable;

public class SuperforgeBlock extends FacingBlock implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SuperforgeBlock(Settings settings){ super(settings); }

    @Nullable @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) { return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite()); }

    @Override protected void appendProperties(StateManager.Builder<Block, BlockState> builder) { builder.add(FACING); }

    @Nullable @Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) { return new SuperforgeBlockEntity(pos, state); }

    @Override public BlockRenderType getRenderType(BlockState state){ return BlockRenderType.ENTITYBLOCK_ANIMATED; }
}