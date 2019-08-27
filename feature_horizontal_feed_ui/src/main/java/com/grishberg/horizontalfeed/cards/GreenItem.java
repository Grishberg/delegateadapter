package com.grishberg.horizontalfeed.cards;

import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer;

import org.jetbrains.annotations.NotNull;

class GreenItem implements HorizontalItem<AlertRenderer> {
    private final int id;
    private final String title;

    public GreenItem(int id, String title) {
        this.id = id;
        this.title = "green " + title;
    }

    @Override
    public int getId() {
        return id;
    }

    @NotNull
    @Override
    public String type() {
        return "green";
    }

    @Override
    public void render(AlertRenderer vh) {
        vh.showTitle(title);
    }
}
