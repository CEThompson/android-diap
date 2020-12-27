package com.example.diap.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.example.diap.MyApplication
import com.example.diap.common.composition.ActivityCompositionRoot
import com.example.diap.common.composition.AppCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot: AppCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val compositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }
    //val compositionRoot get() = (application as MyApplication).appCompositionRoot



}