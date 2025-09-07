package com.github.Shimado.interfaces;

import com.github.Shimado.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface TableAnimation {

    @Nullable
    TableAnimationType getTableAnimationType();
    TableAnimation setTableAnimationType(TableAnimationType tableAnimationType);

    @Nonnull
    List<ItemStack> getItemsToDrop();
    TableAnimation setItemsToDrop(List<ItemStack> itemsToDrop);

    double getDropSpawnChance();
    TableAnimation setDropSpawnChance(double dropSpawnChance);

    int getItemsAmount();
    TableAnimation setItemsAmount(int itemsAmount);

}
