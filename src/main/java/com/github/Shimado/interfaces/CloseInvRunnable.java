package com.github.Shimado.interfaces;

import com.github.Shimado.instances.multiplayer.MultiplayerGameSession;
import com.github.Shimado.instances.multiplayer.MultiplayerGameSessionsHub;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@FunctionalInterface
public interface CloseInvRunnable<S extends MultiplayerGameSessionsHub, T extends MultiplayerGameSession> {

    void run(@Nonnull Player player, @Nonnull T gameSession, @Nonnull T leftGameSession, @Nonnull S sessionHub);

}
