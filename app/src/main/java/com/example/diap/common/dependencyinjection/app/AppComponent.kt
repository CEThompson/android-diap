package com.example.diap.common.dependencyinjection.app

import com.example.diap.common.dependencyinjection.activity.ActivityComponent
import com.example.diap.common.dependencyinjection.activity.ActivityModule
import com.example.diap.common.dependencyinjection.service.ServiceComponent
import com.example.diap.common.dependencyinjection.service.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponentBuilder(): ActivityComponent.Builder
    fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}