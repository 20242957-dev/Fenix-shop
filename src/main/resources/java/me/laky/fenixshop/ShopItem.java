package me.laky.fenixshop;

import org.bukkit.Material;

public class ShopItem {

    private final Material material;
    private final String name;
    private final double buyPrice;
    private final double sellPrice;

    public ShopItem(
            Material material,
            String name,
            double buyPrice,
            double sellPrice) {

        this.material = material;
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }
}
