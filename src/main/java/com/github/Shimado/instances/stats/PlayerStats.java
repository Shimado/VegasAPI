package com.github.Shimado.instances.stats;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Stores all player statistics: number of games, losses,
 * money won/lost, and detailed stats for each game mode.
 */

public class PlayerStats extends VegasStats{

    private UUID playerUUID;
    private Map<String, CasinoGameModeStats> gameStats = new HashMap<>();


    /**
     * Creates a new PlayerStats instance with only a UUID.
     * If you want to create a "clean" user with zero statistics.
     *
     * @param playerUUID unique identifier of the player
     */

    public PlayerStats(@NotNull UUID playerUUID){
        super();
        this.playerUUID = playerUUID;
    }

    /**
     * Creates a new PlayerStats instance with full statistics.
     *
     * @param playerUUID  unique identifier of the player
     * @param gamesPlayed number of games played
     * @param victories   number of victories
     * @param bonuses     number of bonuses
     * @param defeats     number of defeats
     * @param draws       number of draws
     * @param jackpots    number of jackpots
     * @param wonMoney    total amount of money won
     * @param lostMoney   total amount of money lost
     */

    public PlayerStats(@NotNull UUID playerUUID, int gamesPlayed, int victories, int bonuses, int defeats, int draws, int jackpots, double wonMoney, double lostMoney){
        super(gamesPlayed, victories, bonuses, defeats, draws, jackpots, wonMoney, lostMoney);
        this.playerUUID = playerUUID;
    }


    /**
     * Gets the unique identifier of the player.
     *
     * @return the unique identifier of the player
     */

    @NotNull
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    /**
     * Gets statistics for a specific game mode.
     *
     * @param gameName game mode name
     * @return game statistics or {@code null} if not found
     */

    @Nullable
    public CasinoGameModeStats getCasinoGameStats(@NotNull String gameName) {
        return gameStats.get(gameName);
    }

    /**
     * Gets statistics for all game modes.
     *
     * @return map of game statistics
     */

    @NotNull
    public Map<String, CasinoGameModeStats> getCasinoGameStats() {
        return gameStats;
    }

    /**
     * Sets or updates statistics for a specific game mode.
     *
     * @param gameName    game mode name
     * @param gameStats   game mode statistics
     */

    public void setCasinoGameStats(@NotNull String gameName, @NotNull CasinoGameModeStats gameStats) {
        if(gameName == null || gameName.isEmpty() || gameStats == null) return;
        this.gameStats.put(gameName, gameStats);
    }

    /**
     * Sets the statistics map for all games.
     *
     * @param gameStats map of game statistics
     */

    public void setCasinoGameStats(@NotNull Map<String, CasinoGameModeStats> gameStats) {
        if(gameStats == null) return;
        this.gameStats = gameStats;
    }

}
