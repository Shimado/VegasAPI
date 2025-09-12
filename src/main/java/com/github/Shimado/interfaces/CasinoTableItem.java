package com.github.Shimado.interfaces;

import com.github.Shimado.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents a configurable casino table item definition.
 * Stores metadata such as ID, model data, linked game type,
 * table appearance (blocks and items), and optional animations.
 * Stores information about an item, not about the placed table.
 */

public interface CasinoTableItem {

    /**
     * Gets the unique identifier of this table item.
     *
     * @return the ID of the table
     */

    @Nonnull
    String getID();

    /**
     * Sets the unique identifier for this table item.
     *
     * @param id the ID to assign
     * @return this instance for chaining
     */

    CasinoTableItem setID(@Nonnull String id);

    /**
     * Gets the {@link ItemStack} representing the table item.
     *
     * @return the table item
     */

    @Nonnull
    ItemStack getTableItem();

    /**
     * Sets the {@link ItemStack} used as the table item.
     *
     * @param tableItem the item to set
     * @return this instance for chaining
     */

    CasinoTableItem setTableItem(@Nonnull ItemStack tableItem);

    /**
     * Gets the custom model data value used for the item.
     *
     * @return the custom model data
     */

    int getCustomModelData();

    /**
     * Sets the custom model data value for the item.
     *
     * @param customModelData the model data
     * @return this instance for chaining
     */

    CasinoTableItem setCustomModelData(int customModelData);

    /**
     * Gets the game mode name associated with this table item.
     * Or "ALL".
     *
     * @return the game mode name
     */

    @Nonnull
    String getGame();

    /**
     * Sets the game mode name associated with this table item.
     *
     * @param game the game mode name. Or "ALL"
     * @return this instance for chaining
     */

    CasinoTableItem setGame(@Nullable String game);

    /**
     * Gets the Y-axis offset of the table decoration armor stands.
     *
     * @return the vertical offset
     */

    double getYOffset();

    /**
     * Sets the Y-axis offset of the table decoration armor stands.
     *
     * @param yOffset the vertical offset
     * @return this instance for chaining
     */

    CasinoTableItem setYOffset(double yOffset);

    /**
     * Gets the carpet item used in the table's decoration.
     *
     * @return the carpet item, or {@code null} if not set
     */

    @Nullable
    ItemStack getCarpet();

    /**
     * Sets the carpet item used in the table's decoration.
     *
     * @param carpet the carpet item
     * @return this instance for chaining
     */

    CasinoTableItem setCarpet(@Nullable ItemStack carpet);

    /**
     * Gets the concrete item used in the table's decoration.
     *
     * @return the concrete item, or {@code null} if not set
     */

    @Nullable
    ItemStack getConcrete();

    /**
     * Sets the concrete item used in the table's decoration.
     *
     * @param concrete the concrete item
     * @return this instance for chaining
     */

    CasinoTableItem setConcrete(@Nullable ItemStack concrete);

    /**
     * Gets the glass item used in the table's decoration.
     *
     * @return the glass item, or {@code null} if not set
     */

    @Nullable
    ItemStack getGlass();

    /**
     * Sets the glass item used in the table's decoration.
     *
     * @param glass the glass item
     * @return this instance for chaining
     */

    CasinoTableItem setGlass(@Nullable ItemStack glass);

    /**
     * Gets the animation configuration for the casino table.
     *
     * @return the table animation, or {@code null} if not set
     */

    @Nullable
    TableAnimation getTableAnimation();

    /**
     * Sets the animation configuration for the table.
     *
     * @param tableAnimationType the animation type
     * @param itemsToDrop        the list of items to drop during animation
     * @param spawnChance        the chance for an item to spawn
     * @param itemsAmount        the amount of items to drop
     * @return this instance for chaining
     */

    CasinoTableItem setTableAnimation(@Nullable TableAnimationType tableAnimationType, @Nullable List<ItemStack> itemsToDrop, double spawnChance, int itemsAmount);

    /**
     * Sets the animation configuration for the table using string-based values.
     *
     * @param tableAnimationTypeString the animation type as a string
     * @param itemsToDropString        the list of items to drop as string identifiers
     * @param spawnChance              the chance for an item to spawn
     * @param itemsAmount              the amount of items to drop
     * @return this instance for chaining
     */

    CasinoTableItem setTableAnimation(@Nullable String tableAnimationTypeString, @Nullable List<String> itemsToDropString, double spawnChance, int itemsAmount);

}

