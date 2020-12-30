package com.example.diap.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.diap.MyApplication
import com.example.diap.common.dependencyinjection.activity.ActivityModule
import com.example.diap.common.dependencyinjection.activity.DaggerActivityComponent
import com.example.diap.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.example.diap.common.dependencyinjection.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(
                ActivityModule(this, appComponent)
            ).build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent(activityComponent)
            .presentationModule(PresentationModule())
            .build()
    }

    protected val injector get() = presentationComponent

}