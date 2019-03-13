package com.cdc.androidcode.libraries.recy_divider
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.androidcode.libraries.recy_divider.itemdecoration.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.activity_recy_divider_main.*

class SimpleGridDividerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("RecyclerView分割线 Grid")
        setContentView(R.layout.activity_recy_divider_main)

        var adapter=DividerAdapter(this)
        var manager= GridLayoutManager(this,3)
        manager.orientation= RecyclerView.VERTICAL
        recyclerViewDividerMain.layoutManager=manager
        recyclerViewDividerMain.adapter=adapter
        recyclerViewDividerMain.addItemDecoration(HorizontalDividerItemDecoration.Builder(this).build())



    }
}
