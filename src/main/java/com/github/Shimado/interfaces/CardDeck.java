package com.github.Shimado.interfaces;

import com.github.Shimado.enums.CardSuit;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

    @Nonnull
    Map<CardSuit, Deck> getDeckMap();

    /**
     * Returns the deck for the specified suit.
     *
     * @param cardSuit the suit whose deck is requested.
     * @return a non-null deck for the given suit.
     */

    @Nonnull
    Deck getDeck(@Nonnull CardSuit cardSuit);

    /**
     * Returns the card item for the given suit and card number.
     *
     * @param cardSuit   the suit of the card.
     * @param cardNumber the card number (2–14).
     * @return the card item, or {@code null} if cardNumber < 2 or carNumber > 14
     */

    @Nullable
    ItemStack getCardItem(@Nonnull CardSuit cardSuit, int cardNumber);

    /**
     * Removes a card from the deck by suit and card number.
     *
     * @param cardSuit   the suit of the card.
     * @param cardNumber the card number (2–14).
     */

    void removeCardItem(@Nonnull CardSuit cardSuit, int cardNumber);

    /**
     * Returns a random card, namely an array of suit and card number.
     *
     * @return the array, where [0] - CardSuit, [1] - cardNumber
     */

    @Nonnull
    Object[] getRandomCardItem();

    /**
     * Returns a random card, namely an array of suit and card number.
     * And removes it from the deck's card list.
     *
     * @return the array, where [0] - CardSuit, [1] - cardNumber
     */

    @Nonnull
    Object[] getRandomCardItemAndRemoveFromDeck();

}
