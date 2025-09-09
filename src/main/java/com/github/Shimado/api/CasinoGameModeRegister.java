package com.github.Shimado.api;

import com.github.Shimado.instances.CasinoGameMode;
import org.bukkit.event.Listener;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * Registry interface for managing casino game modes.
 * Provides methods for registering, unregistering, and retrieving game modes
 * by name or by their assigned slot in different GUIs.
 *
 * @param <T> the type of casino game mode, which must implement {@link CasinoGameMode}, {@link CasinoGameModeMethods}, and {@link Listener}
 */

public interface CasinoGameModeRegister<T extends CasinoGameMode & CasinoGameModeMethods & Listener> {

    /**
     * Gets a game mode by its registered name.
     *
     * @param gameName the name of the game
     * @return the game mode instance, or {@code null} if not found
     */

    @Nullable
    T getGameByName(@Nullable String gameName);

    /**
     * Gets a game mode by the slot assigned to it in the main GUI.
     *
     * @param slot the slot index in the main GUI
     * @return the game mode instance, or {@code null} if not found
     */

    @Nullable
    T getGameBySlotInMainGUI(int slot);

    /**
     * Gets a game mode by the slot assigned to it in its own game GUI.
     *
     * @param slot the slot index in the one-game GUI
     * @return the game mode instance, or {@code null} if not found
     */

    @Nullable
    T getGameBySlotInOneGameGUI(int slot);

    /**
     * Gets all registered game modes.
     *
     * @return a map of game names to their corresponding game mode instances
     */

    @Nonnull
    Map<String, T> getGames();

    /**
     * Registers a new casino game mode in the registry.
     *
     * @param casinoGameMode the game mode instance to register
     */

    void register(@Nullable T casinoGameMode);

    /**
     * Unregisters a casino game mode by its name.
     *
     * @param gameName the name of the game to remove
     */

    void unregister(@Nullable String gameName);

    /**
     * Optional.
     * Helps to get the base mode from the NON-FLAT map to the game mode.
     *
     * @param mapConfig the data from the config
     * @param mapMessages the data from the messages config
     * @param clazz game mode class
     * @param pluginClazz plugin class. Vegas.class or VegasAddon.class
     */

    @Nullable
    T getGameModeFromMaps(@Nonnull Map<String, Object> mapConfig, @Nonnull Map<String, Object> mapMessages, @Nonnull Class<T> clazz, @Nonnull Class<T> pluginClazz);
}
