package com.grishberg.horizontalfeed

/**
 * Abstraction of horizontal items content.
 */
interface HorizontalContent {
    fun registerOutputBoundsUpdateAction(action: OutputBoundsAction)
    fun unregisterOutputBoundsUpdateAction(action: OutputBoundsAction)
    fun requestData()

    object STUB : HorizontalContent {
        override fun registerOutputBoundsUpdateAction(action: OutputBoundsAction) {
            /* stub */
        }

        override fun unregisterOutputBoundsUpdateAction(action: OutputBoundsAction) {
            /* stub */
        }

        override fun requestData() {
            /* stub */
        }
    }
}