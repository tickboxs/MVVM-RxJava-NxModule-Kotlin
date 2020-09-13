package com.tickboxs.base.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tickboxs.base.R

object GlideUtil {

    fun loadImage(context: Context, url:String, imageView: ImageView) {
        Glide.with(context)
            .load(url)
            .centerCrop()
            .into(imageView)
    }

    fun loadImageFitCenter(context:Context,url:String,imageView: ImageView) {
        Glide.with(context)
            .load(url)
            .fitCenter()
            .into(imageView)
    }

    fun loadUrlImage(context:Context,url:String,imageView:ImageView) {
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .into(imageView)
    }
}