package com.studydicoding.submission_aplikasi_sederhana.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studydicoding.submission_aplikasi_sederhana.constant.Constant
import com.studydicoding.submission_aplikasi_sederhana.data.Plant
import com.studydicoding.submission_aplikasi_sederhana.databinding.ListCardviewItemBinding
import com.studydicoding.submission_aplikasi_sederhana.ui.detail.DetailActivity

class PlantAdapter(private val listPlant: ArrayList<Plant>) :
    RecyclerView.Adapter<PlantAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ListCardviewItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ListCardviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listPlant[position]) {
                tvTitlePlant.text = name
                Glide.with(imgPlant.context).load(image).into(imgPlant)
            }
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(Constant.PLANT_DATA, listPlant[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listPlant.size
}