package com.cdc.androidcode.ui.shape
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_scale.*

class ScaleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("shape scale")
        setContentView(R.layout.activity_scale)
        image30.setImageLevel(1)
        image50.setImageLevel(1)
        image80.setImageLevel(1)
    }
}
