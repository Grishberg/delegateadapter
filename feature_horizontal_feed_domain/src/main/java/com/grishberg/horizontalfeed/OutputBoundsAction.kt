package com.grishberg.horizontalfeed

/**
 * Horizontal items output bounds.
 */
interface OutputBoundsAction {
    /**
     * Is called when HorizontalItemContent updates content items.
     */
    fun updateItems(items: List<HorizontalItem<*>>)
}