package com.github.Shimado.api;

import com.github.Shimado.instances.CasinoBet;
import com.github.Shimado.instances.CasinoGameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * API for handling game results in the casino system.
 * Provides methods for processing victories, bonuses, and defeats of players
 * in a specific casino game mode.
 * Handles prize payouts, jackpot, statistics, http requests and everything else.
 */

public interface VictoryUtil {

    /**
     * Processes the player's win by multiplying his bet by the multiplier.
     *
     * @param player          the winning player
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the win occurred
     * @param multiplier      the payout multiplier applied to the bet
     * @param tableLocation   the location of the table where the game was played
     * @param tableOwnerUUID  the UUID of the table owner
     */

    void victory(@Nonnull Player player, @Nonnull CasinoBet bet, @Nonnull CasinoGameMode gameMode, double multiplier, @Nullable Location tableLocation, @Nullable UUID tableOwnerUUID);

    /**
     * Handles a player win when a player wins other players' bets.
     *
     * @param player          the winning player
     * @param bet             the main bet placed by the player
     * @param prizeBets       the list of another player bets
     * @param gameMode        the game mode where the win occurred
     * @param tableLocation   the location of the table where the game was played
     * @param tableOwnerUUID  the UUID of the table owner
     */

    void victory(@Nonnull Player player, @Nonnull CasinoBet bet, @Nonnull List<CasinoBet> prizeBets, @Nonnull CasinoGameMode gameMode, @Nullable Location tableLocation, @Nullable UUID tableOwnerUUID);

    /**
     * Processes the receipt of bonus winnings.
     *
     * @param player          the player receiving the bonus
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the bonus occurred
     * @param multiplier      the bonus multiplier applied to the bet
     * @param tableLocation   the location of the table where the game was played
     * @param tableOwnerUUID  the UUID of the table owner
     */

    void bonus(@Nonnull Player player, @Nonnull CasinoBet bet, @Nonnull CasinoGameMode gameMode, double multiplier, @Nullable Location tableLocation, @Nullable UUID tableOwnerUUID);

    /**
     * Handles a player's loss.
     *
     * @param player          the player who lost
     * @param bet             the bet placed by the player
     * @param gameMode        the game mode where the loss occurred
     * @param tableLocation   the location of the table where the game was played
     * @param tableOwnerUUID  the UUID of the table owner
     */

    void defeat(@Nonnull Player player, @Nonnull CasinoBet bet, @Nonnull CasinoGameMode gameMode, @Nullable Location tableLocation, @Nullable UUID tableOwnerUUID);

}
