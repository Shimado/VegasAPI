package com.github.Shimado.instances;

import org.bukkit.Location;

import javax.annotation.Nullable;
import java.util.UUID;

public class PlacedCasinoTable {

    private UUID uuid;
    private String casinoTableItemID;
    private CasinoTableItem casinoTableItem;
    private String game;
    private Location loc;
    private float yaw = 0.0f;
    private UUID owner;


    public PlacedCasinoTable(UUID uuid){
        this.uuid = uuid;
    }


    @Nullable
    public UUID getUUID(){
        return this.uuid;
    }

    public PlacedCasinoTable setUUID(UUID uuid){
        this.uuid = uuid;
        return this;
    }


    @Nullable
    public String getCasinoTableItemID(){
        return this.casinoTableItemID;
    }

    public PlacedCasinoTable setCasinoTableItemID(String casinoTableItemID){
        this.casinoTableItemID = casinoTableItemID;
        return this;
    }


    @Nullable
    public CasinoTableItem getCasinoTableItem(){
        return this.casinoTableItem;
    }

    public PlacedCasinoTable setCasinoTableItem(CasinoTableItem casinoTableItem){
        this.casinoTableItem = casinoTableItem;
        return this;
    }


    @Nullable
    public String getGame(){
        return this.game;
    }

    public PlacedCasinoTable setGame(String game){
        this.game = game;
        return this;
    }


    @Nullable
    public Location getLoc(){
        return this.loc;
    }

    public PlacedCasinoTable setLoc(Location loc){
        this.loc = loc;
        return this;
    }


    public float getYaw(){
        return this.yaw;
    }

    public PlacedCasinoTable setYaw(float yaw){
        this.yaw = yaw;
        return this;
    }


    @Nullable
    public UUID getOwner(){
        return owner;
    }

    public PlacedCasinoTable setOwner(UUID owner){
        this.owner = owner;
        return this;
    }

}
