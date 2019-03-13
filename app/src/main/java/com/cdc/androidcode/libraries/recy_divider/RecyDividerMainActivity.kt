package com.cdc.androidcode.libraries.recy_divider
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ActivityUtils
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import com.cdc.androidcode.libraries.recy_divider.itemdecoration.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.activity_recy_divider_main.*
class RecyDividerMainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("RecyclerView分割线")
        setContentView(R.layout.activity_recy_divider_main)

        var adapter=DividerAdapter(this)
        var manager=LinearLayoutManager(this)
        manager.orientation=RecyclerView.VERTICAL
        recyclerViewDividerMain.layoutManager=manager
        recyclerViewDividerMain.adapter=adapter
        var decoration= HorizontalDividerItemDecoration.Builder(this)
            .margin(20,20)
            .showLastDivider()
            .size(15)
            .positionInsideItem(true)
            .color(R.color.colorPrimary)
            .build()
        recyclerViewDividerMain.addItemDecoration(decoration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.recyclerview_divider_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val i = item.itemId
        if (i == R.id.action_paint) {
            ActivityUtils.startActivity(PaintDividerActivity::class.java)
            return true
        } else if (i == R.id.action_drawable) {
            ActivityUtils.startActivity(DrawableDividerActivity::class.java)
            return true
        } else if (i == R.id.action_complex) {
            ActivityUtils.startActivity(ComplexDivderActivity::class.java)
            return true
        } else if (i == R.id.action_simple_grid) {
            ActivityUtils.startActivity(SimpleGridDividerActivity::class.java)
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }



}
