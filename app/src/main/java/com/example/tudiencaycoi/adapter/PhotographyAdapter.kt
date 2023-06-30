package com.example.tudiencaycoi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tudiencaycoi.R
import com.example.tudiencaycoi.databinding.PhotographyItemBinding

class PhotographyAdapter (private val photographyds: List<Int>) : RecyclerView.Adapter<PhotographyAdapter.PhotographyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotographyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photography_item,parent,false)
        return PhotographyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotographyViewHolder, position: Int) {
        holder.binding.apply {
            imgPhotoPoster.setImageResource(photographyds[position])
        }
    }

    override fun getItemCount(): Int {
        return photographyds.size
    }


    inner class PhotographyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = PhotographyItemBinding.bind(itemView)

    }

}