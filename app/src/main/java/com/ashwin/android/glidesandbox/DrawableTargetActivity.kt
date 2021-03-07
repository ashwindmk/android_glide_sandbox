package com.ashwin.android.glidesandbox

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ashwin.android.glidesandbox.databinding.ActivityDrawableTargetBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition

class DrawableTargetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDrawableTargetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawableTargetBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        loadDrawableTarget()
    }

    private fun loadDrawableTarget() {
        val drawableTarget = object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                Log.d(TAG, "CustomTarget: onResourceReady: drawable: $resource, size: ${resource.intrinsicWidth} x ${resource.intrinsicHeight}")
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                Log.d(TAG, "CustomTarget: onLoadCleared: placeholder: $placeholder, size: ${placeholder?.intrinsicWidth} x ${placeholder?.intrinsicHeight}")
            }
        }

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
            .into(drawableTarget)
    }
}