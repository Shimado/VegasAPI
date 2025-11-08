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
     * Processes all three bet types, as well as free spins.
     * Updates CasinoBet to the current bet value.
     *
     * @param player           the player placing the bet
     * @param bet              the bet object containing bet details
     * @param casinoGameMode   the casino game mode where the bet is placed
     * @param betRunnable      action to run if the bet is made with chips/money/items. Handles further actions after a bet has been placed
     */

    void placeBet(@Nonnull Player player, @Nonnull CasinoBet bet, @Nonnull T casinoGameMode, @Nullable ItemRunnable betRunnable);

    /**
     * Responsible for the visual display of the bet for a singleplayer mode.
     * Places the bet itself in the GUI. Sets active levers.
     *
     * @param player          the player placing the bet
     * @param inv             the inventory in which it will be installed
     * @param casinoGameMode  the casino game mode where the bet is placed
     * @param itemToSet       the item that will be placed in the bet slot
     * @param slot            the bet slot where the item will be installed
     * **/

    void placeBetToSingleplayerGameInventory(@Nonnull Player player, @Nonnull Inventory inv, @Nonnull T casinoGameMode, @Nonnull ItemStack itemToSet, int slot);

    /**
     * Responsible for the visual display of the bet for a multiplayer mode.
     * Places the bet itself in the GUI.
     * Sets the placed casino table and visual item to the session memory.
     *
     * @param player             the player placing the bet
     * @param sessionHub         the hub that contains all sessions of players who play in one session
     * @param gameSession        the session of the player who places the bet
     * @param casinoGameMode     the casino game mode where the bet is placed
     * @param itemToSet          the item that will be placed in the bet slot
     * @param slot               the bet slot where the item will be installed
     * **/

    void placeBetToMultiplayerGameInventory(@Nonnull Player player, @Nonnull MultiplayerGameSessionsHub sessionHub, @Nonnull MultiplayerGameSession gameSession, @Nonnull T casinoGameMode, @Nonnull ItemStack itemToSet, int slot);

    /**
     * Refunds a bet or free spin back to the player.
     * Resets the bet data.
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
     * @param player               the player attempting to use the table
     * @param placedCasinoTable    the placed casino table instance with owner's data
     * @return {@code true} if the business table has sufficient money, {@code false} otherwise
     */

    boolean checkIfBusinessTableHasMoney(@Nonnull Player player, @Nullable PlacedCasinoTable placedCasinoTable);

    /**
     * Handles the player closing the GUI, returns their bet if the game has not yet started.
     * It counts as a loss if you lose during an active game.
     *
     * @param player         the player who closed the GUI
     * @param gameSession    the player game session
     * @param casinoGameMode the game mode itself that was closed
     * @param runnable       necessary to complement the method. But it's generally used to remove a player from the session map.
     * **/

    void closeSingleplayerGameGUI(@Nonnull Player player, @Nullable SingleplayerGameSession gameSession, @Nonnull T casinoGameMode, @Nullable Runnable runnable);

    /**
     * Sets the bid buttons, replacing all placeholders.
     *
     * @param player          for whom is the button installed and whose data will be taken
     * @param inv             the inventory where it will be installed
     * @param spotSlots       the slots in the GUI to set
     * @param casinoGameMode  the game mode itself
     * **/

    void setSpotItems(@Nonnull Player player, @Nonnull Inventory inv, @Nonnull List<Integer> spotSlots, @Nonnull CasinoGameMode casinoGameMode);

    /**
     * Handles mode update on /vegas reload, returns their bet if the game has not yet started.
     *
     * @param sessions        the map with all players in this mode, where UUID - is the UUID of the player
     * @param casinoGameMode  the game mode itself
     * **/

    void reloadSingleplayerGameGUI(@Nonnull Map<UUID, SingleplayerGameSession> sessions, @Nonnull T casinoGameMode);

    /**
     * Sets the delay for recharging the mode.
     *
     * @param delay       the delay in ticks before starting a new game
     * @param player      the player who plays in this mode
     * @param gameSession the game session that requires a restart
     * @param runnable    where the method itself is implemented that restarts the mode
     * **/

    void restartSingleplayerGameWithDelay(int delay, @Nonnull Player player, @Nonnull SingleplayerGameSession gameSession, @Nonnull Runnable runnable);

    /**
     * Sets the delay for recharging the mode.
     *
     * @param delay       the delay in ticks before starting a new game
     * @param sessionHub  the game session that contains all game sessions
     * @param runnable    where the method itself is implemented that restarts the mode
     * **/

    void restartMultiplayerGameWithDelay(int delay, @Nonnull MultiplayerGameSessionsHub sessionHub, @Nonnull Runnable runnable);


}
