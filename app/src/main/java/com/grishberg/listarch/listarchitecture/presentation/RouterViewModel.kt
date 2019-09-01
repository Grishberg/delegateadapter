package com.grishberg.listarch.listarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grishberg.listarch.listarchitecture.domain.ApplicationUseCase
import com.grishberg.listarch.listarchitecture.domain.OutputBounds

/**
 * View model for switching between screen states.
 */
class RouterViewModel(
        private val applicationLogic: ApplicationUseCase
) : ViewModel(), OutputBounds {
    private val _showCardContentScreen = MutableLiveData<Boolean>()
    val showCardContentScreen: LiveData<Boolean> = _showCardContentScreen

    init {
        applicationLogic.registerOutputBounds(this)
    }
    override fun showDetailedInformation() {
        _showCardContentScreen.value = true
    }

    override fun showFeeds() {
        _showCardContentScreen.value = false
    }

    override fun onCleared() {
        applicationLogic.unregisterOutputBounds(this)
    }

    fun onBackPressed() {
        applicationLogic.onBackPressed()
    }
}