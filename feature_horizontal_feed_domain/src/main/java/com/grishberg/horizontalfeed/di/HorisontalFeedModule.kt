package com.grishberg.horizontalfeed.di

import com.grishberg.horizontalfeed.FeedConverter
import com.grishberg.horizontalfeed.HorizontalContent
import com.grishberg.horizontalfeed.HorizontalContentImpl
import com.grishberg.horizontalfeed.InputBounds
import com.grishberg.horizontalfeed.repository.FeedConverterImpl
import com.grishberg.horizontalfeed.repository.HorisontalItemsRepository
import com.grishberg.verticalfeeds.VerticalFeedContent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HorisontalFeedModule(
        private val verticalFeedContent: VerticalFeedContent
) {
    @Provides
    @Singleton
    fun providesInputBounds(): InputBounds = HorisontalItemsRepository()

    @Provides
    @Singleton
    fun provideVerticalFeedConverter(): FeedConverter = FeedConverterImpl()

    @Provides
    @Singleton
    fun provideHorisontalContent(bounds: InputBounds, converter: FeedConverter): HorizontalContent =
            HorizontalContentImpl(bounds, verticalFeedContent, converter)
}