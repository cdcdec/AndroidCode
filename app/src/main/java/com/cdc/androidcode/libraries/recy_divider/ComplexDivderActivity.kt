package com.cdc.androidcode.libraries.recy_divider

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.androidcode.libraries.recy_divider.itemdecoration.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.activity_recy_divider_main.*

class ComplexDivderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("RecyclerView分割线 Complex")
        setContentView(R.layout.activity_recy_divider_main)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            recyclerViewDividerMain.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }

        var adapter = DividerComplexAdapter(this)
        var manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.VERTICAL
        recyclerViewDividerMain.layoutManager = manager
        recyclerViewDividerMain.adapter = adapter
        recyclerViewDividerMain.addItemDecoration(
            HorizontalDividerItemDecoration.Builder(this)
                .paintProvider(adapter)
                .visibilityProvider(adapter)
                .marginProvider(adapter)
                .build()
        )

    }

}
