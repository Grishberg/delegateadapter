package com.grishberg.horizontalfeed.repository

import com.grishberg.horizontalfeed.teasers.TeaserRenderer
import com.grishberg.verticalfeeds.NewsRenderer

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