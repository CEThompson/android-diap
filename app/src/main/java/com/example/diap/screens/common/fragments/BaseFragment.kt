package com.example.diap.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.diap.common.dependencyinjection.Injector
import com.example.diap.common.dependencyinjection.PresentationCompositionRoot
import com.example.diap.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val compositionRoot
        by lazy {
            PresentationCompositionRoot(
                (requireActivity() as BaseActivity)
                    .activityCompositionRoot
            )
        }

    protected val injector get() = Injector(compositionRoot)

}