package com.grishberg.horizontalfeed.di

import com.grishberg.horizontalfeed.*
import com.grishberg.horizontalfeed.gateway.HorizontalItemsRepository
import com.grishberg.verticalfeeds.FeedContent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HorizontalFeedModule(
        private val verticalFeedContent: FeedContent,
        private val verticalFeedConverter: FeedConverter,
        private val horizontalCardsFactory: HorizontalCardsFactory
) {
    @Provides
    @Singleton
    fun providesInputBounds(): InputBounds = HorizontalItemsRepository(horizontalCardsFactory)

    @Provides
    @Singleton
    fun provideHorizontalContent(bounds: InputBounds): HorizontalContent =
            HorizontalContentImpl(bounds, verticalFeedContent, verticalFeedConverter)
}