package com.cdc.androidcode.ui.supertextview
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.ui_stv_activity_main.*

class UiStvMainActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        var intent= Intent()
        if (v != null) {
            when(v.id){
                com.cdc.androidcode.R.id.button0->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 0)
                    startActivity(intent)
                }
                R.id.button1->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 1)
                    startActivity(intent)
                }
                R.id.button2->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 2)
                    startActivity(intent)
                }
                R.id.button3->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 3)
                    startActivity(intent)
                }
                R.id.button4->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 4)
                    startActivity(intent)
                }
                R.id.button5->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 5)
                    startActivity(intent)
                }
                R.id.button6->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 6)
                    startActivity(intent)
                }
                R.id.button7->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 7)
                    startActivity(intent)
                }
                R.id.button8->{
                    intent.setClass(this, UiStvTypeActivity::class.java)
                    intent.putExtra("type", 8)
                    startActivity(intent)
                }
                R.id.list_button->{
                    intent.setClass(this, UiStvListActivity::class.java)
                    startActivity(intent)
                }
                R.id.click_button->{
                    intent.setClass(this, UiStvClickActivity::class.java)
                    startActivity(intent)
                }
                R.id.super_button->{
                    intent.setClass(this, UiStvSuperButtonActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Ui Stv Main")

        setContentView(R.layout.ui_stv_activity_main)
        //所有组合
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        list_button.setOnClickListener(this)
        click_button.setOnClickListener(this)
        super_button.setOnClickListener(this)

    }










}
