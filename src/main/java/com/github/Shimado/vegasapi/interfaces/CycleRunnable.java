package com.github.Shimado.vegasapi.interfaces;

import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface CycleRunnable {

    void run(@Nullable Object cycle);

}
