package com.example.diap.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.diap.common.dependencyinjection.app.AppComponent
import com.example.diap.networking.StackoverflowApi
import com.example.diap.screens.common.ScreensNavigator
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): AppCompatActivity
    fun layoutInflater(): LayoutInflater
    fun screensNavigator(): ScreensNavigator
    fun fragmentManager(): FragmentManager
    fun stackoverflowApi(): StackoverflowApi
}