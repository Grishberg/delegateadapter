package com.grishberg.feedsui.presentation

import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.grishberg.core.ComponentScope
import com.grishberg.core.ComponentScopeAction
import com.grishberg.verticalfeeds.VerticalFeedContent

class VerticalFeedFacade(
        private val content: VerticalFeedContent
) : ComponentScope {
    private val scopeActions = mutableListOf<ComponentScopeAction>()
    private var initiated: Boolean = false
    private var view: VerticalFeedView? = null

    fun attachView(activity: FragmentActivity, parent: ViewGroup, lp: ViewGroup.LayoutParams) {
        val viewModel = ViewModelProviders
                .of(activity, ViewModelFactory(content))
                .get(VerticalFeedViewModel::class.java)
        view = VerticalFeedView(viewModel, activity).apply {
            layoutParams = lp
        }
        parent.addView(view)
        notifyInitiated()
    }

    private fun notifyInitiated() {
        for (action in scopeActions) {
            action.init()
        }
    }

    override fun registerComponentAction(action: ComponentScopeAction) {
        scopeActions.add(action)
        if (initiated) {
            action.init()
        }
    }

    override fun unregisterComponentAction(action: ComponentScopeAction?) {
        scopeActions.remove(action)
    }

    @SuppressWarnings("unchecked")
    private class ViewModelFactory(
            private val content: VerticalFeedContent
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return VerticalFeedViewModel(content) as T
        }
    }
}