package com.example.diap.common.dependencyinjection

import com.example.diap.screens.questiondetails.QuestionDetailsActivity
import com.example.diap.screens.questionslist.QuestionsListActivity
import com.example.diap.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(fragment: QuestionsListFragment) {
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
    }

    fun inject(activity: QuestionsListActivity){
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
        activity.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
    }
}