package com.example.diap.common.dependencyinjection

import com.example.diap.questions.FetchQuestionDetailsUseCase
import com.example.diap.questions.FetchQuestionsUseCase
import com.example.diap.screens.common.ScreensNavigator
import com.example.diap.screens.common.dialogs.DialogsNavigator
import com.example.diap.screens.common.viewsmvc.ViewMvcFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun viewMvcFactory(): ViewMvcFactory
    fun screensNavigator(): ScreensNavigator
    fun dialogsNavigator(): DialogsNavigator
    fun fetchQuestionsUseCase(): FetchQuestionsUseCase
    fun fetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase
}