package com.grishberg.horizontalfeed.rv.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.grishberg.delegateadapter.AdapterDelegate
import com.github.grishberg.delegateadapter.RecycableViewHolder

internal abstract class FeedAdapterDelegate<T, VH : RecycableViewHolder> : AdapterDelegate<T, VH> {

    override fun onCreateViewHolder(parent: ViewGroup): RecycableViewHolder {
        val view = createView(parent)
        val vh = createViewHolder(view)
        view.setOnClickListener {
            val position = vh.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onClickedByPosition(position)
            }
        }
        return vh
    }

    abstract fun createView(parent: ViewGroup): View

    abstract fun createViewHolder(view: View): VH

    open fun onClickedByPosition(position: Int) {}
}