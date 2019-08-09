package com.grishberg.listarch.listarchitecture.rv;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.grishberg.delegateadapter.AdapterDelegate;
import com.github.grishberg.delegateadapter.RecycableViewHolder;
import com.grishberg.listarch.listarchitecture.R;

public class RedItemsAdapterDelegate implements AdapterDelegate<Item, RedItem, ItemViewHolder> {
    private final LayoutInflater inflater;

    public RedItemsAdapterDelegate(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public boolean isForType(Item item) {
        return item.isRed();
    }

    @Override
    public RecycableViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ItemViewHolder(
                inflater.inflate(R.layout.red_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder vh, RedItem item) {

        item.doSpecialForRed();
        item.renderToViewHolder(vh);
    }
}
