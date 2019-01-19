package com.cdc.androidcode.ui

import com.cdc.androidcode.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class UIItemAdapter(layoutResId: Int, data: List<UIItemBean>?) : BaseQuickAdapter<UIItemBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: UIItemBean) {
        helper.setText(R.id.tvUITitle, item.uiTitle)
        helper.setText(R.id.tvUIContent, item.uiContent)
    }
}
