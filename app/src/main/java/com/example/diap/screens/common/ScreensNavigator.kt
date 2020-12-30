package com.example.diap.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.diap.common.dependencyinjection.activity.ActivityScope
import com.example.diap.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigator @Inject constructor(private val activity: AppCompatActivity) {
    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun navigateBack() {
        activity.onBackPressed()
    }
}