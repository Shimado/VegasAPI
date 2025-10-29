package com.github.Shimado.api;

import com.github.Shimado.instances.CasinoBet;
import com.github.Shimado.instances.CasinoGameMode;
import com.github.Shimado.instances.SingleplayerGameSession;
import com.github.Shimado.instances.multiplayer.MultiplayerGameSession;
import com.github.Shimado.instances.multiplayer.MultiplayerGameSessionHandler;
import com.github.Shimado.instances.multiplayer.MultiplayerGameSessionsHub;
import com.github.Shimado.interfaces.CloseInvRunnable;
import com.github.Shimado.interfaces.ItemRunnable;
import com.github.Shimado.interfaces.PlacedCasinoTable;
import com.github.Shimado.interfaces.RefreshInvRunnable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
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
     * @param betRunnable    action to run if the bet is made with chips/money/items. Handles further actions after a bet has been placed
     */

    void placeBet(@Nonnull Player player, @Nonnull CasinoBet bet, @Nonnull T casinoGameMode, @Nullable ItemRunnable betRunnable);

    void placeBetToSingleplayerGameInventory(@Nonnull Player player, @Nonnull Inventory inv, @Nonnull T casinoGameMode, @Nonnull ItemStack itemToSet, int slot);

    void placeBetToMultiplayerGameInventory(@Nonnull Player player, @Nonnull MultiplayerGameSessionsHub sessionHub, @Nonnull MultiplayerGameSession gameSession, @Nonnull T casinoGameMode, @Nullable PlacedCasinoTable casinoTable, @Nonnull ItemStack itemToSet, int slot);

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
     * Checks whether a business-owned table has enough funds.
     *
     * @param player         the player attempting to use the table
     * @param casinoTable    the placed casino table instance with owner's data
     * @return {@code true} if the business table has sufficient money, {@code false} otherwise
     */

    boolean checkIfBusinessTableHasMoney(@Nonnull Player player, @Nullable PlacedCasinoTable casinoTable);

    /**
     * Handles the player closing the GUI, returns their bet if the game has not yet started.
     *
     * @param player         the player who closed the GUI
     * @param gameSession    the player game session
     * @param casinoGameMode the game mode itself that was closed
     * @param runnable       necessary to complement the method. But it's generally used to remove a player from the session map.
     * **/

    void closeSingleplayerGameGUI(@Nonnull Player player, @Nullable SingleplayerGameSession gameSession, @Nonnull T casinoGameMode, @Nonnull Runnable runnable);

    void closeMultiplayerGameGUI(@Nonnull Player player, @Nullable MultiplayerGameSessionHandler sessionHandler, @Nonnull T casinoGameMode, int refreshInvDelay, @Nonnull CloseInvRunnable inactiveRunnable, @Nonnull CloseInvRunnable activeRunnable, @Nonnull RefreshInvRunnable refreshInvRunnable);

    /**
     * Sets the bid buttons, replacing all placeholders.
     *
     * @param player         for whom is the button installed and whose data will be taken
     * @param inv            inventory where it will be installed
     * @param spotSlots      slots in the GUI to set
     * @param casinoGameMode the game mode itself
     * **/

    void setSpotItems(@Nonnull Player player, @Nonnull Inventory inv, @Nonnull List<Integer> spotSlots, @Nonnull CasinoGameMode casinoGameMode);

    /**
     * Handles mode update on /vegas reload, returns their bet if the game has not yet started.
     *
     * @param sessions       the map with all players in this mode, where UUID - is the UUID of the player
     * @param casinoGameMode the game mode itself
     * **/

    void reloadSingleplayerGameGUI(@Nonnull Map<UUID, SingleplayerGameSession> sessions, @Nonnull T casinoGameMode);

    /**
     * Sets the delay for recharging the mode + responds to the restart music.
     *
     * @param delay       the delay in ticks before starting a new game
     * @param player      the player who plays in this mode
     * @param gameSession the game session that requires a restart
     * @param runnable    where the method itself is implemented that restarts the mode
     * **/

    void restartSingleplayerGameWithDelay(int delay, @Nonnull Player player, @Nonnull SingleplayerGameSession gameSession, @Nonnull Runnable runnable);

    void restartMultiplayerGameWithDelay(int delay, @Nonnull MultiplayerGameSessionsHub sessionHub, @Nonnull Runnable runnable);


}
