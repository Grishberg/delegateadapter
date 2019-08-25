package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

internal class NewsToTeasersRendererAdapter {
    fun getAdapter(teaserRenderer: TeaserRenderer): NewsRenderer {
        return TeaserNewsRenderer(teaserRenderer)
    }

    private class TeaserNewsRenderer(
            private val teaserRenderer: TeaserRenderer
    ) : NewsRenderer {
        override fun showTitle(title: String) {
            teaserRenderer.setTitle(title)
        }

        override fun showDescription(description: String) {
            /* not used */
        }
    }
}