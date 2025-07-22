package com.myname.mymodid;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class YourModConfig {

    private static Configuration config;

    public static boolean isParticleEnabled = true;
    public static int effectMode = 0;
    public static float particleMultiplier = 1.0f;
    public static int displayTimer = 0;

    public static void loadConfig(File configFile) {
        config = new Configuration(configFile);
        config.load();

        isParticleEnabled = config.getBoolean("isParticleEnabled", "general", true, "Enable custom particles");
        effectMode = config.getInt("effectMode", "general", 0, 0, 4, "Particle effect mode");
        particleMultiplier = (float) config.getFloat("particleMultiplier", "general", 1.0f, 0.1f, 10.0f, "Particle multiplier");

        if (config.hasChanged()) {
            config.save();
        }
    }

    public static void saveConfig() {
        config.getCategory("general").get("isParticleEnabled").set(isParticleEnabled);
        config.getCategory("general").get("effectMode").set(effectMode);
        config.getCategory("general").get("particleMultiplier").set(particleMultiplier);

        config.save();
    }

    public static String getEffectName() {
        switch (effectMode) {
            case 0:
                return "Sharpness";
            case 1:
                return "Blood";
            case 2:
                return "Corsair";
            case 3:
                return "Zombie";

            default:
                return "Unknown";
        }
    }
}