package com.myname.mymodid;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraft.client.settings.KeyBinding;

@EventBusSubscriber
public class KeyInputHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {

        if (KeyBindings.toggleParticle == null || KeyBindings.openGui == null) return;

        Minecraft mc = Minecraft.getMinecraft();

        if (KeyBindings.toggleParticle.isPressed()) {
            YourModConfig.isParticleEnabled = !YourModConfig.isParticleEnabled;
            String message = YourModConfig.isParticleEnabled ? "Custom particle: §aON" : "Custom particle: §cOFF";
            mc.player.sendMessage(new TextComponentString(message));
        }

        if (KeyBindings.openGui.isPressed()) {
            mc.displayGuiScreen(new ParticleConfigGui());
        }
    }
}
