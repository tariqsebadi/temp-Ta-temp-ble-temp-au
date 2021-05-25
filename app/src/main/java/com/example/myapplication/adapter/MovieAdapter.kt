package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.MovieProperty
import com.example.myapplication.databinding.ListViewItemBinding

class MovieAdapter : ListAdapter<MovieProperty,
        MovieAdapter.MoviePropertyViewHolder>(DiffCallback) {
    class MoviePropertyViewHolder(private var binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movieProperty: MovieProperty){
            //todo set up network first before binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MoviePropertyViewHolder {
        return MoviePropertyViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieAdapter.MoviePropertyViewHolder, position: Int) {
        val movieProperty = getItem(position)
        holder.bind(movieProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieProperty>(){
        override fun areItemsTheSame(oldItem: MovieProperty, newItem: MovieProperty): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MovieProperty, newItem: MovieProperty): Boolean {
            return oldItem.Title == newItem.Title
            //todo set up network first and finish later
        }
    }
}