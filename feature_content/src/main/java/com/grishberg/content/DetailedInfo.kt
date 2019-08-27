package com.grishberg.content

import com.grishberg.content.renderer.DetailedInfoRenderer

/**
 * Interface of content details entity.
 */
interface DetailedInfo {
    fun render(renderer: DetailedInfoRenderer)
}