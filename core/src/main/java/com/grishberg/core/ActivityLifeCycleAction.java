package com.grishberg.core;

public interface ActivityLifeCycleAction {
    void onResume();

    void onPause();

    void onDestroy();
}