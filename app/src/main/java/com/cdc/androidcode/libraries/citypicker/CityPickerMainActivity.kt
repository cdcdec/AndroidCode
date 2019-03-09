package com.cdc.androidcode.libraries.citypicker
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R

class CityPickerMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("City Picker")
        setContentView(R.layout.activity_city_picker_main)
    }
}
