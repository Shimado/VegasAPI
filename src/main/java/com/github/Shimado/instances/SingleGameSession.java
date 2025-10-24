package com.github.Shimado.instances;

import com.github.Shimado.interfaces.CycleTask;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SingleGameSession {

    private CasinoBet bet;
    private CycleTask cycle;
    private int timer = 0;
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


    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void addTime(){
        timer++;
    }

    public void removeTime(){
        timer--;
    }



}
