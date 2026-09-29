package me.laky.fenixshop;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class ShopItems {

    public static List<ShopItem> getBlocks() {

        return Arrays.asList(

                new ShopItem(
                        Material.STONE,
                        "Piedra",
                        10.0,
                        5.0
                ),

                new ShopItem(
                        Material.COBBLESTONE,
                        "Piedra labrada",
                        8.0,
                        4.0
                ),

                new ShopItem(
                        Material.DIRT,
                        "Tierra",
                        5.0,
                        2.0
                ),

                new ShopItem(
                        Material.SAND,
                        "Arena",
                        12.0,
                        6.0
                ),

                new ShopItem(
                        Material.GRAVEL,
                        "Grava",
                        12.0,
                        6.0
                )
        );
    }

    public static List<ShopItem> getMinerals() {

        return Arrays.asList(

                new ShopItem(
                        Material.COAL,
                        "Carbon",
                        25.0,
                        12.0
                ),

                new ShopItem(
                        Material.IRON_INGOT,
                        "Lingote de hierro",
                        100.0,
                        50.0
                ),

                new ShopItem(
                        Material.GOLD_INGOT,
                        "Lingote de oro",
                        250.0,
                        125.0
                ),

                new ShopItem(
                        Material.DIAMOND,
                        "Diamante",
                        1000.0,
                        500.0
                ),

                new ShopItem(
                        Material.EMERALD,
                        "Esmeralda",
                        750.0,
                        375.0
                )
        );
    }

    public static List<ShopItem> getFood() {

        return Arrays.asList(

                new ShopItem(
                        Material.BREAD,
                        "Pan",
                        20.0,
                        10.0
                ),

                new ShopItem(
                        Material.APPLE,
                        "Manzana",
                        30.0,
                        15.0
                ),

                new ShopItem(
                        Material.COOKED_BEEF,
                        "Carne cocinada",
                        50.0,
                        25.0
                ),

                new ShopItem(
                        Material.COOKED_CHICKEN,
                        "Pollo cocinado",
                        40.0,
                        20.0
                )
        );
    }

    public static List<ShopItem> getTools() {

        return Arrays.asList(

                new ShopItem(
                        Material.IRON_PICKAXE,
                        "Pico de hierro",
                        500.0,
                        250.0
                ),

                new ShopItem(
                        Material.IRON_AXE,
                        "Hacha de hierro",
                        500.0,
                        250.0
                ),

                new ShopItem(
                        Material.IRON_SPADE,
                        "Pala de hierro",
                        300.0,
                        150.0
                ),

                new ShopItem(
                        Material.DIAMOND_PICKAXE,
                        "Pico de diamante",
                        3000.0,
                        1500.0
                )
        );
    }
}
