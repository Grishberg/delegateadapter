package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.GreenCard
import com.grishberg.horizontalfeed.HorizontalCardsFactory
import com.grishberg.horizontalfeed.RedCard

/**
 * Creates instances of {@link HorizontalItem}
 */
class HorizontalCardsFactoryImpl : com.grishberg.horizontalfeed.HorizontalCardsFactory {
    override fun createRedItem(id: Int, title: String): com.grishberg.horizontalfeed.RedCard = RedItem(id, title)

    override fun createGreenItem(id: Int, title: String): com.grishberg.horizontalfeed.GreenCard = GreenItem(id, title)
}