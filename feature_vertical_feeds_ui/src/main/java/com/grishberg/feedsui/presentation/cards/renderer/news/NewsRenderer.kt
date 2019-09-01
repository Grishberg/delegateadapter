package com.grishberg.feedsui.presentation.cards.renderer.news

/**
 * Renders news item.
 */
interface NewsRenderer {
    fun showTitle(title: String)
    fun showDescription(description: String)
}