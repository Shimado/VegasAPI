package com.github.Shimado.interfaces;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Player settings that are needed to simplify the gameplay.
 * So that the player does not have to constantly select music, but turns on the one he chose earlier,
 * so that the bet in the monetary format is saved, etc.
 * **/

public interface PlayerSettings {

    /**
     * Gets the player's UUID.
     *
     * @return UUID of the player
     */

    @Nonnull
    UUID getPlayerUUID();

    /**
     * Gets the player's cash bet for each click.
     * Works only for ChipType.MONEY
     *
     * @return default bet amount
     */

    double getDefaultMoneyBet();

    /**
     * Sets the player's cash bet for each click.
     * Works only for ChipType.MONEY
     *
     * @param defaultMoneyBet bet amount
     * @return this PlayerSettings instance for chaining
     */

     PlayerSettings setDefaultMoneyBet(double defaultMoneyBet);

    /**
     * Gets a number of free spins. If you receive more than 0,
     * simply click on the bet slot and start playing!
     *
     * @return default bet amount
     */

    int getFreeSpins();

    /**
     * Sets a number of free spins.
     *
     * @param freeSpins number of free spins
     * @return this PlayerSettings instance for chaining
     */

    PlayerSettings setFreeSpins(int freeSpins);

    /**
     * Gets the background song settings for the main GUI.
     *
     * @return main GUI background song settings, or {@code null} if not set
     */

    @Nullable
    BackgroundSongSettings getMainGUISong();

    /**
     * Sets the background song for the main GUI.
     *
     * @param musicActive whether the music is active. If so, music will play when the GUI is opened.
     * @param musicID     ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
     * @return this PlayerSettings instance for chaining
     */

    PlayerSettings setMainGUISong(boolean musicActive, @Nonnull String musicID);

    /**
     * Gets background song settings for all game GUIs.
     *
     * @return map of game names to background song settings
     */

    @Nonnull
    Map<String, BackgroundSongSettings> getGamesGUISongs();

    /**
     * Gets the background song settings for a specific game.
     *
     * @param gameName name of the game
     * @return background song settings, or {@code null} if not found
     */

    @Nullable
    BackgroundSongSettings getGameGUISong(@Nonnull String gameName);

    /**
     * Sets the background song for a specific game GUI.
     *
     * @param gameName    name of the game
     * @param musicActive whether the music is active. If so, music will play when the GUI is opened
     * @param musicID     ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
     * @return this PlayerSettings instance for chaining
     */

    PlayerSettings setGameGUISong(@Nonnull String gameName, boolean musicActive, @Nonnull String musicID);

}
