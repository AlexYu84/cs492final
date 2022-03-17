package com.example.cs492final.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cs492final.R
import com.example.cs492final.data.ProfileItem

const val EXTRA_COMPANY_PROFILE = "com.example.android.cs492final.ProfileItem"

class CompanyProfileActivity : AppCompatActivity() {
    private var profile: ProfileItem? = null
    private var isBookmarked = false

    private val viewModel: BookmarkedCompanyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_profile)

        if (intent != null && intent.hasExtra(EXTRA_COMPANY_PROFILE)) {
            profile = intent.getSerializableExtra(EXTRA_COMPANY_PROFILE) as ProfileItem
            TODO("find view stuff")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        TODO("implement bookmarked company stuff")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        TODO("implement share and bookmark actions")
    }

    private fun toggleCompanyBookmark(menuItem: MenuItem) {
        TODO("implement")
    }

    private fun shareCompany() {
        TODO("implement")
    }
}