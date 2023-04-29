package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

public class VendorBlock extends DirectionalBlock {
    int random; long timeLeft; boolean available;
    public VendorBlock(Settings settings){ super(settings); }

    @Override public BlockRenderType getRenderType(BlockState state) { return BlockRenderType.MODEL; }

    @Override public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if(timeLeft <= 0){
                if(player.getStackInHand(hand).isOf(ModItems.VENDOR_TOKEN)) {
                    world.playSound((double)pos.getX() + 0.5,pos.getY(), (double)pos.getZ() + 0.5, SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON,
                            SoundCategory.BLOCKS, 1.0F, 1.0F, false); timeLeft = 20; return ActionResult.SUCCESS;
                }
            }
        } return ActionResult.PASS;
    }

    ItemStack drop(){
        random = Random.createLocal().nextBetween(1,7);
        if(random == 1) return ModItems.COLA_CYAN.getDefaultStack();
        else if(random ==2) return ModItems.MUSHROOM_STEW_CAN.getDefaultStack();
        else if(random ==3) return ModItems.RABBIT_STEW_CAN.getDefaultStack();
        else if(random ==4) return ModItems.BEETROOT_SOUP_CAN.getDefaultStack();
        else if(random ==5) return ModItems.COLA_ORANGE.getDefaultStack();
        else if(random ==6) return ModItems.COLA_GREEN.getDefaultStack();
        else return ModItems.MILK_CAN.getDefaultStack();
    }

    @Override public boolean hasRandomTicks(BlockState state) { return true; }
    @Override public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (timeLeft > 0) { available = false; timeLeft--;
        } else if (timeLeft < 0) timeLeft = 0;
        else{ if(!available){
                if (state.get(FACING) == Direction.NORTH) {
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ() - 1, drop());
                } else if (state.get(FACING) == Direction.SOUTH) {
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ() + 1, drop());
                } else if (state.get(FACING) == Direction.EAST) {
                    ItemScatterer.spawn(world, pos.getX() + 1, pos.getY(), pos.getZ(), drop());
                } else if (state.get(FACING) == Direction.WEST) {
                    ItemScatterer.spawn(world, pos.getX() - 1, pos.getY(), pos.getZ(), drop());
                }
                available = true;
            }
        }
    }

    @Override public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0) world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                (double)pos.getZ() + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5f, 0.0f, false);
        if(timeLeft > 0) world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_BELL_USE, SoundCategory.BLOCKS,
                1.0f, timeLeft * 0.1f, false);
    }
}