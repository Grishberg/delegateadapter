package com.grishberg.horizontalfeed.rv;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Item decoration for side paddings.
 */
public class CustomItemDecorator extends RecyclerView.ItemDecoration {
    private int sideOffset;
    private int midOffset;

    public CustomItemDecorator(int sideOffset,
                               int midOffset) {
        this.sideOffset = sideOffset;
        this.midOffset = midOffset;
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
