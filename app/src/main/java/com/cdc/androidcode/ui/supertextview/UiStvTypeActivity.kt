package com.cdc.androidcode.ui.supertextview

import android.graphics.drawable.Drawable
import android.support.v7.widget.Toolbar
import android.view.Gravity
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.ui_stv_type0_activity.*
import kotlinx.android.synthetic.main.ui_stv_type6_activity.*
import com.bumptech.glide.Glide
import com.cdc.androidcode.common.GlideApp
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ui_stv_type5_activity.*
import com.bumptech.glide.request.target.*
import com.bumptech.glide.request.transition.Transition
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.ui_stv_type1_activity.*
import kotlinx.android.synthetic.main.ui_stv_type2_activity.*
import kotlinx.android.synthetic.main.ui_stv_type3_activity.*
import kotlinx.android.synthetic.main.ui_stv_type4_activity.*
import kotlinx.android.synthetic.main.ui_stv_type7_activity.*
import kotlinx.android.synthetic.main.ui_stv_type8_activity.*

class UiStvTypeActivity : BaseActivity() {

    var type: Int = 0

    var url1 = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG"
    var url2 = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=219781665,3032880226&fm=80&w=179&h=119&img.JPEG"
    var url3 = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG"
    var url4 = "http://osnoex6vf.bkt.clouddn.com/original_label.png"

    override fun initView() {
        when(type){
            0->{
                setDiv_stv.setTopDividerLineColor(resources.getColor(R.color.colorAccent))
                    .setBottomDividerLineColor(resources.getColor(R.color.colorPrimary))
                leftArrow(toolbarType0)
            }
            1->{
                leftArrow(toolbarType1)
            }
            2->{
                leftArrow(toolbarType2)
            }
            3->{
                leftArrow(toolbarType3)
            }
            4->{
                leftArrow(toolbarType4)
            }
            5->{
                leftArrow(toolbarType5)
                Picasso.get()
                    .load(url1)
                    .placeholder(com.cdc.androidcode.R.mipmap.head_default)
                    .into(super_tv1.leftIconIV)
                GlideApp.with(this)
                    .load(url2)
                    .placeholder(R.mipmap.head_default)
                    .fitCenter()
                    .into(super_tv2.rightIconIV)


                GlideApp.with(this)
                    .load(url3)
                    .placeholder(R.mipmap.head_default)
                    .into(object: SimpleTarget<Drawable>() {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            super_tv3.setRightTvDrawableRight(resource)
                        }
                    })




                Glide.with(this)
                    .load(url4)
                    .into(object : SimpleTarget<Drawable>() {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            alipay_stv_5.setLeftTvDrawableRight(resource)
                        }
                    })



            }
            6->{
                leftArrow(toolbarType6)
                super_tv4.setCenterTextGravity(Gravity.LEFT)
            }
            7->{
                leftArrow(toolbarType7)
            }
            8->{
                leftArrow(toolbarType8)
            }
        }
    }

    override fun initData() {

    }

    private fun leftArrow(toolBar:Toolbar){
        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolBar.setNavigationOnClickListener{
            finish()
        }
    }

    override fun layoutId(): Int {
        type = intent.getIntExtra("type", 0)
        when (type) {
            0 -> {
                return R.layout.ui_stv_type0_activity
            }
            1 -> {
                return R.layout.ui_stv_type1_activity
            }
            2 -> {
                return R.layout.ui_stv_type2_activity
            }
            3 -> {
                return R.layout.ui_stv_type3_activity
            }
            4 -> {
                return R.layout.ui_stv_type4_activity
            }
            5 -> {
                return R.layout.ui_stv_type5_activity
            }
            6 -> {
                return R.layout.ui_stv_type6_activity
            }
            7 -> {
                return R.layout.ui_stv_type7_activity
            }
            8 -> {
                return R.layout.ui_stv_type8_activity
            }
        }

        return R.layout.ui_stv_type_activity
    }

    override fun initImmersionBar() {
        super.initImmersionBar()
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).init()
    }


}


