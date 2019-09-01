package com.grishberg.contentui

import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.grishberg.detailedinfo.DetailedInfo
import com.grishberg.detailedinfo.renderer.DetailedInfoRenderer

class ContentViewHolder(
        ctx: FragmentActivity,
        viewModel: ContentViewModel,
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
        rootView.setBackgroundColor(color)
    }
}