package com.example.diap.common.dependencyinjection.app

import android.app.Application
import com.example.diap.Constants
import com.example.diap.common.dependencyinjection.Retrofit1
import com.example.diap.common.dependencyinjection.Retrofit2
import com.example.diap.networking.StackoverflowApi
import com.example.diap.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

// This class composes services and resides at the root of the dependency tree
@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    @Retrofit1
    // @Named qualifier is builtin to javax inject package
    //@Named("retrofit1")
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
    fun application() = application

    @Provides
    @AppScope
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit): StackoverflowApi =
        retrofit.create(StackoverflowApi::class.java)

}