package com.grishberg.domain

import com.grishberg.content.ContentDetails
import com.grishberg.content.DetailedInfo
import com.grishberg.content.OutputBounds
import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.verticalfeeds.AnyFeedItem

class ContentUseCase : ContentDetails {
    private val outputBounds = mutableListOf<OutputBounds>()

    override fun registerOutputBounds(bounds: OutputBounds) {
        outputBounds.add(bounds)
    }

    override fun unregisterOutputBounds(bounds: OutputBounds) {
        outputBounds.remove(bounds)
    }

    override fun requestCardDetails(card: AnyHorizontalCard) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestCardDetails(card: AnyFeedItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun notifyBoundChanged(detailedInfo: DetailedInfo) {
        for (bound in outputBounds) {
            bound.updateDetailedInfo(detailedInfo)
        }
    }
}