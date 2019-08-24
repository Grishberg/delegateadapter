package com.github.grishberg.delegateadapter;

import android.view.ViewGroup;

public interface AdapterDelegate<T, VH extends RecycableViewHolder> {
    void onBindViewHolder(VH vh, T item);

    RecycableViewHolder onCreateViewHolder(ViewGroup parent);

    boolean isForType(T item);

/*
    default void onViewAttachedToWindow(VH holder) { */
/* stub *//*
 }

    default void onViewDetachedFromWindow(VH holder) { */
/* stub *//*
 }

    default void onResume() { */
/* stub *//*
 }

    default void onPause() { */
/* stub *//*
 }

    default void onDestroy() {*/
/* stub *//*
 }
*/
}
