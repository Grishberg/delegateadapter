package com.grishberg.content.renderer

/**
 * Used for rendering detailed info.
 */
interface DetailedInfoRenderer {
    fun show()
    fun hide()
    fun drawTitle(title: String)
    fun fillBackgroundWithColor(color: Int)
}