package me.laky.fenixshop;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ShopListener implements Listener {

    private final EconomyManager economyManager;

    public ShopListener(EconomyManager economyManager) {
        this.economyManager = economyManager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        String title = event.getView().getTitle();

        // =========================
        // MENU PRINCIPAL
        // =========================

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

        // =========================
        // CATEGORIAS
        // =========================

        if (title.equals(ChatColor.DARK_GREEN + "Bloques")
                || title.equals(ChatColor.DARK_GREEN + "Minerales")
                || title.equals(ChatColor.DARK_GREEN + "Comida")
                || title.equals(ChatColor.DARK_GREEN + "Herramientas")) {

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

            ShopItem shopItem = findItem(title, itemName);

            if (shopItem == null) {
                return;
            }

            // =========================
            // CLICK IZQUIERDO = COMPRAR
            // =========================

            if (event.isLeftClick()) {

                double price = shopItem.getBuyPrice();

                if (!economyManager.hasMoney(player, price)) {

                    player.sendMessage(
                            ChatColor.RED
                                    + "No tienes suficiente dinero."
                    );

                    return;
                }

                if (!economyManager.withdraw(player, price)) {

                    player.sendMessage(
                            ChatColor.RED
                                    + "No se pudo realizar la compra."
                    );

                    return;
                }

                ItemStack item = new ItemStack(
                        shopItem.getMaterial(),
                        1
                );

                player.getInventory().addItem(item);

                player.sendMessage(
                        ChatColor.GREEN
                                + "Has comprado 1x "
                                + shopItem.getName()
                                + " por "
                                + economyManager.format(price)
                );

                return;
            }

            // =========================
            // CLICK DERECHO = VENDER
            // =========================

            if (event.isRightClick()) {

                ItemStack item = new ItemStack(
                        shopItem.getMaterial(),
                        1
                );

                if (!player.getInventory().containsAtLeast(item, 1)) {

                    player.sendMessage(
                            ChatColor.RED
                                    + "No tienes "
                                    + shopItem.getName()
                                    + " para vender."
                    );

                    return;
                }

                player.getInventory().removeItem(item);

                double price = shopItem.getSellPrice();

                if (!economyManager.deposit(player, price)) {

                    player.getInventory().addItem(item);

                    player.sendMessage(
                            ChatColor.RED
                                    + "No se pudo realizar la venta."
                    );

                    return;
                }

                player.sendMessage(
                        ChatColor.GREEN
                                + "Has vendido 1x "
                                + shopItem.getName()
                                + " por "
                                + economyManager.format(price)
                );
            }
        }
    }

    private ShopItem findItem(String title, String name) {

        List<ShopItem> items;

        if (title.equals(ChatColor.DARK_GREEN + "Bloques")) {

            items = ShopItems.getBlocks();

        } else if (title.equals(ChatColor.DARK_GREEN + "Minerales")) {

            items = ShopItems.getMinerals();

        } else if (title.equals(ChatColor.DARK_GREEN + "Comida")) {

            items = ShopItems.getFood();

        } else if (title.equals(ChatColor.DARK_GREEN + "Herramientas")) {

            items = ShopItems.getTools();

        } else {

            return null;
        }

        for (ShopItem item : items) {

            if (item.getName().equals(name)) {
                return item;
            }
        }

        return null;
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
