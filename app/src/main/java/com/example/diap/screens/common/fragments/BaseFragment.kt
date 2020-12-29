package com.example.diap.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.diap.common.dependencyinjection.DaggerPresentationComponent
import com.example.diap.common.dependencyinjection.Injector
import com.example.diap.common.dependencyinjection.PresentationModule
import com.example.diap.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(
                PresentationModule(
                    (requireActivity() as BaseActivity)
                        .activityCompositionRoot
                )
            )
            .build()
    }

    protected val injector get() = Injector(presentationComponent)

}