package com.cdc.androidcode.ui.supertextview

import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.cdc.androidcode.Logger
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_ui_stv_list.*



class UiStvListActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {

    private var isRefresh = false//是否刷新中
    override fun onRefresh() {
        if(!isRefresh) {
            isRefresh = true
        }
        Handler().postDelayed({
            swipe_refresh_layout.isRefreshing=false
            getRefreshData()
            adapter!!.notifyDataSetChanged()
            isRefresh=false

        }, 4000)
        Logger.e("123","=刷新="+adapter!!.itemCount.toString()+","+ newsBeanList[0].title)

    }

    private val newsBeanList = ArrayList<NewsBean>()
    private var adapter: UiListAdapter? = null
    private val url = arrayOf(
        "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1580482776,3214289843&fm=80&w=179&h=119&img.JPEG",
        "https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/vip/whcrop%3D176%2C106/sign=cffe5aed6363f6241c086f41e834d6c9/f3d3572c11dfa9ecb7f287c36ad0f703908fc102.jpg",
        "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1383170885,2038374031&fm=80&w=179&h=119&img.JPEG",
        "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2218526845,522933158&fm=80&w=179&h=119&img.JPEG",
        "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=775731846,1370921386&fm=80",
        "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG",
        "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=4096069947,473932952&fm=80&w=179&h=119&img.JPEG",
        "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3244336274,3651700434&fm=80&w=179&h=119&img.JPEG",
        "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=219781665,3032880226&fm=80&w=179&h=119&img.JPEG",
        "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=831306574,2792494868&fm=80&w=179&h=119&img.GIF"
    )

    private fun getData(): List<NewsBean> {
        for (i in 0..9) {
            val newsBean = NewsBean(url[i], "新闻标题$i", "在列表中使用的demo在列表中使用的demo在列表中使用的demo$i")
            newsBeanList.add(newsBean)
        }
        return newsBeanList
    }

    override fun initView() {
        leftArrow(toolbarList)
    }

    override fun initData() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = layoutManager
        adapter = UiListAdapter(recycler_view)
        recycler_view.adapter = adapter
        adapter!!.setData(getData())
        swipe_refresh_layout.setOnRefreshListener(this)
    }

    private fun getRefreshData(): List<NewsBean> {
        newsBeanList.clear()
        for (i in 0..9) {
            val newsBean = NewsBean(url[i], "新标$i", "在列表中使用的demo$i")
            newsBeanList.add(newsBean)
        }
        return newsBeanList
    }

    override fun layoutId(): Int {
        return R.layout.activity_ui_stv_list
    }

    private fun leftArrow(toolBar: Toolbar){
        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        toolBar.setNavigationOnClickListener{
            finish()
        }
    }

    override fun initImmersionBar() {
        super.initImmersionBar()
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).init()
    }


}


data class NewsBean(var imgUrl: String, var title: String, var time: String)

