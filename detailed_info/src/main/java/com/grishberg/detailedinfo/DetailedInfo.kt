package com.grishberg.detailedinfo

import com.grishberg.detailedinfo.renderer.DetailedInfoRenderer

/**
 * Interface of content details entity.
 */
interface DetailedInfo {
    fun render(renderer: DetailedInfoRenderer)

    object STUB : DetailedInfo {
        override fun render(renderer: DetailedInfoRenderer) {
            /* stub */
        }
    }
}