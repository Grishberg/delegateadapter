package com.grishberg.horizontalfeed.di

import com.grishberg.horizontalfeed.HorizontalContent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HorisontalFeedModule::class])
interface HorizontalFeedComponent {
    fun provideHorizontalFeedContent(): com.grishberg.horizontalfeed.HorizontalContent
}