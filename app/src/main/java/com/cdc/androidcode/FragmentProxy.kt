package com.cdc.androidcode

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gyf.barlibrary.ImmersionBar
import com.gyf.barlibrary.ImmersionOwner

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:33
 * updateDesc:(修改内容)
 */
class FragmentProxy(fragment: Fragment) {
    /**
     * 要操作的Fragment对象
     */
    private var mFragment: Fragment? = fragment
    /**
     * 沉浸式实现接口
     */
    private var mImmersionOwner: ImmersionOwner? = null

    init {
        if (fragment is ImmersionOwner) {
            this.mImmersionOwner = fragment
        } else {
            throw IllegalArgumentException("Fragment请实现ImmersionOwner接口")
        }
    }



    /**
     * Fragment的view是否已经初始化完成
     */
    private var mIsActivityCreated: Boolean = false
    /**
     * 懒加载，是否已经在view初始化完成之前调用
     */
    private var mIsLazyAfterView: Boolean = false
    /**
     * 懒加载，是否已经在view初始化完成之后调用
     */
    private var mIsLazyBeforeView: Boolean = false

    fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (mFragment != null) {
            if (mFragment!!.getUserVisibleHint()) {
                if (!mIsLazyBeforeView) {
                    mImmersionOwner!!.onLazyBeforeView()
                    mIsLazyBeforeView = true
                }
                if (mIsActivityCreated) {
                    if (mFragment!!.getUserVisibleHint()) {
                        if (mImmersionOwner!!.immersionBarEnabled()) {
                            mImmersionOwner!!.initImmersionBar()
                        }
                        if (!mIsLazyAfterView) {
                            mImmersionOwner!!.onLazyAfterView()
                            mIsLazyAfterView = true
                        }
                        mImmersionOwner!!.onVisible()
                    }
                }
            } else {
                if (mIsActivityCreated) {
                    mImmersionOwner!!.onInvisible()
                }
            }
        }
    }

    fun onCreate(savedInstanceState: Bundle?) {
        if (mFragment != null && mFragment!!.getUserVisibleHint()) {
            if (!mIsLazyBeforeView) {
                mImmersionOwner!!.onLazyBeforeView()
                mIsLazyBeforeView = true
            }
        }
    }

    fun onActivityCreated(savedInstanceState: Bundle?) {
        mIsActivityCreated = true
        if (mFragment != null && mFragment!!.getUserVisibleHint()) {
            if (mImmersionOwner!!.immersionBarEnabled()) {
                mImmersionOwner!!.initImmersionBar()
            }
            if (!mIsLazyAfterView) {
                mImmersionOwner!!.onLazyAfterView()
                mIsLazyAfterView = true
            }
        }
    }

    fun onResume() {
        if (mFragment != null && mFragment!!.getUserVisibleHint()) {
            mImmersionOwner!!.onVisible()
        }
    }

    fun onPause() {
        if (mFragment != null) {
            mImmersionOwner!!.onInvisible()
        }
    }

    fun onDestroy() {
        if (mFragment != null && mFragment!!.getActivity() != null && mImmersionOwner!!.immersionBarEnabled()) {
            ImmersionBar.with(mFragment!!).destroy()
        }
        mFragment = null
        mImmersionOwner = null
    }

    fun onConfigurationChanged(newConfig: Configuration) {
        if (mFragment != null && mFragment!!.getUserVisibleHint()) {
            if (mImmersionOwner!!.immersionBarEnabled()) {
                mImmersionOwner!!.initImmersionBar()
            }
            mImmersionOwner!!.onVisible()
        }
    }

    fun onHiddenChanged(hidden: Boolean) {
        if (mFragment != null) {
            mFragment!!.setUserVisibleHint(!hidden)
        }
    }

    /**
     * 是否已经对用户可见
     * Is user visible hint boolean.
     *
     * @return the boolean
     */
    fun isUserVisibleHint(): Boolean {
        return if (mFragment != null) {
            mFragment!!.getUserVisibleHint()
        } else {
            false
        }
    }

}