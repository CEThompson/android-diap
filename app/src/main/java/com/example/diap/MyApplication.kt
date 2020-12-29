package com.example.diap

import android.app.Application
import com.example.diap.common.dependencyinjection.AppModule
import com.example.diap.common.dependencyinjection.DaggerAppComponent

class MyApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}