package com.example.diap

import android.app.Application
import com.example.diap.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    override fun onCreate() {
        super.onCreate()
    }

}