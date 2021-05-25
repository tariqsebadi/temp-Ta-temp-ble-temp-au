package com.example.myapplication.binding

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.adapter.MovieAdapter
import com.example.myapplication.data.MovieProperty

@BindingAdapter("ListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MovieProperty>?){
    val adapter = recyclerView.adapter as MovieAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl.let {
        val imgUri = imgUrl?.toUri()?.buildUpon()?.scheme("https")?.build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animated)
                .error(R.drawable.ic_baseline_broken_image_24)
            )
            .into(imgView)
    }
}