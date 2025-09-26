package com.github.Shimado;

import com.github.Shimado.api.*;

public class VegasAPI {

    private static SchedulerAdapter schedulerAdapter;
    private static CasinoGameModeRegister casinoGameModeRegister;
    private static DataStorage dataStorage;
    private static EconomyUtil economyUtil;
    private static ChipUtil chipUtil;
    private static VictoryUtil victoryUtil;
    private static CasinoGameModeUtil casinoGameModeUtil;
    private static InvSession invSession;


    public static SchedulerAdapter getSchedulerAdapter(){
        return schedulerAdapter;
    }

    public static SchedulerAdapter setSchedulerAdapter(SchedulerAdapter s){
        schedulerAdapter = s;
        return s;
    }


    public static CasinoGameModeRegister getCasinoGameModeRegister(){
        return casinoGameModeRegister;
    }

    public static CasinoGameModeRegister setCasinoGameModeRegister(CasinoGameModeRegister c){
        casinoGameModeRegister = c;
        return c;
    }


    public static DataStorage getDataStorage(){
        return dataStorage;
    }

    public static DataStorage setDataStorage(DataStorage d){
        dataStorage = d;
        return d;
    }


    public static EconomyUtil getEconomyUtil(){
        return economyUtil;
    }

    public static EconomyUtil setEconomyUtil(EconomyUtil e){
        economyUtil = e;
        return e;
    }


    public static ChipUtil getChipUtil(){
        return chipUtil;
    }

    public static ChipUtil setChipUtil(ChipUtil c){
        chipUtil = c;
        return c;
    }


    public static VictoryUtil getVictoryUtil(){
        return victoryUtil;
    }

    public static VictoryUtil setVictoryUtil(VictoryUtil v){
        victoryUtil = v;
        return v;
    }


    public static CasinoGameModeUtil getCasinoGameModeUtil(){
        return casinoGameModeUtil;
    }

    public static CasinoGameModeUtil setCasinoGameModeUtil(CasinoGameModeUtil c){
        casinoGameModeUtil = c;
        return c;
    }


    public static InvSession getInvSession(){
        return invSession;
    }

    public static InvSession setInvSession(InvSession i){
        invSession = i;
        return i;
    }

}
