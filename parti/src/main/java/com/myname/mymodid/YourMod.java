package com.myname.mymodid;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import java.io.File;


@Mod(modid = "mzmod", name = "particlemod", version = "1.0")
public class YourMod {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        KeyBindings.register();

        File configFile = event.getSuggestedConfigurationFile();
        YourModConfig.loadConfig(configFile);
    }
}
