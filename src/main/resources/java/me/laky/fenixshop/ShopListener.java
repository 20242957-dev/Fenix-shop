package me.laky.fenixshop;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class ShopListener implements Listener {

    private final EconomyManager economyManager;

    public ShopListener(EconomyManager economyManager) {
        this.economyManager = economyManager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (!event.getView().getTitle().equals(
                ChatColor.DARK_GREEN + "FenixShop")) {
            return;
        }

        event.setCancelled(true);

        if (event.getCurrentItem() == null) {
            return;
        }

        if (!event.getCurrentItem().hasItemMeta()) {
            return;
        }

        if (!event.getCurrentItem().getItemMeta().hasDisplayName()) {
            return;
        }

        String itemName = ChatColor.stripColor(
                event.getCurrentItem()
                        .getItemMeta()
                        .getDisplayName()
        );

        if (itemName.equals("Bloques")) {

            event.getWhoClicked().sendMessage(
                    ChatColor.GREEN + "Categoria: Bloques"
            );

        } else if (itemName.equals("Minerales")) {

            event.getWhoClicked().sendMessage(
                    ChatColor.AQUA + "Categoria: Minerales"
            );

        } else if (itemName.equals("Comida")) {

            event.getWhoClicked().sendMessage(
                    ChatColor.GOLD + "Categoria: Comida"
            );

        } else if (itemName.equals("Herramientas")) {

            event.getWhoClicked().sendMessage(
                    ChatColor.BLUE + "Categoria: Herramientas"
            );
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {

        if (event.getView().getTitle().equals(
                ChatColor.DARK_GREEN + "FenixShop")) {

            event.setCancelled(true);
        }
    }
}
