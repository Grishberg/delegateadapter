package com.grishberg.feedsui.presentation.cards.renderer.news

class NewsRendererProxy : NewsRenderer {
    private val deattached: NewsRenderer = Detached()
    private var renderer: NewsRenderer = deattached

    fun attachViewHolder(attachedRenderer: NewsRenderer) {
        renderer = attachedRenderer
    }

    fun detachViewHolder() {
        renderer = deattached
    }

    override fun showTitle(title: String) {
        renderer.showTitle(title)
    }

    override fun showDescription(description: String) {
        renderer.showDescription(description)
    }


    private class Detached : NewsRenderer {
        override fun showTitle(title: String) = Unit

        override fun showDescription(description: String) = Unit
    }
}