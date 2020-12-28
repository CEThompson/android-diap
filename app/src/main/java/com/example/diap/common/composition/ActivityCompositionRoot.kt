package com.example.diap.common.composition

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.diap.networking.StackoverflowApi
import com.example.diap.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    val layoutInflater: LayoutInflater get() = LayoutInflater.from(activity)

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val fragmentManager get() = activity.supportFragmentManager

    val stackoverflowApi: StackoverflowApi get() = appCompositionRoot.stackoverflowApi

}
