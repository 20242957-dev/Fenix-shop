package me.laky.fenixshop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CategoryMenu {

    public static void open(
            Player player,
            String category,
            List<ShopItem> items) {

        Inventory inventory = Bukkit.createInventory(
                null,
                27,
                ChatColor.DARK_GREEN + category
        );

        int slot = 10;

        for (ShopItem shopItem : items) {

            if (slot >= 17) {
                break;
            }

            ItemStack item = new ItemStack(shopItem.getMaterial());
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(
                    ChatColor.GREEN + shopItem.getName()
            );

            meta.setLore(java.util.Arrays.asList(
                    "",
                    ChatColor.YELLOW + "Comprar: "
                            + ChatColor.WHITE
                            + shopItem.getBuyPrice(),

                    ChatColor.YELLOW + "Vender: "
                            + ChatColor.WHITE
                            + shopItem.getSellPrice(),

                    "",
                    ChatColor.GREEN + "Click izquierdo: Comprar",
                    ChatColor.RED + "Click derecho: Vender"
            ));

            item.setItemMeta(meta);

            inventory.setItem(slot, item);

            slot++;

            if (slot == 13) {
                slot = 14;
            }
        }

        player.openInventory(inventory);
    }
}
