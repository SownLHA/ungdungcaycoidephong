package com.example.tudiencaycoi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tudiencaycoi.databinding.ActivityPlantDetailBinding
import com.google.firebase.database.FirebaseDatabase

class PlantDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlantDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setValueToView()
    }

    private fun setValueToView() {
        binding.tvEmpId.text = intent.getStringExtra("empId")
        binding.tvEmpAge.text = intent.getStringExtra("empAge")
        binding.tvEmpName.text = intent.getStringExtra("empName")
        binding.tvEmpSalary.text = intent.getStringExtra("empSalary")
    }
}