package com.github.Shimado.interfaces;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.UUID;

public interface GameLog {

    @Nonnull
    LocalDateTime getDateTime();


    @Nonnull
    UUID getPlayerUUID();


    @Nonnull
    String getPlayerName();


    @Nonnull
    String getGameName();


    @Nonnull
    String getBet();


    boolean isVictory();


    boolean isBonus();


    boolean isDefeat();


    @Nonnull
    String getPrize();


    boolean isJackpot();


    @Nonnull
    String getJackpotPrize();

}
