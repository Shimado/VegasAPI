package com.github.Shimado.interfaces;

import org.bukkit.Location;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Represents a placed casino table in the world.
 * Stores metadata about its identity, location, orientation,
 * associated game, and owner.
 */

public interface PlacedCasinoTable {

    /**
     * Gets the unique identifier of this placed table.
     *
     * @return the table UUID
     */

    @Nonnull
    UUID getUUID();

    /**
     * Gets the ID of the {@link CasinoTableItem} that defines this table.
     *
     * @return the table item ID
     */

    @Nonnull
    String getCasinoTableItemID();

    /**
     * Gets the {@link CasinoTableItem} definition linked to this placed table.
     *
     * @return the table item definition
     */

    @Nonnull
    CasinoTableItem getCasinoTableItem();

    /**
     * Gets the game mode name associated with this table.
     * Can be "ALL".
     *
     * @return the game mode name
     */

    @Nonnull
    String getGame();

    /**
     * Sets the game mode name associated with this table.
     * Can be "ALL".
     *
     * @param game the game mode name
     * @return this instance for chaining
     */

    PlacedCasinoTable setGame(@Nullable String game);

    /**
     * Gets the location of this table in the world.
     *
     * @return this table location
     */

    @Nonnull
    Location getLoc();

    /**
     * Gets the yaw (rotation) of this table.
     * Needs for the developers pack.
     *
     * @return the yaw angle
     */

    float getYaw();

    /**
     * Gets the UUID of the player who owns this table.
     *
     * @return the owner's UUID, or {@code null} if not set
     */

    @Nullable
    UUID getOwner();

}

