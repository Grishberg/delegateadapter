package com.grishberg.horizontalfeed.details

import android.graphics.Color
import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.detailedinfo.renderer.DetailedInfoRenderer

class GreenItemDetailInfo(
        private val title: String
) : DetailedInfo {
    private val backgroundColor: Int = Color.GREEN

    override fun render(renderer: DetailedInfoRenderer) {
        renderer.drawTitle(title)
        renderer.fillBackgroundWithColor(backgroundColor)
    }
}