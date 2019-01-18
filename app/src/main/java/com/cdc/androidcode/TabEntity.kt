package com.cdc.androidcode

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)10:59
 * updateDesc:(修改内容)
 */
class TabEntity constructor(title: String, component_check: Int, component: Int) :CustomTabEntity {
    private var title: String = title
    private var component_check: Int = component_check
    private var component: Int = component
    override fun getTabUnselectedIcon(): Int {
        return component
    }

    override fun getTabSelectedIcon(): Int {
        return component_check
    }

    override fun getTabTitle(): String {
        return title
    }
}