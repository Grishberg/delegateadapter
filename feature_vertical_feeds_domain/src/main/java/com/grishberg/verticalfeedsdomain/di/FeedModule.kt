package com.grishberg.verticalfeedsdomain.di

import com.grishberg.verticalfeedsdomain.FeedContent
import com.grishberg.verticalfeeds.FeedsContentInputBounds
import com.grishberg.verticalfeeds.VerticalFeedContent
import com.grishberg.verticalfeedsdomain.repository.FakeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeedModule {
    @Singleton
    @Provides
    fun provideFeedRepository(): FeedsContentInputBounds = FakeRepository()

    @Singleton
    @Provides
    fun provideFeedContent(feedsRepository: FeedsContentInputBounds): VerticalFeedContent = FeedContent(feedsRepository)
}