package com.github.Shimado.instances;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

    public PlayerStats(UUID playerUUID){
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
     * @param jackpots    number of jackpots
     * @param wonMoney    total amount of money won
     * @param lostMoney   total amount of money lost
     */

    public PlayerStats(UUID playerUUID, int gamesPlayed, int victories, int bonuses, int defeats, int jackpots, double wonMoney, double lostMoney){
        super(gamesPlayed, victories, bonuses, defeats, jackpots, wonMoney, lostMoney);
        this.playerUUID = playerUUID;
    }


    @Nullable
    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }


    /**
     * Gets statistics for a specific game.
     *
     * @param game game name
     * @return game statistics or {@code null} if not found
     */

    @Nullable
    public CasinoGameModeStats getCasinoGameStats(String game) {
        return gameStats.get(game);
    }

    /**
     * Gets statistics for all games.
     *
     * @return map of game statistics, never {@code null}
     */

    @Nonnull
    public Map<String, CasinoGameModeStats> getCasinoGameStats() {
        return gameStats;
    }

    /**
     * Sets or updates statistics for a specific game.
     *
     * @param game          game name
     * @param gameModeStats game statistics
     */

    public void setCasinoGameStats(String game, CasinoGameModeStats gameModeStats) {
        this.gameStats.put(game, gameModeStats);
    }

    /**
     * Sets the statistics map for all games.
     *
     * @param gameStats map of game statistics
     */

    public void setCasinoGameStats(Map<String, CasinoGameModeStats> gameStats) {
        this.gameStats = gameStats;
    }

}
