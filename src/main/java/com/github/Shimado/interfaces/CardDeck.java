package com.github.Shimado.interfaces;

import com.github.Shimado.enums.CardSuit;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Represents a collection of playing cards organized by suits.
 * Each {@link CardSuit} has its own {@link Deck} containing cards numbered from 2 to 14.
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

public interface CardDeck {

    /**
     * Returns a map of all decks by suit.
     *
     * @return a non-null map where keys are suits and values are decks.
     */

    @NotNull
    Map<CardSuit, Deck> getDeckMap();

    /**
     * Returns the deck for the specified suit.
     *
     * @param cardSuit the suit whose deck is requested.
     * @return the deck for the given suit, or {@code null}
     */

    @Nullable
    Deck getDeck(@NotNull CardSuit cardSuit);

    /**
     * Returns the card item for the given suit and card number.
     *
     * @param cardSuit   the suit of the card.
     * @param cardNumber the card number (2–14).
     * @return the card item, or {@code null} if cardNumber less than 2 or carNumber more than 14
     */

    @Nullable
    ItemStack getCardItem(@NotNull CardSuit cardSuit, int cardNumber);

    /**
     * Removes a card from the deck by suit and card number.
     *
     * @param cardSuit   the suit of the card.
     * @param cardNumber the card number (2–14).
     */

    void removeCardItem(@NotNull CardSuit cardSuit, int cardNumber);

    /**
     * Returns a random card, namely an array of suit and card number.
     *
     * @return the array, where [0] - CardSuit, [1] - cardNumber, [2] - ItemStack
     */

    @NotNull
    Object[] getRandomCardItem();

    /**
     * Returns a random card, namely an array of suit and card number.
     * And removes it from the deck's card list.
     *
     * @return the array, where [0] - CardSuit, [1] - cardNumber, [2] - ItemStack
     */

    @NotNull
    Object[] getRandomCardItemAndRemoveFromDeck();

}
