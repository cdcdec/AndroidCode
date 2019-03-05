package com.cdc.androidcode.ui
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.cdc.androidcode.application.RecycleViewDivider
import com.cdc.androidcode.ui.supertextview.UiStvMainActivity
import kotlinx.android.synthetic.main.fresh_scroll_recy_common.*

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
       return  R.layout.fresh_scroll_recy_common
    }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(RecycleViewDivider(activity, LinearLayoutManager.VERTICAL, R.drawable.shape_recycleview_divider))
    }



    override fun initData() {
        var list:MutableList<UIItemBean> =ArrayList()
        list.add(UIItemBean("SuperTextView","SuperTextView,CommonTextView继承RelativeLayout,SuperButton继承Button\n https://github.com/lygttpod/SuperTextView",UiStvMainActivity::class.java))
        uiAdapter= UIItemAdapter(R.layout.ui_item,list)
        recyclerView.adapter=uiAdapter
        uiAdapter.setOnItemClickListener { adapter, view, position ->
            var intent= Intent(view.context, list[position].clas)
            view.context.startActivity(intent)
        }

    }
}