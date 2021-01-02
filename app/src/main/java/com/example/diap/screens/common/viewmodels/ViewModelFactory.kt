package com.example.diap.screens.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.example.diap.questions.FetchQuestionDetailsUseCase
import com.example.diap.questions.FetchQuestionsUseCase
import com.example.diap.screens.viewmodel.MyViewModel
import com.example.diap.screens.viewmodel.MyViewModel2
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
    private val fetchQuestionDetailsUseCaseProvider: Provider<FetchQuestionDetailsUseCase>,
    savedStateRegistryOwner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {

        return when (modelClass) {
            MyViewModel::class.java -> MyViewModel(
                fetchQuestionsUseCaseProvider.get(),
                fetchQuestionDetailsUseCaseProvider.get(),
                handle
            ) as T
            MyViewModel2::class.java -> MyViewModel2(
                fetchQuestionsUseCaseProvider.get(),
                fetchQuestionDetailsUseCaseProvider.get()
            ) as T
            else -> throw RuntimeException("unsupported viewmodel type: $modelClass")
        }

    }
}