package com.ashwin.android.glidesandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashwin.android.glidesandbox.databinding.ActivityRemoteimageBinding
import com.bumptech.glide.Glide

class RemoteImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRemoteimageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRemoteimageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        loadImage()
    }

    private fun loadImage() {
        Glide.with(this)
            .load(IMAGE_1)
            .into(binding.remoteImageView)
    }
}
