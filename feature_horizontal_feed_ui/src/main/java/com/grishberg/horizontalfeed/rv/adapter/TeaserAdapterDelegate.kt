package com.grishberg.horizontalfeed.rv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grishberg.horizontalfeed.HorizontalFeedViewModel
import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.R
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer
import com.grishberg.horizontalfeed.rv.HorizontalTeaserViewHolder

internal class TeaserAdapterDelegate(
        private val inflater: LayoutInflater,
        private val viewModel: HorizontalFeedViewModel
) : FeedAdapterDelegate<HorizontalItem<TeaserRenderer>, HorizontalTeaserViewHolder>() {

    override fun onBindViewHolder(vh: HorizontalTeaserViewHolder,
                                  item: HorizontalItem<TeaserRenderer>) {
        item.render(vh)
    }

    override fun createView(parent: ViewGroup): View =
            inflater.inflate(R.layout.teaser_item_layout, parent, false)

    override fun createViewHolder(view: View): HorizontalTeaserViewHolder =
            HorizontalTeaserViewHolder(view)

    override fun onClickedByPosition(position: Int) {
        viewModel.onClickedByCard(position)
    }

    override fun isForType(item: HorizontalItem<TeaserRenderer>): Boolean =
            item.type() == "teaser"
}