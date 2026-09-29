package me.laky.fenixshop;

import org.bukkit.plugin.java.JavaPlugin;

public class FenixShop extends JavaPlugin {

    private EconomyManager economyManager;

    @Override
    public void onEnable() {

        getLogger().info("FenixShop se esta iniciando...");

        // Configurar economia
        economyManager = new EconomyManager(this);

        if (!economyManager.setupEconomy()) {

            getLogger().severe(
                    "No se pudo conectar con Vault o con un plugin de economia."
            );

            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Registrar comando /shop
        getCommand("shop").setExecutor(new ShopCommand());

        // Registrar eventos de la tienda
        getServer().getPluginManager().registerEvents(
                new ShopListener(),
                this
        );

        getLogger().info("Economia conectada correctamente.");
        getLogger().info("FenixShop ha sido activado correctamente.");
    }

    @Override
    public void onDisable() {

        getLogger().info("FenixShop ha sido desactivado.");
    }

    public EconomyManager getEconomyManager() {
        return economyManager;
    }
}
