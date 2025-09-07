package com.github.Shimado.api;

import com.github.Shimado.interfaces.CycleTask;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface SchedulerAdapter {

    CycleTask scheduleSyncDelayedTask(Runnable task, int delay);
    CycleTask scheduleSyncDelayedTask(Location loc, Runnable task, int delay);
    CycleTask scheduleSyncDelayedTask(Player player, Runnable task, int delay);
    CycleTask scheduleSyncRepeatingTask(Runnable task, int delayBeforeStart, int delay);
    CycleTask scheduleSyncRepeatingTask(Location loc, Runnable task, int delayBeforeStart, int delay);
    CycleTask scheduleSyncRepeatingTask(Player player, Runnable task, int delayBeforeStart, int delay);
    void runTaskAsynchronously(Runnable task);

}
