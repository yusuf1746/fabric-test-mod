package testmodu.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import testmodu.genel_ayarlar;



@Mixin(BoatEntity.class)
public abstract class boatfly {

    @Shadow private double fallVelocity;

    MinecraftClient client = MinecraftClient.getInstance();

    double flypower = 5.0;

    @Inject(at = @At("TAIL"), method = "tick()V")
    public void tick(CallbackInfo info) {
        if(genel_ayarlar.boatflyEnabled && this.client.options.jumpKey.isPressed()) {

            this.fallVelocity = flypower + this.fallVelocity;

        }

        genel_ayarlar.LOGGER.info("hi");



    }


}
