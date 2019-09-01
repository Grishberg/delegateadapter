package com.grishberg.domain.gateway

import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.verticalfeeds.AnyFeedItem

class CachedInfoGateway : DetailedInfoGateway {
    override fun requestDetailedInfo(card: AnyHorizontalCard, actionWhenReceived: DetailInfoAction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestDetailedInfo(card: AnyFeedItem, actionWhenReceived: DetailInfoAction) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}