package xyz.luisch444.carpet.mixin;

import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.luisch444.carpet.HostingluischSettings;

@Mixin(ItemCooldownManager.class)
public class ItemCooldownManagerMixin {
    @Inject(method = "set(Lnet/minecraft/item/ItemStack;I)V", at = @At("HEAD"), cancellable = true)
    private void changeCooldown(ItemStack item, int duration, CallbackInfo ci) {
        if (HostingluischSettings.enderPearlsNoCooldown && item.getItem() instanceof EnderPearlItem){
            ci.cancel();
        }
    }

    @Inject(method = "set(Lnet/minecraft/util/Identifier;I)V", at = @At("HEAD"), cancellable = true)
    private void changeCooldown(Identifier groupId, int duration, CallbackInfo ci) {
        if (HostingluischSettings.enderPearlsNoCooldown && Registries.ITEM.getId(Items.ENDER_PEARL).equals(groupId)){
            ci.cancel();
        }
    }
}
