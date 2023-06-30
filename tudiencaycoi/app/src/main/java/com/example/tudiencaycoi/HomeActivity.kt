package com.example.tudiencaycoi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tudiencaycoi.adapter.PhotographyAdapter
import com.example.tudiencaycoi.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Xuly()

        binding.crdSpecies.setOnClickListener {
            val intent = Intent(this, SpeciesActivity::class.java)
            startActivity(intent)
        }

        binding.crdSpecies.setOnClickListener {
            val intent = Intent(this, ArticlesActivity::class.java)
            startActivity(intent)
        }

    }

    private fun Xuly() {
        val Photographyds = mutableListOf<Int>()
        Photographyds.add(R.drawable.cate1)
        Photographyds.add(R.drawable.cate2)
        Photographyds.add(R.drawable.cate3)
        Photographyds.add(R.drawable.cate4)

        binding.rvPhotoChild.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        val photographyAdapter = PhotographyAdapter(Photographyds)
        binding.rvPhotoChild.adapter = photographyAdapter

        binding.btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

}