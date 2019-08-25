package com.grishberg.horizontalfeed.cards;

import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer;

import org.jetbrains.annotations.NotNull;

class RedItem implements HorizontalItem<AlertRenderer> {
    private final String title;
    private final int id;

    public RedItem(int id, String title) {
        this.id = id;
        this.title = "red " + title;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void render(AlertRenderer renderer) {
        renderer.setTitle(title);
    }

    @NotNull
    @Override
    public String type() {
        return "red";
    }
}
