package com.example.cs492final.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.activity.viewModels
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs492final.R
import com.example.cs492final.BuildConfig
import com.example.cs492final.data.SearchItem
import com.google.android.material.progressindicator.CircularProgressIndicator

/*
 * Just like in the homework this is configured to pull an API key
 * from $USER_HOME/.gradle/gradle.properties via gradle build
 */

// if this is red and you've set your key in build.gradle just build the app
const val FMPDEV_APPID = BuildConfig.FMPDEV_API_KEY

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var searchBoxET: EditText
    private lateinit var savedCompaniesListRV: RecyclerView
    private lateinit var errorTV: TextView
    private lateinit var loadingIndicator: CircularProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBoxET = findViewById(R.id.et_search_box)
        savedCompaniesListRV = findViewById(R.id.rv_saved_companies)
        errorTV = findViewById(R.id.tv_saved_error)
        loadingIndicator = findViewById(R.id.loading_indicator)

        //val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)

        val searchBtn: Button = findViewById(R.id.btn_search)
        searchBtn.setOnClickListener{
            val query = searchBoxET.text.toString()
            if (!TextUtils.isEmpty(query)) {
                TODO("Make a Search API call and add intent to go to activity_search_list")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
        else -> super.onOptionsItemSelected(item)
        }
    }

}