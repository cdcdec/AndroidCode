package com.gyf.immersionbar.simple.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.immersionbar.simple.R;
import com.gyf.immersionbar.simple.bean.FunBean;

/**
 * @author geyifeng
 * @date 2019/4/19 3:03 PM
 */
public class MainAdapter extends BaseQuickAdapter<FunBean, BaseViewHolder> {
    public MainAdapter() {
        super(R.layout.item_fun);
    }

    @Override
    protected void convert(BaseViewHolder helper, FunBean item) {
        CardView cardView = helper.getView(R.id.card);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) cardView.getLayoutParams();
        layoutParams.setMarginStart(item.getMarginStart());
        layoutParams.setMarginEnd(item.getMarginEnd());
        helper.setText(R.id.tvName, item.getName());
        ImageView ivIcon = helper.getView(R.id.ivIcon);
        ImageView ivFlower = helper.getView(R.id.ivFlower);
        ivFlower.setImageResource(item.getFlower());
        Glide.with(mContext).load(item.getPic()).into(ivIcon);
    }
}
