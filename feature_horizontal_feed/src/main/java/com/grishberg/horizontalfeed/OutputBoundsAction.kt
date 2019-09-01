package com.grishberg.horizontalfeed

/**
 * Horizontal items output bounds.
 */
interface OutputBoundsAction {
    /**
     * Is called when HorizontalItemContent updates content items.
     */
    fun updateItems(items: List<AnyHorizontalCard>) = Unit

    /**
     * Is called when item selected.
     */
    fun onItemSelected(clickedCard: AnyHorizontalCard) = Unit
}