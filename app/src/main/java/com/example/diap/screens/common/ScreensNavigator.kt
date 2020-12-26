package com.example.diap.screens.common

import android.app.Activity
import android.content.Context
import com.example.diap.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator(private val activity: Activity) {
    fun toQuestionDetails(questionId: String){
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun navigateBack(){
        activity.onBackPressed()
    }
}