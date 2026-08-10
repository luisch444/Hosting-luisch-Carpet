package xyz.luisch444.carpet.mixin;

import net.minecraft.util.Holidays;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.luisch444.carpet.HostingluischSettings;

@Mixin(Holidays.class)
public class HolidaysMixin {

    @Inject(at = @At("HEAD"), method = "isHalloween()Z", cancellable = true)
    private static void checkHallowing(CallbackInfoReturnable<Boolean> cir) {
        if (!HostingluischSettings.isHalloween) {
            return;
        }
        cir.setReturnValue(true);
    }

}
