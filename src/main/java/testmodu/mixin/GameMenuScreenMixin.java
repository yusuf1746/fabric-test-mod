package testmodu.mixin;


import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import testmodu.hacks;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    @Shadow protected abstract void initWidgets();

    protected GameMenuScreenMixin(Text text) {super(text);}

    @Inject(at = @At("TAIL"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci) {

        this.addDrawableChild(new ButtonWidget(this.width / 2 -155, this.height / 4 + 24 + -40, 50, 20, Text.of("Hacks"), (button) -> {
            this.client.setScreen(new hacks(this, this.client.options));
        }));



    }

}

