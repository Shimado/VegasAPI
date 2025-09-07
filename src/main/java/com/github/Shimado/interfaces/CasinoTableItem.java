package com.github.Shimado.interfaces;

import com.github.Shimado.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

public interface CasinoTableItem {

    @Nullable
    String getID();
    CasinoTableItem setID(String id);

    @Nullable
    ItemStack getTableItem();
    CasinoTableItem setTableItem(ItemStack tableItem);

    int getCustomModelData();
    CasinoTableItem setCustomModelData(int customModelData);

    @Nullable
    String getGame();
    CasinoTableItem setGame(String game);

    double getYOffset();
    CasinoTableItem setYOffset(double yOffset);

    @Nullable
    ItemStack getCarpet();
    CasinoTableItem setCarpet(ItemStack carpet);

    @Nullable
    ItemStack getConcrete();
    CasinoTableItem setConcrete(ItemStack concrete);

    @Nullable
    ItemStack getGlass();
    CasinoTableItem setGlass(ItemStack glass);

    @Nullable
    TableAnimation getTableAnimation();
    CasinoTableItem setTableAnimation(TableAnimationType tableAnimationType, List<ItemStack> itemsToDrop, double spawnChance, int itemsAmount);
    CasinoTableItem setTableAnimation(String tableAnimationTypeString, List<String> itemsToDropString, double spawnChance, int itemsAmount);

}
