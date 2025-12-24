package com.github.Shimado.interfaces;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public interface GameLog {

    @NotNull
    LocalDateTime getDateTime();


    @NotNull
    UUID getPlayerUUID();


    @NotNull
    String getPlayerName();


    @NotNull
    String getGameName();


    @NotNull
    String getBet();


    boolean isVictory();


    boolean isBonus();


    boolean isDefeat();


    boolean isDraw();


    @NotNull
    String getPrize();


    boolean isJackpot();


    @NotNull
    String getJackpotPrize();

}
