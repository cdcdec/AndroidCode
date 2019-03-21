package com.cdc.androidcode.component
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.cdc.androidcode.application.RecycleViewDivider
import com.cdc.androidcode.component.foregroundService.ForegroundServiceMainActivity
import com.cdc.androidcode.ui.UIItemAdapter
import com.cdc.androidcode.ui.UIItemBean
import kotlinx.android.synthetic.main.fragment_library.*

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:25
 * updateDesc:(修改内容)
 */
class ComponentFragment: BaseFragment() {
    private lateinit var uiAdapter: UIItemAdapter


    override fun layoutId(): Int {
    return R.layout.component_fragment
    }
    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(
            RecycleViewDivider(
                activity,
                LinearLayoutManager.VERTICAL,
                R.drawable.shape_recycleview_divider
            )
        )
    }

    override fun initData() {
        var list: MutableList<UIItemBean> = ArrayList()
        list.add(UIItemBean("ForegroundService", "ForegroundService", ForegroundServiceMainActivity::class.java))
        uiAdapter = UIItemAdapter(R.layout.ui_item, list)
        recyclerView.adapter = uiAdapter
        uiAdapter.setOnItemClickListener { adapter, view, position ->
            run {
                var intent = Intent(view.context, list[position].clas)
                view.context.startActivity(intent)
            }

        }
    }



}