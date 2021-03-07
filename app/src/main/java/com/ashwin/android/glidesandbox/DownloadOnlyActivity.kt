package com.ashwin.android.glidesandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ashwin.android.glidesandbox.databinding.ActivityDownloadOnlyBinding
import com.bumptech.glide.Glide

class DownloadOnlyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDownloadOnlyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadOnlyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        downloadOnly()
    }

    private fun downloadOnly() {
        val future = Glide.with(this)
            .downloadOnly()
            .load(IMAGE_1)
            .submit()

        Thread {
            val file = future.get()
            Log.d(TAG, "Downloaded file: ${file.path}")
        }.start()
    }
}