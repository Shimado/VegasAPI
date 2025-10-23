package com.github.Shimado.instances;

import com.github.Shimado.enums.ChipType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * Represents a casino bet.
 * A bet can be placed in one of three different forms:
 *     MONEY (numeric value)
 *     CHIPS ({@link ItemStack})
 *     ITEMS ({@link ItemStack})
 * Provides utility methods for modifying the bet, checking its type,
 * and retrieving its total value.
 */

public class CasinoBet {

    private double moneyBet = 0.0;
    private ItemStack chipsBet;
    private ItemStack itemsBet;
    private boolean isFreeSpin = false;


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
     * @return this instance for chaining
     */

    public CasinoBet setMoneyBet(double moneyBet) {
        this.moneyBet = moneyBet;
        return this;
    }

    /**
     * Adds money to the current money bet.
     *
     * @param moneyBet the amount to add
     * @return this instance for chaining
     */

    public CasinoBet addMoneyBet(double moneyBet) {
        this.moneyBet += moneyBet;
        return this;
    }

    /**
     * Removes money from the current money bet.
     * If the result is negative, it will reset to zero.
     *
     * @param moneyBet the amount to remove
     * @return this instance for chaining
     */

    public CasinoBet removeMoneyBet(double moneyBet) {
        this.moneyBet -= moneyBet;
        if (this.moneyBet < 0) this.moneyBet = 0;
        return this;
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
     * @return this instance for chaining
     */

    public CasinoBet setChipsBet(@Nullable ItemStack chipsBet) {
        this.chipsBet = chipsBet;
        return this;
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
     * @return this instance for chaining
     */

    public CasinoBet setItemsBet(@Nullable ItemStack itemsBet) {
        this.itemsBet = itemsBet;
        return this;
    }

    /**
     * Is the bet placed free?
     *
     * @return true if this is a free spin
     */

    public boolean isFreeSpin() {
        return isFreeSpin;
    }

    /**
     * Sets whether the bet will be free
     *
     * @param isFreeSpin is a free spin
     * @return this instance for chaining
     */

    public CasinoBet setFreeSpin(boolean isFreeSpin) {
        this.isFreeSpin = isFreeSpin;
        return this;
    }

    /**
     * Checks if there is any bet (money, chips, or items).
     *
     * @return {@code true} if at least one type of bet is present, otherwise {@code false}
     */

    public boolean isAnyBet() {
        return moneyBet > 0 || chipsBet != null || itemsBet != null;
    }


    @Nullable
    public ChipType getChipType(){
        if(moneyBet > 0) return ChipType.MONEY;
        if(chipsBet != null) return ChipType.CHIPS;
        if(itemsBet != null) return ChipType.ITEMS;
        return null;
    }

}
