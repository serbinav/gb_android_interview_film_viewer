package com.example.filmslist

import android.graphics.Point
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun usePicassoToLoadPhoto(
    imageView: ImageView,
    imageLink: String,
    priority: Picasso.Priority = Picasso.Priority.LOW
) {
    Picasso.get().load(imageLink)
        .placeholder(R.drawable.loading_placeholder).fit()
        .priority(priority)
        .into(imageView, object : Callback {
            override fun onSuccess() {
            }

            override fun onError(e: Exception?) {
                imageView.setImageResource(R.drawable.ic_baseline_error_outline_24)
            }
        })
}

fun getDisplayWidthSize(windowManager: WindowManager): Int {
    val width: Int

    if (android.os.Build.VERSION.SDK_INT >= 30) {
        val metrics = windowManager.currentWindowMetrics
        val windowInsets = metrics.windowInsets
        val insets = windowInsets.getInsetsIgnoringVisibility(
            WindowInsets.Type.navigationBars()
                    or WindowInsets.Type.displayCutout()
        )

        val insetsWidth = insets.right + insets.left

        val bounds = metrics.bounds
        width = bounds.width() - insetsWidth
    } else {
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        width = size.x
    }
    return width
}