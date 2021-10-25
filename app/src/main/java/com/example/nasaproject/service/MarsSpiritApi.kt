package com.example.nasaproject.service
import com.example.nasaproject.model.Photos
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/spirit/"

interface MarsSpiritApi {
    @GET("photos?sol=642&api_key=UvBzxfoqZ8dGCm39XoC0vcAwz7oLrDfiCtCN5G9I")
    fun getSpiritPhotos(): Call<Photos>
}

object SpiritNetwork{
    val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarsSpiritApi::class.java)
    }
}
