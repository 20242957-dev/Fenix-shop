package me.laky.fenixshop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(
                    "Este comando solo puede ser usado por jugadores."
            );
            return true;
        }

        Player player = (Player) sender;

        ShopMenu.open(player);

        return true;
    }
}
