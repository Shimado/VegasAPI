package com.github.Shimado.instances;

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

public class PlayerSettings {

    private UUID playerUUID;
    private double defaultMoneyBet = 0.0;
    private BackgroundSongSettings mainGUISong;
    private Map<String, BackgroundSongSettings> gamesGUISongs = new HashMap<>();

    /**
     * Creates a new PlayerSettings instance with a player UUID.
     *
     * @param playerUUID unique identifier of the player
     */

    public PlayerSettings(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }


    /**
     * Gets the player's UUID.
     *
     * @return UUID of the player, or {@code null} if not set
     */

    @Nullable
    public UUID getPlayerUUID() {
        return playerUUID;
    }


    /**
     * Gets the player's cash bet for each click.
     * Works only for ChipType.MONEY
     *
     * @return default bet amount
     */

    public double getDefaultMoneyBet() {
        return defaultMoneyBet;
    }

    /**
     * Sets the player's cash bet for each click.
     * Works only for ChipType.MONEY
     *
     * @param defaultMoneyBet bet amount
     * @return this PlayerSettings instance for chaining
     */

    public PlayerSettings setDefaultMoneyBet(double defaultMoneyBet) {
        this.defaultMoneyBet = defaultMoneyBet;
        return this;
    }


    /**
     * Gets the background song settings for the main GUI.
     *
     * @return main GUI background song settings, or {@code null} if not set
     */

    @Nullable
    public BackgroundSongSettings getMainGUISong() {
        return mainGUISong;
    }

    /**
     * Sets the background song for the main GUI.
     *
     * @param musicActive whether the music is active. If so, music will play when the GUI is opened.
     * @param musicID     ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
     * @return this PlayerSettings instance for chaining
     */

    public PlayerSettings setMainGUISong(boolean musicActive, String musicID) {
        mainGUISong = new BackgroundSongSettings(musicActive, musicID);
        return this;
    }


    /**
     * Gets background song settings for all game GUIs.
     *
     * @return map of game names to background song settings
     */

    @Nonnull
    public Map<String, BackgroundSongSettings> getGamesGUISongs() {
        return gamesGUISongs;
    }

    /**
     * Gets the background song settings for a specific game.
     *
     * @param gameName name of the game
     * @return background song settings, or {@code null} if not found
     */

    @Nullable
    public BackgroundSongSettings getGameGUISong(String gameName) {
        return gamesGUISongs.get(gameName);
    }

    /**
     * Sets the background song for a specific game GUI.
     *
     * @param gameName    name of the game
     * @param musicActive whether the music is active. If so, music will play when the GUI is opened
     * @param musicID     ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
     * @return this PlayerSettings instance for chaining
     */

    public PlayerSettings setGameGUISong(String gameName, boolean musicActive, String musicID) {
        gamesGUISongs.put(gameName, new BackgroundSongSettings(musicActive, musicID));
        return this;
    }


    /**
     * Represents background song status (active state and music ID).
     */

    public class BackgroundSongSettings {

        private boolean musicActive = false;
        private String musicID = "";

        /**
         * Creates a new BackgroundSongSettings instance.
         *
         * @param musicActive whether the music is active. If so, music will play when the GUI is opened.
         * @param musicID     identifier of the music
         */

        public BackgroundSongSettings(boolean musicActive, String musicID) {
            this.musicActive = musicActive;
            this.musicID = musicID;
        }


        /**
         * Checks if music is active. If so, music will play when the GUI is opened.
         *
         * @return {@code true} if music is active, {@code false} otherwise
         */
        public boolean isMusicActive() {
            return musicActive;
        }

        /**
         * Sets whether the music is active. If so, music will play when the GUI is opened.
         *
         * @param musicActive true if active, false otherwise
         */
        public void setMusicActive(boolean musicActive) {
            this.musicActive = musicActive;
        }


        /**
         * Gets the music identifier.
         * ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
         *
         * @return music ID, never {@code null}
         */

        @Nonnull
        public String getMusicID() {
            return musicID;
        }

        /**
         * Sets the music identifier.
         * ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
         *
         * @param musicID music ID
         */

        public void setMusicID(String musicID) {
            this.musicID = musicID;
        }


        @Override
        public String toString() {
            return musicID + "/" + (musicActive ? 1 : 0);
        }
    }
}
