package com.grishberg.listarch.listarchitecture.presentation

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer

class Router(
        private val activity: FragmentActivity,
        private val viewModel: RouterViewModel,
        private val descriptionView: View,
        private val feedView: View
) {
    init {
        viewModel.showCardContentScreen.observe(activity, Observer<Boolean> { shouldShow ->
            changeCardContentVisibility(shouldShow)
        })
    }

    private fun changeCardContentVisibility(shouldShowContent: Boolean) {
        val descriptionVisibility: Int = if (shouldShowContent) View.VISIBLE else View.GONE
        val feedVisibility: Int = if (shouldShowContent) View.GONE else View.VISIBLE
        descriptionView.visibility = descriptionVisibility
        feedView.visibility = feedVisibility
    }

    fun onBackPressed() {
        viewModel.onBackPressed()
    }
}