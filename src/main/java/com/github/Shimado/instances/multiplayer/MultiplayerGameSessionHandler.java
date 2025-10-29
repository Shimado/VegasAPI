package com.github.Shimado.instances.multiplayer;

import com.github.Shimado.VegasAPI;
import com.github.Shimado.api.CasinoGameModeUtil;
import com.github.Shimado.instances.CasinoGameMode;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MultiplayerGameSessionHandler<S extends MultiplayerGameSessionsHub, M extends MultiplayerGameSession> {

    private CasinoGameModeUtil casinoGameModeUtil = VegasAPI.getCasinoGameModeUtil();

    private int maxPlayers = 0;
    private Map<UUID, S> sessions = new HashMap<>();

    public MultiplayerGameSessionHandler(){}

    public MultiplayerGameSessionHandler(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }


    public int getMaxPlayers() {
        return maxPlayers;
    }

    public MultiplayerGameSessionHandler setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }


    @Nonnull
    public Map<UUID, S> getSessions(){
        return sessions;
    }


    @Nonnull
    public S joinPlayerToGame(@Nonnull Player player, @Nonnull M gameSession){
        S result = null;

        for(S session : sessions.values()){
            if(session.isOpened() && session.getPlayerSessions().size() < maxPlayers){
                result = session;
                break;
            }
        }

        if(result == null){
            UUID sessionUUID = UUID.randomUUID();
            result = sessions.computeIfAbsent(sessionUUID, k -> (S) new MultiplayerGameSessionsHub<>(sessionUUID));
        }

        result.addPlayerSession(player, gameSession);
        return result;
    }


    @Nullable
    public S getMultiplayerGameSessionHub(@Nonnull Player player){
        for(S session : sessions.values()){
            if(session.getPlayerSessions().containsKey(player)){
                return session;
            }
        }
        return null;
    }


    @Nullable
    public M getGameSession(@Nonnull Player player){
        for(S session : sessions.values()){
            if(session.getPlayerSessions().containsKey(player)){
                return (M) session.getPlayerSessions().get(player);
            }
        }
        return null;
    }


    public void removeSession(@Nonnull UUID sessionUUID){
        sessions.remove(sessionUUID);
    }


    public void reload(@Nonnull CasinoGameMode casinoGameMode){
        for (S session : sessions.values()) {
            session.cancelCycleID();
            casinoGameModeUtil.reloadSingleGameGUI(session.getPlayerSessions(), casinoGameMode);
            session.setPlayerSessions(new HashMap<>());
            session.setOpened(false);
        }
        sessions.clear();
    }

}
