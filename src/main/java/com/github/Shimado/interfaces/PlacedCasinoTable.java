package com.github.Shimado.interfaces;

import org.bukkit.Location;

import javax.annotation.Nullable;
import java.util.UUID;

public interface PlacedCasinoTable {

    @Nullable
    UUID getUUID();
    PlacedCasinoTable setUUID(UUID uuid);

    @Nullable
    String getCasinoTableItemID();
    PlacedCasinoTable setCasinoTableItemID(String casinoTableItemID);

    @Nullable
    CasinoTableItem getCasinoTableItem();
    PlacedCasinoTable setCasinoTableItem(CasinoTableItem casinoTableItem);

    @Nullable
    String getGame();
    PlacedCasinoTable setGame(String game);

    @Nullable
    Location getLoc();
    PlacedCasinoTable setLoc(Location loc);

    float getYaw();
    PlacedCasinoTable setYaw(float yaw);

    @Nullable
    UUID getOwner();
    PlacedCasinoTable setOwner(UUID owner);

}
