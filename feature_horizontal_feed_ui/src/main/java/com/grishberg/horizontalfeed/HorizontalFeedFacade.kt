package com.grishberg.horizontalfeed

import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.grishberg.delegateadapter.AdapterDelegate
import com.github.grishberg.delegateadapter.ViewTracker
import com.grishberg.core.ComponentScope
import com.grishberg.core.ComponentScopeAction
import com.grishberg.horizontalfeed.rv.*
import java.util.*

class HorizontalFeedFacade(
        private val content: HorizontalContent
) : ComponentScope {
    private val scopeActions = mutableListOf<ComponentScopeAction>()
    private var initiated: Boolean = false
    private lateinit var adapter: ItemsAdapter

    /**
     * Creates new instance of view and attaches to parent.
     */
    fun attachView(rv: RecyclerView, activity: FragmentActivity) {
        val inflater = LayoutInflater.from(activity)

        val delegates = ArrayList<AdapterDelegate<*, *>>()
        delegates.add(RedItemsAdapterDelegate(inflater))
        delegates.add(GreenAdapterDelegate(inflater))
        delegates.add(TeaserAdapterDelegate(inflater))
        adapter = ItemsAdapter(delegates)

        rv.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
        adapter.attachToRecyclerView(rv)

        val lm = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        rv.layoutManager = lm
        val itemDecorator = CustomItemDecorator(
                activity.resources.getDimensionPixelSize(R.dimen.sideOffset),
                activity.resources.getDimensionPixelSize(R.dimen.midOffset))
        rv.addItemDecoration(itemDecorator)

        val tracker = ViewTracker()
        tracker.startTracking(rv)
        val viewModel = ViewModelProviders.of(activity, ViewModelFactory(content)).get(HorizontalFeedViewModel::class.java)
        viewModel.feeds.observe(activity, Observer<List<HorizontalItem<*>>> { feeds ->
            adapter.populate(feeds)
        })

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

    private class ViewModelFactory(
            private var content: HorizontalContent
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HorizontalFeedViewModel(content) as T
        }
    }
}