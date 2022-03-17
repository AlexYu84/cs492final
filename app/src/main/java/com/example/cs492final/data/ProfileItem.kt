package com.example.cs492final.data

import androidx.room.Entity
import java.io.Serializable

@Entity
data class ProfileItem(
    val symbol: String,
    val price: Double,
    val beta: Double,
    val volAvg: Int,
    val mktCap: Int,
    val lastDiv: Double,
    val range: String,
    val changes: Double,
    val companyName: String,
    val currency: String,
    val cik: String,
    val isin: String,
    val cusip: String,
    val exchange: String,
    val exchangeShortName: String,
    val industry: String,
    val website: String,
    val description: String,
    val ceo: String,
    val sector: String,
    val country: String,
    val fullTimeEmployees: String,
    val phone: String,
    val address: String,
    val city: String,
    val state: String,
    val zip: String,
    val dcfDiff: Double,
    val dcf: Double,
    val image: String,
    val ipoDate: String,
    val isEtf: Boolean,
    val isActivelyTrading: Boolean,
    val isAdr: Boolean,
    val isFund: Boolean
) : Serializable
