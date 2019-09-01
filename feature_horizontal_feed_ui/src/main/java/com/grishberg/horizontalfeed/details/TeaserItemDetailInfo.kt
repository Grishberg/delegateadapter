package com.grishberg.horizontalfeed.details

import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.detailedinfo.renderer.DetailedInfoRenderer

class TeaserItemDetailInfo(
        private val title: String,
        private val backgroundColor: Int
) : DetailedInfo {

    override fun render(renderer: DetailedInfoRenderer) {
        renderer.drawTitle(title)
        renderer.fillBackgroundWithColor(backgroundColor)
    }
}