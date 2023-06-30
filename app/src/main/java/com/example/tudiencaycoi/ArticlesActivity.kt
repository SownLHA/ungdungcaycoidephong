package com.example.tudiencaycoi

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tudiencaycoi.adapter.PltAdapter
import com.example.tudiencaycoi.databinding.ActivityArticlesBinding
import com.google.firebase.database.*

class ArticlesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticlesBinding
    private lateinit var ds: ArrayList<PlantModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticlesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPlt.layoutManager = LinearLayoutManager(this)
        binding.rvPlt.setHasFixedSize(true)
        ds = arrayListOf<PlantModel>()
        GetThongTinPlant() // alt + enter
    }

    private fun GetThongTinPlant() {
        binding.rvPlt.visibility = View.GONE
        dbRef = FirebaseDatabase.getInstance().getReference("Plants")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                if (snapshot.exists()) {
                    for (pltSnap in snapshot.children) {
                        val pltData = pltSnap.getValue(PlantModel::class.java)
                        ds.add(pltData!!)
                    }
                    val mAdapter = PltAdapter(ds)
                    binding.rvPlt.adapter = mAdapter
                    mAdapter.setOnItemClickListener(object : PltAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            val intent =
                                Intent(this@ArticlesActivity, PlantDetailActivity::class.java)
                            intent.putExtra("pltId", ds[position].pltId)
                            intent.putExtra("pltName", ds[position].pltName)
                            intent.putExtra("species", ds[position].species)
                            intent.putExtra("description", ds[position].description)
                            startActivity(intent)
                        }
                    })
                    binding.rvPlt.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled event
            }
        })
    }
}
