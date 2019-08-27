package com.grishberg.verticalfeedsdomain.di

import com.grishberg.verticalfeeds.VerticalFeedContent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FeedModule::class])
interface VerticalFeedComponent {
    fun provideFeedContent(): VerticalFeedContent
}
