package com.cdc.androidcode.ui.shape
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R

class ShapeBitmapActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Shape Bitmap State Inset Transtion")
        setContentView(R.layout.activity_shape_bitmap)
    }
}
