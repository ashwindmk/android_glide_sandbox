package com.ashwin.android.glidesandbox

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ashwin.android.glidesandbox.databinding.ActivityCustomTargetBinding
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition

class CustomTargetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomTargetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomTargetBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        loadImage()
    }

    private fun loadImage() {
        val target = object : CustomTarget<MyData>() {
            override fun onResourceReady(resource: MyData, transition: Transition<in MyData>?) {
                Log.d(TAG, "CustomTarget: onResourceReady: drawable: $resource, size: ${resource.width} x ${resource.height}")
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                Log.d(TAG, "CustomTarget: onLoadCleared: placeholder: $placeholder, size: ${placeholder?.intrinsicWidth} x ${placeholder?.intrinsicHeight}")
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                Log.d(TAG, "CustomTarget: onLoadFailed: error: $errorDrawable, size: ${errorDrawable?.intrinsicWidth} x ${errorDrawable?.intrinsicHeight}")
            }
        }

        // Uses GlideModule
        GlideApp.with(this)
            .`as`(MyData::class.java)
            .load(IMAGE_1)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .skipMemoryCache(true)
            .listener(object : RequestListener<MyData> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<MyData>?, isFirstResource: Boolean): Boolean {
                    Log.e(TAG, "CustomTarget: Error in request", e)
                    return false
                }

                override fun onResourceReady(resource: MyData?, model: Any?, target: com.bumptech.glide.request.target.Target<MyData>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    // Actual size of the image
                    Log.d(TAG, "CustomTarget: onResourceReady: data: $dataSource, size: ${resource?.width} x ${resource?.height}")
                    return false
                }
            })
            .into(target)
    }
}
