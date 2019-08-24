package com.grishberg.horizontalfeed.repository

import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.NewsRenderer

internal class TeaserItem(
        private val verticalItem: FeedItem<NewsRenderer>,
        private val newsToTeasersAdapter: NewsToTeasersRendererAdapter
) : HorizontalItem<TeaserRenderer> {

    override fun render(renderer: TeaserRenderer) {
        verticalItem.render(newsToTeasersAdapter.getAdapter(renderer))
    }

    override fun type(): String = "teaser"

    override fun getId(): Int = verticalItem.id
}