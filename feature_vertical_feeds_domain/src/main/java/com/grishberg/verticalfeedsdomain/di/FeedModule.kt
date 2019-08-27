package com.grishberg.verticalfeedsdomain.di

import com.grishberg.verticalfeeds.CardsFactory
import com.grishberg.verticalfeeds.FeedsContentInputBounds
import com.grishberg.verticalfeeds.FeedContent
import com.grishberg.verticalfeedsdomain.FeedContentUseCase
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
    fun provideFeedContent(feedsRepository: FeedsContentInputBounds): FeedContent =
            FeedContentUseCase(feedsRepository)
}