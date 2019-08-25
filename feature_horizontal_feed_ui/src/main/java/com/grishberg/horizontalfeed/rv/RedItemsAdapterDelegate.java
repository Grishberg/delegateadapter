package com.grishberg.horizontalfeed.rv;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.grishberg.delegateadapter.AdapterDelegate;
import com.github.grishberg.delegateadapter.RecycableViewHolder;
import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.R;
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer;

public class RedItemsAdapterDelegate implements AdapterDelegate<HorizontalItem<AlertRenderer>, ItemViewHolder> {
    private final LayoutInflater inflater;

    public RedItemsAdapterDelegate(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public boolean isForType(HorizontalItem item) {
        return item.type().equals("red");
    }

    @Override
    public RecycableViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ItemViewHolder(
                inflater.inflate(R.layout.red_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, HorizontalItem<AlertRenderer> item) {
        item.render(itemViewHolder);
    }
}
