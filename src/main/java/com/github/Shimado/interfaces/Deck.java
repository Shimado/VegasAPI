package com.github.Shimado.interfaces;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public interface Deck {

    @Nonnull
    Map<Integer, ItemStack> getCards();

    @Nullable
    ItemStack getCard(int cardNumber);

    void setCard(int cardNumber, ItemStack card);

}
