package com.grishberg.horizontalfeed

/**
 * Horizontal items input bounds.
 */
interface InputBounds {
    fun addInputAction(action: InputBoundsAction)
    fun removeInputAction(action: InputBoundsAction)
    fun getItems(): List<HorizontalItem<*>>
    fun requestItems()
}