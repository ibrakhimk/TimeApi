package com.example.timeapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TimeApi {
    @GET("/api/timezone/Asia/Bishkek")
    fun getTime(
        @Query("datetime") time: String= "2023-06-30T14:15:26.005172+06:00",
        ):Call<ModelTime>
}