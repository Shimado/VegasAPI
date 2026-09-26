package com.github.Shimado.vegasapi.events;

import com.github.Shimado.vegasapi.enums.TransactionType;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class EconomyEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID playerUUID;
    private double money;
    private final TransactionType transactionType;
    private boolean cancelled;

    public EconomyEvent(@NotNull UUID playerUUID, double money, @NotNull TransactionType transactionType) {
        this.playerUUID = playerUUID;
        this.money = money;
        this.transactionType = transactionType;
    }


    @NotNull
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    @NotNull
    public TransactionType getTransactionType() {
        return transactionType;
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


    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

}
