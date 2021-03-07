package com.ashwin.android.glidesandbox

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ashwin.android.glidesandbox.databinding.ActivityGetresolutionBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target

class GetResolutionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetresolutionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetresolutionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        getSize()
    }

    private fun getSize() {
        Glide.with(this)
            .load(IMAGE_1)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    Log.e(TAG, "Error in request", e)
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    // Actual size of the image
                    Log.d(TAG, "onResourceReady: Got data: $dataSource, size: ${resource?.intrinsicWidth} x ${resource?.intrinsicHeight}")
                    return false
                }
            })
            .preload()
            //.into(binding.remoteImageView)
            .getSize(SizeReadyCallback { width, height ->
                // Size of the view
                Log.d(TAG, "SizeReadyCallback: $width x $height")
            })
    }
}
