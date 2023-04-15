package com.example.wallpaperapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaperapp.Adapter.BomAdapter
import com.example.wallpaperapp.Adapter.CatAdapter
import com.example.wallpaperapp.Adapter.TctAdapter
import com.example.wallpaperapp.Model.BomModel
import com.example.wallpaperapp.Model.CatModel
import com.example.wallpaperapp.Model.TctModel
import com.example.wallpaperapp_firebase.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        db= FirebaseFirestore.getInstance()

        db.collection("BestOfMonth").addSnapshotListener { value, error ->
            val listBestOfMonth= arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
            listBestOfMonth.addAll(data!!)

            binding.rcvBom.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.rcvBom.adapter= BomAdapter(requireContext(),listBestOfMonth)
        }

        db.collection("thecolortone").addSnapshotListener { value, error ->
            val listTheColortone= arrayListOf<TctModel>()
            val data = value?.toObjects(TctModel::class.java)
           listTheColortone.addAll(data!!)

            binding.rcvTct.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.rcvTct.adapter=TctAdapter(requireContext(),listTheColortone)
        }

        db.collection("categories").addSnapshotListener { value, error ->
           val listOfcategories = arrayListOf<CatModel>()
            val data=value?.toObjects(CatModel::class.java)
            listOfcategories.addAll(data!!)

            binding.rcvCat.layoutManager= GridLayoutManager(requireContext(),2)
            binding.rcvCat.adapter=CatAdapter(requireContext(),listOfcategories)

        }


        return  binding.root
    }

}