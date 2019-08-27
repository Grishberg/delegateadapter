package com.grishberg.horizontalfeed

interface HorizontalCardsFactory {
    fun createRedItem(id: Int, title: String): RedCard
    fun createGreenItem(id: Int, title: String): GreenCard
}