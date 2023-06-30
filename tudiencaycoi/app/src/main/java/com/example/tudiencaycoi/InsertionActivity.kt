package com.example.tudiencaycoi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tudiencaycoi.databinding.ActivityInsertionBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsertionBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbRef = FirebaseDatabase.getInstance().getReference("Plants")

        binding.btnSave.setOnClickListener {
            savePlantData()
        }
    }

    private fun savePlantData() {
        // Getting values using ViewBinding
        val pltName = binding.edtpltName.text.toString()
        val pltSpecies = binding.edtspecies.text.toString()
        val description = binding.description.text.toString()

        // Đẩy dữ liệu
        val pltId = dbRef.push().key!!
        val plant = PlantModel(pltId, pltName,pltSpecies , description)

        // Kiểm tra các ô nhập liệu đã có dữ liệu hay chưa
        if (pltName.isEmpty()) {
            binding.edtpltName.error = "Please enter name"
            return
        }
        if (pltSpecies.isEmpty()) {
            binding.edtspecies.error = "Please enter Age"
            return
        }
        if (description.isEmpty()) {
            binding.description.error = "Please enter Salary"
            return
        }

        dbRef.child(pltId).setValue(plant)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Data insert thành công", Toast.LENGTH_SHORT).show()
                    binding.edtpltName.setText("")
                    binding.edtspecies.setText("")
                    binding.description.setText("")
                } else {
                    Toast.makeText(this, "Error ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}