package com.example.diap.screens.common.fragments

import androidx.fragment.app.Fragment

import com.example.diap.common.dependencyinjection.PresentationModule
import com.example.diap.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.example.diap.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(
                PresentationModule(
                    (requireActivity() as BaseActivity)
                        .activityComponent
                )
            )
            .build()
    }

    protected val injector get() = presentationComponent

}