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

    public PlayerStats(@Nonnull UUID playerUUID){
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

    public PlayerStats(@Nonnull UUID playerUUID, int gamesPlayed, int victories, int bonuses, int defeats, int jackpots, double wonMoney, double lostMoney){
        super(gamesPlayed, victories, bonuses, defeats, jackpots, wonMoney, lostMoney);
        this.playerUUID = playerUUID;
    }


    /**
     * Gets the unique identifier of the player.
     *
     * @return the unique identifier of the player
     */

    @Nonnull
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
    public CasinoGameModeStats getCasinoGameStats(@Nonnull String gameName) {
        return gameStats.get(gameName);
    }

    /**
     * Gets statistics for all game modes.
     *
     * @return map of game statistics, never {@code null}
     */

    @Nonnull
    public Map<String, CasinoGameModeStats> getCasinoGameStats() {
        return gameStats;
    }

    /**
     * Sets or updates statistics for a specific game mode.
     *
     * @param gameName      game mode name
     * @param gameModeStats game mode statistics
     */

    public void setCasinoGameStats(@Nonnull String gameName, @Nonnull CasinoGameModeStats gameModeStats) {
        if(gameName == null || gameName.isEmpty() || gameModeStats == null) return;
        this.gameStats.put(gameName, gameModeStats);
    }

    /**
     * Sets the statistics map for all games.
     *
     * @param gameStats map of game statistics
     */

    public void setCasinoGameStats(@Nonnull Map<String, CasinoGameModeStats> gameStats) {
        if(gameStats == null) return;
        this.gameStats = gameStats;
    }

}
