package com.myname.mymodid;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyBindings {

    public static final KeyBinding toggleParticle = new KeyBinding(
            "custom particle", Keyboard.KEY_O, "particle");

    public static final KeyBinding openGui = new KeyBinding(
            "custom particle gui", Keyboard.KEY_RSHIFT, "particle");

    public static void register() {
        ClientRegistry.registerKeyBinding(toggleParticle);
        ClientRegistry.registerKeyBinding(openGui);
    }
}
