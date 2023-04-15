package com.example.wallpaperapp_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wallpaperapp.Fragments.DownloadFragment
import com.example.wallpaperapp.Fragments.HomeFragment
import com.example.wallpaperapp_firebase.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())

        binding.icHome.setOnClickListener {
            loadFragment(HomeFragment())
            Toast.makeText(this,"Click Home", Toast.LENGTH_SHORT).show()
        }
        binding.icDownload.setOnClickListener {
            loadFragment(DownloadFragment())
            Toast.makeText(this,"Click Download", Toast.LENGTH_SHORT).show()
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.loadfragemnt, fragment)
        transaction.commit()


    }
}