package com.github.Shimado.instances.multiplayer;

import com.github.Shimado.instances.CasinoBet;
import com.github.Shimado.interfaces.PlacedCasinoTable;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a multiplayer game session in a multiplayer hub.
 * This class manages the state of a player's participation in a casino table game,
 * including their inventory, bets, and table information.
 */

public class MultiplayerGameSession {

    private int slot = -1;
    private Inventory inv;
    private CasinoBet bet;
    private ItemStack visualBetItem;
    private PlacedCasinoTable casinoTable;

    /**
     * Gets the bet slot of the player in the game session GUI.
     *
     * @return the slot position, or -1 if no slot is assigned
     */

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    /**
     * Gets the inventory associated with this game session.
     *
     * @return the inventory, or null if no inventory is set
     */

    @Nullable
    public Inventory getInv() {
        return inv;
    }

    public void setInv(@Nullable Inventory inv) {
        this.inv = inv;
    }

    /**
     * Gets the current casino bet of the player placed in this session.
     *
     * @return the casino bet, or null if no bet is placed
     */

    @Nullable
    public CasinoBet getBet() {
        return bet;
    }

    public void setBet(@Nullable CasinoBet bet) {
        this.bet = bet;
    }

    /**
     * Gets the visual representation of the bet item.
     * This is typically an ItemStack that visually represents the bet in the GUI.
     *
     * @return the visual bet item, or null if not set
     */

    @Nullable
    public ItemStack getVisualBetItem() {
        return visualBetItem;
    }

    public void setVisualBetItem(@Nullable ItemStack visualBetItem) {
        this.visualBetItem = visualBetItem;
    }

    /**
     * Gets the placed casino table associated with this game session.
     *
     * @return the placed casino table, or null if no table is associated
     */

    @Nullable
    public PlacedCasinoTable getCasinoTable() {
        return casinoTable;
    }

    public void setCasinoTable(@Nullable PlacedCasinoTable casinoTable) {
        this.casinoTable = casinoTable;
    }
}
