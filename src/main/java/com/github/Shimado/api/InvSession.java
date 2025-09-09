package com.github.Shimado.api;

import com.github.Shimado.interfaces.PlacedCasinoTable;
import com.github.Shimado.interfaces.ISession;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * Represents a manager for player inventory sessions.
 * Provides methods to create, retrieve, update, and remove sessions
 * associated with players, as well as handle session-related actions.
 */

public interface InvSession {

    /**
     * Gets the map of all active player sessions.
     *
     * @return a map of players to their active sessions
     */

    @Nonnull
    Map<Player, ISession> getSessions();

    /**
     * Gets the current session for the specified player.
     *
     * @param player the player
     * @return the player's session, or {@code null} if none exists
     */

    @Nullable
    ISession getSession(@Nonnull Player player);

    /**
     * Removes the current session for the specified player.
     *
     * @param player the player whose session should be removed
     */

    void removeSession(@Nonnull Player player);

    /**
     * Gets the existing session for the specified player,
     * or creates a new one if none exists.
     *
     * @param player the player
     * @return the existing or newly created session
     */

    @Nonnull
    ISession getOrCreateNewSession(@Nonnull Player player);

    /**
     * Gets the player's session if available,
     * or closes their inventory if no session exists.
     *
     * @param player the player
     * @return the player's session, or {@code null} if none exists
     */

    @Nullable
    ISession getSessionOrCloseInventory(@Nonnull Player player);

    /**
     * Removes a specific casino table from any session it is associated with.
     *
     * @param casinoTable the placed casino table to remove from session
     */

    void removeTableFromSession(@Nullable PlacedCasinoTable casinoTable);

    /**
     * Returns the player to their previous inventory page,
     * if available in the session history.
     *
     * @param player the player to return
     */

    void returnToPreviousPage(@Nonnull Player player);

    /**
     * Reloads all active sessions and their states.
     */

    void reload();
}

