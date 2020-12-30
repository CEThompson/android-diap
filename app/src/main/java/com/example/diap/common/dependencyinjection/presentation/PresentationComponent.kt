package com.example.diap.common.dependencyinjection.presentation

import com.example.diap.common.dependencyinjection.PresentationModule
import com.example.diap.screens.questiondetails.QuestionDetailsActivity
import com.example.diap.screens.questionslist.QuestionsListActivity
import com.example.diap.screens.questionslist.QuestionsListFragment
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(activity: QuestionsListActivity)
    fun inject(activity: QuestionDetailsActivity)
}