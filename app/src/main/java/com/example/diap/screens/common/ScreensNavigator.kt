package com.example.diap.screens.common

interface ScreensNavigator {

    fun toQuestionDetails(questionId: String)

    fun navigateBack()

    fun toViewModel()
}