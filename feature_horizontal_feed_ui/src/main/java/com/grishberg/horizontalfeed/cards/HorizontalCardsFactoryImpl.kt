package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.GreenCard
import com.grishberg.horizontalfeed.HorizontalCardsFactory
import com.grishberg.horizontalfeed.RedCard

/**
 * Creates instances of {@link HorizontalItem}
 */
class HorizontalCardsFactoryImpl : HorizontalCardsFactory {
    override fun createRedItem(id: Int, title: String): RedCard = RedItem(id, title)

    override fun createGreenItem(id: Int, title: String): GreenCard = GreenItem(id, title)
}