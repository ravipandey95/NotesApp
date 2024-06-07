package com.example.notesapp.di

import android.util.Log
import com.example.notesapp.api.UserAPI
import com.example.notesapp.utils.Constants.BASE_URL
import com.example.notesapp.utils.Constants.TAG
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit () : Retrofit{
        Log.d(TAG,"providesRetrofit")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesUserAPI(retrofit: Retrofit) : UserAPI {
        Log.d(TAG,"providesUserAPI")
        return retrofit.create(UserAPI::class.java)
    }
}