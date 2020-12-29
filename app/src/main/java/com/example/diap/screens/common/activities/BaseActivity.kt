package com.example.diap.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.diap.MyApplication
import com.example.diap.common.dependencyinjection.ActivityCompositionRoot
import com.example.diap.common.dependencyinjection.AppCompositionRoot
import com.example.diap.common.dependencyinjection.Injector
import com.example.diap.common.dependencyinjection.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot: AppCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val activityCompositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }

    private val compositionRoot by lazy { PresentationCompositionRoot(activityCompositionRoot) }

    protected val injector get() = Injector(compositionRoot)

}