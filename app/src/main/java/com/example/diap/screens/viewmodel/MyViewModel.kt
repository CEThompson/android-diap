package com.example.diap.screens.viewmodel

import androidx.lifecycle.*
import com.example.diap.questions.FetchQuestionDetailsUseCase
import com.example.diap.questions.FetchQuestionsUseCase
import com.example.diap.questions.Question
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor (
    private val fetchQuestionsUseCase: FetchQuestionsUseCase,
    private val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _questions: MutableLiveData<List<Question>> = savedStateHandle.getLiveData("questions")
    val questions: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch {
            delay(5000)
            val result = fetchQuestionsUseCase.fetchLatestQuestions()
            if (result is FetchQuestionsUseCase.Result.Success){
                _questions.value = result.questions
            } else {
                // Don't do this in actual code
                throw RuntimeException("fetch_failed")
            }
        }

    }

}