package com.grishberg.feedsui.presentation.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import com.grishberg.feedsui.R

internal class NewsViewHolderFactory(
        private val inflater: LayoutInflater
) {
    fun create(parent: ViewGroup): NewsViewHolder {
        val view = inflater.inflate(R.layout.news_item_layout, parent, false)
        return NewsViewHolder(view)
    }
}