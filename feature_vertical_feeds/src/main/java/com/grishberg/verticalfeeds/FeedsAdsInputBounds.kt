package com.grishberg.verticalfeeds

interface FeedsAdsInputBounds {
    interface AdsReceivedAction {
        fun onAdsReceived()
    }

    fun addAdsReceivedAction(action: AdsReceivedAction)

    fun removeAdsReceivedAction(action: AdsReceivedAction)

    fun requestAds()

    fun getAds(): List<AdsCard>
}