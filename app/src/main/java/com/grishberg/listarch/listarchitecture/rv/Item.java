package com.grishberg.listarch.listarchitecture.rv;

import android.support.v7.widget.*;

public interface Item<VH extends RecyclerView.ViewHolder> {
    boolean isRed();

    void renderToViewHolder(VH vh);
}