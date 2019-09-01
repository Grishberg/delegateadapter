package com.grishberg.feedsui.presentation

import com.grishberg.feedsui.presentation.cards.AdsFeed
import com.grishberg.feedsui.presentation.cards.NewsFeed
import com.grishberg.feedsui.presentation.cards.renderer.RendererProvider
import com.grishberg.verticalfeeds.AdsCard
import com.grishberg.verticalfeeds.CardsFactory
import com.grishberg.verticalfeeds.NewsCard

class RenderedFeedsFactory(
        private val rendererProvider: RendererProvider
) : CardsFactory {
    override fun createNewsCard(id: Int, title: String, description: String): NewsCard =
            NewsFeed(id, title, description, rendererProvider.provideNewsRenderer())


    override fun createAdsCard(id: Int, title: String, targetUri: String): AdsCard =
            AdsFeed(id, title, rendererProvider.provideAdsRenderer())
}