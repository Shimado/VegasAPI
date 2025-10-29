package com.github.Shimado.interfaces;

import com.github.Shimado.instances.multiplayer.MultiplayerGameSession;
import com.github.Shimado.instances.multiplayer.MultiplayerGameSessionsHub;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface RefreshInvRunnable<S extends MultiplayerGameSessionsHub, T extends MultiplayerGameSession> {

    void run(@Nonnull T leftGameSession, @Nonnull S sessionHub);

}
