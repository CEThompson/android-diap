package com.example.diap.common.composition

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.diap.networking.StackoverflowApi
import com.example.diap.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    // For use of different contexts
    // Since Android contexts violates Liskov substitution principle
    val application get() = appCompositionRoot.application

    val layoutInflater: LayoutInflater get() = LayoutInflater.from(activity)

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val fragmentManager get() = activity.supportFragmentManager

    val stackoverflowApi: StackoverflowApi get() = appCompositionRoot.stackoverflowApi

}
