package com.grishberg.horizontalfeed

import com.grishberg.delegateadapter.ItemWithId
import com.grishberg.horizontalfeed.renderer.alerts.AlertRenderer
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer

typealias GreenCard = HorizontalItem<AlertRenderer>
typealias RedCard = HorizontalItem<AlertRenderer>
typealias TeaserCard = HorizontalItem<TeaserRenderer>
typealias AnyHorizontalCard = HorizontalItem<*>

interface HorizontalItem<R> : ItemWithId {
    fun render(renderer: R)
    fun type(): String
}