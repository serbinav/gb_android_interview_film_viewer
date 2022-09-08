package com.example.filmslist

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun usePicassoToLoadPhoto(imageView: ImageView, imageLink: String) {
    Picasso.get().load(imageLink)
        .placeholder(R.drawable.no_img_200_200).fit().centerCrop()
        .into(imageView, object : Callback {
            override fun onSuccess() {
            }

            override fun onError(e: Exception?) {
                imageView.setImageResource(R.drawable.ic_baseline_error_outline_24)
            }
        })
}