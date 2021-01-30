package com.hanamin.alaa.ui.view.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hanamin.alaa.R

@BindingAdapter("listImage", "cacheMode")
fun bindImage(imageView: ImageView, url: String?, cacheMode: Boolean) {
    if (cacheMode) {
        Glide
            .with(imageView.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)

    } else {
        Glide
            .with(imageView.context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}
