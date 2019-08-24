package com.grishberg.horizontalfeed.repository

import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.InputBounds
import com.grishberg.horizontalfeed.InputBoundsAction
import java.util.*

class HorisontalItemsRepository : InputBounds {
    private val actions = mutableListOf<InputBoundsAction>()
    private val items = mutableListOf<HorizontalItem<*>>()

    override fun addInputAction(action: InputBoundsAction) {
        actions.add(action)
        if (items.isNotEmpty()) {
            action.onHorizontalItemUpdated()
        }
    }

    override fun removeInputAction(action: InputBoundsAction) {
        actions.remove(action)
    }

    override fun getItems(): List<HorizontalItem<*>> = items

    override fun requestItems() {
        items.clear()
        items.addAll(createData())
        notifyItemUpdated()
    }

    private fun createData(): List<HorizontalItem<*>> {
        val res = ArrayList<HorizontalItem<*>>()
        for (i in 0..19) {
            if (i % 2 == 0) {
                res.add(RedItem(i, "Menu item $i"))
            } else {
                res.add(GreenItem(i, "Menu item $i"))
            }
        }
        return res
    }

    private fun notifyItemUpdated() {
        for (action in actions) {
            action.onHorizontalItemUpdated()
        }
    }
}