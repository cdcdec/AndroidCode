package com.cdc.androidcode.ui.supertextview;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.allen.library.SuperTextView;
import com.cdc.androidcode.Logger;
import com.cdc.androidcode.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName：AndroidCode
 * DESC: (类描述)
 * Created by chendongchu 2019\1\20 0020
 * updateName:(修改人名称)
 * updateTime:(修改时间)10:59
 * updateDesc:(修改内容)
 */
public class UiListAdapter extends RecyclerView.Adapter<UiListAdapter.UiViewHolder>{

    private Context mContext;
    private List<NewsBean> dataList=new ArrayList<>();

    public UiListAdapter(RecyclerView recyclerView){
        this.mContext=recyclerView.getContext();
    }

    public void setData(List<NewsBean> dataList) {
        if (null != dataList) {
            this.dataList.clear();
            this.dataList.addAll(dataList);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public UiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ui_stv_list_item, viewGroup, false);
        return new UiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UiViewHolder uiViewHolder, int position) {
        uiViewHolder.superTextView.setLeftTopString(dataList.get(position).getTitle()).setLeftBottomString(dataList.get(position).getTime());
        Picasso.get().load(dataList.get(position).getImgUrl()).placeholder(R.mipmap.head_default
        ).into(uiViewHolder.superTextView.getLeftIconIV());
    }

    @Override
    public int getItemCount() {
        Logger.e("123",dataList.size()+"");
        return dataList.size();
    }

    class UiViewHolder extends RecyclerView.ViewHolder{

        SuperTextView superTextView;

        public UiViewHolder(@NonNull View itemView) {
            super(itemView);
            superTextView=itemView.findViewById(R.id.stv_ui_list_item);
        }
    }
}
