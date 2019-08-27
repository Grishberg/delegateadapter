package com.grishberg.horizontalfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HorizontalFeedViewModel(
        private var content: HorizontalContent
) : ViewModel(), OutputBoundsAction {
    private val _feeds = MutableLiveData<List<AnyHorizontalCard>>()
    val feeds: LiveData<List<AnyHorizontalCard>>
        get() = _feeds

    init {
        content.registerOutputBoundsUpdateAction(this)
    }

    override fun onCleared() {
        content.unregisterOutputBoundsUpdateAction(this)
    }

    override fun updateItems(items: List<AnyHorizontalCard>) {
        _feeds.value = items
    }

    fun onClickedByCard(position: Int) {
        val clickedCard = _feeds.value?.get(position) ?: return
        content.onCardSelected(clickedCard)
    }
}