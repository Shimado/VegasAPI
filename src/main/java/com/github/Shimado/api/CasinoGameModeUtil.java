package com.github.Shimado.api;

import com.github.Shimado.instances.CasinoBet;
import com.github.Shimado.instances.CasinoGameMode;
import com.github.Shimado.instances.SingleGameSession;
import com.github.Shimado.interfaces.ItemRunnable;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
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
     * @param casinoGameMode   the casino game mode where the bet is placed
     * @param chipsRunnable    action to run if the bet is made with chips. Handles further actions after a bet has been placed
     * @param moneyRunnable    action to run if the bet is made with money. Handles further actions after a bet has been placed
     * @param itemsRunnable    action to run if the bet is made with items. Handles further actions after a bet has been placed
     */

    void placeBet(@Nonnull Player player, @Nonnull CasinoBet bet, @Nonnull T casinoGameMode, @Nullable ItemRunnable chipsRunnable, @Nullable ItemRunnable moneyRunnable, @Nullable ItemRunnable itemsRunnable);

    /**
     * Refunds a bet back to the player.
     *
     * @param player          the player whose bet is refunded
     * @param bet             the bet to refund
     * @param casinoGameMode  the casino game itself
     */

    void refundBet(@Nonnull Player player, @Nullable CasinoBet bet, @Nonnull T casinoGameMode);

    /**
     * Checks whether a business-owned table has enough funds.
     *
     * @param player         the player attempting to use the table
     * @param tableOwnerUUID the UUID of the table's owner
     * @return {@code true} if the business table has sufficient money, {@code false} otherwise
     */

    boolean checkIfBusinessTableHasMoney(@Nonnull Player player, @Nullable UUID tableOwnerUUID);

    /**
     * Handles the player closing the GUI, returns their bet if the game has not yet started.
     *
     * @param player         the player who closed the GUI
     * @param gameSession    the player game session
     * @param casinoGameMode the game mode itself that was closed
     * @param runnable       necessary to complement the method. But it's generally used to remove a player from the session map.
     * **/

    void closeSingleGameGUI(@Nonnull Player player, @Nullable SingleGameSession gameSession, @Nonnull T casinoGameMode, @Nonnull Runnable runnable);

    /**
     * Sets the bid buttons, replacing all placeholders.
     *
     * @param player         for whom is the button installed and whose data will be taken
     * @param inv            inventory where it will be installed
     * @param casinoGameMode the game mode itself
     * **/

    void setSpotItem(@Nonnull Player player, @Nonnull Inventory inv, @Nonnull CasinoGameMode casinoGameMode);

    /**
     * Handles mode update on /vegas reload, returns their bet if the game has not yet started.
     *
     * @param sessions       the map with all players in this mode, where UUID - is the UUID of the player
     * @param casinoGameMode the game mode itself
     * **/

    void reloadSingleGameGUI(@Nonnull Map<UUID, SingleGameSession> sessions, @Nonnull T casinoGameMode);


}
