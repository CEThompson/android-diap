package com.example.diap.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.diap.common.composition.PresentationCompositionRoot
import com.example.diap.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    protected val compositionRoot
        by lazy {
            PresentationCompositionRoot(
                (requireActivity() as BaseActivity)
                    .activityCompositionRoot
            )
        }

}