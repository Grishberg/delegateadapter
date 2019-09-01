package com.grishberg.domain.di

import com.grishberg.content.ContentDetails
import com.grishberg.domain.ContentUseCase
import com.grishberg.domain.gateway.CachedInfoGateway
import com.grishberg.domain.gateway.FakeNetworkGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContentDetailsModule {
    @Provides
    @Singleton
    fun provideContentDetails(): ContentDetails = ContentUseCase(
            FakeNetworkGateway(CachedInfoGateway()))
}