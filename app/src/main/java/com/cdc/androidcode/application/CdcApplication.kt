package com.cdc.androidcode.application

import android.app.Application

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)13:30
 * updateDesc:(修改内容)
 */
class CdcApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        RudenessScreenHelper(this, 750f).activate() //初始化百分比布局
    }
}