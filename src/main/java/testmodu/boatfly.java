package testmodu;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

import static testmodu.genel_ayarlar.LOGGER;

public class boatfly implements ClientTickEvents.StartTick {


    public boatfly() {

        LOGGER.info("test");

    }

    public void onStartTick(MinecraftClient client) {
        if(client.player!=null && client.player.hasVehicle() && genel_ayarlar.boatflyEnabled) {
            Entity vehicle = client.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY = client.options.jumpKey.isPressed() ? 0.5 : 0;
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
            LOGGER.info("sonunda!");
        }
        LOGGER.info("sonunda?");
    }

}
