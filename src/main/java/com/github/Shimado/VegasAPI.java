package com.github.Shimado;

import com.github.Shimado.api.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class VegasAPI {

    private static SchedulerAdapter schedulerAdapter;
    private static CasinoGameModeRegister casinoGameModeRegister;
    private static DataStorage dataStorage;
    private static EconomyUtil economyUtil;
    private static ChipUtil chipUtil;
    private static VictoryUtil victoryUtil;
    private static CasinoGameModeUtil casinoGameModeUtil;
    private static InvSession invSession;


    @Nullable
    public static SchedulerAdapter getSchedulerAdapter(){
        return schedulerAdapter;
    }

    public static SchedulerAdapter setSchedulerAdapter(@Nullable SchedulerAdapter s){
        schedulerAdapter = s;
        return s;
    }


    @Nullable
    public static CasinoGameModeRegister getCasinoGameModeRegister(){
        return casinoGameModeRegister;
    }

    public static CasinoGameModeRegister setCasinoGameModeRegister(@Nullable CasinoGameModeRegister c){
        casinoGameModeRegister = c;
        return c;
    }


    @Nullable
    public static DataStorage getDataStorage(){
        return dataStorage;
    }

    public static DataStorage setDataStorage(@Nullable DataStorage d){
        dataStorage = d;
        return d;
    }


    @Nullable
    public static EconomyUtil getEconomyUtil(){
        return economyUtil;
    }

    public static EconomyUtil setEconomyUtil(@Nullable EconomyUtil e){
        economyUtil = e;
        return e;
    }


    @Nullable
    public static ChipUtil getChipUtil(){
        return chipUtil;
    }

    public static ChipUtil setChipUtil(@Nullable ChipUtil c){
        chipUtil = c;
        return c;
    }


    @Nullable
    public static VictoryUtil getVictoryUtil(){
        return victoryUtil;
    }

    public static VictoryUtil setVictoryUtil(@Nullable VictoryUtil v){
        victoryUtil = v;
        return v;
    }


    @Nullable
    public static CasinoGameModeUtil getCasinoGameModeUtil(){
        return casinoGameModeUtil;
    }

    public static CasinoGameModeUtil setCasinoGameModeUtil(@Nullable CasinoGameModeUtil c){
        casinoGameModeUtil = c;
        return c;
    }


    @Nullable
    public static InvSession getInvSession(){
        return invSession;
    }

    public static InvSession setInvSession(@Nullable InvSession i){
        invSession = i;
        return i;
    }

}
