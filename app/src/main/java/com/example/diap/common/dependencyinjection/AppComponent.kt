package com.example.diap.common.dependencyinjection

import android.app.Application
import com.example.diap.networking.StackoverflowApi
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [AppModule::class])
interface AppComponent {
    fun application(): Application
    fun retrofit(): Retrofit
    fun stackoverflowApi(): StackoverflowApi
}