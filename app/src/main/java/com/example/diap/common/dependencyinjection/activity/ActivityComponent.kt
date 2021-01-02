package com.example.diap.common.dependencyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.diap.common.dependencyinjection.presentation.PresentationComponent
import com.example.diap.common.dependencyinjection.presentation.PresentationModule
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: AppCompatActivity): Builder
        fun build(): ActivityComponent
        //fun activityModule(activityModule: ActivityModule): Builder

    }
}