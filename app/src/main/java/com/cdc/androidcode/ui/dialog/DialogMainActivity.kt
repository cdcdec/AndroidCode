package com.cdc.androidcode.ui.dialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import kotlinx.android.synthetic.main.activity_dialog_main.*
import android.view.Gravity
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Toast
import com.cdc.androidcode.R
import com.cdc.androidcode.utils.BarUtils
import com.cdc.androidcode.utils.ConvertUtils
import com.scwang.smartrefresh.layout.util.DensityUtil
class DialogMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("对话框")
        setContentView(R.layout.activity_dialog_main)

        initView()

    }

    private fun initView(){
        btnBottomDialog1.setOnClickListener(this)
        btnBottomCornerDialog1.setOnClickListener(this)
        btnBottomScrollDialog1.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when(view?.id){
            R.id.btnBottomDialog1->{
                val bottomDialog = Dialog(this, R.style.BottomDialog)
                val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_normal, null)
                bottomDialog.setContentView(contentView)
                val layoutParams = contentView.layoutParams
                layoutParams.width = resources.displayMetrics.widthPixels
                contentView.layoutParams = layoutParams
                bottomDialog.window.setGravity(Gravity.BOTTOM)
                bottomDialog.setCanceledOnTouchOutside(true)
                bottomDialog.window.setWindowAnimations(R.style.BottomDialog_Animation)
                bottomDialog.show()
            }
            R.id.btnBottomCornerDialog1->{
                val bottomDialog = Dialog(this, R.style.BottomDialog)
                val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_circle, null)
                bottomDialog.setContentView(contentView)
                val params = contentView.layoutParams as ViewGroup.MarginLayoutParams
                params.width = resources.displayMetrics.widthPixels - ConvertUtils.dp2px( 16f)
                params.bottomMargin = ConvertUtils.dp2px( 8f)
                contentView.layoutParams = params
                bottomDialog.setCanceledOnTouchOutside(true)
                bottomDialog.window.setGravity(Gravity.BOTTOM)
                bottomDialog.window.setWindowAnimations(R.style.BottomDialog_Animation)
                bottomDialog.show()
            }
            R.id.btnBottomScrollDialog1->{
                val bottomDialog = Dialog(this, R.style.BottomDialog)
                val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_scroll, null)
                bottomDialog.setContentView(contentView)
                val params = contentView.layoutParams as ViewGroup.MarginLayoutParams
                params.width = resources.displayMetrics.widthPixels - ConvertUtils.dp2px( 16f)
                params.height=resources.displayMetrics.heightPixels-BarUtils.getActionBarHeight()-BarUtils.getStatusBarHeight()-ConvertUtils.dp2px( 8f)
                params.bottomMargin = ConvertUtils.dp2px( 8f)
                contentView.layoutParams = params
                bottomDialog.setCanceledOnTouchOutside(true)
                bottomDialog.window.setGravity(Gravity.BOTTOM)
                bottomDialog.window.setWindowAnimations(R.style.BottomDialog_Animation)
                bottomDialog.show()
            }
        }
    }


}
