package xyz.luisch444.carpet.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.luisch444.carpet.HostingluischSettings;

import java.util.Map;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class AbstractBlockStateMixin {


    @Shadow
    public abstract Block getBlock();

    @Inject(method = "getHardness", at = @At("HEAD"), cancellable = true)
    public void changeHardness(BlockView world, BlockPos pos, CallbackInfoReturnable<Float> ci) {
        if (getBlock().equals(Blocks.END_STONE) && HostingluischSettings.endstoneInstaminable) {
            ci.setReturnValue(1.55f);
        } else if (getBlock().equals(Blocks.DEEPSLATE) && HostingluischSettings.deepslateInstaminable) {
            ci.setReturnValue(1.55f);
        }
        // (1 + 0.2 * 2 + el**2 + 1) / f / 30 = t
    }
}