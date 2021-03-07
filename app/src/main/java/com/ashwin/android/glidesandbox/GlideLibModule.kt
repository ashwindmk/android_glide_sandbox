package com.ashwin.android.glidesandbox

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.LibraryGlideModule
import java.io.File

@GlideModule
class GlideLibModule : LibraryGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        Log.d(TAG, "GlideLibModule: registerComponents")
        registry.prepend(File::class.java, BitmapFactory.Options::class.java, BitmapSizeDecoder())
        registry.register(BitmapFactory.Options::class.java, MyData::class.java, OptionsSizeResourceTranscoder())
    }
}
