package com.github.Shimado.api;

import com.github.Shimado.instances.*;
import com.github.Shimado.interfaces.Jackpot;
import com.github.Shimado.interfaces.PlayerSettings;
import com.github.Shimado.interfaces.ShopItem;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

/**
 * Provides access to persistent and runtime data used in the casino system.
 * This interface defines methods to retrieve bet items, jackpots, player-related data,
 * shop items, and game statistics.
 */

public interface DataStorage {

    /**
     * Gets the base bet item used in the casino.
     * Needed if the token type is "ITEMS"
     * If the item is {@code null}, then players will be able to bet with any item.
     * If specified, then only with this item.
     *
     * @return the bet {@link ItemStack} or {@code null}
     */

    @Nullable
    ItemStack getBetItem();

    /**
     * Gets the current jackpot instance.
     *
     * @return the {@link Jackpot}
     */

    @Nonnull
    Jackpot getJackpot();

    /**
     * Gets the settings of a specific player.
     *
     * @param playerUUID the unique identifier of the player
     * @return the {@link PlayerSettings} of the player, or {@code null} if not found
     */

    @Nullable
    PlayerSettings getPlayerSettings(@Nullable UUID playerUUID);

    /**
     * Gets the player's internal in-plugin balance. Use {@link EconomyUtil}
     *
     * @param playerUUID the unique identifier of the player
     * @return the balance as a double
     */

    double getBalance(@Nullable UUID playerUUID);

    /**
     * Gets all shop items available in the casino.
     * Key in this map is a slot in the shop GUI.
     *
     * @return a map of slot indices to {@link ShopItem}
     */

    @Nonnull
    Map<Integer, ShopItem> getShopItems();

    /**
     * Gets a specific shop item by slot in the shop GUI.
     *
     * @param slot the slot index
     * @return the {@link ShopItem}, or {@code null} if not found
     */

    @Nullable
    ShopItem getShopItem(int slot);

    /**
     * Gets all registered player statistics.
     *
     * @return a map of player UUIDs to {@link PlayerStats}
     */

    @Nonnull
    Map<UUID, PlayerStats> getPlayerStats();

    /**
     * Gets statistics of a specific player.
     *
     * @param playerUUID the unique identifier of the player
     * @return the {@link PlayerStats} of the player, or {@code null} if not found
     */

    @Nullable
    PlayerStats getPlayerStats(@Nullable UUID playerUUID);

    /**
     * Gets overall statistics for all casino game modes.
     * Where is the map key, this is the name of the game mode.
     *
     * @return a map of game names to {@link CasinoGameModeStats}
     */

    @Nonnull
    Map<String, CasinoGameModeStats> getGameStats();

    /**
     * Gets statistics for a specific casino game mode.
     *
     * @param gameName the name of the game
     * @return the {@link CasinoGameModeStats}, or {@code null} if not found
     */

    @Nullable
    CasinoGameModeStats getCasinoGameStats(@Nullable String gameName);

    /**
     * Gets a queue of all player logs that contain data on the game played and its results:
     * Prizes, victory/defeat, player UUID/name, game mode and etc
     *
     * @return a queue of all player logs.
     */

    @Nonnull
    Queue getGameLogs();

    /**
     * Gets a queue of the player logs that contain data on the game played and its results:
     * Prizes, victory/defeat, player UUID/name, game mode and etc
     *
     * @param playerUUID the unique identifier of the player
     * @return a queue of all logs for a given player, or {@code null} if not found
     */

    @Nullable
    Queue getPlayerGameLogs(@Nullable UUID playerUUID);

}
