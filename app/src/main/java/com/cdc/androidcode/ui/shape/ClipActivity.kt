package com.cdc.androidcode.ui.shape
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_clip.*

class ClipActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Shape clipe")
        setContentView(R.layout.activity_clip)

        var clipDrawable=imageView.background
        clipDrawable.level=5000

        var clipDrawableRight=rightClip.background
        clipDrawableRight.level=5000


    }
}
