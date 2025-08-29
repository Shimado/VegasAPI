package com.github.Shimado.instances;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * Represents a casino bet.
 * A bet can be placed in one of three different forms:
 *     Money (numeric value)
 *     Chips ({@link ItemStack})
 *     Items ({@link ItemStack})
 * Provides utility methods for modifying the bet, checking its type,
 * and retrieving its total value.
 */

public class CasinoBet {

    private double moneyBet = 0.0;
    private ItemStack chipsBet;
    private ItemStack itemsBet;

    /**
     * Creates a money bet.
     *
     * @param moneyBet the amount of money bet
     */

    public CasinoBet(double moneyBet) {
        this.moneyBet = moneyBet;
    }

    /**
     * Creates a chips bet.
     *
     * @param chipsBet the chips bet
     */

    public CasinoBet(@Nullable ItemStack chipsBet) {
        this.chipsBet = chipsBet;
    }


    /**
     * Gets the money bet.
     *
     * @return the money bet value
     */

    public double getMoneyBet() {
        return moneyBet;
    }

    /**
     * Sets the money bet value.
     *
     * @param moneyBet the new money bet value
     */

    public void setMoneyBet(double moneyBet) {
        this.moneyBet = moneyBet;
    }

    /**
     * Adds money to the current money bet.
     *
     * @param moneyBet the amount to add
     */

    public void addMoneyBet(double moneyBet) {
        this.moneyBet += moneyBet;
    }

    /**
     * Removes money from the current money bet.
     * If the result is negative, it will reset to zero.
     *
     * @param moneyBet the amount to remove
     */

    public void removeMoneyBet(double moneyBet) {
        this.moneyBet -= moneyBet;
        if (this.moneyBet < 0) this.moneyBet = 0;
    }


    /**
     * Gets the chips bet.
     *
     * @return the chips bet, or {@code null} if none
     */

    @Nullable
    public ItemStack getChipsBet() {
        return chipsBet;
    }

    /**
     * Sets the chips bet.
     *
     * @param chipsBet the chips bet
     */

    public void setChipsBet(@Nullable ItemStack chipsBet) {
        this.chipsBet = chipsBet;
    }



    /**
     * Gets the items bet.
     *
     * @return the items bet, or {@code null} if none
     */

    @Nullable
    public ItemStack getItemsBet() {
        return itemsBet;
    }

    /**
     * Sets the items bet.
     *
     * @param itemsBet the items bet
     */

    public void setItemsBet(@Nullable ItemStack itemsBet) {
        this.itemsBet = itemsBet;
    }


    /**
     * Checks if there is any bet (money, chips, or items).
     *
     * @return {@code true} if at least one type of bet is present, otherwise {@code false}
     */

    public boolean isAnyBet() {
        return moneyBet > 0 || chipsBet != null || itemsBet != null;
    }

}
