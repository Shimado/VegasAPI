package com.github.Shimado.interfaces;

/**
 * Represents a scheduled task that can be cancelled.
 * Typically returned by a scheduler when creating
 * delayed or repeating tasks.
 */

public interface CycleTask {

    /**
     * Cancels the task if it is still scheduled or running.
     * Once cancelled, the task will no longer execute.
     */

    void cancelTask();

}

