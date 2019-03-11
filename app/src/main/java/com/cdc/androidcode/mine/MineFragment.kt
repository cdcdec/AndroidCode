package com.cdc.androidcode.mine
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:59
 * updateDesc:(修改内容)
 */
class MineFragment:BaseFragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MinReAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var activityList= arrayOf(DeviceActivity::class.java)

    override fun initView() {
        //设置布局管理器
        viewManager= LinearLayoutManager(this.context)
        //设置为垂直布局，这也是默认的
        (viewManager as LinearLayoutManager).orientation=RecyclerView.VERTICAL
        var strs= arrayOf("我的设备")
        viewAdapter=MinReAdapter(strs)
        //这里的R.id.recyclerView_mine  名称要唯一  否则这样写可能加载不到对应的布局文件  显示错乱 ？？
        recyclerView= this.activity!!.findViewById<RecyclerView>(R.id.recyclerView_mine).apply{
            //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
            setHasFixedSize(true)
            layoutManager=viewManager
            adapter=viewAdapter
        }
        viewAdapter.setOnItemClickListener(object:MinReAdapter.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                var intent=Intent(this@MineFragment.activity,activityList[position])
                startActivity(intent)
            }

        })
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.mine_fragment
    }
}

