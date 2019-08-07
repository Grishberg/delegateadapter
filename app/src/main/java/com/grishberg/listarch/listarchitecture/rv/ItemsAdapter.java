package com.grishberg.listarch.listarchitecture.rv;

import android.view.*;
import android.support.v7.widget.*;

import com.github.grishberg.delegateadapter.AdapterDelegate;
import com.github.grishberg.delegateadapter.CompositeDelegateAdapter;

import java.util.*;

public class ItemsAdapter {
    private final CompositeDelegateAdapter<Item> adapter;

    public ItemsAdapter(LayoutInflater inflater) {
        ArrayList<AdapterDelegate> delegates = new ArrayList<>();
        delegates.add(new RedItemsAdapterDelegate(inflater));
        delegates.add(new GreenAdapterDelegate(inflater));
        adapter = new CompositeDelegateAdapter<>(delegates);
    }

    public void attachToRecyclerView(RecyclerView rv) {
        rv.setAdapter(adapter);
    }

    public void populate(List<Item> items) {
        adapter.populate(items);
    }
}
