package com.grishberg.horizontalfeed.rv;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.grishberg.delegateadapter.AdapterDelegate;
import com.github.grishberg.delegateadapter.RecycableViewHolder;
import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.R;

public class GreenAdapterDelegate implements AdapterDelegate<HorizontalItem, ItemViewHolder> {
    private final LayoutInflater inflater;

    public GreenAdapterDelegate(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public boolean isForType(HorizontalItem item) {
        return item.type().equals("green");
    }

    @Override
    public RecycableViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ItemViewHolder(inflater.inflate(R.layout.green_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder vh, HorizontalItem item) {
        item.render(vh);
    }
}
