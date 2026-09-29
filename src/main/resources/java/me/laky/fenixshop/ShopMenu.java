package me.laky.fenixshop;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ShopMenu {

    public static void open(Player player) {

        Inventory inventory = Bukkit.createInventory(
                null,
                27,
                ChatColor.DARK_GREEN + "FenixShop"
        );

        // Bloques
        inventory.setItem(
                11,
                createItem(
                        Material.GRASS,
                        ChatColor.GREEN + "Bloques",
                        ChatColor.GRAY + "Comprar y vender bloques"
                )
        );

        // Minerales
        inventory.setItem(
                13,
                createItem(
                        Material.DIAMOND,
                        ChatColor.AQUA + "Minerales",
                        ChatColor.GRAY + "Comprar y vender minerales"
                )
        );

        // Comida
        inventory.setItem(
                15,
                createItem(
                        Material.COOKED_BEEF,
                        ChatColor.GOLD + "Comida",
                        ChatColor.GRAY + "Comprar y vender comida"
                )
        );

        // Herramientas
        inventory.setItem(
                22,
                createItem(
                        Material.DIAMOND_PICKAXE,
                        ChatColor.BLUE + "Herramientas",
                        ChatColor.GRAY + "Comprar herramientas"
                )
        );

        // Rellenar espacios
        ItemStack filler = new ItemStack(
                Material.STAINED_GLASS_PANE,
                1,
                (short) 7
        );

        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(ChatColor.GRAY + " ");
        filler.setItemMeta(fillerMeta);

        for (int i = 0; i < 27; i++) {

            if (inventory.getItem(i) == null) {
                inventory.setItem(i, filler);
            }
        }

        player.openInventory(inventory);
    }

    private static ItemStack createItem(
            Material material,
            String name,
            String lore) {

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        meta.setLore(Arrays.asList(
                lore,
                "",
                ChatColor.YELLOW + "Click para abrir"
        ));

        item.setItemMeta(meta);

        return item;
    }
}
