package com.example.cs492final.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.cs492final.data.AppDatabase
import com.example.cs492final.data.BookmarkedCompanyRepository
import com.example.cs492final.data.ProfileItem
import kotlinx.coroutines.launch

class BookmarkedCompanyViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = BookmarkedCompanyRepository(
        AppDatabase.getInstance(application).profileItemDao()
    )

    val bookmarkedCompanies = repository.getAllBookmarkedCompanies().asLiveData()

    fun addBookmarkedCompany(item: ProfileItem) {
        viewModelScope.launch {
            repository.insertBookmarkedCompany(item)
        }
    }

    fun removeBookmarkedCompany(item: ProfileItem) {
        viewModelScope.launch {
            repository.removeBookmarkedCompany(item)
        }
    }

    fun getBookmarkedCompanyByName(symbol: String) =
        repository.getBookmarkedCompanyBySymbol(symbol).asLiveData()

}