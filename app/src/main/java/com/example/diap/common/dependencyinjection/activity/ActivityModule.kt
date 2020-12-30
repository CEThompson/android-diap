package com.example.diap.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.diap.common.dependencyinjection.app.AppComponent
import com.example.diap.networking.StackoverflowApi
import com.example.diap.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {

    @Provides
    @ActivityScope
    fun screensNavigator(): ScreensNavigator = ScreensNavigator(activity)

    @Provides
    fun activity() = activity

    // For use of different contexts
    // Since Android contexts violates Liskov substitution principle
    @Provides
    fun application() = appComponent.application()

    @Provides
    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun stackoverflowApi(): StackoverflowApi = appComponent.stackoverflowApi()

}
