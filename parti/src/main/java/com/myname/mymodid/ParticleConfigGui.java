package com.myname.mymodid;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiPageButtonList;

import java.io.IOException;

public class ParticleConfigGui extends GuiScreen {

    private GuiSlider slider;
    private GuiButton toggleButton;

    @Override
    public void initGui() {
        int x = this.width / 2 - 100;
        int y = this.height / 2 - 20;

        slider = new GuiSlider(
                new GuiPageButtonList.GuiResponder() {
                    @Override
                    public void setEntryValue(int id, boolean value) {}

                    @Override
                    public void setEntryValue(int id, float value) {
                        YourModConfig.particleMultiplier = value;
                    }

                    @Override
                    public void setEntryValue(int id, String value) {}
                },
                0,
                x, y,
                "Particle Multiplier: ",
                0.1f, 10.0f,
                YourModConfig.particleMultiplier,
                (id, label, value) -> String.format("%.1fx", value)
        );
        this.buttonList.add(slider);


        toggleButton = new GuiButton(2, x + 210, y, 100, 20, getButtonLabel());
        this.buttonList.add(toggleButton);


        this.buttonList.add(new GuiButton(1, x, y + 40, 200, 20, "Done"));
    }

    private String getButtonLabel() {
        return "Effect: " + YourModConfig.getEffectName();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 1) {
            this.mc.displayGuiScreen(null);
        } else if (button.id == 2) {

            YourModConfig.effectMode = (YourModConfig.effectMode + 1) % 4;
            button.displayString = getButtonLabel();
            YourModConfig.saveConfig();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        drawCenteredString(this.fontRenderer, "Particle Settings", this.width / 2, 40, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
