package com.github.Shimado.instances;

import com.github.Shimado.interfaces.CycleTask;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SingleGameSession {

    private CasinoBet bet;
    private CycleTask cycle;
    private boolean opened = true;


    @Nonnull
    public CasinoBet getBet(){
        return bet;
    }

    public void setBet(@Nonnull CasinoBet bet){
        this.bet = bet;
    }


    public boolean isCycleActive(){
        return cycle != null;
    }

    public void setCycleID(@Nullable CycleTask cycle){
        this.cycle = cycle;
    }

    public void cancelCycleID(){
        if(cycle != null){
            cycle.cancelTask();
            cycle = null;
        }
    }


    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }


    public boolean isSessionActive(){
        return cycle != null && !opened;
    }
}
