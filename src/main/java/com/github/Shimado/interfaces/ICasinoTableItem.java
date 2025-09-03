package com.github.Shimado.interfaces;

import com.github.Shimado.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

public interface ICasinoTableItem {

    @Nullable
    String getID();
    ICasinoTableItem setID(String id);

    @Nullable
    ItemStack getTableItem();
    ICasinoTableItem setTableItem(ItemStack tableItem);

    int getCustomModelData();
    ICasinoTableItem setCustomModelData(int customModelData);

    @Nullable
    String getGame();
    ICasinoTableItem setGame(String game);

    double getYOffset();
    ICasinoTableItem setYOffset(double yOffset);

    @Nullable
    ItemStack getCarpet();
    ICasinoTableItem setCarpet(ItemStack carpet);

    @Nullable
    ItemStack getConcrete();
    ICasinoTableItem setConcrete(ItemStack concrete);

    @Nullable
    ItemStack getGlass();
    ICasinoTableItem setGlass(ItemStack glass);

    @Nullable
    ITableAnimation getTableAnimation();
    ICasinoTableItem setTableAnimation(TableAnimationType tableAnimationType, List<ItemStack> itemsToDrop, double spawnChance, int itemsAmount);
    ICasinoTableItem setTableAnimation(String tableAnimationTypeString, List<String> itemsToDropString, double spawnChance, int itemsAmount);

}
