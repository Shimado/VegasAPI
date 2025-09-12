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
     * Adds or replaces a deck for the specified suit.
     *
     * @param cardSuit the suit to associate with the given deck.
     * @param deck     the deck to add.
     */

    void addToDeck(@Nonnull CardSuit cardSuit, @Nonnull Deck deck);

    /**
     * Returns the card item for the given suit and card number.
     *
     * @param cardSuit   the suit of the card.
     * @param cardNumber the card number (2–14).
     * @return the card item, or {@code null} if not present.
     */

    @Nullable
    ItemStack getCardItem(@Nonnull CardSuit cardSuit, int cardNumber);

}
