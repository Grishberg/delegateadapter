package com.grishberg.contentui

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.grishberg.content.DetailedInfo
import com.grishberg.content.renderer.DetailedInfoRenderer

class ContentViewHolder(
        private val ctx: FragmentActivity,
        private val viewModel: ContentViewModel,
        private val rootView: View
) : DetailedInfoRenderer {
    private val titleView: TextView = rootView.findViewById(R.id.contentTitleView)

    init {
        viewModel.details.observe(ctx, Observer<DetailedInfo> { details ->
            details.render(this)
        })
    }

    override fun show() {
        rootView.visibility = View.VISIBLE
    }

    override fun hide() {
        rootView.visibility = View.GONE
    }

    override fun drawTitle(title: String) {
        titleView.text = title
    }

    override fun fillBackgroundWithColor(color: Int) {
        rootView.setBackgroundColor(Color.toArgb(color.toLong()))
    }
}