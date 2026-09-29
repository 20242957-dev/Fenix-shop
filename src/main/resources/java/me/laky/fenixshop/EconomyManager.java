package me.laky.fenixshop;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class EconomyManager {

    private final FenixShop plugin;
    private Economy economy;

    public EconomyManager(FenixShop plugin) {
        this.plugin = plugin;
    }

    public boolean setupEconomy() {

        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> provider =
                plugin.getServer()
                        .getServicesManager()
                        .getRegistration(Economy.class);

        if (provider == null) {
            return false;
        }

        economy = provider.getProvider();

        return economy != null;
    }

    public Economy getEconomy() {
        return economy;
    }

    public boolean hasMoney(Player player, double amount) {

        if (economy == null) {
            return false;
        }

        return economy.has(player, amount);
    }

    public boolean withdraw(Player player, double amount) {

        if (economy == null) {
            return false;
        }

        return economy.withdrawPlayer(player, amount)
                .transactionSuccess();
    }

    public boolean deposit(Player player, double amount) {

        if (economy == null) {
            return false;
        }

        return economy.depositPlayer(player, amount)
                .transactionSuccess();
    }

    public String format(double amount) {

        if (economy == null) {
            return String.valueOf(amount);
        }

        return economy.format(amount);
    }
}
