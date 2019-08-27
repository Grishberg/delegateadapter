package com.grishberg.horizontalfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HorizontalFeedViewModel(
        private var content: HorizontalContent
) : ViewModel(), OutputBoundsAction {
    private val _feeds = MutableLiveData<List<HorizontalItem<*>>>()
    val feeds: LiveData<List<HorizontalItem<*>>>
        get() = _feeds

    init {
        content.registerOutputBoundsUpdateAction(this)
    }

    override fun onCleared() {
        content.unregisterOutputBoundsUpdateAction(this)
    }

    override fun updateItems(items: List<HorizontalItem<*>>) {
        _feeds.value = items
    }
}