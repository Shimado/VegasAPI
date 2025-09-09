package com.github.Shimado.api;

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
     * @param inv    the inventory (GUI) that will be shown to the player
     */

    void openGame(@Nonnull Player player, @Nonnull Inventory inv);

    /**
     * Handles logic when the game GUI is closed.
     * Here you can specify the return of the bet if the session has not started.
     * And the deletion of the player's data from the session.
     *
     * @param e the inventory close event
     */

    void closeGUI(@Nonnull InventoryCloseEvent e);

    /**
     * Handles logic when the player interacts with the game GUI (clicking items, etc.).
     *
     * @param e the inventory click event
     */

    void clickGUI(@Nonnull InventoryClickEvent e);

    /**
     * Reloads the game mode, refreshing configuration or resetting state if needed.
     */

    void reload();

}
