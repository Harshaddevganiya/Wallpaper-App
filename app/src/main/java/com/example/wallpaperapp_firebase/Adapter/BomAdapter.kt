package com.example.wallpaperapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.Model.BomModel
import com.example.wallpaperapp_firebase.FinalWallpaper
import com.example.wallpaperapp_firebase.R

class BomAdapter(
    val requireContext: Context,
    val listBestOfMonth: ArrayList<BomModel>) : RecyclerView.Adapter<BomAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        val ImageView = itemView.findViewById<ImageView>(R.id.bom_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_bom,parent,false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBestOfMonth[position].link).into(holder.ImageView)

        holder.itemView.setOnClickListener {
            val intent =Intent(requireContext, FinalWallpaper::class.java)
            intent.putExtra("link",listBestOfMonth[position].link)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount() = listBestOfMonth.size
}