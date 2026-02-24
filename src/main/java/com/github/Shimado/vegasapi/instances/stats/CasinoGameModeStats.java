package com.github.Shimado.vegasapi.instances.stats;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents statistics for a specific casino game mode.
 * Also displays statistics for each player in this game mode.
 * Tracks the number of games played, victories, defeats, bonuses, jackpots,
 * and the total money won or lost.
 */

public class CasinoGameModeStats extends VegasStats{

    private String gameName;

    /**
     * Creates a new statistics object for a specific game.
     *
     * @param gameName name of the game mode
     */

    public CasinoGameModeStats(@NotNull String gameName) {
        super();
        this.gameName = gameName;
    }

    /**
     * Creates a new statistics object with full values.
     *
     * @param gameName    name of the game mode
     * @param gamesPlayed number of games played
     * @param victories   number of victories
     * @param bonuses     number of bonuses
     * @param defeats     number of defeats
     * @param draws       number of draws
     * @param jackpots    number of jackpots
     * @param wonMoney    total money won
     * @param lostMoney   total money lost
     */

    public CasinoGameModeStats(@NotNull String gameName, int gamesPlayed, int victories, int bonuses, int defeats, int draws, int jackpots, double wonMoney, double lostMoney) {
        super(gamesPlayed, victories, bonuses, defeats, draws, jackpots, wonMoney, lostMoney);
        this.gameName = gameName;
    }


    /**
     * Gets the name of the game mode.
     *
     * @return the name of the game mode
     */

    @Nullable
    public String getGameName() {
        return gameName;
    }

}
