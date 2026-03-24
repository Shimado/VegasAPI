package com.github.Shimado.vegasapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChipsSaleEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final double chipsPrice;
    private final double chipsPriceWithTax;
    private final int chipsAmount;

    public ChipsSaleEvent(@NotNull Player player, double chipsPrice, double chipsPriceWithTax, int chipsAmount) {
        this.player = player;
        this.chipsPrice = chipsPrice;
        this.chipsPriceWithTax = chipsPriceWithTax;
        this.chipsAmount = chipsAmount;
    }


    @NotNull
    public Player getPlayer() {
        return player;
    }

    public double getChipsPrice() {
        return chipsPrice;
    }

    public double getChipsPriceWithTax() {
        return chipsPriceWithTax;
    }

    public int getChipsAmount(){
        return chipsAmount;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
