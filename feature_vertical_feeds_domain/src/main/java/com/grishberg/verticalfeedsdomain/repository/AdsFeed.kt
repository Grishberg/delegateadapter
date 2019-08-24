package com.grishberg.verticalfeedsdomain.repository

import com.grishberg.verticalfeeds.FeedItem

class AdsFeed(private val id: Int, private val title: String) : FeedItem<AdsRenderer> {
    override fun type() = "ads"

    override fun getId(): Int = id

    override fun render(renderer: AdsRenderer) {
        renderer.setTitle(title)
    }
}