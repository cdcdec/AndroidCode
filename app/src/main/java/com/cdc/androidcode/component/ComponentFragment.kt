package com.cdc.androidcode.component
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.gyf.barlibrary.ImmersionBar

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:25
 * updateDesc:(修改内容)
 */
class ComponentFragment: BaseFragment() {
    //沉浸式代码写着这里
    override fun initImmersionBar() {
        ImmersionBar.with(this)
            .reset()
            //设置状态栏颜色
            .statusBarColor(R.color.colorPrimary)
            .keyboardEnable(false)
            .init()
    }

    //返回false时  当前Fragment不实现沉浸式initImmersionBar()方法不执行
    override fun immersionBarEnabled(): Boolean {
        return true
    }

    override fun layoutId(): Int {
    return R.layout.component_fragment
    }

    override fun initView() {

    }

    override fun initData() {

    }




}