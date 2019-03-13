package com.cdc.androidcode.libraries.recy_divider
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.androidcode.libraries.recy_divider.itemdecoration.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.activity_recy_divider_main.*

class DrawableDividerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("RecyclerView分割线 Drawable")
        setContentView(R.layout.activity_recy_divider_main)

        var adapter=DividerAdapter(this)
        var manager= LinearLayoutManager(this)
        manager.orientation= RecyclerView.VERTICAL
        recyclerViewDividerMain.layoutManager=manager
        recyclerViewDividerMain.adapter=adapter
        recyclerViewDividerMain.addItemDecoration(
            HorizontalDividerItemDecoration.Builder(this)
                .drawable(R.drawable.cat)
                .size(15)
                .build()
        )
    }
}
