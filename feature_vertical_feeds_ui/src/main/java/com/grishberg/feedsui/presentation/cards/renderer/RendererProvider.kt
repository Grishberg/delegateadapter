package com.grishberg.feedsui.presentation.cards.renderer

import com.grishberg.feedsui.presentation.cards.renderer.ads.AdsRendererProxy
import com.grishberg.feedsui.presentation.cards.renderer.news.NewsRendererProxy

class RendererProvider {
    private val newsRenderer = NewsRendererProxy()
    private val adsRenderer = AdsRendererProxy()

    fun provideNewsRenderer(): NewsRendererProxy = newsRenderer

    fun provideAdsRenderer(): AdsRendererProxy = adsRenderer
}