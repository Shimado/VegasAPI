package com.github.Shimado.instances;

/**
 * Stores jackpot information. One object per plugin.
 */

public class Jackpot {

    private int gamesPlayed = 0;
    private double money = 0.0;

    /**
     * Creates an empty Jackpot with default values (0 games, 0 money).
     */

    public Jackpot() {
    }

    /**
     * Creates a Jackpot with initial values.
     *
     * @param gamesPlayed number of games were played by players in the modes.
     *                    This value is needed to control the jackpot after reaching a certain number of games.
     *                    In simple words, the jackpot can be hit after 50 games played
     * @param money       accumulated jackpot money. Each game mode adds a certain amount here for a loss.
     *                    When the player hits the jackpot, the amount becomes 0.
     */

    public Jackpot(int gamesPlayed, double money) {
        this.gamesPlayed = gamesPlayed;
        this.money = money;
    }


    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void addGamesPlayed() {
        this.gamesPlayed++;
    }


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double money) {
        this.money += money;
    }
}
