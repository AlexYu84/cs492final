package com.example.cs492final.data

import androidx.room.Entity
import java.io.Serializable

@Entity
data class SearchItem(
    val symbol: String,
    val name: String,
    val currency: String,
    val exchangeShortName: String
) : Serializable
