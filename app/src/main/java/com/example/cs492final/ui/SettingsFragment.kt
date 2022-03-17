package com.example.cs492final.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.cs492final.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}