package com.github.Shimado.interfaces;

import com.github.Shimado.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents the animation configuration for a casino table.
 * Defines how items are spawned/dropped, the animation type,
 * and other related parameters.
 */

public interface TableAnimation {

    /**
     * Gets the type of table animation.
     *
     * @return the animation type
     */

    @Nonnull
    TableAnimationType getTableAnimationType();

    /**
     * Sets the type of table animation.
     *
     * @param tableAnimationType the animation type
     * @return this instance for chaining
     */

    TableAnimation setTableAnimationType(@Nonnull TableAnimationType tableAnimationType);

    /**
     * Gets the list of items that can be dropped during the animation.
     *
     * @return a non-null list of item stacks (may be empty)
     */

    @Nonnull
    List<ItemStack> getItemsToDrop();

    /**
     * Sets the list of items that can be dropped during the animation.
     *
     * @param itemsToDrop the list of item stacks
     * @return this instance for chaining
     */

    TableAnimation setItemsToDrop(@Nullable List<ItemStack> itemsToDrop);

    /**
     * Gets the chance that an item will spawn/drop during the animation.
     * Value is typically between {@code 0.0} (never) and {@code 100.0}
     *
     * @return the drop spawn chance
     */

    double getDropSpawnChance();

    /**
     * Sets the chance that an item will spawn/drop during the animation.
     * Value should be between {@code 0.0} and {@code 100.0}.
     *
     * @param dropSpawnChance the spawn chance
     * @return this instance for chaining
     */

    TableAnimation setDropSpawnChance(double dropSpawnChance);

    /**
     * Gets the amount of items that can be dropped per animation cycle.
     *
     * @return the number of items
     */

    int getItemsAmount();

    /**
     * Sets the amount of items that can be dropped per animation cycle.
     *
     * @param itemsAmount the number of items
     * @return this instance for chaining
     */

    TableAnimation setItemsAmount(int itemsAmount);

}

