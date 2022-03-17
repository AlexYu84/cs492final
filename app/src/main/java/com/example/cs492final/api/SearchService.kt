package com.example.cs492final.api

import com.example.cs492final.data.ProfileResult
import com.example.cs492final.data.SearchResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://financialmodelingprep.com/api/v3/
// search?query={symbol}&limit={limit}&exchange={exch}&apikey={apikey}

// exchange values
// ETF, MUTUAL_FUND, COMMODITY, INDEX, CRYPTO, FOREX, TSX
// AMEX, NASDAQ, NYSE, EURONEXT, XETRA, NSE, LSE

// maybe we just limit the search to the NYSE for now to simplify things
// if we don't may need to make specific profile services for each
// exchange type as reporting standards, and therefore json data,
// would differ

interface SearchService {
    @GET("search")
    suspend fun searchCompany(
        @Query("query") symbol: String,
        //@Query("limit") limit: Int,
        @Query("apikey") apiKey: String,
    ) : SearchResult

    companion object {
        private const val BASE_URL = "https://financialmodelingprep.com/api/v3/"
        fun create() : SearchService {
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
            return retrofit.create(SearchService::class.java)
        }
    }
}