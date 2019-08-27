package com.grishberg.contentui

import com.grishberg.content.DetailedInfo
import com.grishberg.content.renderer.DetailedInfoRenderer

class VerticalDetailedInfo(
        private val title: String
) : DetailedInfo {
    override fun render(renderer: DetailedInfoRenderer) {
        renderer.drawTitle(title)
    }
}