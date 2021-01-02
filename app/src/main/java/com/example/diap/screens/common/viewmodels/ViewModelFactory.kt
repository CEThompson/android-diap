package com.example.diap.screens.common.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diap.screens.viewmodel.MyViewModel
import com.example.diap.screens.viewmodel.MyViewModel2
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor (
    private val viewModelProvider: Provider<MyViewModel>,
    private val viewModel2Provider: Provider<MyViewModel2>
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return when(modelClass){
                MyViewModel::class.java -> viewModelProvider.get() as T
                MyViewModel2:: class.java -> viewModel2Provider.get() as T
                else -> throw RuntimeException("unsupported viewmodel type: $modelClass")
            }

        }
}