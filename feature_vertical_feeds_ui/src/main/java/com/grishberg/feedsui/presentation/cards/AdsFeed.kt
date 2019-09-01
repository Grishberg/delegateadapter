package com.grishberg.feedsui.presentation.cards

import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.verticalfeeds.AdsCard
import com.grishberg.verticalfeeds.CardType
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.renderer.ads.AdsRenderer

class AdsFeed(private val id: Int, private val title: String) : AdsCard {
    override val type: CardType = CardType.ADS

    override fun render(renderer: AdsRenderer) {
        renderer.setTitle(title)
    }

    override fun isIdEquals(id: Int): Boolean = this.id == id
    override fun isIdEquals(another: FeedItem<*>): Boolean = another.isIdEquals(id)
    override fun provideDetailedInfo(): DetailedInfo = DetailedInfo.STUB
}
