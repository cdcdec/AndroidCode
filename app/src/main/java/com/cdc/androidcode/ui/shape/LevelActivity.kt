package com.cdc.androidcode.ui.shape
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import android.widget.Toast
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_level.*
class LevelActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Shape Level")
        setContentView(R.layout.activity_level)
    }
    fun sure(view: View) {
        val levelText = et_level.text.toString()
        if (TextUtils.isEmpty(levelText)) {
            Toast.makeText(this, "level can't empty", Toast.LENGTH_SHORT).show()
            return
        }
        val level = Integer.parseInt(levelText)
        val drawable = imageView.drawable
        if (drawable != null) {
            drawable!!.level = level
        }
    }
}
