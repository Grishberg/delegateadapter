package com.grishberg.feedsui.presentation.cards

import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.detailedinfo.renderer.DetailedInfoRenderer

/**
 * Abstraction of news item details.
 */
class NewsDetailInfo(
        private val title: String,
        private val backgroundColor: Int
) : DetailedInfo {
    override fun render(renderer: DetailedInfoRenderer) {
        renderer.drawTitle(title)
        renderer.fillBackgroundWithColor(backgroundColor)
    }
}