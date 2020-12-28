package com.example.diap.common.composition

import android.app.Activity
import android.text.Layout
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.diap.networking.StackoverflowApi
import com.example.diap.questions.FetchQuestionDetailsUseCase
import com.example.diap.questions.FetchQuestionsUseCase
import com.example.diap.screens.common.ScreensNavigator
import com.example.diap.screens.common.dialogs.DialogsNavigator
import com.example.diap.screens.common.viewsmvc.ViewMvcFactory

class ActivityCompositionRoot(private val activity: AppCompatActivity,
                              private val appCompositionRoot: AppCompositionRoot) {

    private val layoutInflater: LayoutInflater get() = LayoutInflater.from(activity)

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)

    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val fragmentManager get() = activity.supportFragmentManager

    val dialogsNavigator get() = DialogsNavigator(fragmentManager)

    private val stackoverflowApi: StackoverflowApi get() = appCompositionRoot.stackoverflowApi

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}
