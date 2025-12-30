package com.github.Shimado.instances;

import com.github.Shimado.interfaces.CycleRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a single-player game session in a casino environment.
 * This class manages the state of a player's individual casino game session,
 * including bets, game timing, cycle tasks, and session status.
 */

public class SingleplayerGameSession {

    private CasinoBet bet;
    private Object cycle;
    private int time = 0;
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

    @Nullable
    public Object getCycleID(){
        return cycle;
    }

    public void setCycleID(@Nullable Object cycle) {
        this.cycle = cycle;
    }

    /**
     * Cancels and clears the current cycle task if one is active.
     */

    public void cancelCycleID(@NotNull CycleRunnable cancelCycleRunnable) {
        if (cycle != null) {
            cancelCycleRunnable.run(cycle);
            cycle = null;
        }
    }


    /**
     * Gets the current timer value for this session.
     *
     * @return the current timer value
     */

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void addTime() {
        time++;
    }

    public void removeTime() {
        time--;
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
