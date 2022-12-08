package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private val BASE_URL = "https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 通过泛型得到serviceClass具体类型，并通过retrofit创建
    fun<T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun<reified T> create(): T = create(T::class.java)
}