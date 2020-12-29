package com.example.diap.common.dependencyinjection

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.diap.networking.StackoverflowApi
import com.example.diap.screens.common.ScreensNavigator
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): AppCompatActivity
    fun application(): Application
    fun layoutInflater(): LayoutInflater
    fun screensNavigator(): ScreensNavigator
    fun fragmentManager(): FragmentManager
    fun stackoverflowApi(): StackoverflowApi
}