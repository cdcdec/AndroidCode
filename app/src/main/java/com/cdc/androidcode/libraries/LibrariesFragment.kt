package com.cdc.androidcode.libraries

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.cdc.androidcode.application.RecycleViewDivider
import com.cdc.androidcode.libraries.glide.GlideMainActivity
import com.cdc.androidcode.ui.UIItemAdapter
import com.cdc.androidcode.ui.UIItemBean
import com.cdc.androidcode.ui.supertextview.UiStvMainActivity
import kotlinx.android.synthetic.main.fresh_scroll_recy_common.*

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:58
 * updateDesc:(修改内容)
 */
class LibrariesFragment:BaseFragment() {
    private lateinit var uiAdapter: UIItemAdapter
    override fun initImmersionBar() {

    }

    override fun layoutId(): Int {
        return R.layout.fresh_scroll_recy_common
    }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(RecycleViewDivider(activity, LinearLayoutManager.VERTICAL, R.drawable.shape_recycleview_divider))
    }

    override fun initData() {
        var list:MutableList<UIItemBean> =ArrayList()
        list.add(UIItemBean("Glide","Glide1"))
        uiAdapter= UIItemAdapter(R.layout.ui_item,list)
        recyclerView.adapter=uiAdapter
        uiAdapter.setOnItemClickListener { adapter, view, position ->
            var intent= Intent(view.context, GlideMainActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}