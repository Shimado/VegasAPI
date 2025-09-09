package com.github.Shimado.interfaces;

import com.github.Shimado.enums.CardSuit;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public interface CardDeck {

    @Nonnull
    Map<CardSuit, Deck> getDeckMap();

    @Nonnull
    Deck getDeck(CardSuit cardSuit);

    void addToDeck(CardSuit cardSuit, Deck deck);

    @Nullable
    ItemStack getCardItem(CardSuit cardSuit, int cardNumber);

}
