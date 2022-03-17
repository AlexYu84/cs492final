package com.example.cs492final.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs492final.R
import com.example.cs492final.data.LoadingStatus
import com.example.cs492final.data.SearchItem
import com.google.android.material.progressindicator.CircularProgressIndicator

class SearchListActivity : AppCompatActivity() {
    private val tag = "SearchListActivity"

    private val searchListAdapter = SearchListAdapter(::onListItemClick)
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var searchResultsListRV: RecyclerView
    private lateinit var loadingIndicator: CircularProgressIndicator
    private lateinit var searchErrorTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)

        searchResultsListRV = findViewById(R.id.rv_search_results)
        searchErrorTV = findViewById(R.id.tv_search_error)
        loadingIndicator = findViewById(R.id.loading_indicator)

        searchResultsListRV.layoutManager = LinearLayoutManager(this)
        searchResultsListRV.setHasFixedSize(true)

        viewModel.searchResults.observe(this) { searchResults ->
            searchListAdapter.updateItemList(searchResults)
        }

        viewModel.loadingStatus.observe(this) { uiState ->
            when (uiState) {
                LoadingStatus.LOADING -> {
                    loadingIndicator.visibility = View.VISIBLE
                    searchResultsListRV.visibility = View.INVISIBLE
                    searchErrorTV.visibility = View.INVISIBLE
                }
                LoadingStatus.ERROR -> {
                    loadingIndicator.visibility = View.INVISIBLE
                    searchResultsListRV.visibility = View.INVISIBLE
                    searchErrorTV.visibility = View.VISIBLE
                }
                LoadingStatus.SUCCESS -> {
                    loadingIndicator.visibility = View.INVISIBLE
                    searchResultsListRV.visibility = View.VISIBLE
                    searchErrorTV.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun onListItemClick(item: SearchItem) {
        // we need to make a Profile API call and pass it
        val profile = "replace this with an actual company profile"
        val intent = Intent(this, CompanyProfileActivity::class.java).apply {
            putExtra(EXTRA_COMPANY_PROFILE, profile)
        }
        startActivity(intent)
    }
}