package xyz.luisch444.carpet.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.luisch444.carpet.HostingluischSettings;

@Mixin(VillagerEntity.class)
public class VillagerEntityMixin {

    @Inject(method = "canSummonGolem", at = @At("HEAD"), cancellable = true)
    private void summonGolem(CallbackInfoReturnable<Boolean> cir) {
        if (HostingluischSettings.villagersNoGenerateGolems) {
            cir.setReturnValue(false);
        }
    }

}
