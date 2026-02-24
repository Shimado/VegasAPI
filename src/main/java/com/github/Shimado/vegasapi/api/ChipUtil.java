package com.github.Shimado.vegasapi.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Utility interface for working with in-game "chips".
 * Provides methods to identify, create, and manage chip items,
 * as well as perform operations with them inside a player's inventory.
 */

public interface ChipUtil {

    /**
     * Creates a chip with the specified price.
     *
     * @param price the chip price
     * @return a chip item, or {@code null} if creation is not possible
     */

    @Nullable
    ItemStack getChip(double price);


    /**
     * Creates a chip with the specified price and amount.
     *
     * @param price  the chip price
     * @param amount number of chips
     * @return a chip item, or {@code null} if creation is not possible
     */

    @Nullable
    ItemStack getChip(double price, int amount);


    /**
     * Checks if the given item is a chip.
     *
     * @param item the item to check
     * @return {@code true} if the item is a chip (has nbt tag "ChipPrice"), otherwise {@code false}
     */

    boolean isChip(@Nullable ItemStack item);


    /**
     * Gets the price of a single chip from the given item.
     *
     * @param item the item to check
     * @return the price of one chip, or {@code 0.0} if the item is not a chip
     */

    double getOneChipPrice(@Nullable ItemStack item);


    /**
     * Gets the total price of all chips in the given item stack.
     *
     * @param item the item to check
     * @return the total price of all chips, or {@code 0.0} if the item is not a chip
     */

    double getChipsPrice(@Nullable ItemStack item);


    /**
     * Checks whether two chip items have similar prices within a given difference.
     *
     * @param chip1         the first chip item
     * @param chip2         the second chip item
     * @param maxDifference the maximum allowed price difference in percent
     * @return {@code true} if the chip prices are similar +- maxDifference in percent, otherwise {@code false}
     */

    boolean isSimilarChipsPrice(@Nullable ItemStack chip1, @Nullable ItemStack chip2, double maxDifference);


    /**
     * Checks if the given inventory contains any chips with the same price and amount as the specified item.
     *
     * @param item the chip item to compare
     * @param inv  the inventory to check
     * @return {@code true} if matching chips exist in the inventory, otherwise {@code false}
     */

    boolean isHaveSameChipsInInv(@Nullable ItemStack item, @NotNull Inventory inv);


    /**
     * Removes chips with the same price and amount as the specified item from the given inventory.
     *
     * @param item the chip item to remove
     * @param inv  the inventory from which chips will be removed
     * @return {@code true} if all chips was removed, otherwise {@code false}
     */

    boolean removeSameChipsFromInv(@Nullable ItemStack item, @NotNull Inventory inv);


    /**
     * Sells all chips from the player's inventory.
     *
     * @param player the player whose inventory will be processed
     */

    void sellAllChipsInInv(@NotNull Player player);

}

