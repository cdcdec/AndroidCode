package com.cdc.androidcode.libraries.recy_divider
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.androidcode.libraries.recy_divider.itemdecoration.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.activity_recy_divider_main.*
class PaintDividerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("RecyclerView分割线 Paint")
        setContentView(R.layout.activity_recy_divider_main)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            recyclerViewDividerMain.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
        var adapter=DividerAdapter(this)
        var manager= LinearLayoutManager(this)
        manager.orientation= RecyclerView.VERTICAL
        recyclerViewDividerMain.layoutManager=manager
        recyclerViewDividerMain.adapter=adapter

        val paint = Paint()
        paint.strokeWidth = 5f
        paint.color = Color.BLUE
        paint.isAntiAlias = true
        //画虚线 DashPathEffect
        paint.pathEffect = DashPathEffect(floatArrayOf(25.0f, 25.0f), 0f)
        recyclerViewDividerMain.addItemDecoration(
            HorizontalDividerItemDecoration.Builder(this)
                .paint(paint)
                .showLastDivider()
                .build()
        )
    }
}
