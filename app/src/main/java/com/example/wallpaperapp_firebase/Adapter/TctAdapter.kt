package com.example.wallpaperapp.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.Model.TctModel
import com.example.wallpaperapp_firebase.FinalWallpaper
import com.example.wallpaperapp_firebase.R

class TctAdapter(
    val requireContext: Context,
    val listTheColortone: ArrayList<TctModel>,
    ) : RecyclerView.Adapter<TctAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        val CardBack = itemView.findViewById<CardView>(R.id.item_color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_tct,parent,false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        val color=listTheColortone[position].color
        holder.CardBack.setCardBackgroundColor(Color.parseColor(color!!))

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, FinalWallpaper::class.java)
            intent.putExtra("link",listTheColortone[position].link)
            requireContext.startActivity(intent)
        }

    }
    override fun getItemCount() = listTheColortone.size
}