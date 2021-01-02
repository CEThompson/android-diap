package com.example.diap.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.example.diap.common.dependencyinjection.presentation.PresentationModule
import com.example.diap.screens.common.activities.BaseActivity

open class BaseDialog : DialogFragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            PresentationModule(this)
        )
    }

    protected val injector get() = presentationComponent

}