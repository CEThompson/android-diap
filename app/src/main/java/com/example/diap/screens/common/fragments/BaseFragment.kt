package com.example.diap.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.diap.common.dependencyinjection.presentation.PresentationModule
import com.example.diap.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            PresentationModule(this)
        )
    }

    protected val injector get() = presentationComponent

}