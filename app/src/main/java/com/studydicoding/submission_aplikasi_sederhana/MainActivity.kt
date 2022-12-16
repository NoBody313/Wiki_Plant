package com.studydicoding.submission_aplikasi_sederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.studydicoding.submission_aplikasi_sederhana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Action Bar
        supportActionBar?.hide()
    }
}