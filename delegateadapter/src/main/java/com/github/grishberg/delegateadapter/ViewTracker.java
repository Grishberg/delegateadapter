package com.github.grishberg.delegateadapter;

import android.util.Log;

import java.util.HashMap;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewTracker implements ItemsTracker {
    private static final String TAG = ViewTracker.class.getSimpleName();
    private int prevStartPos = -1;
    private final HashMap<Object, Integer> counts = new HashMap<>();

    public void startTracking(final RecyclerView rv) {
        if (!(rv.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }

        if (!(rv.getAdapter() instanceof CompositeDelegateAdapter)) {
            return;
        }

        final CompositeDelegateAdapter adapter = (CompositeDelegateAdapter) rv.getAdapter();
        final LinearLayoutManager lm = (LinearLayoutManager) rv.getLayoutManager();

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                scroll(adapter, lm);
            }
        });
    }

    private void scroll(CompositeDelegateAdapter adapter, LinearLayoutManager lm) {
        int startPos = lm.findFirstCompletelyVisibleItemPosition();
        int endPos = lm.findLastCompletelyVisibleItemPosition();

        if (startPos == prevStartPos || startPos == -1) {
            return;
        }
        prevStartPos = startPos;
        for (int i = startPos; i <= endPos; i++) {
            if (i >= adapter.getItemCount()) {
                Log.e(TAG, "pos = " + i +" is greater then adapter count " + adapter.getItemCount());
                return;
            }

            Object item = adapter.getItem(i).hashCode();
            Integer c = counts.get(item);
            int count = c != null ? c : 0;
            counts.put(item, count + 1);
        }
    }

    @Override
    public void clear() {
        counts.clear();
    }
}
