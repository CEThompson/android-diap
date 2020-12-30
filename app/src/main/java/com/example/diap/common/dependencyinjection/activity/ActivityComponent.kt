package com.example.diap.common.dependencyinjection.activity

import com.example.diap.common.dependencyinjection.presentation.PresentationComponent
import com.example.diap.common.dependencyinjection.presentation.PresentationModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}