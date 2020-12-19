package com.swiper.store.di

import com.swiper.store.model.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    fun provideApiRepository(): ApiRepository {
        return ApiRepository()
    }
}