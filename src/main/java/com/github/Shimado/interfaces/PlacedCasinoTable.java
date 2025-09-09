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
     * Sets the unique identifier for this placed table.
     *
     * @param uuid the UUID to assign
     * @return this instance for chaining
     */

    PlacedCasinoTable setUUID(@Nonnull UUID uuid);

    /**
     * Gets the ID of the {@link CasinoTableItem} that defines this table.
     *
     * @return the table item ID
     */

    @Nonnull
    String getCasinoTableItemID();

    /**
     * Sets the ID of the {@link CasinoTableItem} that defines this table.
     *
     * @param casinoTableItemID the item ID to set
     * @return this instance for chaining
     */

    PlacedCasinoTable setCasinoTableItemID(@Nonnull String casinoTableItemID);

    /**
     * Gets the {@link CasinoTableItem} definition linked to this placed table.
     *
     * @return the table item definition
     */

    @Nonnull
    CasinoTableItem getCasinoTableItem();

    /**
     * Sets the {@link CasinoTableItem} definition linked to this placed table.
     *
     * @param casinoTableItem the table item definition
     * @return this instance for chaining
     */

    PlacedCasinoTable setCasinoTableItem(@Nonnull CasinoTableItem casinoTableItem);

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

    PlacedCasinoTable setGame(@Nonnull String game);

    /**
     * Gets the location of this table in the world.
     *
     * @return this table location
     */

    @Nonnull
    Location getLoc();

    /**
     * Sets the location of this table in the world.
     *
     * @param loc the location to set
     * @return this instance for chaining
     */

    PlacedCasinoTable setLoc(@Nonnull Location loc);

    /**
     * Gets the yaw (rotation) of this table.
     * Needs for the developers pack.
     *
     * @return the yaw angle
     */

    float getYaw();

    /**
     * Sets the yaw (rotation) of this table.
     * Needs for the developers pack.
     *
     * @param yaw the yaw angle
     * @return this instance for chaining
     */

    PlacedCasinoTable setYaw(float yaw);

    /**
     * Gets the UUID of the player who owns this table.
     *
     * @return the owner's UUID, or {@code null} if not set
     */

    @Nullable
    UUID getOwner();

    /**
     * Sets the UUID of the player who owns this table.
     *
     * @param owner the owner's UUID
     * @return this instance for chaining
     */

    PlacedCasinoTable setOwner(@Nullable UUID owner);
}

