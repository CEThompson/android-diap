package com.example.diap

import android.app.Application
import com.example.diap.common.dependencyinjection.app.AppComponent
import com.example.diap.common.dependencyinjection.app.AppModule
import com.example.diap.common.dependencyinjection.app.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}