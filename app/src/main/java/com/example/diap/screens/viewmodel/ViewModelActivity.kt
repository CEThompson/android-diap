package com.techyourchance.dagger2course.screens.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.diap.R
import com.example.diap.screens.common.ScreensNavigator
import com.example.diap.screens.common.activities.BaseActivity
import com.example.diap.screens.common.toolbar.MyToolbar
import com.example.diap.screens.viewmodel.MyViewModel
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    @Inject
    lateinit var factory: MyViewModel.Factory

    private lateinit var toolbar: MyToolbar

    private lateinit var myViewModel: MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_view_model)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }

        myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        
        myViewModel.questions.observe(this, Observer {
            questions ->
            Toast.makeText(this, "fetched ${questions.size} questions", Toast.LENGTH_LONG).show()
        })
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(intent)
        }
    }
}