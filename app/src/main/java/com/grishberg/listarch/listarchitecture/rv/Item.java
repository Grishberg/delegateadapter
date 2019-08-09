package com.grishberg.listarch.listarchitecture.rv;

import android.support.v7.widget.*;

import com.github.grishberg.delegateadapter.ItemWithId;

public interface Item<VH extends RecyclerView.ViewHolder> extends ItemWithId {
    boolean isRed();

    void renderToViewHolder(VH vh);
}
