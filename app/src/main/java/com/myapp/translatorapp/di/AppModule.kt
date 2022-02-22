package com.myapp.translatorapp.di

import com.myapp.translatorapp.BuildConfig
import com.myapp.translatorapp.data.remote.TranslatorApi
import com.myapp.translatorapp.data.repository.GetTranslationRepositoryImpl
import com.myapp.translatorapp.domain.repository.GetTranslationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTranslatorApi(): TranslatorApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(TranslatorApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetTranslationRepository(api: TranslatorApi): GetTranslationRepository {
        return GetTranslationRepositoryImpl(api)
    }

}