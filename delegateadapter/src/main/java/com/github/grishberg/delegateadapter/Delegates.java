package com.github.grishberg.delegateadapter;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.collection.SparseArrayCompat;

class Delegates<T> {
    private final SparseArrayCompat<AdapterDelegate> delegates = new SparseArrayCompat<>();
    private final ArrayList<RecycableViewHolder> attachedHolders = new ArrayList<>();

    Delegates(List<AdapterDelegate> delegates) {
        int type = 0;
        for (AdapterDelegate d : delegates) {
            this.delegates.append(type++, d);
        }
    }

    @SuppressWarnings("unchecked")
    int getViewType(List<T> items, int pos) {
        for (int i = 0, l = delegates.size(); i < l; i++) {
            if (delegates.get(i).isForType(items.get(pos))) {
                return i;
            }
        }
        throw new IllegalStateException("Delegate not found for item =" +
                items.get(pos) + ", pos = " + pos);
    }

    @SuppressWarnings("unchecked")
    void bindVh(RecycableViewHolder vh, T item, int pos) {
        for (int i = 0, l = delegates.size(); i < l; i++) {
            AdapterDelegate adapterDelegate = delegates.get(i);
            if (adapterDelegate.isForType(item)) {
                adapterDelegate.onBindViewHolder(vh, item);
                return;
            }
        }
        throw new IllegalStateException("Not found delegate for position = " + pos);
    }

    RecycableViewHolder createVh(ViewGroup parent, int viewType) {
        AdapterDelegate d = delegates.get(viewType);
        if (d == null) {
            throw new IllegalStateException("Not found delegate for viewType = " + viewType);
        }
        return d.onCreateViewHolder(parent);
    }

    void onViewRecycled(RecycableViewHolder vh) {
        vh.onRecycled();
    }

    @SuppressWarnings("unchecked")
    void onViewAttachedToWindow(RecycableViewHolder holder) {
        attachedHolders.add(holder);
        holder.onAtachedToWindow();

        AdapterDelegate delegate = delegates.get(holder.getItemViewType());
        if (delegate == null) {
            throw new IllegalStateException("Not found delegate for viewType = "
                    + holder.getItemViewType());
        }
        //delegate.onViewAttachedToWindow(holder);
    }

    @SuppressWarnings("unchecked")
    void onViewDetachedFromWindow(RecycableViewHolder holder) {
        attachedHolders.remove(holder);
        holder.onDetachedFromWindow();

        AdapterDelegate delegate = delegates.get(holder.getItemViewType());
        if (delegate == null) {
            throw new IllegalStateException("Not found delegate for viewType = "
                    + holder.getItemViewType());
        }
        //delegate.onViewDetachedFromWindow(holder);
    }

    void onResume() {
        for (int i = 0, l = delegates.size(); i < l; i++) {
            AdapterDelegate adapterDelegate = delegates.get(i);
            //adapterDelegate.onResume();
        }
        for (RecycableViewHolder holder : attachedHolders) {
            holder.onResume();
        }
    }

    void onPause() {
        for (int i = 0, l = delegates.size(); i < l; i++) {
            AdapterDelegate adapterDelegate = delegates.get(i);
            //adapterDelegate.onPause();
        }
        for (RecycableViewHolder holder : attachedHolders) {
            holder.onPaused();
        }
    }

    void onDestroy() {
        for (int i = 0, l = delegates.size(); i < l; i++) {
            AdapterDelegate adapterDelegate = delegates.get(i);
            //adapterDelegate.onDestroy();
        }
        for (RecycableViewHolder holder : attachedHolders) {
            holder.onDestroy();
        }
    }
}
