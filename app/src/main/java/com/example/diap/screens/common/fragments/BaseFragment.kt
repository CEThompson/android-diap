package com.example.diap.screens.common.fragments

import androidx.fragment.app.Fragment
import com.example.diap.MyApplication
import com.example.diap.common.composition.ActivityCompositionRoot
import com.example.diap.common.composition.AppCompositionRoot
import com.example.diap.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    protected val compositionRoot get() = (requireActivity() as BaseActivity).compositionRoot

    /*val compositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }
    //val compositionRoot get() = (application as MyApplication).appCompositionRoot*/


}