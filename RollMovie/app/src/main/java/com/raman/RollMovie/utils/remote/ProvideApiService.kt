package com.raman.RollMovie.utils.remote

import com.raman.RollMovie.model.api.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun createApiService(): ApiService {

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val request = it.request().newBuilder().addHeader("accept", "application/json").addHeader("Authorization", "Bearer $API_KEY")
            return@addInterceptor it.proceed(request.build())
        }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    return retrofit.create(ApiService::class.java)
}