package com.example.cs492final.api

import com.example.cs492final.data.ProfileResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileService {
    // not totally sure how to implement the profile/{symbol}? part of the
    // api call
    @GET("profile/{companySymbol}")
    suspend fun searchCompany(
        @Query("apikey") apiKey: String,
    ) : ProfileResult

    companion object {
        private const val BASE_URL = "https://financialmodelingprep.com/api/v3/"
        fun create() : ProfileService {
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

            // This enables useful logs in LogCat when investigating API calls
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(httpClient.build())
                .build()
            return retrofit.create(ProfileService::class.java)
        }
    }
}
