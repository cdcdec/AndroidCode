package com.cdc.androidcode.libraries.materialDesign
import android.os.Bundle
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R

class MaterialDesignMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("MaterialDesign")
        setContentView(R.layout.activity_material_design_main)
    }
}
