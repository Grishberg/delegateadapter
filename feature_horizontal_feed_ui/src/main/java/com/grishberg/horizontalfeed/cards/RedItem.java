package com.grishberg.horizontalfeed.cards;

import com.grishberg.detailedinfo.DetailedInfo;
import com.grishberg.horizontalfeed.HorizontalDetailedInfoDelegate;
import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.details.RedItemDetailInfo;
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
    public void render(AlertRenderer renderer) {
        renderer.showTitle(title);
    }

    @Override
    public void requestDetailedInfo(@NotNull HorizontalDetailedInfoDelegate gateway) {
        gateway.requestHorizontalDetailedInfo(id);
    }

    @NotNull
    @Override
    public String type() {
        return "red";
    }

    @NotNull
    @Override
    public DetailedInfo provideDetailedInfo() {
        return new RedItemDetailInfo(title);
    }
}
