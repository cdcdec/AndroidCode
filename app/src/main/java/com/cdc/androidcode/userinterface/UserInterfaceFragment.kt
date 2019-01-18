package com.cdc.androidcode.userinterface

import android.support.v7.widget.LinearLayoutManager
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.cdc.androidcode.application.RecycleViewDivider
import kotlinx.android.synthetic.main.fragment_userinterface.*

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:59
 * updateDesc:(修改内容)
 */
class UserInterfaceFragment:BaseFragment() {
    override fun initImmersionBar() {

    }

    override fun layoutId(): Int {
       return  R.layout.fragment_userinterface
    }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(RecycleViewDivider(activity, LinearLayoutManager.VERTICAL, R.drawable.shape_recycleview_divider))
    }

    override fun initData() {

    }
}