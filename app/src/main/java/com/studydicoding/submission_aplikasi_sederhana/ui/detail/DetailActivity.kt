package com.studydicoding.submission_aplikasi_sederhana.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.studydicoding.submission_aplikasi_sederhana.data.Plant
import com.studydicoding.submission_aplikasi_sederhana.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val PLANT_DATA = "plant"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportActionBar?.hide()

        val dataPlant = intent.getParcelableExtra<Plant>(PLANT_DATA) as Plant

        Glide.with(this).load(dataPlant.image).into(binding.imgDetailPlant)
        binding.apply {
            tvDetailNamePlant.text = dataPlant.name
            tvDetailNameBotanical.text = dataPlant.botanicalName
            tvDescPlant.text = dataPlant.desc
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}