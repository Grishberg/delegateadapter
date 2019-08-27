package com.grishberg.horizontalfeed.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.grishberg.delegateadapter.AdapterDelegate
import com.github.grishberg.delegateadapter.RecycableViewHolder
import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.R
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer

class TeaserAdapterDelegate(
        private val inflater: LayoutInflater
) : AdapterDelegate<com.grishberg.horizontalfeed.HorizontalItem<TeaserRenderer>, HorizontalTeaserViewHolder> {

    override fun onBindViewHolder(vh: HorizontalTeaserViewHolder,
                                  item: com.grishberg.horizontalfeed.HorizontalItem<TeaserRenderer>) {
        item.render(vh)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecycableViewHolder {
        return HorizontalTeaserViewHolder(inflater.inflate(R.layout.teaser_item_layout, parent, false))
    }

    override fun isForType(item: com.grishberg.horizontalfeed.HorizontalItem<TeaserRenderer>): Boolean =
            item.type() == "teaser"
}