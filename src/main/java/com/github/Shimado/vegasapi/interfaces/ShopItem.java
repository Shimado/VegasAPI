package com.github.Shimado.vegasapi.interfaces;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an item that can be displayed and traded in the shop.
 * Each {@code ShopItem} contains information about its slot position,
 * the actual item, its display representation, and purchase/selling prices.
 */

public interface ShopItem {

    /**
     * Returns the inventory slot index where this shop item is placed.
     *
     * @return the slot index
     */

    int getSlot();

    /**
     * Returns the actual {@link ItemStack} representing the item to be given
     * to a player upon purchase.
     *
     * @return the actual item
     */

    @NotNull
    ItemStack getItem();

    /**
     * Returns the {@link ItemStack} representation of this item
     * to be displayed in the shop GUI.
     *
     * @return the item representation to show in the shop
     */

    @NotNull
    ItemStack getItemToShow();

    /**
     * Returns the price at which this item can be purchased.
     *
     * @return the purchase price
     */

    double getPurchasePrice();

    /**
     * Returns the price at which this item can be sold back.
     *
     * @return the selling price
     */

    double getSellingPrice();

}

