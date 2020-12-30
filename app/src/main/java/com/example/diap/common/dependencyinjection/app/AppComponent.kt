package com.example.diap.common.dependencyinjection.app

import android.app.Application
import com.example.diap.networking.StackoverflowApi
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun application(): Application
    fun stackoverflowApi(): StackoverflowApi
}