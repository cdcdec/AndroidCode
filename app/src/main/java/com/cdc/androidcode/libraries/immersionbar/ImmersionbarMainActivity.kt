package com.cdc.androidcode.libraries.immersionbar
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_immersionbar_main.*
class ImmersionbarMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Immersionbar")
        setContentView(R.layout.activity_immersionbar_main)

        initView()
    }

    private fun initView(){
        topIvStatusBarBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        var intent= Intent()
        when(view?.id){
            R.id.topIvStatusBarBtn->{
                intent.setClass(this@ImmersionbarMainActivity,TopIvImmerBarActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
