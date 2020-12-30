package com.example.diap.common.dependencyinjection.activity

import com.example.diap.common.dependencyinjection.presentation.PresentationComponent
import com.example.diap.common.dependencyinjection.presentation.PresentationModule
import com.example.diap.common.dependencyinjection.presentation.UseCaseModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule, useCaseModule: UseCaseModule): PresentationComponent
}