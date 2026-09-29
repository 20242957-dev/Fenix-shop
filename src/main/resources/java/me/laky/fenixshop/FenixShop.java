package me.laky.fenixshop;

import org.bukkit.plugin.java.JavaPlugin;

public class FenixShop extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("FenixShop se esta iniciando...");

        getLogger().info("FenixShop ha sido activado correctamente.");
    }

    @Override
    public void onDisable() {

        getLogger().info("FenixShop ha sido desactivado.");
    }
}
