package com.example.wallpaperapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.Model.CatModel
import com.example.wallpaperapp_firebase.FinalWallpaper
import com.example.wallpaperapp_firebase.R

class CatAdapter(
    val requireContext: Context,
    val listOfcategories: ArrayList<CatModel>,
    ) : RecyclerView.Adapter<CatAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        val ImageView = itemView.findViewById<ImageView>(R.id.cat_image)
        val name = itemView.findViewById<TextView>(R.id.cat_name)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_cat,parent,false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        holder.name.text=listOfcategories[position].name
        Glide.with(requireContext).load(listOfcategories[position].link).into(holder.ImageView)

        holder.itemView.setOnClickListener {
            val intent =Intent(requireContext, FinalWallpaper::class.java)
            intent.putExtra("link",listOfcategories[position].link)
            requireContext.startActivity(intent)
        }

    }
    override fun getItemCount() = listOfcategories.size

}