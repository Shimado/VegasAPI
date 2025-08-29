package com.github.Shimado.instances;

import javax.annotation.Nullable;

/**
 * Represents statistics for a specific casino game mode.
 * Also displays statistics for each player in this game mode.
 * Tracks the number of games played, victories, defeats, bonuses, jackpots,
 * and the total money won or lost.
 */

public class CasinoGameModeStats extends VegasStats{

    private String game;

    /**
     * Creates a new statistics object for a specific game.
     *
     * @param game name of the game
     */

    public CasinoGameModeStats(String game) {
        super();
        this.game = game;
    }

    /**
     * Creates a new statistics object with full values.
     *
     * @param game        name of the game
     * @param gamesPlayed number of games played
     * @param victories   number of victories
     * @param bonuses     number of bonuses
     * @param defeats     number of defeats
     * @param jackpots    number of jackpots
     * @param wonMoney    total money won
     * @param lostMoney   total money lost
     */
    public CasinoGameModeStats(String game, int gamesPlayed, int victories, int bonuses, int defeats, int jackpots, double wonMoney, double lostMoney) {
        super(gamesPlayed, victories, bonuses, defeats, jackpots, wonMoney, lostMoney);
        this.game = game;
    }


    @Nullable
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

}
