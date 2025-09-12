package com.github.Shimado.api;

import com.github.Shimado.instances.CasinoBet;
import com.github.Shimado.instances.CasinoGameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

/**
 * A set of optional methods to simplify the creation of a game mode.
 */

public interface CasinoGameModeUtil<T extends CasinoGameMode & CasinoGameModeMethods> {

    /**
     * Places a bet for a player in a specific casino game mode.
     * Checks for all restrictions: minimum/maximum bet amount, etc.
     *
     * @param player           the player placing the bet
     * @param bet              the bet object containing bet details
     * @param itemOnCursor     the item currently held on the cursor (if any). For bet type = "ITEMS", "CHIPS"
     * @param defaultMoneyBet  the default monetary value of the bet. For bet type = "MONEY"
     * @param casinoGameMode   the casino game mode where the bet is placed
     * @param chipsRunnable    action to run if the bet is made with chips. Handles further actions after a bet has been placed.
     * @param moneyRunnable    action to run if the bet is made with money. Handles further actions after a bet has been placed.
     * @param itemsRunnable    action to run if the bet is made with items. Handles further actions after a bet has been placed.
     */

    void placeBet(@Nonnull Player player, @Nullable CasinoBet bet, @Nullable ItemStack itemOnCursor, double defaultMoneyBet, @Nullable T casinoGameMode, @Nonnull Runnable chipsRunnable, @Nonnull Runnable moneyRunnable, @Nonnull Runnable itemsRunnable);

    /**
     * Refunds a bet back to the player.
     *
     * @param player the player whose bet is refunded
     * @param bet    the bet to refund
     */

    void refundBet(@Nonnull Player player, @Nullable CasinoBet bet);

    /**
     * Checks whether a business-owned table has enough funds.
     *
     * @param player         the player attempting to use the table
     * @param tableOwnerUUID the UUID of the table's owner
     * @return {@code true} if the business table has sufficient money,
     *         {@code false} otherwise
     */

    boolean checkIfBusinessTableHasMoney(@Nonnull Player player, @Nullable UUID tableOwnerUUID);
}
