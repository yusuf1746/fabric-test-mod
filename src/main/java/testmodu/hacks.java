package testmodu;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class hacks extends Screen {

    private final Screen parent;
    private final GameOptions settings;

    public hacks( Screen parent, GameOptions gameOptions) {
        super(Text.of("sa"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    Text boatflyText() {
        if(genel_ayarlar.boatflyEnabled)
            return Text.of("boatfly: Enabled");
        else
            return Text.of("boatfly: Disabled");
    }

    Text AutoFishingText() {
        if(genel_ayarlar.AutoFishingEnabled)
            return Text.of("AutoFishing: Enabled");
        else
            return Text.of("AutoFishing: Disabled");
    }


    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 2 + 30, 200, 20, boatflyText(), (button) -> {
            genel_ayarlar.boatflyEnabled = !genel_ayarlar.boatflyEnabled;
            button.setMessage(boatflyText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 2 + 50, 200, 20, AutoFishingText(), (button) -> {

            genel_ayarlar.AutoFishingEnabled = !genel_ayarlar.AutoFishingEnabled;
            button.setMessage(AutoFishingText());
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 2 + 100, 200, 20, ScreenTexts.BACK, (button) -> {

            this.client.setScreen(this.parent);

        }));


    }

}
