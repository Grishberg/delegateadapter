package com.grishberg.horizontalfeed.rv;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VisibilityTracker {
    public void trackVisibility(RecyclerView rv) {
        if (!(rv.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        final LinearLayoutManager lm = (LinearLayoutManager) rv.getLayoutManager();
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastStartPos = 0;
            int lastEndPos = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int firstPos = lm.findFirstCompletelyVisibleItemPosition();
                int endPos = lm.findLastCompletelyVisibleItemPosition();

                int i1 = 0;
                int i2 = 0;
                if (endPos > lastEndPos) {
                    i1 = lastEndPos;
                    i2 = endPos;
                } else {
                    i1 = firstPos;
                    i2 = lastStartPos;
                }
                lastEndPos = endPos;
                lastStartPos = firstPos;
                //TODO: implement item view count.
            }
        });
    }
}
