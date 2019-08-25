package com.grishberg.verticalfeedsdomain.di

import com.grishberg.verticalfeeds.CardsFactory
import com.grishberg.verticalfeeds.FeedsContentInputBounds
import com.grishberg.verticalfeeds.VerticalFeedContent
import com.grishberg.verticalfeedsdomain.FeedContent
import com.grishberg.verticalfeedsdomain.gateway.FakeNewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeedModule(
        private val cardsFactory: CardsFactory
) {
    @Singleton
    @Provides
    fun provideFeedRepository(): FeedsContentInputBounds =
            FakeNewsRepository(cardsFactory)

    @Singleton
    @Provides
    fun provideFeedContent(feedsRepository: FeedsContentInputBounds): VerticalFeedContent =
            FeedContent(feedsRepository)
}