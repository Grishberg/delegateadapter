package com.grishberg.feedsui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grishberg.verticalfeeds.AnyFeedItem
import com.grishberg.verticalfeeds.FeedContentOutputAction
import com.grishberg.verticalfeeds.FeedItem
import com.grishberg.verticalfeeds.FeedContent

/**
 * Used for updating data to VerticalFeedView.
 */
class VerticalFeedViewModel(
        private var content: FeedContent
) : ViewModel(), FeedContentOutputAction {

    private val _feeds = MutableLiveData<List<AnyFeedItem>>()
    val feeds: LiveData<List<FeedItem<*>>>
        get() = _feeds

    init {
        content.registerOutputBoundsAction(this)
    }

    override fun onCleared() {
        content.unregisterOutputBounds(this)
    }

    override fun updateFeeds(newFeeds: List<AnyFeedItem>) {
        _feeds.value = newFeeds
    }
}