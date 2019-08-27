package com.grishberg.horizontalfeed.di

import com.grishberg.horizontalfeed.*
import com.grishberg.horizontalfeed.gateway.HorizontalItemsRepository
import com.grishberg.verticalfeeds.FeedContent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HorisontalFeedModule(
        private val verticalFeedContent: FeedContent,
        private val verticalFeedConverter: FeedConverter,
        private val horizontalCardsFactory: com.grishberg.horizontalfeed.HorizontalCardsFactory
) {
    @Provides
    @Singleton
    fun providesInputBounds(): com.grishberg.horizontalfeed.InputBounds = HorizontalItemsRepository(horizontalCardsFactory)

    @Provides
    @Singleton
    fun provideHorizontalContent(bounds: com.grishberg.horizontalfeed.InputBounds): com.grishberg.horizontalfeed.HorizontalContent =
            HorizontalContentImpl(bounds, verticalFeedContent, verticalFeedConverter)
}