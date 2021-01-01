package com.example.diap.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.diap.screens.common.ScreensNavigator
import com.example.diap.screens.common.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    // Note: this is the simplest way to map an interface to an implementation
    // See the ScreensNavigator class for automatic service discovery / injection
    // and abstract screens navigator binding below for another method
    /*@Provides
    @ActivityScope
    fun screensNavigator(activity: AppCompatActivity): ScreensNavigator {
        return ScreensNavigatorImpl(activity)
    }*/

    @ActivityScope
    @Binds
    abstract fun screensNavigator(screensNavigatorImpl: ScreensNavigatorImpl): ScreensNavigator

    companion object {
        @Provides
        fun layoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }
}
