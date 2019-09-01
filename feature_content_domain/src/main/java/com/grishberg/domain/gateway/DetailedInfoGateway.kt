package com.grishberg.domain.gateway

import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.verticalfeeds.AnyFeedItem

internal typealias DetailInfoAction = DetailedInfoGateway.ReceivedDetailInfoAction

interface DetailedInfoGateway {
    fun requestDetailedInfo(card: AnyHorizontalCard, actionWhenReceived: DetailInfoAction)
    fun requestDetailedInfo(card: AnyFeedItem, actionWhenReceived: DetailInfoAction)

    interface ReceivedDetailInfoAction {
        fun onDetailedInfoReceived(detailedInfo: DetailedInfo)
    }
}