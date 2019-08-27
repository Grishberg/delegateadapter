package com.grishberg.contentui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grishberg.content.ContentDetails
import com.grishberg.content.DetailedInfo
import com.grishberg.content.OutputBounds

class ContentViewModel(
        private val contentDetails: ContentDetails
) : ViewModel(), OutputBounds {
    private val _details = MutableLiveData<DetailedInfo>()
    val details: LiveData<DetailedInfo> = _details

    override fun updateDetailedInfo(detailedInfo: DetailedInfo) {
        _details.value = detailedInfo
    }
}