package com.grishberg.feedsui.presentation.rv

import android.view.View
import android.widget.TextView
import com.github.grishberg.delegateadapter.RecycableViewHolder
import com.grishberg.feedsui.R
import com.grishberg.feedsui.presentation.cards.renderer.news.NewsRenderer

internal class NewsViewHolder(view: View) : RecycableViewHolder(view), NewsRenderer {
    private val titleView = view.findViewById<TextView>(R.id.title)
    private val descriptionView = view.findViewById<TextView>(R.id.description)

    override fun showTitle(title: String) {
        titleView.text = title
    }

    override fun showDescription(text: String) {
        descriptionView.text = text
    }
}