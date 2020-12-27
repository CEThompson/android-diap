package com.example.diap.common.composition

import android.app.Activity
import com.example.diap.networking.StackoverflowApi
import com.example.diap.questions.FetchQuestionDetailsUseCase
import com.example.diap.questions.FetchQuestionsUseCase
import com.example.diap.screens.common.ScreensNavigator

class ActivityCompositionRoot(private val activity: Activity,
                              private val appCompositionRoot: AppCompositionRoot) {

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    private val stackoverflowApi: StackoverflowApi get() = appCompositionRoot.stackoverflowApi

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}
