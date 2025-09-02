package com.github.Shimado.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface ChipUtil {

    ItemStack getChip(double price);
    boolean isChip(ItemStack item);
    double getOneChipPrice(ItemStack item);
    double getChipsPrice(ItemStack item);
    boolean isSimilarChipsPrice(ItemStack chip1, ItemStack chip2, double maxDifference);
    boolean isHaveSameChipsInInv(ItemStack item, Inventory inv);
    boolean removeSameChipsFromInv(ItemStack item, Inventory inv);
    void sellAllChipsInInv(Player player);

}
