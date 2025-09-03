package com.github.Shimado.interfaces;

import com.github.Shimado.api.CasinoGameModeMethods;
import com.github.Shimado.enums.InventoryType;
import com.github.Shimado.instances.CasinoGameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nullable;

public interface ISession<T extends CasinoGameMode & CasinoGameModeMethods & Listener>{

    @Nullable
    Inventory getInv();
    void setInv(Inventory inv);

    @Nullable
    InventoryType getInventoryType();
    void setInventoryType(InventoryType inventoryType);

    boolean isChangingPage();
    void setChangingPage(boolean changingPage);

    @Nullable
    String getTableGame();
    void setTableGame(String tableGame);

    @Nullable
    T getOpenedGame();
    void setOpenedGame(T openedGame);

    @Nullable
    IPlacedCasinoTable getCasinoTable();
    void setCasinoTable(IPlacedCasinoTable casinoTable);

    int getMusicPage();
    void setMusicPage(int musicPage);
    int nextMusicPage();
    int previousMusicPage();

    void closeInventory(Player player);

}
