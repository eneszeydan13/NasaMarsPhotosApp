package com.example.nasaproject.service

import com.example.nasaproject.model.Photos
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/opportunity/"

interface MarsOpportunityApi {

    @GET("photos?sol=621&api_key=UvBzxfoqZ8dGCm39XoC0vcAwz7oLrDfiCtCN5G9I")
    fun getOpportunityPhotos(): Call<Photos>

}

object OpportunityNetwork{
    val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarsOpportunityApi::class.java)
    }
}