package com.github.Shimado.api;

import com.github.Shimado.interfaces.ISession;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;

/**
 * Defines common methods that any casino game mode must implement.
 * Needed to automate opening the game mode through the main GUI, returning to the main menu, etc.
 */

public interface CasinoGameModeMethods {

    /**
     * Opens the game GUI for a given player.
     *
     * @param player the player who is opening the game
     * @param inv    the inventory (GUI) that will be shown to the player.
     *               It will already contain a title and items from "empty-slots:"
     */

    void openGame(@Nonnull Player player, @Nonnull Inventory inv);

    /**
     * Handles logic when the game GUI is closed.
     * Here you can specify the return of the bet if the session has not started.
     * And the deletion of the player's data from the session.
     *
     * @param player the player who closed the game inventory
     */

    void closeGUI(@Nonnull Player player);

    /**
     * Handles logic when the player interacts with the game GUI (clicking items, etc.).
     *
     * @param e      the inventory click event
     * @param player the player who clicked
     * @param session the inventory session that stores some data
     */

    void clickGUI(@Nonnull InventoryClickEvent e, @Nonnull Player player, @Nonnull ISession session);

    /**
     * Reloads the game mode, refreshing configuration or resetting state if needed.
     */

    void reload();

}
