package com.example.diap

import android.app.Application
import com.example.diap.common.dependencyinjection.app.AppComponent
import com.example.diap.common.dependencyinjection.app.AppModule
import com.example.diap.common.dependencyinjection.app.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}