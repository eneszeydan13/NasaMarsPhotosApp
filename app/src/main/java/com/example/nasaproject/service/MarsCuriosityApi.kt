package com.example.nasaproject.service

import android.provider.ContactsContract
import com.example.nasaproject.model.Photos
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"

interface MarsCuriosityApi {

    @GET("photos?sol=1000&api_key=UvBzxfoqZ8dGCm39XoC0vcAwz7oLrDfiCtCN5G9I")
    fun getCuriosityPhotos(): Call<Photos>
}

object CuriosityNetwork{
    val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarsCuriosityApi::class.java)
    }
}