package xyz.luisch444.carpet.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.luisch444.carpet.HostingluischSettings;


@Mixin(targets = {"net.minecraft.entity.mob.EndermanEntity$PickUpBlockGoal", "net.minecraft.entity.mob.EndermanEntity$PlaceBlockGoal"})
public class EndermanEntityMixin {
    @Inject(method = "canStart", at = @At("HEAD"), cancellable = true)
    private void onEndermanAction(CallbackInfoReturnable<Boolean> cir) {
        if (HostingluischSettings.endermanNoGrief) {
            cir.setReturnValue(false);
        }
    }
}