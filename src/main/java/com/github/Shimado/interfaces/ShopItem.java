package com.github.Shimado.interfaces;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
     * Sets the inventory slot index for this shop item.
     *
     * @param slot the slot index to set
     */

    void setSlot(int slot);

    /**
     * Returns the actual {@link ItemStack} representing the item to be given
     * to a player upon purchase.
     *
     * @return the actual item
     */

    @Nonnull
    ItemStack getItem();

    /**
     * Sets the actual {@link ItemStack} that will be given to a player
     * upon purchase.
     *
     * @param item the item to set
     */

    void setItem(@Nonnull ItemStack item);

    /**
     * Returns the {@link ItemStack} representation of this item
     * to be displayed in the shop GUI.
     *
     * @return the item representation to show in the shop
     */

    @Nonnull
    ItemStack getItemToShow();

    /**
     * Sets the {@link ItemStack} representation of this item
     * to be displayed in the shop GUI.
     *
     * @param itemToShow the item to display
     */

    void setItemToShow(@Nonnull ItemStack itemToShow);

    /**
     * Returns the price at which this item can be purchased.
     *
     * @return the purchase price
     */

    double getPurchasePrice();

    /**
     * Sets the purchase price of this item.
     *
     * @param purchasePrice the price to set
     */

    void setPurchasePrice(double purchasePrice);

    /**
     * Returns the price at which this item can be sold back.
     *
     * @return the selling price
     */

    double getSellingPrice();

    /**
     * Sets the selling price of this item.
     *
     * @param sellingPrice the price to set
     */

    void setSellingPrice(double sellingPrice);

}

