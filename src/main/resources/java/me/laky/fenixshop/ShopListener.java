package me.laky.fenixshop;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
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

        String title = event.getView().getTitle();

        // Menu principal
        if (title.equals(ChatColor.DARK_GREEN + "FenixShop")) {

            event.setCancelled(true);

            if (!(event.getWhoClicked() instanceof Player)) {
                return;
            }

            if (event.getCurrentItem() == null) {
                return;
            }

            if (!event.getCurrentItem().hasItemMeta()) {
                return;
            }

            if (!event.getCurrentItem().getItemMeta().hasDisplayName()) {
                return;
            }

            Player player = (Player) event.getWhoClicked();

            String itemName = ChatColor.stripColor(
                    event.getCurrentItem()
                            .getItemMeta()
                            .getDisplayName()
            );

            if (itemName.equals("Bloques")) {

                CategoryMenu.open(
                        player,
                        "Bloques",
                        ShopItems.getBlocks()
                );

            } else if (itemName.equals("Minerales")) {

                CategoryMenu.open(
                        player,
                        "Minerales",
                        ShopItems.getMinerals()
                );

            } else if (itemName.equals("Comida")) {

                CategoryMenu.open(
                        player,
                        "Comida",
                        ShopItems.getFood()
                );

            } else if (itemName.equals("Herramientas")) {

                CategoryMenu.open(
                        player,
                        "Herramientas",
                        ShopItems.getTools()
                );
            }

            return;
        }

        // Menus de categorias
        if (title.equals(ChatColor.DARK_GREEN + "Bloques")
                || title.equals(ChatColor.DARK_GREEN + "Minerales")
                || title.equals(ChatColor.DARK_GREEN + "Comida")
                || title.equals(ChatColor.DARK_GREEN + "Herramientas")) {

            event.setCancelled(true);

            if (!(event.getWhoClicked() instanceof Player)) {
                return;
            }

            // Todavia no compramos/vendemos.
            // Eso lo añadiremos en el siguiente paso.

            return;
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {

        String title = event.getView().getTitle();

        if (title.equals(ChatColor.DARK_GREEN + "FenixShop")
                || title.equals(ChatColor.DARK_GREEN + "Bloques")
                || title.equals(ChatColor.DARK_GREEN + "Minerales")
                || title.equals(ChatColor.DARK_GREEN + "Comida")
                || title.equals(ChatColor.DARK_GREEN + "Herramientas")) {

            event.setCancelled(true);
        }
    }
}
