package com.cdc.androidcode.ui
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.cdc.androidcode.BaseFragment
import com.cdc.androidcode.R
import com.cdc.androidcode.application.RecycleViewDivider
import com.cdc.androidcode.ui.countdownview.CountDownViewMainActivity
import com.cdc.androidcode.ui.deawable.DrawerArrowActivity
import com.cdc.androidcode.ui.dialog.DialogMainActivity
import com.cdc.androidcode.ui.notifications.NotificationMainActivity
import com.cdc.androidcode.ui.shape.ShapeMainActivity
import com.cdc.androidcode.ui.supertextview.UiStvMainActivity
import com.cdc.androidcode.ui.toast.StyleableToastActivity
import com.cdc.androidcode.ui.toast.ToastMainActivity
import com.cdc.androidcode.ui.toolbar.CustomToolBar1Activity
import com.cdc.androidcode.ui.toolbar.ToolBar1Activity
import com.cdc.androidcode.ui.toolbar.Toolbar2Activity
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


    override fun layoutId(): Int {
       return  R.layout.ui_fragment
    }

    override fun initView() {
        recyclerViewUi.layoutManager = LinearLayoutManager(activity)
        recyclerViewUi.addItemDecoration(RecycleViewDivider(activity, LinearLayoutManager.VERTICAL, R.drawable.shape_recycleview_divider))
    }



    override fun initData() {
        var list:MutableList<UIItemBean> =ArrayList()
        list.add(UIItemBean("倒计时","https://github.com/iwgang/CountdownView",
            CountDownViewMainActivity::class.java))
        list.add(UIItemBean("对话框","对话框",
            DialogMainActivity::class.java))

        list.add(UIItemBean("Notification","Notification",
            NotificationMainActivity::class.java))

        list.add(UIItemBean("Shape Demo","Shape xml文件",
            ShapeMainActivity::class.java))

        list.add(UIItemBean("SuperTextView","SuperTextView,CommonTextView继承RelativeLayout,SuperButton继承Button\n https://github.com/lygttpod/SuperTextView",UiStvMainActivity::class.java))
        list.add(UIItemBean("Toolbar1","androidx.appcompat.widget.Toolbar",
            ToolBar1Activity::class.java))
        list.add(UIItemBean("Toolbar2","androidx.appcompat.widget.Toolbar",
            Toolbar2Activity::class.java))
        list.add(UIItemBean("CustomToolBar1","继承Toolbar实现",
            CustomToolBar1Activity::class.java))
        list.add(UIItemBean("DrawerArrow","继承Drawable实现",
            DrawerArrowActivity::class.java))

        list.add(UIItemBean("StyleableToast","继承LinearLayout实现",
            StyleableToastActivity::class.java))

        list.add(UIItemBean("StyleableToast","继承LinearLayout实现",
            ToastMainActivity::class.java))

        uiAdapter= UIItemAdapter(R.layout.ui_item,list)
        recyclerViewUi.adapter=uiAdapter
        uiAdapter.setOnItemClickListener { adapter, view, position ->
            var intent= Intent(view.context, list[position].clas)
            view.context.startActivity(intent)
        }

    }
}