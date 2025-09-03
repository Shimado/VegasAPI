package com.github.Shimado.interfaces;

import org.bukkit.Location;

import javax.annotation.Nullable;
import java.util.UUID;

public interface IPlacedCasinoTable {

    @Nullable
    UUID getUUID();
    IPlacedCasinoTable setUUID(UUID uuid);

    @Nullable
    String getCasinoTableItemID();
    IPlacedCasinoTable setCasinoTableItemID(String casinoTableItemID);

    @Nullable
    ICasinoTableItem getCasinoTableItem();
    IPlacedCasinoTable setCasinoTableItem(ICasinoTableItem casinoTableItem);

    @Nullable
    String getGame();
    IPlacedCasinoTable setGame(String game);

    @Nullable
    Location getLoc();
    IPlacedCasinoTable setLoc(Location loc);

    float getYaw();
    IPlacedCasinoTable setYaw(float yaw);

    @Nullable
    UUID getOwner();
    IPlacedCasinoTable setOwner(UUID owner);

}
