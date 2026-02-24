package com.github.Shimado.vegasapi.instances;

import com.github.Shimado.vegasapi.enums.ChipType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

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

    private int slot = -1;
    private double moneyBet = 0.0;
    private ItemStack chipsBet;
    private ItemStack itemsBet;
    private boolean isFreeSpin = false;


    /**
     * Gets the bet slot of the player in the game session GUI.
     *
     * @return the slot position, or -1 if no slot is assigned
     */

    public int getSlot() {
        return slot;
    }

    public CasinoBet setSlot(int slot) {
        this.slot = slot;
        return this;
    }


    /**
     * Gets the money bet.
     *
     * @return the money bet value
     */

    public double getMoneyBet() {
        return moneyBet;
    }

    public CasinoBet setMoneyBet(double moneyBet) {
        this.moneyBet = moneyBet;
        return this;
    }

    public CasinoBet addMoneyBet(double moneyBet) {
        this.moneyBet += moneyBet;
        return this;
    }

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

    public CasinoBet setItemsBet(@Nullable ItemStack itemsBet) {
        this.itemsBet = itemsBet;
        return this;
    }


    /**
     * Is the bet placed free?
     * You need to set the bet (money, chips, or items) itself.
     *
     * @return true if this is a free spin
     */

    public boolean isFreeSpin() {
        return isFreeSpin;
    }

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


    /**
     * Gets the bet type.
     *
     * @return the chip type, or {@code null} if none
     * **/

    @Nullable
    public ChipType getChipType(){
        if(moneyBet > 0) return ChipType.MONEY;
        if(chipsBet != null) return ChipType.CHIPS;
        if(itemsBet != null) return ChipType.ITEMS;
        return null;
    }

}
