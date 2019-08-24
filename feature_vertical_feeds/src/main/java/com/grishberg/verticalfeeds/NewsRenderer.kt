package com.grishberg.verticalfeeds

interface NewsRenderer {
    fun showTitle(title: String)
    fun showDescription(description: String)
}