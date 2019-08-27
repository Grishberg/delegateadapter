package com.grishberg.feedsui.presentation

import android.net.Uri
import com.grishberg.feedsui.presentation.cards.AdsFeed
import com.grishberg.feedsui.presentation.cards.NewsFeed
import com.grishberg.verticalfeeds.AdsCard
import com.grishberg.verticalfeeds.CardsFactory
import com.grishberg.verticalfeeds.NewsCard

class RenderedFeedsFactory : CardsFactory {
    override fun createNewsCard(id: Int, title: String, description: String): NewsCard =
        NewsFeed(id, title, description)


    override fun createAdsCard(id: Int, title: String, targetUri: Uri): AdsCard =
        AdsFeed(id, title)
}