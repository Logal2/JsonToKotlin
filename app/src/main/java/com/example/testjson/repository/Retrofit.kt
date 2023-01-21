package com.example.testjson

import com.example.testjson.data.Results
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://restcountries.com/v2"

object RetrofitInstance{
    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchRandomRegionApi:SearchRandomUserApi= retrofit.create(SearchRandomUserApi::class.java)

}


interface SearchRandomUserApi{
    @Headers (
        "Accept: application/json",
        "Content-type: application/json"
    )

    @GET("all/name/{name}")
    //@Query()
    suspend fun getRandomRegion(): Results
}