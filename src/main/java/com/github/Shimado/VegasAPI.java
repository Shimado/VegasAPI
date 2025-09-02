package com.github.Shimado;

import com.github.Shimado.api.*;

public class VegasAPI {

    private static CasinoGameModeRegister casinoGameModeRegister;
    private static DataStorage dataStorage;
    private static EconomyUtil economyUtil;
    private static ChipUtil chipUtil;
    private static VictoryUtil victoryUtil;
    private static CasinoGameModeUtil casinoGameModeUtil;


    public static void setCasinoGameModeRegister(CasinoGameModeRegister c){
        casinoGameModeRegister = c;
    }

    public static CasinoGameModeRegister getCasinoGameModeRegister(){
        return casinoGameModeRegister;
    }


    public static void setDataStorage(DataStorage d){
        dataStorage = d;
    }

    public static DataStorage getDataStorage(){
        return dataStorage;
    }


    public static void setEconomyUtil(EconomyUtil e){
        economyUtil = e;
    }

    public static EconomyUtil getEconomyUtil(){
        return economyUtil;
    }


    public static void setChipUtil(ChipUtil e){
        chipUtil = e;
    }

    public static ChipUtil getChipUtil(){
        return chipUtil;
    }


    public static void setVictoryUtil(VictoryUtil v){
        victoryUtil = v;
    }

    public static VictoryUtil getVictoryUtil(){
        return victoryUtil;
    }


    public static void setCasinoGameModeUtil(CasinoGameModeUtil c){
        casinoGameModeUtil = c;
    }

    public static CasinoGameModeUtil getCasinoGameModeUtil(){
        return casinoGameModeUtil;
    }

}
