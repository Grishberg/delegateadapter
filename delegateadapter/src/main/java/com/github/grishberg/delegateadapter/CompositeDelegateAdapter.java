package com.github.grishberg.delegateadapter;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adapter with composition of delegate.
 */
public class CompositeDelegateAdapter<T> extends RecyclerView.Adapter<RecycableViewHolder> {
    private final ArrayList<T> items = new ArrayList<>();
    private final Delegates<T> delegates;

    public CompositeDelegateAdapter(List<AdapterDelegate> delegates) {
        this.delegates = new Delegates<>(delegates);
    }

    /**
     * Populate adapter with data.
     * Should be called before notifyDataSetChanged or DiffUtils.
     */
    public void populate(List<T> i) {
        items.clear();
        items.addAll(i);
    }

    /**
     * @return copy of items.
     */
    public List<T> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    T getItem(int position) {
        return items.get(position);
    }

    @NonNull
    @Override
    public RecycableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        return delegates.createVh(parent, type);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(@NonNull RecycableViewHolder vh, int pos) {
        T item = items.get(pos);
        delegates.bindVh(vh, item, pos);
    }

    @Override
    public int getItemViewType(int position) {
        return delegates.getViewType(items, position);
    }

    @Override
    public void onViewRecycled(@NonNull RecycableViewHolder holder) {
        delegates.onViewRecycled(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecycableViewHolder holder) {
        delegates.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecycableViewHolder holder) {
        delegates.onViewDetachedFromWindow(holder);
    }

    public void onResume() {
        delegates.onResume();
    }

    public void onPause() {
        delegates.onPause();
    }

    public void onDestroy() {
        delegates.onDestroy();
    }
}
