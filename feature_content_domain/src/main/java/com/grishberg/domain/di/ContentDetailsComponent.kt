package com.grishberg.domain.di

import com.grishberg.content.ContentDetails
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContentDetailsModule::class])
interface ContentDetailsComponent {

    fun provideContentDetails(): ContentDetails
}