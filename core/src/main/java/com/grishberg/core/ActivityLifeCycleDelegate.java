package com.grishberg.core;

public interface ActivityLifeCycleDelegate {
    void registerActivityLifeCycleAction(ActivityLifeCycleAction action);

    void unregisterActivityLifeCycleAction(ActivityLifeCycleAction action);
}