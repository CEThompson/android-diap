package com.example.diap.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.diap.MyApplication
import com.example.diap.common.dependencyinjection.activity.ActivityModule
import com.example.diap.common.dependencyinjection.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule())
    }

    protected val injector get() = presentationComponent

}