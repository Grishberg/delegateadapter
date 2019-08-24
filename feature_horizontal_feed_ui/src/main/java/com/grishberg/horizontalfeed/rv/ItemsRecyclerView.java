package com.grishberg.horizontalfeed.rv;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

public class ItemsRecyclerView extends RecyclerView {
    private final String T = "RV";
    private int scrollOffset;

    public ItemsRecyclerView(Context c) {
        this(c, null);
    }

    public ItemsRecyclerView(Context c, AttributeSet a) {
        this(c, a, 0);
    }

    public ItemsRecyclerView(Context c, AttributeSet a, int s) {
        super(c, a, s);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        scrollOffset += dy;
    }
}
