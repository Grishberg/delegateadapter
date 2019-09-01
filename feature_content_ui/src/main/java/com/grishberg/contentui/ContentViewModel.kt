package com.grishberg.contentui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grishberg.content.ContentDetails
import com.grishberg.content.OutputBounds
import com.grishberg.detailedinfo.DetailedInfo

class ContentViewModel(
        private val contentDetails: ContentDetails
) : ViewModel(), OutputBounds {
    private val _details = MutableLiveData<DetailedInfo>()
    val details: LiveData<DetailedInfo> = _details

    init {
        contentDetails.registerOutputBounds(this)
    }

    override fun updateDetailedInfo(detailedInfo: DetailedInfo) {
        _details.value = detailedInfo
    }
}