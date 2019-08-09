package com.github.grishberg.delegateadapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;

public class ViewTracker implements ItemsTracker {
    private int prevStartPos = -1;
    private final SparseIntArray counts = new SparseIntArray();

    public void startTracking(final RecyclerView rv) {
        if (!(rv.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }

        final LinearLayoutManager lm = (LinearLayoutManager) rv.getLayoutManager();

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                scroll(rv, lm);
            }
        });
    }

    private void scroll(RecyclerView rv, LinearLayoutManager lm) {
        int startPos = lm.findFirstCompletelyVisibleItemPosition();
        int endPos = lm.findLastCompletelyVisibleItemPosition();

        if (startPos == prevStartPos || startPos == -1) {
            return;
        }
        prevStartPos = startPos;
        for (int i = startPos; i <= endPos; i++) {
            View child = lm.findViewByPosition(i);
            if (child == null) {
                return;
            }

            Object obj = child.getTag(CompositeDelegateAdapter.TAG_KEY);
            if (!(obj instanceof ItemWithId)) {
                return;
            }

            int id = ((ItemWithId) obj).getId();
            counts.put(id, counts.get(id) + 1);
        }
    }

    @Override
    public void clear() {
        counts.clear();
    }
}
