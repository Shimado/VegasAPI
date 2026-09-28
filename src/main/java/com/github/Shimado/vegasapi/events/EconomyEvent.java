package com.github.Shimado.vegasapi.events;

import com.github.Shimado.vegasapi.enums.TransactionType;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when an economic transaction is performed for a player.
 * <p>
 * The type of the operation is defined by {@link TransactionType}. Handlers may
 * modify the transaction amount or cancel the event to take over the operation.
 * <p>
 * <b>Processing notes:</b>
 * <ul>
 *     <li>The value set via {@link #setMoney(double)} is applied
 *     <b>always</b>, even if the event is cancelled.</li>
 *     <li>The value set via {@link #setEnoughMoney(boolean)} is taken into account
 *     <b>only if the event is cancelled</b> ({@link #isCancelled()} == {@code true}).
 *     If the event is not cancelled, this flag is ignored.</li>
 * </ul>
 */

public class EconomyEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID playerUUID;
    private double money;
    private boolean isEnoughMoney = false;
    private final TransactionType transactionType;
    private boolean cancelled;

    /**
     * Creates a new economy transaction event.
     *
     * @param playerUUID      the UUID of the player involved in the transaction
     * @param money           the transaction amount
     * @param transactionType the type of the transaction
     */

    public EconomyEvent(@NotNull UUID playerUUID, double money, @NotNull TransactionType transactionType) {
        this.playerUUID = playerUUID;
        this.money = money;
        this.transactionType = transactionType;
    }


    /**
     * Gets the UUID of the player involved in the transaction.
     *
     * @return the player's UUID
     */

    @NotNull
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    /**
     * Gets the current transaction amount.
     *
     * @return the transaction amount
     */

    public double getMoney() {
        return money;
    }

    /**
     * Sets the transaction amount.
     * <p>
     * The new value is applied <b>regardless of whether the event is cancelled or not</b>.
     *
     * @param money the new transaction amount
     */

    public void setMoney(double money) {
        this.money = money;
    }


    /**
     * Gets whether the player has enough money to complete the transaction.
     * <p>
     * Defaults to {@code false}. This value is only meaningful
     * if the event is cancelled (see {@link #setEnoughMoney(boolean)}).
     *
     * @return {@code true} if the player has enough money; {@code false} otherwise
     */

    public boolean isEnoughMoney() {
        return isEnoughMoney;
    }

    /**
     * Sets whether the player has enough money to complete the transaction.
     * <p>
     * This value is taken into account <b>only if the event is cancelled</b>
     * ({@link #isCancelled()} == {@code true}). If the event is not cancelled,
     * the flag is ignored.
     *
     * @param enoughMoney {@code true} if the player has enough money
     */

    public void setEnoughMoney(boolean enoughMoney) {
        isEnoughMoney = enoughMoney;
    }


    /**
     * Gets the type of the transaction.
     *
     * @return the transaction type
     */

    @NotNull
    public TransactionType getTransactionType() {
        return transactionType;
    }


    /**
     * Gets the list of handlers for this event.
     *
     * @return the handler list
     */

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Gets the static handler list of this event
     * (required by Bukkit for listener registration).
     *
     * @return the handler list
     */

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }


    /**
     * Gets whether the event is cancelled.
     * <p>
     * The cancellation state determines whether the value set via
     * {@link #setEnoughMoney(boolean)} is taken into account.
     *
     * @return {@code true} if the event is cancelled
     */

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the cancellation state of the event.
     * <p>
     * Cancelling the event does not affect whether {@link #setMoney(double)} is applied,
     * but it is a prerequisite for {@link #setEnoughMoney(boolean)} to take effect.
     *
     * @param cancel {@code true} to cancel the event
     */

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

}