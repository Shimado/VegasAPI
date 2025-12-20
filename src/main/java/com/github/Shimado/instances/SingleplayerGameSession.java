package com.github.Shimado.instances;

import javax.annotation.Nullable;

/**
 * Represents a single-player game session in a casino environment.
 * This class manages the state of a player's individual casino game session,
 * including bets, game timing, cycle tasks, and session status.
 */

public class SingleplayerGameSession {

    private CasinoBet bet;
    private Object cycle;
    private int timer = 0;
    private boolean opened = true;
    private boolean ended = false;


    /**
     * Gets the current casino bet of the player placed in this session.
     *
     * @return the casino bet, or null if no bet is currently placed
     */

    @Nullable
    public CasinoBet getBet() {
        return bet;
    }

    public void setBet(@Nullable CasinoBet bet) {
        this.bet = bet;
    }

    /**
     * Checks whether a cycle task is currently active for this session.
     *
     * @return true if a cycle task is active, false otherwise
     */

    public boolean isCycleActive() {
        return cycle != null;
    }

    public void setCycleID(@Nullable Object cycle) {
        this.cycle = cycle;
    }

    /**
     * Cancels and clears the current cycle task if one is active.
     */

    public void cancelCycleID() {
        if (cycle != null) {
            //cycle.cancelTask();
            cycle = null;
        }
    }

    /**
     * Checks if the session is currently open for gameplay.
     * And every player can join to this session.
     *
     * @return true if the session is open, false if closed
     */

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    /**
     * Gets the current timer value for this session.
     *
     * @return the current timer value
     */

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void addTime() {
        timer++;
    }

    public void removeTime() {
        timer--;
    }

    /**
     * Checks if the game has ended.
     *
     * @return true if the game has ended, false if still active
     */

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
}
