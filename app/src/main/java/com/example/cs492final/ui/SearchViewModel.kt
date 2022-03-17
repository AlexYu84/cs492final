package com.example.cs492final.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs492final.api.SearchService
import com.example.cs492final.data.LoadingStatus
import com.example.cs492final.data.SearchItem
import com.example.cs492final.data.SearchRepository
import kotlinx.coroutines.launch


class SearchViewModel : ViewModel() {
    private val repository = SearchRepository(SearchService.create())

    private val _searchResults = MutableLiveData<List<SearchItem>>(null)
    val searchResults: LiveData<List<SearchItem>?> = _searchResults

    private val _loadingStatus = MutableLiveData(LoadingStatus.SUCCESS)
    val loadingStatus: LiveData<LoadingStatus> = _loadingStatus

    fun loadSearchResults(
        query: String,
        appid: String
    ) {
        viewModelScope.launch {
            _loadingStatus.value = LoadingStatus.LOADING
            val result = repository.loadRepositoriesSearch(query, appid)
            _searchResults.value = result.getOrNull()
            _loadingStatus.value = when (result.isSuccess) {
                true -> LoadingStatus.SUCCESS
                false -> LoadingStatus.ERROR
            }
        }
    }
}
