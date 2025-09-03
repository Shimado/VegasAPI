package com.github.Shimado.api;

import com.github.Shimado.interfaces.IPlacedCasinoTable;
import com.github.Shimado.interfaces.InvSessionInstance;
import org.bukkit.entity.Player;

import java.util.Map;

public interface InvSession<T extends InvSessionInstance> {

    Map<Player, T> getSessions();

    T getSession(Player player);

    void removeSession(Player player);

    T getOrCreateNewSession(Player player);

    T getSessionOrCloseInventory(Player player);

    void removeTableFromSession(IPlacedCasinoTable casinoTable);

    void returnToPreviousPage(Player player);

    void reload();

}
