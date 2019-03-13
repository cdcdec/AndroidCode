package com.cdc.androidcode.ui.toast
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_styleable_toast.*


class StyleableToastActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("ToastStyleable")
        setContentView(R.layout.activity_styleable_toast)
        btnToast1.setOnClickListener(this)
        btnToast2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when(view!!.id){
            R.id.btnToast1->{
                StyleableToast.Builder(this@StyleableToastActivity)
                    .cornerRadius(3)
                    .backgroundColor(resources.getColor(R.color.colorPrimary))
                    .text("Toast")
                    .iconStart(R.mipmap.add_icon)
                    .iconEnd(R.mipmap.buy_icon)
                    .textColor(resources.getColor(R.color.white_text_color))
                    .textSize(16.0f)
                    .show()
            }
            R.id.btnToast2->{

            }
        }
    }
}
