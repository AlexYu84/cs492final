package com.example.cs492final.data

class BookmarkedCompanyRepository (private val dao: ProfileItemDao) {
    suspend fun insertBookmarkedCompany(item: ProfileItem) = dao.insert(item)
    suspend fun removeBookmarkedCompany(item: ProfileItem) = dao.delete(item)
    fun getAllBookmarkedCompanies() = dao.getAllComapnies()
    fun getBookmarkedCompanyBySymbol(symbol: String) = dao.getCompanyBySymbol(symbol)
}