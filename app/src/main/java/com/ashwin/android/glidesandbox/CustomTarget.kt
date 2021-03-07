package com.ashwin.android.glidesandbox

import android.graphics.BitmapFactory
import android.os.Parcelable
import android.util.Log
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder
import kotlinx.android.parcel.Parcelize
import java.io.File
import java.io.IOException

@Parcelize
data class MyData(val width: Int, val height: Int) : Parcelable

class BitmapSizeDecoder : ResourceDecoder<File, BitmapFactory.Options> {
    @Throws(IOException::class)
    override fun handles(file: File, options: Options): Boolean {
        Log.d(TAG, "BitmapSizeDecoder: handles")
        return true
    }

    override fun decode(file: File, width: Int, height: Int, options: Options): Resource<BitmapFactory.Options>? {
        Log.d(TAG, "BitmapSizeDecoder: decode")
        val bmOptions: BitmapFactory.Options = BitmapFactory.Options()
        bmOptions.inJustDecodeBounds = true
        BitmapFactory.decodeFile(file.absolutePath, bmOptions)
        return SimpleResource(bmOptions)
    }
}

class OptionsSizeResourceTranscoder : ResourceTranscoder<BitmapFactory.Options, MyData> {
    override fun transcode(resource: Resource<BitmapFactory.Options>, options: Options): Resource<MyData> {
        Log.d(TAG, "OptionsSizeResourceTranscoder: transcode")
        val bmOptions = resource.get()
        val size = MyData(bmOptions.outWidth, bmOptions.outHeight)
        return SimpleResource(size)
    }
}
