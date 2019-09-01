package com.grishberg.horizontalfeed.cards;

import com.grishberg.detailedinfo.DetailedInfo;
import com.grishberg.horizontalfeed.HorizontalDetailedInfoDelegate;
import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.details.GreenItemDetailInfo;
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer;

import org.jetbrains.annotations.NotNull;

class GreenItem implements HorizontalItem<AlertRenderer> {
    private final int id;
    private final String title;

    public GreenItem(int id, String title) {
        this.id = id;
        this.title = "green " + title;
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

    @Override
    public void requestDetailedInfo(HorizontalDetailedInfoDelegate gateway) {
        gateway.requestHorizontalDetailedInfo(id);
    }

    @NotNull
    @Override
    public DetailedInfo provideDetailedInfo() {
        return new GreenItemDetailInfo(title);
    }
}
