package com.github.Shimado.instances.multiplayer;

import com.github.Shimado.instances.CasinoGameMode;
import com.github.Shimado.interfaces.CycleTask;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class MultiplayerGameSessionsHub<M extends MultiplayerGameSession> {

    private UUID sessionUUID;
    private Map<Player, M> playerSessions = new HashMap<>();
    private CycleTask cycle;
    private int timer = 0;
    private boolean opened = true;

    public MultiplayerGameSessionsHub(@Nonnull UUID sessionUUID){
        this.sessionUUID = sessionUUID;
    }


    @Nonnull
    public UUID getSessionUUID() {
        return sessionUUID;
    }


    @Nonnull
    public Map<Player, M> getPlayerSessions(){
        return playerSessions;
    }

    public void setPlayerSessions(@Nonnull Map<Player, M> playerSessions) {
        this.playerSessions = playerSessions;
    }

    @Nullable
    public M getPlayerSession(@Nonnull Player player){
        return playerSessions.get(player);
    }

    public void addPlayerSession(@Nonnull Player player, @Nonnull M gameSession){
        playerSessions.put(player, gameSession);
    }

    public void removePlayerSession(@Nonnull UUID player){
        playerSessions.remove(player);
    }


    @Nonnull
    public Map<Player, M> getPlayerSessionsWithActiveBetsAndSlots(){
        return playerSessions.entrySet().stream()
                .filter(it -> it.getValue().getBet() != null && it.getValue().getBet().isAnyBet() && it.getValue().getSlot() != -1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Nonnull
    public Map<Player, M> getPlayerSessionsWithActiveBets(){
        return playerSessions.entrySet().stream()
                .filter(it -> it.getValue().getBet() != null && it.getValue().getBet().isAnyBet())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    public int getPlayersAmount(){
        return playerSessions.size();
    }

    public int getPlayerAmountWithActiveBetsAndSlots(){
        return (int) playerSessions.values().stream().filter(it -> it.getBet() != null && it.getBet().isAnyBet() && it.getSlot() != -1).count();
    }

    public int getPlayerAmountWithActiveBets(){
        return (int) playerSessions.values().stream().filter(it -> it.getBet() != null && it.getBet().isAnyBet()).count();
    }

    public List<Integer> getFreeSpotSlots(@Nonnull CasinoGameMode gameMode){
        List<Integer> emptySlots = new ArrayList<>(gameMode.getSpotSlots());
        Set<Integer> occupiedSlots = playerSessions.values().stream()
                .map(s -> s.getSlot())
                .filter(slot -> slot != -1)
                .collect(Collectors.toSet());

        emptySlots.removeAll(occupiedSlots);
        return emptySlots;
    }


    public boolean isCycleActive() {
        return cycle != null;
    }

    public void setCycleID(@Nullable CycleTask cycle) {
        this.cycle = cycle;
    }

    public void cancelCycleID() {
        if (cycle != null) {
            cycle.cancelTask();
            cycle = null;
        }
    }


    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }


    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

}
