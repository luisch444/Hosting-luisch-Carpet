package xyz.luisch444.carpet.mixin;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.luisch444.carpet.HostingluischSettings;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public abstract Item getItem();

    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void stackingItems(CallbackInfoReturnable<Integer> cir) {
        if (HostingluischSettings.stackeableTotems && Items.TOTEM_OF_UNDYING.equals(this.getItem())){
            cir.setReturnValue(HostingluischSettings.stackeableTotemsSize);
        }
    }
}
