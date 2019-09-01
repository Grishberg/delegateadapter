package com.grishberg.horizontalfeed.rv.adapter;

import com.github.grishberg.delegateadapter.AdapterDelegate;
import com.github.grishberg.delegateadapter.CompositeDelegateAdapter;
import com.grishberg.horizontalfeed.HorizontalItem;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter {
    private final CompositeDelegateAdapter<HorizontalItem> adapter;

    public ItemsAdapter(List<AdapterDelegate> delegates) {
        adapter = new CompositeDelegateAdapter<>(delegates);
    }

    public void attachToRecyclerView(RecyclerView rv) {
        rv.setAdapter(adapter);
    }

    public void populate(List<HorizontalItem> items) {
        adapter.populate(items);
        adapter.notifyDataSetChanged();
    }
}
