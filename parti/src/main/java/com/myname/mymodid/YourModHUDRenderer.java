package com.myname.mymodid;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

@EventBusSubscriber
public class YourModHUDRenderer {

    @SubscribeEvent
    public static void onRenderOverlay(RenderGameOverlayEvent.Text event) {
        if (YourModConfig.displayTimer > 0) {
            Minecraft mc = Minecraft.getMinecraft();
            ScaledResolution sr = new ScaledResolution(mc);

            String effect = YourModConfig.getEffectName();

            String status = String.format("Effect: %s | Multiplier: %.1fx",
                    effect, YourModConfig.particleMultiplier);

            int x = sr.getScaledWidth() / 2 - mc.fontRenderer.getStringWidth(status) / 2;
            int y = sr.getScaledHeight() / 2 + 20;

            mc.fontRenderer.drawStringWithShadow(status, x, y, 0xFFFFFF);

            YourModConfig.displayTimer--;
        }
    }
}

