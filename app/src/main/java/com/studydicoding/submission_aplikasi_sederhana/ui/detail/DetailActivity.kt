package com.studydicoding.submission_aplikasi_sederhana.ui.detail

import android.os.Build.VERSION
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.studydicoding.submission_aplikasi_sederhana.constant.Constant
import com.studydicoding.submission_aplikasi_sederhana.data.Plant
import com.studydicoding.submission_aplikasi_sederhana.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataPlant = if (VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(Constant.PLANT_DATA, Plant::class.java)
        } else {
            intent.getParcelableExtra(Constant.PLANT_DATA)
        }

        if (dataPlant != null) {
            Glide.with(this).load(dataPlant.image).into(binding.imgDetailPlant)
        }
        binding.apply {
            if (dataPlant != null) {
                tvDetailNamePlant.text = dataPlant.name
                tvDetailNameBotanical.text = dataPlant.botanicalName
                tvDescPlant.text = dataPlant.desc
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}