package com.github.Shimado.api;

import com.github.Shimado.interfaces.CycleTask;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Abstraction for scheduling synchronous and asynchronous tasks
 * for Folia and regular kernels: Paper, Spigot, Purpur.
 * Provides methods for delayed execution, repeating execution,
 * and context-aware scheduling bound to locations or players.
 */

public interface SchedulerAdapter {

    /**
     * Schedules a synchronous task to be executed after a delay.
     *
     * @param task  the task to execute
     * @param delay the delay in ticks before execution
     * @return a handle to the scheduled task
     */

    @Nullable
    CycleTask scheduleSyncDelayedTask(@Nonnull Runnable task, int delay);

    /**
     * Schedules a synchronous task to be executed after a delay,
     * associated with a specific location.
     *
     * @param loc   the location context for the task
     * @param task  the task to execute
     * @param delay the delay in ticks before execution
     * @return a handle to the scheduled task or {@code null} if delay < 1
     */

    @Nullable
    CycleTask scheduleSyncDelayedTask(@Nullable Location loc, @Nonnull Runnable task, int delay);

    /**
     * Schedules a synchronous task to be executed after a delay,
     * associated with a specific player.
     *
     * @param player the player context for the task
     * @param task   the task to execute
     * @param delay  the delay in ticks before execution
     * @return a handle to the scheduled task or {@code null} if delay < 1
     */

    @Nullable
    CycleTask scheduleSyncDelayedTask(@Nullable Player player, @Nonnull Runnable task, int delay);

    /**
     * Schedules a synchronous repeating task.
     *
     * @param task             the task to execute
     * @param delayBeforeStart the delay in ticks before the first execution
     * @param delay            the delay in ticks between repetitions
     * @return a handle to the scheduled task or {@code null} if delayBeforeStart < 0 or delay < 1
     */

    @Nullable
    CycleTask scheduleSyncRepeatingTask(@Nonnull Runnable task, int delayBeforeStart, int delay);

    /**
     * Schedules a synchronous repeating task associated with a specific location.
     *
     * @param loc              the location context for the task
     * @param task             the task to execute
     * @param delayBeforeStart the delay in ticks before the first execution
     * @param delay            the delay in ticks between repetitions
     * @return a handle to the scheduled task or {@code null} if delayBeforeStart < 0 or delay < 1
     */

    @Nullable
    CycleTask scheduleSyncRepeatingTask(@Nullable Location loc, @Nonnull Runnable task, int delayBeforeStart, int delay);

    /**
     * Schedules a synchronous repeating task associated with a specific player.
     *
     * @param player           the player context for the task
     * @param task             the task to execute
     * @param delayBeforeStart the delay in ticks before the first execution
     * @param delay            the delay in ticks between repetitions
     * @return a handle to the scheduled task or {@code null} if delayBeforeStart < 0 or delay < 1
     */

    @Nullable
    CycleTask scheduleSyncRepeatingTask(@Nullable Player player, @Nonnull Runnable task, int delayBeforeStart, int delay);

    /**
     * Runs a task asynchronously in a separate thread.
     *
     * @param task the task to execute asynchronously
     */

    void runTaskAsynchronously(@Nonnull Runnable task);
}

