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
 * @param <T> the type of casino game mode, which must implement {@link CasinoGameMode}, {@link CasinoGameModeMethods}
 */

public interface CasinoGameModeRegister<T extends CasinoGameMode & CasinoGameModeMethods> {

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
     * @param mapConfig the data from the config that stores fields and values: "mode-name", "gui-size", "jackpot" and etc
     * @param mapMessages the data from the messages config that stores fields and values: "title", "lore" and etc
     * @param clazz game mode class. For example: Drums.class, Roulette.class and etc
     * @param pluginClazz your plugin class. Vegas.class or VegasAddon.class
     */

    @Nullable
    T getGameModeFromMaps(@Nullable Map<String, Object> mapConfig, @Nullable Map<String, Object> mapMessages, @Nonnull Class<T> clazz, @Nonnull Class pluginClazz);
}
