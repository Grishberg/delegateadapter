package com.grishberg.horizontalfeed.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.grishberg.delegateadapter.AdapterDelegate;
import com.github.grishberg.delegateadapter.RecycableViewHolder;
import com.grishberg.horizontalfeed.HorizontalFeedViewModel;
import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.R;
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer;

import androidx.recyclerview.widget.RecyclerView;

public class GreenAdapterDelegate implements AdapterDelegate<HorizontalItem<AlertRenderer>, ItemViewHolder> {
    private final LayoutInflater inflater;
    private final HorizontalFeedViewModel viewModel;

    public GreenAdapterDelegate(LayoutInflater inflater, HorizontalFeedViewModel viewModel) {
        this.inflater = inflater;
        this.viewModel = viewModel;
    }

    @Override
    public boolean isForType(HorizontalItem item) {
        return item.type().equals("green");
    }

    @Override
    public RecycableViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = inflater.inflate(R.layout.green_item_layout, parent, false);
        final ItemViewHolder vh = new ItemViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    viewModel.onClickedByCard(position);
                }
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder vh, HorizontalItem<AlertRenderer> item) {
        item.render(vh);
    }
}
