package xyz.luisch444.carpet.mixin;

import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.luisch444.carpet.HostingluischSettings;

@Mixin(ItemCooldownManager.class)
public class ItemCooldownManagerMixin {
    @Inject(method = "set", at = @At("HEAD"), cancellable = true)
    private void changeCooldown(Item item, int duration, CallbackInfo ci) {
        if (HostingluischSettings.enderPearlsNoCooldown && item instanceof EnderPearlItem){
            ci.cancel();
        }
    }
}
