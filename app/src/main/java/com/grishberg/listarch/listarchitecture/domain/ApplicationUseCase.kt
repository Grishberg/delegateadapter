package com.grishberg.listarch.listarchitecture.domain

import com.grishberg.content.ContentDetails
import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.horizontalfeed.HorizontalContent
import com.grishberg.horizontalfeed.OutputBoundsAction
import com.grishberg.verticalfeeds.FeedContent

class ApplicationUseCase(
        private val contentDetails: ContentDetails,
        private val horizontalContent: HorizontalContent,
        private val verticalFeedContent: FeedContent
) {
    private val outputBounds = mutableListOf<OutputBounds>()
    private val horizontalContentOutput = HorizontalContentOutput()

    init {
        horizontalContent.registerOutputBoundsUpdateAction(horizontalContentOutput)
    }

    /**
     * Is called when user want to return from detailed info screen.
     * TODO: maybe should subscribe on this event from {@link ContentDetails} ?
     */
    fun returnToPrevousScreen() {
        // TODO: check current state, if there is details state - show feed screen.
        notifyShowFeeds()
    }

    private fun notifyShowFeeds() {
        for (bounds in outputBounds) {
            bounds.showFeeds()
        }
    }

    private inner class HorizontalContentOutput : OutputBoundsAction {
        override fun updateItems(items: List<AnyHorizontalCard>) {
            // TODO: maybe create separate interface to avoid this stubs?
            /* not used */
        }

        override fun onItemSelected(clickedCard: AnyHorizontalCard) {
            contentDetails.requestCardDetails(clickedCard)
            notifyShowDetailedInformationHorizontal()
        }
    }

    private fun notifyShowDetailedInformationHorizontal() {
        for (bounds in outputBounds) {
            bounds.showDetailedInformation()
        }
    }
}