package com.grishberg.listarch.listarchitecture.domain

import com.grishberg.content.ContentDetails
import com.grishberg.horizontalfeed.AnyHorizontalCard
import com.grishberg.horizontalfeed.HorizontalContent
import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.OutputBoundsAction
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.FeedContent

class ApplicationUseCase(
        private val contentDetails: ContentDetails,
        private val horizontalContent: HorizontalContent,
        private val verticalFeedContent: FeedContent
) {
    private val outputBounds = mutableListOf<OutputBounds>()
    private val horizontalContentOutput = HorizontalContentOutput()
    private val feedState = FeedState()
    private val detailedState = DetailedState()
    private var state: State = feedState

    init {
        horizontalContent.registerOutputBoundsUpdateAction(horizontalContentOutput)
    }

    fun registerOutputBounds(bounds: OutputBounds) {
        outputBounds.add(bounds)
    }

    fun unregisterOutputBounds(bounds: OutputBounds) {
        outputBounds.remove(bounds)
    }

    /**
     * Is called when user press back.
     */
    fun onBackPressed() {
        state.onBackPressed()
    }

    private inner class HorizontalContentOutput : OutputBoundsAction {
        override fun onItemSelected(clickedCard: AnyHorizontalCard) {

            state.onCardSelected()
            contentDetails.requestCardDetails(clickedCard)
        }
    }

    private inner class DetailedState : State {
        override fun onBackPressed() {
            state = feedState
            notifyShowFeeds()
        }

        private fun notifyShowFeeds() {
            for (bounds in outputBounds) {
                bounds.showFeeds()
            }
        }
    }

    private inner class FeedState : State {
        override fun onCardSelected() {
            state = detailedState
            notifyShowDetailedInformationHorizontal()
        }

        private fun notifyShowDetailedInformationHorizontal() {
            for (bounds in outputBounds) {
                bounds.showDetailedInformation()
            }
        }
    }

    private interface State {
        fun onBackPressed() = Unit
        fun onCardSelected() = Unit
    }
}