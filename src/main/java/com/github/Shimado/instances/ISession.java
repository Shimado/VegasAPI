package com.github.Shimado.instances;

import com.github.Shimado.api.CasinoGameModeMethods;
import org.bukkit.event.Listener;
import org.shimado.basicutils.inventory.InvSessionInstance;

import javax.annotation.Nullable;

public class ISession<T extends CasinoGameMode & CasinoGameModeMethods & Listener> extends InvSessionInstance {

    private InventoryType inventoryType;
    private String tableGame;
    private T openedGame;
    private PlacedCasinoTable casinoTable;
    private int musicPage = 1;


    public void setInventoryType(InventoryType inventoryType){
        this.inventoryType = inventoryType;
    }

    @Nullable
    public InventoryType getInventoryType(){
        return inventoryType;
    }


    public void setTableGame(String tableGame){
        this.tableGame = tableGame;
    }

    @Nullable
    public String getTableGame(){
        return tableGame;
    }


    public void setOpenedGame(T openedGame){
        this.openedGame = openedGame;
    }

    @Nullable
    public T getOpenedGame(){
        return openedGame;
    }


    public void setCasinoTable(PlacedCasinoTable casinoTable){
        this.casinoTable = casinoTable;
    }

    @Nullable
    public PlacedCasinoTable getCasinoTable(){
        return casinoTable;
    }


    public void setMusicPage(int musicPage){
        this.musicPage = musicPage;
    }

    public int getMusicPage(){
        return musicPage;
    }


    public enum InventoryType{
        MAIN,
        SHOP,
        STATISTICS,
        MUSIC,
        GAME_MODE,
    }

}
