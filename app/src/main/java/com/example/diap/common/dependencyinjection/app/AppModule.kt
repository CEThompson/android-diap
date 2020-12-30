package com.example.diap.common.dependencyinjection.app

import android.app.Application
import com.example.diap.Constants
import com.example.diap.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// This class composes services and resides at the root of the dependency tree
@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun application() = application

    @Provides
    @AppScope
    fun stackoverflowApi(retrofit: Retrofit): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

}

// NOTE: Below is a retrofit instantiation that is not thread safe,
// but it is asserted that there are not valid reasons for accessing composition root on a background thread
// ALSO NOTE: kotlin lazy allows us to simplify this retrofit code block
/*private var _retrofit: Retrofit? = null
private val retrofit: Retrofit
    get() = if (_retrofit == null) {
        _retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        _retrofit!!
    } else _retrofit!!*/