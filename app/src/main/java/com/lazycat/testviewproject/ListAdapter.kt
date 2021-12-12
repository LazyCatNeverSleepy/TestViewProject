package com.lazycat.testviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lazycat.testviewproject.databinding.ItemRecyclerviewBinding

class ListAdapter(private val mList:MutableList<String>) : RecyclerView.Adapter<ListAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.apply {
            content.text = mList[position]
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class CustomViewHolder(val binding:ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {

    }
}