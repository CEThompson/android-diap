package com.example.diap.common.dependencyinjection.app

import com.example.diap.common.dependencyinjection.activity.ActivityComponent
import com.example.diap.common.dependencyinjection.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}