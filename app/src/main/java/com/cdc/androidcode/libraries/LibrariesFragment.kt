package com.cdc.androidcode.libraries

import afollestad.AfollestadDialogActivity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.cdc.androidcode.application.RecycleViewDivider
import com.cdc.androidcode.libraries.glide.GlideMainActivity
import com.cdc.androidcode.libraries.jpush.JpushMainActivity
import com.cdc.androidcode.libraries.update.UpdateMainActivity
import com.cdc.androidcode.ui.UIItemAdapter
import com.cdc.androidcode.ui.UIItemBean
import com.cdc.mapsearchlocation.MapSearchLocationMainActivity
import com.cdc.toasty.ToastSyleActivity
import com.cdc.toasty.ToastyMainActivity
import com.chad.baserecyclerviewadapterhelper.BaseRecyclerViewAdapterHelperActivity
import com.chad.baserecyclerviewadapterhelper.HomeActivity
import com.yqritc.recyclerviewflexibledivider.sample.SimpleActivity
import kotlinx.android.synthetic.main.fresh_scroll_recy_common.*

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)11:58
 * updateDesc:(修改内容)
 */
class LibrariesFragment : BaseFragment() {
    private lateinit var uiAdapter: UIItemAdapter
    override fun initImmersionBar() {

    }

    override fun layoutId(): Int {
        return R.layout.fresh_scroll_recy_common
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
        list.add(UIItemBean("Glide", "Glide1", GlideMainActivity::class.java))
        list.add(UIItemBean("Jpush", "Jpush", JpushMainActivity::class.java))
        list.add(
            UIItemBean(
                "Update",
                "https://github.com/Lee465357793/AppUpdateDialog",
                UpdateMainActivity::class.java
            )
        )
        list.add(
            UIItemBean(
                "baserecyclerviewadapterhelper",
                "https://github.com/CymChad/BaseRecyclerViewAdapterHelper",
                BaseRecyclerViewAdapterHelperActivity::class.java
            )
        )

        list.add(
            UIItemBean(
                "flexibledivider",
                "https://github.com/yqritc/RecyclerView-FlexibleDivider",
                SimpleActivity::class.java
            )
        )

        list.add(
            UIItemBean(
                "高德地图搜索定位",
                "https://lbs.amap.com",
                MapSearchLocationMainActivity::class.java
            )
        )

        list.add(
            UIItemBean(
                "Toasty",
                "https://github.com/GrenderG/Toasty",
                ToastyMainActivity::class.java
            )
        )

        list.add(
            UIItemBean(
                "StyleableToast",
                "https://github.com/Muddz/StyleableToast",
                ToastSyleActivity::class.java
            )
        )

        list.add(
            UIItemBean(
                "afollestad Dialog",
                "https://github.com/afollestad/material-dialogs",
                AfollestadDialogActivity::class.java
            )
        )

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