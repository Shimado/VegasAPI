package com.github.Shimado.interfaces;

import com.github.Shimado.api.CasinoGameModeMethods;
import com.github.Shimado.enums.InventoryType;
import com.github.Shimado.instances.CasinoGameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents a session for a casino game GUI (inventory-based).
 * Stores information about the current state of the session such as
 * opened inventory, associated game, table, and pagination.
 *
 * @param <T> the game mode, which must implement {@link CasinoGameMode}, {@link CasinoGameModeMethods}
 */

public interface ISession<T extends CasinoGameMode & CasinoGameModeMethods> {

    /**
     * Gets the current inventory associated with this session.
     *
     * @return the inventory
     */

    @Nonnull
    Inventory getInv();

    /**
     * Sets the inventory associated with this session.
     *
     * @param inv the inventory to set
     */

    void setInv(@Nonnull Inventory inv);

    /**
     * Gets the opened Music inventory associated with this session.
     *
     * @return the inventory, or {@code null} if GUI is closed
     */

    @Nullable
    Inventory getMusicInv();

    /**
     * Sets the opened Music inventory associated with this session.
     *
     * @param musicInv the inventory to set
     */

    void setMusicInv(@Nullable Inventory musicInv);

    /**
     * Gets the type of the current GUI.
     *
     * @return the GUI type
     */

    @Nonnull
    InventoryType getInventoryType();

    /**
     * Sets the type of the current GUI.
     *
     * @param inventoryType the GUI type
     */

    void setInventoryType(@Nonnull InventoryType inventoryType);

    /**
     * Checks whether the session is currently changing pages.
     *
     * @return {@code true} if a page change is in progress, otherwise {@code false}
     */

    boolean isChangingPage();

    /**
     * Sets whether the session is currently changing pages.
     *
     * @param changingPage {@code true} if changing, otherwise {@code false}
     */

    void setChangingPage(boolean changingPage);

    /**
     * Gets the name of the game mode associated with this session's table.
     * Can be "ALL"
     *
     * @return the table game identifier
     */

    @Nonnull
    String getTableGame();

    /**
     * Sets the name of the game associated with this session's table.
     * Can be "ALL"
     *
     * @param tableGame the game identifier
     */

    void setTableGame(@Nonnull String tableGame);

    /**
     * Gets the currently opened game instance in this session.
     *
     * @return the opened game, or {@code null} if none is active
     */

    @Nullable
    T getOpenedGame();

    /**
     * Sets the currently opened game instance in this session.
     *
     * @param openedGame the game instance
     */

    void setOpenedGame(@Nullable T openedGame);

    /**
     * Gets the placed casino table the player is playing.
     *
     * @return the placed casino table, or {@code null} if opened by a command.
     */

    @Nullable
    PlacedCasinoTable getCasinoTable();

    /**
     * Sets the placed casino table associated with this session or {@code null} if opened by a command.
     *
     * @param casinoTable the placed casino table
     */

    void setCasinoTable(@Nullable PlacedCasinoTable casinoTable);

    /**
     * Gets the current page index.
     *
     * @return the page number
     */

    int getPage();

    /**
     * Sets the current page index.
     *
     * @param page the page number
     */

    void setPage(int page);

    /**
     * Advances to the next page and returns the new index.
     *
     * @return the next page number
     */

    int nextPage();

    /**
     * Goes back to the previous page and returns the new index.
     *
     * @return the previous page number
     */

    int previousPage();

    /**
     * Closes the GUI for the given player.
     * Closes the GUI and does not return to the previous one.
     *
     * @param player the player whose inventory should be closed
     */

    void closeInventory(@Nonnull Player player);

}

