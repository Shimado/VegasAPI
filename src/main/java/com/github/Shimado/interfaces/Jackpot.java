package com.github.Shimado.interfaces;

/**
 * Represents jackpot information for a plugin.
 * One Jackpot instance corresponds to one plugin.
 */

public interface Jackpot {

    /**
     * Returns the number of games played.
     * This value is used to control when the jackpot can be hit
     * (e.g., after a certain number of games).
     *
     * @return number of games played
     */

    int getGamesPlayed();

    /**
     * Sets the number of games played.
     *
     * @param gamesPlayed the new number of games played
     */

    void setGamesPlayed(int gamesPlayed);

    /**
     * Increments the number of games played by one.
     */

    void addGamesPlayed();

    /**
     * Returns the current accumulated jackpot amount.
     *
     * @return current jackpot amount
     */

    double getMoney();

    /**
     * Sets the current jackpot amount.
     *
     * @param money new jackpot amount
     */

    void setMoney(double money);

    /**
     * Adds the specified amount to the jackpot.
     *
     * @param money amount to add
     */

    void addMoney(double money);

}

