package xyz.luisch444.carpet.mixin;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.luisch444.carpet.HostingluischSettings;


import java.util.Random;

import static net.minecraft.block.Block.*;



@Mixin(Block.class)
public abstract class BlockMixin implements ItemConvertible {


    @Unique
    private static Random rand = new Random();

    @Inject(method = "dropStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)V",
            at = @At("HEAD"), cancellable = true)
    private static void dropStacks(BlockState state, World world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfo ci) {
        if (world instanceof ServerWorld && entity instanceof PlayerEntity) {
            boolean isSneaking = entity.isInSneakingPose();
            if ((HostingluischSettings.carefulBreak.equals("sneaking") && isSneaking) ||
                            (HostingluischSettings.carefulBreak.equals("no-sneaking") && !isSneaking) ||
                            HostingluischSettings.carefulBreak.equals("always")){
                getDroppedStacks(state, (ServerWorld) world, pos, blockEntity, entity, stack).forEach((itemStack) -> {
                    Item item = itemStack.getItem();
                    int itemAmount = itemStack.getCount();
                    if (((PlayerEntity) entity).getInventory().insertStack(itemStack)) {
                        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, (rand.nextFloat() - rand.nextFloat()) * 1.4F + 2.0F);
                        ((PlayerEntity) entity).increaseStat(Stats.PICKED_UP.getOrCreateStat(item), itemAmount);
                    } else {
                        Block.dropStack(world, pos, itemStack);
                    }
                });
                state.onStacksDropped((ServerWorld)world, pos, stack, false);
                ci.cancel();
            }
        }
    }

    //carefulBreak Multi-Blocks
    @Inject(method = "onBreak", at = @At("HEAD"))
    private void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<BlockState> cir) {
        boolean isSneaking = player.isInSneakingPose();
        if ((HostingluischSettings.carefulBreak.equals("sneaking") && isSneaking) ||
                        (HostingluischSettings.carefulBreak.equals("no-sneaking") && !isSneaking) ||
                        HostingluischSettings.carefulBreak.equals("always")){
            if (Blocks.PISTON_HEAD.equals(state.getBlock())) {
                Direction direction = state.get(FacingBlock.FACING).getOpposite();
                BlockPos pos2 = pos.offset(direction);
                BlockState blockState = world.getBlockState(pos2);
                Block block = world.getBlockState(pos2).getBlock();
                if (block == Blocks.PISTON || block == Blocks.STICKY_PISTON && blockState.get(PistonBlock.EXTENDED)) {
                    Block.dropStacks(blockState, world, pos2, null, player, player.getMainHandStack());
                    world.removeBlock(pos2, false);
                }
            }
        }
    }
}