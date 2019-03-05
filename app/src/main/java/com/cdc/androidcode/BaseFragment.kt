package com.cdc.androidcode

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gyf.barlibrary.ImmersionOwner

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:29
 * updateDesc:(修改内容)
 */
abstract class BaseFragment : Fragment(), ImmersionOwner{

    /**
     * Fragment代理类
     */
    private val mFragmentProxy = FragmentProxy(this@BaseFragment)
    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(layoutId(), null)
        return rootView
    }

    abstract fun layoutId(): Int

    abstract fun initView()
    abstract fun initData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        mFragmentProxy.onDestroy()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mFragmentProxy.setUserVisibleHint(isVisibleToUser)
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFragmentProxy.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mFragmentProxy.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        mFragmentProxy.onResume()
    }

    override fun onPause() {
        super.onPause()
        mFragmentProxy.onPause()
    }


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        mFragmentProxy.onHiddenChanged(hidden)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mFragmentProxy.onConfigurationChanged(newConfig)
    }

    /**
     * 懒加载，在view初始化完成之前执行
     * On lazy after view.
     */
    override fun onLazyBeforeView() {}

    /**
     * 懒加载，在view初始化完成之后执行
     * On lazy before view.
     */
    override fun onLazyAfterView() {}

    /**
     * Fragment用户可见时候调用
     * On visible.
     */
    override fun onVisible() {}

    /**
     * Fragment用户不可见时候调用
     * On invisible.
     */
    override fun onInvisible() {}

    /**
     * 是否可以实现沉浸式，当为true的时候才可以执行initImmersionBar方法
     * Immersion bar enabled boolean.
     *
     * @return the boolean
     */
    override fun immersionBarEnabled(): Boolean {
        return true
    }
}