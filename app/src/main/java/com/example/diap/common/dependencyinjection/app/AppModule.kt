package com.example.diap.common.dependencyinjection.app

import com.example.diap.common.dependencyinjection.Retrofit1
import com.example.diap.common.dependencyinjection.Retrofit2
import com.example.diap.networking.StackoverflowApi
import com.example.diap.networking.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// This class composes services and resides at the root of the dependency tree
@Module
@InstallIn(ApplicationComponent::class)
class AppModule() {

    @Provides
    @AppScope
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl2())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    fun urlProvider() = UrlProvider()

    @Provides
    @AppScope
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit): StackoverflowApi =
        retrofit.create(StackoverflowApi::class.java)

}