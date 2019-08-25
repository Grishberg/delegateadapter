package com.grishberg.verticalfeeds

import android.net.Uri
import com.grishberg.verticalfeeds.renderer.ads.AdsRenderer
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

typealias NewsCard = FeedItem<NewsRenderer>
typealias AdsCard = FeedItem<AdsRenderer>

interface CardsFactory {
    fun createNewsCard(id: Int, title: String, description: String): NewsCard

    fun createAdsCard(id: Int, title: String, targetUri: Uri): AdsCard
}