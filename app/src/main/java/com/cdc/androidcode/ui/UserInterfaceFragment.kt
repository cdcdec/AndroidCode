package com.cdc.androidcode.ui

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.cdc.androidcode.application.RecycleViewDivider
import kotlinx.android.synthetic.main.ui_fragment.*

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:59
 * updateDesc:(修改内容)
 */
class UserInterfaceFragment:BaseFragment() {
private lateinit var uiAdapter:UIItemAdapter
    override fun initImmersionBar() {

    }

    override fun layoutId(): Int {
       return  R.layout.ui_fragment
    }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(RecycleViewDivider(activity, LinearLayoutManager.VERTICAL, R.drawable.shape_recycleview_divider))
    }

    override fun initData() {
        var list:MutableList<UIItemBean> =ArrayList()
        list.add(UIItemBean("SuperTextView","SuperTextView Content"))
        uiAdapter= UIItemAdapter(R.layout.ui_item,list)
        recyclerView.adapter=uiAdapter
        uiAdapter.setOnItemClickListener { adapter, view, position ->
            var intent= Intent(view.context,UiSputerTextViewActivity::class.java)
            view.context.startActivity(intent)
        }

    }
}