package com.ashwin.android.glidesandbox

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.module.AppGlideModule
import java.io.File
import java.io.IOException

@GlideModule
class GlideAppModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        Log.d(TAG, "GlideAppModule: registerComponents")
//        registry.prepend(File::class.java, BitmapFactory.Options::class.java, BitmapSizeDecoder())
//        registry.register(BitmapFactory.Options::class.java, MyData::class.java, OptionsSizeResourceTranscoder())
    }
}
