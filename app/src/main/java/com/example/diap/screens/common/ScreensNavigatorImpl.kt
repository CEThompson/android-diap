package com.example.diap.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.example.diap.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor(private val activity: AppCompatActivity) :
    ScreensNavigator {
    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    override fun navigateBack() {
        activity.onBackPressed()
    }
}