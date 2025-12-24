package com.github.Shimado.interfaces;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ItemRunnable {

    void run(@Nullable ItemStack item);

}
