package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

internal class TeaserItem(
        private val verticalItem: FeedItem<NewsRenderer>,
        private val newsToTeasersAdapter: NewsToTeasersRendererAdapter
) : com.grishberg.horizontalfeed.HorizontalItem<TeaserRenderer> {

    override fun render(renderer: TeaserRenderer) {
        verticalItem.render(newsToTeasersAdapter.createAdapter(renderer))
    }

    override fun type(): String = "teaser"

    override fun getId(): Int = verticalItem.id
}