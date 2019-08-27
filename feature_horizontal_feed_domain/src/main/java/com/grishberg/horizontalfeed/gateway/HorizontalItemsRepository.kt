package com.grishberg.horizontalfeed.gateway

import com.grishberg.horizontalfeed.HorizontalCardsFactory
import com.grishberg.horizontalfeed.HorizontalItem
import com.grishberg.horizontalfeed.InputBounds
import com.grishberg.horizontalfeed.InputBoundsAction
import java.util.*

class HorizontalItemsRepository(
        private val horizontalCardsFactory: com.grishberg.horizontalfeed.HorizontalCardsFactory
) : com.grishberg.horizontalfeed.InputBounds {
    private val actions = mutableListOf<com.grishberg.horizontalfeed.InputBoundsAction>()
    private val items = mutableListOf<com.grishberg.horizontalfeed.HorizontalItem<*>>()

    override fun addInputAction(action: com.grishberg.horizontalfeed.InputBoundsAction) {
        actions.add(action)
        if (items.isNotEmpty()) {
            action.onHorizontalItemUpdated()
        }
    }

    override fun removeInputAction(action: com.grishberg.horizontalfeed.InputBoundsAction) {
        actions.remove(action)
    }

    override fun getItems(): List<com.grishberg.horizontalfeed.HorizontalItem<*>> = items

    override fun requestItems() {
        items.clear()
        items.addAll(createData())
        notifyItemUpdated()
    }

    private fun createData(): List<com.grishberg.horizontalfeed.HorizontalItem<*>> {
        val res = ArrayList<com.grishberg.horizontalfeed.HorizontalItem<*>>()
        for (i in 0..19) {
            if (i % 2 == 0) {
                res.add(horizontalCardsFactory.createRedItem(i, "Menu item $i"))
            } else {
                res.add(horizontalCardsFactory.createGreenItem(i, "Menu item $i"))
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