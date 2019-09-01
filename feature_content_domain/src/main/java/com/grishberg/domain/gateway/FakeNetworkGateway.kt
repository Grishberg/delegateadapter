package com.grishberg.domain.gateway

import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.horizontalfeed.HorizontalDetailedInfoDelegate
import com.grishberg.verticalfeeds.AnyFeedItem

class FakeNetworkGateway(
        private val cachedInfoGateway: CachedInfoGateway
) : DetailedInfoGateway {

    override fun requestDetailedInfo(card: AnyHorizontalCard, actionWhenReceived: DetailInfoAction) {
        actionWhenReceived.onDetailedInfoReceived(card.provideDetailedInfo())
        HorizontalCardNetworkRequestTask(card, actionWhenReceived).requestDetailedInfo()
    }

    override fun requestDetailedInfo(card: AnyFeedItem, actionWhenReceived: DetailInfoAction) {
        actionWhenReceived.onDetailedInfoReceived(card.provideDetailedInfo())
        FeedNetworkRequestTask(card, actionWhenReceived).requestDetailedInfo()
    }

    private class HorizontalCardNetworkRequestTask(
            private val card: AnyHorizontalCard,
            private val actionWhenReceived: DetailInfoAction
    ) : HorizontalDetailedInfoDelegate {
        override fun requestHorizontalDetailedInfo(id: Int) {
            // TODO: use coroutines to get async data.
            // request data from network by id.
            // receive data and call actionWhenReceived.onDetailedInfoReceived()
        }

        fun requestDetailedInfo() {
            card.requestDetailedInfo(this)
        }
    }

    private class FeedNetworkRequestTask(
            private val card: AnyFeedItem,
            private val actionWhenReceived: DetailInfoAction
    ) : HorizontalDetailedInfoDelegate {
        override fun requestHorizontalDetailedInfo(id: Int) {
            // TODO: use coroutines to get async data.
            // request data from network by id.
            // receive data and call actionWhenReceived.onDetailedInfoReceived()
        }

        fun requestDetailedInfo() {
            //TODO: request data by this delegate.
        }
    }
}