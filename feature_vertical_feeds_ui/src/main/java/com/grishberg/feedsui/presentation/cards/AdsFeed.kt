package com.grishberg.feedsui.presentation.cards

import com.grishberg.verticalfeeds.AdsCard
import com.grishberg.verticalfeeds.CardType
import com.grishberg.verticalfeeds.renderer.ads.AdsRenderer

class AdsFeed(private val id: Int, private val title: String) : AdsCard {
    override val type: CardType = CardType.ADS

    override fun getId(): Int = id

    override fun render(renderer: AdsRenderer) {
        renderer.setTitle(title)
    }
}