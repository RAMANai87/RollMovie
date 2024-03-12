package com.raman.RollMovie.utils

import com.raman.RollMovie.model.api.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun createApiService(): ApiService {

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val request = it.request().newBuilder().addHeader("Authorization", "Bearer $API_KEY")
            return@addInterceptor it.proceed(request.build())
        }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    return retrofit.create(ApiService::class.java)
}