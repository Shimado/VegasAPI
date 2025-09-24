package com.github.Shimado.instances;

import com.github.Shimado.interfaces.CycleTask;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SingleGameSession {

    private CasinoBet bet;
    private CycleTask cycle;


    @Nonnull
    public CasinoBet getBet(){
        return bet;
    }

    public void setBet(@Nonnull CasinoBet bet){
        this.bet = bet;
    }


    public boolean isSessionActive(){
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

}
