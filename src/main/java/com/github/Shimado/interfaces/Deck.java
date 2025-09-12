package com.github.Shimado.interfaces;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * Represents a single deck of cards for a specific suit.
 * Contains cards numbered from 2 to 14.
 * <p>
 * Card number mapping:
 * <ul>
 *     <li>2–10 → Number cards</li>
 *     <li>11 → Jack</li>
 *     <li>12 → Queen</li>
 *     <li>13 → King</li>
 *     <li>14 → Ace</li>
 * </ul>
 */

public interface Deck {

    /**
     * Returns all cards in this deck as a map.
     *
     * @return a non-null map where keys are card numbers (2–14) and values are card items.
     */

    @Nonnull
    Map<Integer, ItemStack> getCards();

    /**
     * Returns the card for the specified number.
     *
     * @param cardNumber the card number (2–14).
     * @return the card item, or {@code null} if not present.
     */

    @Nullable
    ItemStack getCard(int cardNumber);

    /**
     * Sets or replaces the card at the specified number.
     *
     * @param cardNumber the card number (2–14).
     * @param card       the card item to set.
     */

    void setCard(int cardNumber, @Nonnull ItemStack card);

}
