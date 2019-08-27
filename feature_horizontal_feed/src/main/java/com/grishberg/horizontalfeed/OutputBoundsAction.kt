package com.grishberg.horizontalfeed

/**
 * Horizontal items output bounds.
 */
interface OutputBoundsAction {
    /**
     * Is called when HorizontalItemContent updates content items.
     */
    fun updateItems(items: List<AnyHorizontalCard>)

    /**
     * Is called when item selected.
     */
    fun onItemSelected(clickedCard: AnyHorizontalCard)
}