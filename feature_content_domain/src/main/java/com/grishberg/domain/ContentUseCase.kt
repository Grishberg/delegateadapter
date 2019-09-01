package com.grishberg.domain

import com.grishberg.content.ContentDetails
import com.grishberg.content.OutputBounds
import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.domain.gateway.DetailedInfoGateway
import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.verticalfeeds.AnyFeedItem

class ContentUseCase(
        private val detailedInfoGateway: DetailedInfoGateway
) : ContentDetails, DetailedInfoGateway.ReceivedDetailInfoAction {
    private val outputBounds = mutableListOf<OutputBounds>()

    override fun registerOutputBounds(bounds: OutputBounds) {
        outputBounds.add(bounds)
    }

    override fun unregisterOutputBounds(bounds: OutputBounds) {
        outputBounds.remove(bounds)
    }

    override fun requestCardDetails(card: AnyHorizontalCard) {
        detailedInfoGateway.requestDetailedInfo(card, DetailedInfoAction())
    }

    override fun requestCardDetails(card: AnyFeedItem) {
        detailedInfoGateway.requestDetailedInfo(card, DetailedInfoAction())
    }

    override fun onDetailedInfoReceived(detailedInfo: DetailedInfo) {
        notifyBoundChanged(detailedInfo)
    }

    private fun notifyBoundChanged(detailedInfo: DetailedInfo) {
        for (bound in outputBounds) {
            bound.updateDetailedInfo(detailedInfo)
        }
    }

    private inner class DetailedInfoAction : DetailedInfoGateway.ReceivedDetailInfoAction {
        override fun onDetailedInfoReceived(detailedInfo: DetailedInfo) {
            notifyBoundChanged(detailedInfo)
        }
    }
}