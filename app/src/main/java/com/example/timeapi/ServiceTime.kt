package com.example.timeapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceTime {

    private var retrofit =Retrofit.Builder().baseUrl("http://worldtimeapi.org")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(TimeApi::class.java)
}