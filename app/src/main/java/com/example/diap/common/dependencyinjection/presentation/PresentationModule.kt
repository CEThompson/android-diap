package com.example.diap.common.dependencyinjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.example.diap.common.dependencyinjection.activity.ActivityComponent
import com.example.diap.networking.StackoverflowApi
import com.example.diap.questions.FetchQuestionDetailsUseCase
import com.example.diap.questions.FetchQuestionsUseCase
import com.example.diap.screens.common.dialogs.DialogsNavigator
import com.example.diap.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activityComponent: ActivityComponent) {

    @Provides
    fun layoutInflater() = activityComponent.layoutInflater()

    @Provides
    fun fragmentManager() = activityComponent.fragmentManager()

    @Provides
    fun stackoverflowApi() = activityComponent.stackoverflowApi()

    @Provides
    fun activity() = activityComponent.activity()

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun screensNavigator() = activityComponent.screensNavigator()

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionDetailsUseCase(stackoverflowApi)

}