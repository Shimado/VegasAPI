package com.github.Shimado.interfaces;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

@FunctionalInterface
public interface ItemRunnable {

    void run(@Nullable ItemStack item);

}
