package com.github.grishberg.delegateadapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * ViewHolder with life-cycle callback
 */
public abstract class RecycableViewHolder extends RecyclerView.ViewHolder {
    public RecycableViewHolder(View v) {
        super(v);
    }

    public void onRecycled() {
        /* to be implemented in subclass */
    }

    public void onAtachedToWindow() {
        /* to be implemented in subclass */
    }

    public void onDetachedFromWindow() {
        /* to be implemented in subclass */
    }

    public void onResume() {
        /* to be implemented in subclass */
    }

    public void onPaused() {
        /* to be implemented in subclass */
    }

    public void onDestroy() {
        /* to be implemented in subclass */
    }
}
