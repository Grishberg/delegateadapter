package com.grishberg.horizontalfeed.cards

import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.renderer.news.NewsRenderer

/**
 * Creates adapter that allow working TeaserRenderer as instance of NewsRenderer.
 */
internal class NewsToTeasersRendererAdapter {
    fun createAdapter(teaserRenderer: TeaserRenderer): NewsRenderer {
        return TeaserNewsRenderer(teaserRenderer)
    }

    private class TeaserNewsRenderer(
            private val teaserRenderer: TeaserRenderer
    ) : NewsRenderer {

        override fun showTitle(title: String) {
            teaserRenderer.showTitle(title)
        }

        override fun showDescription(description: String) {
            /* not used */
        }
    }
}