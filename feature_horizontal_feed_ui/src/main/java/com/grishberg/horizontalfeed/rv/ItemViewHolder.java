package com.grishberg.horizontalfeed.rv;

import android.view.View;
import android.widget.TextView;

import com.github.grishberg.delegateadapter.RecycableViewHolder;
import com.grishberg.horizontalfeed.R;
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer;

class ItemViewHolder extends RecycableViewHolder implements AlertRenderer {
    private final TextView tv;

    ItemViewHolder(View v) {
        super(v);
        tv = v.findViewById(R.id.title);
    }

    @Override
    public void setTitle(String t) {
        tv.setText(t);
    }
}
