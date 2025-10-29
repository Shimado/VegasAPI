package com.github.Shimado.instances.multiplayer;

import com.github.Shimado.instances.CasinoBet;
import com.github.Shimado.interfaces.PlacedCasinoTable;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MultiplayerGameSession {

    private int slot = -1;
    private Inventory inv;
    private CasinoBet bet;
    private ItemStack visualBetItem;
    private PlacedCasinoTable casinoTable;


    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }


    @Nonnull
    public Inventory getInv() {
        return inv;
    }

    public void setInv(@Nonnull Inventory inv) {
        this.inv = inv;
    }


    @Nonnull
    public CasinoBet getBet() {
        return bet;
    }

    public void setBet(@Nonnull CasinoBet bet) {
        this.bet = bet;
    }


    @Nullable
    public ItemStack getVisualBetItem() {
        return visualBetItem;
    }

    public void setVisualBetItem(@Nullable ItemStack visualBetItem) {
        this.visualBetItem = visualBetItem;
    }


    @Nullable
    public PlacedCasinoTable getCasinoTable() {
        return casinoTable;
    }

    public void setCasinoTable(@Nullable PlacedCasinoTable casinoTable) {
        this.casinoTable = casinoTable;
    }
}
