package com.github.Shimado.interfaces;

import com.github.Shimado.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface ITableAnimation {

    @Nullable
    TableAnimationType getTableAnimationType();
    void setTableAnimationType(TableAnimationType tableAnimationType);

    @Nonnull
    List<ItemStack> getItemsToDrop();
    void setItemsToDrop(List<ItemStack> itemsToDrop);

    double getDropSpawnChance();
    void setDropSpawnChance(double dropSpawnChance);

    int getItemsAmount();
    void setItemsAmount(int itemsAmount);

}
