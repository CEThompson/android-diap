package com.example.diap.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.diap.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.example.diap.common.dependencyinjection.presentation.PresentationModule
import com.example.diap.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent(
                (requireActivity() as BaseActivity)
                    .activityComponent
            )
            .presentationModule(
                PresentationModule()
            )
            .build()
    }

    protected val injector get() = presentationComponent

}