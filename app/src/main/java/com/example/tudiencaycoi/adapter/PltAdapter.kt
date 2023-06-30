package com.example.tudiencaycoi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tudiencaycoi.PlantModel
import com.example.tudiencaycoi.databinding.PltListItemBinding

class PltAdapter(private val ds: ArrayList<PlantModel>) :
    RecyclerView.Adapter<PltAdapter.ViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: Any) {
        mListener = clickListener as OnItemClickListener
    }

    class ViewHolder(val binding: PltListItemBinding, clickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PltListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = ds[position]
        with(holder.binding) {
            tvPltName.text = currentItem.pltName
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}