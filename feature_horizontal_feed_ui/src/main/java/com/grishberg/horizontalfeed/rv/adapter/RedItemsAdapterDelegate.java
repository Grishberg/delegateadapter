package com.grishberg.horizontalfeed.rv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grishberg.horizontalfeed.HorizontalFeedViewModel;
import com.grishberg.horizontalfeed.HorizontalItem;
import com.grishberg.horizontalfeed.R;
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer;

import org.jetbrains.annotations.NotNull;

public class RedItemsAdapterDelegate extends FeedAdapterDelegate<HorizontalItem<AlertRenderer>, ItemViewHolder> {
    private final LayoutInflater inflater;
    private final HorizontalFeedViewModel viewModel;

    public RedItemsAdapterDelegate(LayoutInflater inflater, HorizontalFeedViewModel viewModel) {
        this.inflater = inflater;
        this.viewModel = viewModel;
    }

    @Override
    public boolean isForType(HorizontalItem item) {
        return item.type().equals("red");
    }

    @NotNull
    @Override
    public View createView(@NotNull ViewGroup parent) {
        return inflater.inflate(R.layout.red_item_layout, parent, false);
    }

    @NotNull
    @Override
    public ItemViewHolder createViewHolder(@NotNull View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onClickedByPosition(int position) {
        viewModel.onClickedByCard(position);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, HorizontalItem<AlertRenderer> item) {
        item.render(itemViewHolder);
    }
}
