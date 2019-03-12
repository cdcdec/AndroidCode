package com.cdc.androidcode.libraries.citypicker

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_city_picker_main.*
import com.zaaach.citypicker.model.LocateState
import com.zaaach.citypicker.model.LocatedCity
import com.zaaach.citypicker.CityPicker
import android.widget.Toast
import com.zaaach.citypicker.adapter.OnPickListener
import com.zaaach.citypicker.model.City
import com.zaaach.citypicker.model.HotCity





class CityPickerMainActivity : BaseActivity() {

    private val key = "current_theme"

    private var themeTemp: Int = 0

    private var enable: Boolean = false

    private var hotCities: ArrayList<HotCity>? = ArrayList()
    private var anim: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            themeTemp = savedInstanceState.getInt(key)
            if (themeTemp > 0) {
                setTheme(themeTemp)
            } else {
                setTheme(R.style.DefaultCityPickerTheme)
            }

        }
        setBackBtn()
        setTitle("City Picker")
        setContentView(R.layout.activity_city_picker_main)

        if (themeTemp == R.style.DefaultCityPickerTheme) {
            btn_style.text = "默认主题"
        } else if (themeTemp == R.style.CustomTheme) {
            btn_style.text = "自定义主题"
        }

        init()


    }

    private fun init() {
        btn_style.setOnClickListener(this)
        btn_pick.setOnClickListener(this)


        cb_hot.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                hotCities!!.add(HotCity("北京", "北京", "101010100"))
                hotCities!!.add(HotCity("北京", "北京", "101010100"))
                hotCities!!.add(HotCity("上海", "上海", "101020100"))
                hotCities!!.add(HotCity("广州", "广东", "101280101"))
                hotCities!!.add(HotCity("深圳", "广东", "101280601"))
                hotCities!!.add(HotCity("杭州", "浙江", "101210101"))
            } else {
                hotCities = null
            }
        }

        cb_anim.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                anim = R.style.CustomAnim
            } else {
                anim = R.style.DefaultCityPickerAnimation
            }
        }

        cb_enable_anim.setOnCheckedChangeListener{buttonView, isChecked ->

            enable = isChecked

        }


    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when (view!!.id) {
            R.id.btn_style -> {
                if (btn_style.text.toString().startsWith("自定义")) {
                    btn_style.text = "默认主题"
                    themeTemp = R.style.DefaultCityPickerTheme
                } else if (btn_style.text.toString().startsWith("默认")) {
                    btn_style.text = "自定义主题"
                    themeTemp = R.style.CustomTheme
                }
                recreate()
            }
            R.id.btn_pick -> {
                CityPicker.from(this@CityPickerMainActivity)
                    .enableAnimation(enable)
                    .setAnimationStyle(anim)
                    .setLocatedCity(null)
                    .setHotCities(hotCities)
                    .setOnPickListener(object : OnPickListener {
                        override fun onPick(position: Int, data: City) {
                            tv_current.text = String.format("当前城市：%s，%s", data.name, data.code)
                            Toast.makeText(
                                applicationContext,
                                String.format("点击的数据：%s，%s", data.name, data.code),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        override fun onCancel() {
                            Toast.makeText(applicationContext, "取消选择", Toast.LENGTH_SHORT).show()
                        }

                        override fun onLocate() {
                            //开始定位，这里模拟一下定位
                            Handler().postDelayed({
                                CityPicker.from(this@CityPickerMainActivity)
                                    .locateComplete(LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS)
                            }, 3000)
                        }
                    })
                    .show()
            }

        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(key, themeTemp)
    }


}
