package com.cdc.androidcode.ui.shape
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_shape_main.*
import android.content.Intent
class ShapeMainActivity : BaseActivity() {
    //定义一个Map集合
    var clsMap=mutableMapOf<Int,Class<*>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("Shape")
        setContentView(R.layout.activity_shape_main)
        clsMap?.put(0, ShapeBitmapActivity::class.java)
        clsMap?.put(1,LevelActivity::class.java)
        clsMap?.put(2,NinePatchActivity::class.java)
        clsMap?.put(3,LayerActivity::class.java)
        clsMap?.put(4,ClipActivity::class.java)
        clsMap?.put(5,ScaleActivity::class.java)
        clsMap?.put(6,ShapeActivity::class.java)
        var adapter= ArrayAdapter<String>(this,R.layout.shape_list_item,R.id.name,resources.getStringArray(R.array.MyList))
        listView.onItemClickListener= AdapterView.OnItemClickListener{parent, view, position, id ->
            goToActivity(clsMap[position]!!)
        }
        listView.adapter=adapter
    }

    private fun goToActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }


}
