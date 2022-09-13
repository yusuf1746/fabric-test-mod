package testmodu.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import testmodu.genel_ayarlar;
@Mixin(FishingBobberEntity.class)
public abstract class autofishingMixin {


    @Shadow private boolean caughtFish;


    @Inject(at = @At("TAIL"), method = "tick()V")
    public void tick(CallbackInfo info) {


        MinecraftClient client = MinecraftClient.getInstance();


        if(caughtFish == true) {
            if(genel_ayarlar.AutoFishingEnabled) {
                client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    if(i == 10) {
                        client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
                    }
                }
            }
        }



    }
    
}
