package com.cdc.androidcode.userinterface

import com.cdc.androidcode.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\18 0018
 * updateName:(修改人名称)
 * updateTime:(修改时间)17:57
 * updateDesc:(修改内容)
 */
class UIItemAdapter(data: MutableList<UIItemBean>?) : BaseQuickAdapter<UIItemBean, BaseViewHolder>(data) {
    override fun convert(helper: BaseViewHolder?, item: UIItemBean?) {
        helper!!.setText(R.id.tvUITitle, item!!.uiTitle)
        helper!!.setText(R.id.tvUIContent, item!!.uiContent)
    }

}