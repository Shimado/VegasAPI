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

    public static void setSchedulerAdapter(SchedulerAdapter s){
        schedulerAdapter = s;
    }


    public static CasinoGameModeRegister getCasinoGameModeRegister(){
        return casinoGameModeRegister;
    }

    public static void setCasinoGameModeRegister(CasinoGameModeRegister c){
        casinoGameModeRegister = c;
    }


    public static DataStorage getDataStorage(){
        return dataStorage;
    }

    public static void setDataStorage(DataStorage d){
        dataStorage = d;
    }


    public static EconomyUtil getEconomyUtil(){
        return economyUtil;
    }

    public static void setEconomyUtil(EconomyUtil e){
        economyUtil = e;
    }


    public static ChipUtil getChipUtil(){
        return chipUtil;
    }

    public static void setChipUtil(ChipUtil e){
        chipUtil = e;
    }


    public static VictoryUtil getVictoryUtil(){
        return victoryUtil;
    }

    public static void setVictoryUtil(VictoryUtil v){
        victoryUtil = v;
    }


    public static CasinoGameModeUtil getCasinoGameModeUtil(){
        return casinoGameModeUtil;
    }

    public static void setCasinoGameModeUtil(CasinoGameModeUtil c){
        casinoGameModeUtil = c;
    }


    public static InvSession getInvSession(){
        return invSession;
    }

    public static void setInvSession(InvSession i){
        invSession = i;
    }

}
