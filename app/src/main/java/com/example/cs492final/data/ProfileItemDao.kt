package com.example.cs492final.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileItemDao {
    @Insert
    suspend fun insert(item: ProfileItem)

    @Delete
    suspend fun delete(item: ProfileItem)

    @Query("Select * FROM ProfileItem")
    fun getAllComapnies(): Flow<List<ProfileItem>>

    @Query("SELECT * FROM ProfileItem WHERE symbol = :symbol LIMIT 1")
    fun getCompanyBySymbol(symbol: String): Flow<ProfileItem?>
}