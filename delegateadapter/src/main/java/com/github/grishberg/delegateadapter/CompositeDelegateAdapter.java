package com.github.grishberg.delegateadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CompositeDelegateAdapter<T> extends RecyclerView.Adapter<RecycableViewHolder> {
    private final ArrayList<T> items = new ArrayList<>();
    private final Delegates<T> delegates;

    public CompositeDelegateAdapter(List<AdapterDelegate> d) {
        delegates = new Delegates<>(d);
    }

    public void populate(List<T> i) {
        items.clear();
        items.addAll(i);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public RecycableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        return delegates.createVh(parent, type);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(RecycableViewHolder vh, int pos) {
        delegates.bindVh(vh, items, pos);
    }

    @Override
    public int getItemViewType(int position) {
        return delegates.getViewType(items, position);
    }

    @Override
    public void onViewRecycled(@NonNull RecycableViewHolder holder) {
        delegates.onViewRecycled(holder);
    }
}
