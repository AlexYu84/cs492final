package com.example.cs492final.data

import android.util.Log
import com.example.cs492final.api.SearchService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class SearchRepository(
    private val service: SearchService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun loadRepositoriesSearch(
        query: String,
        appid: String
    ): Result<List<SearchItem>> = withContext(ioDispatcher) {
        try {
            val results = service.searchCompany(query, appid)
            Result.success(results.items)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}