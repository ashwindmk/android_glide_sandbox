package com.ashwin.android.glidesandbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openRemoteImage(view: View) {
        startActivity(Intent(this, RemoteImageActivity::class.java))
    }

    fun openDownloadOnly(view: View) {
        startActivity(Intent(this, DownloadOnlyActivity::class.java))
    }

    fun openGetResolution(view: View) {
        startActivity(Intent(this, GetResolutionActivity::class.java))
    }

    fun openDrawableTarget(view: View) {
        startActivity(Intent(this, DrawableTargetActivity::class.java))
    }

    fun openCustomTarget(view: View) {
        startActivity(Intent(this, CustomTargetActivity::class.java))
    }
}
