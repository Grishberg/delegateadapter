package com.grishberg.horizontalfeed

/**
 * Abstraction of horizontal items content.
 */
interface HorizontalContent {
    fun registerOutputBoundsUpdateAction(action: OutputBoundsAction)
    fun unregisterOutputBoundsUpdateAction(action: OutputBoundsAction)
    fun requestData()
    fun onCardSelected(clickedCard: AnyHorizontalCard)
}