package com.example.diap.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.diap.questions.Question
import com.example.diap.screens.questionslist.QuestionsListViewMvc

class ViewMvcFactory(private val layoutInflater: LayoutInflater) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

}