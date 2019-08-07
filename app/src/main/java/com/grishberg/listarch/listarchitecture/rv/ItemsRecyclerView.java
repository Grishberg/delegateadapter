package com.grishberg.listarch.listarchitecture.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.github.grishberg.consoleview.Logger;
import com.github.grishberg.consoleview.LoggerImpl;

public class ItemsRecyclerView extends RecyclerView {
    private final String T = "RV";
    private final Logger log = new LoggerImpl();
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
