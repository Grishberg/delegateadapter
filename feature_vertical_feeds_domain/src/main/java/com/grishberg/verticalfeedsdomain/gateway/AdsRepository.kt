package com.grishberg.verticalfeedsdomain.gateway

import com.grishberg.verticalfeeds.AdsCard
import com.grishberg.verticalfeeds.CardsFactory
import com.grishberg.verticalfeeds.FeedsAdsInputBounds

/**
 * Creates ads feed item.
 */
internal class AdsRepository(
        private val cardsFactory: CardsFactory
) : FeedsAdsInputBounds {
    override fun addAdsReceivedAction(action: FeedsAdsInputBounds.AdsReceivedAction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAdsReceivedAction(action: FeedsAdsInputBounds.AdsReceivedAction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestAds() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAds(): List<AdsCard> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}