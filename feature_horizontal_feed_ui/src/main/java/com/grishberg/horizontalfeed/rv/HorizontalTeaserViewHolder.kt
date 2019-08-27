package com.grishberg.horizontalfeed.rv

import android.view.View
import android.widget.TextView
import com.github.grishberg.delegateadapter.RecycableViewHolder
import com.grishberg.horizontalfeed.R
import com.grishberg.horizontalfeed.renderer.teasers.TeaserRenderer

class HorizontalTeaserViewHolder(v: View) : RecycableViewHolder(v), TeaserRenderer {
    private val tv = v.findViewById<TextView>(R.id.title)

    override fun showTitle(title: String) {
        tv.text = title
    }
}