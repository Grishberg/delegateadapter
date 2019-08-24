package com.grishberg.horizontalfeed

import com.grishberg.delegateadapter.ItemWithId

interface HorizontalItem<R> : ItemWithId {
    fun render(renderer: R)
    fun type(): String
}