package com.github.Shimado.api;

import com.github.Shimado.interfaces.IPlacedCasinoTable;
import com.github.Shimado.interfaces.ISession;
import org.bukkit.entity.Player;

import java.util.Map;

public interface InvSession {

    Map<Player, ISession> getSessions();

    ISession getSession(Player player);

    void removeSession(Player player);

    ISession getOrCreateNewSession(Player player);

    ISession getSessionOrCloseInventory(Player player);

    void removeTableFromSession(IPlacedCasinoTable casinoTable);

    void returnToPreviousPage(Player player);

    void reload();

}
