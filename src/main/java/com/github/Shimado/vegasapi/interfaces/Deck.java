package com.github.Shimado.vegasapi.interfaces;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    @NotNull
    Map<Integer, ItemStack> getCards();

    /**
     * Returns the card for the specified number.
     *
     * @param cardNumber the card number (2–14).
     * @return the card item, or {@code null} if cardNumber less than 2 or carNumber more than 14
     */

    @Nullable
    ItemStack getCard(int cardNumber);

    /**
     * Returns a random card number.
     *
     * @return the card number
     */

    int getRandomCardNumber();

    /**
     * Returns a random card number and removes it from the deck's card list.
     *
     * @return the card number
     */

    int getRandomCardNumberAndRemoveFromDeck();

}
