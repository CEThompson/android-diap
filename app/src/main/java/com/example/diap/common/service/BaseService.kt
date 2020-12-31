package com.example.diap.common.service

import android.app.Service
import com.example.diap.MyApplication
import com.example.diap.common.dependencyinjection.service.ServiceModule

abstract class BaseService : Service() {

    private val appComponent get() = (application as MyApplication).appComponent

    val serviceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }

}