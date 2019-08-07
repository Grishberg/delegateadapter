package com.grishberg.listarch.listarchitecture.rv;

import android.support.v7.widget.*;
import android.graphics.*;
import android.support.v7.widget.RecyclerView.*;
import android.view.*;
import android.support.annotation.*;
import android.content.*;

import com.grishberg.listarch.listarchitecture.R;

public class CustomItemDecorator extends RecyclerView.ItemDecoration {
    private final LayoutManager lm;
    private int sideOffset;
    private int midOffset;

    public CustomItemDecorator(LayoutManager lm, Context c) {
        this.lm = lm;
        sideOffset = c.getResources().getDimensionPixelSize(R.dimen.sideOffset);
        midOffset = c.getResources().getDimensionPixelSize(R.dimen.midOffset);
    }

    @Override
    public void getItemOffsets(
            Rect outRect,
            View view,
            RecyclerView parent,
            RecyclerView.State state) {
        int count = parent.getAdapter().getItemCount();
        int pos = parent.getChildViewHolder(view).getAdapterPosition();
        if (pos == 0) {
            outRect.set(sideOffset, 0, midOffset, 0);
        } else if (pos == count - 1) {
            outRect.set(midOffset, 0, sideOffset, 0);
        } else {
            outRect.set(midOffset, 0, midOffset, 0);
        }
    }
}
