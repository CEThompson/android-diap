package com.example.diap.common.dependencyinjection.app

import android.app.Application
import com.example.diap.networking.StackoverflowApi
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun application(): Application
    fun retrofit(): Retrofit
    fun stackoverflowApi(): StackoverflowApi
}