package com.grishberg.verticalfeeds


interface CardsFactory {
    fun createNewsCard(id: Int, title: String, description: String): NewsCard

    fun createAdsCard(id: Int, title: String, targetUri: String): AdsCard
}