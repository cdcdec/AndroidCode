package com.yzx.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
* @Title ViewHolder 
* @Description View袋子，防止重复创建
* @Company yunzhixun
* @author zhuqian
* @date 2015-11-18 下午2:48:26 
*/
public class ViewHolder {
	
	private View mConvertview;
	//保存mConvertview下的子view
	private SparseArray<View> mViews;
	
	private int position;
	
	private  ViewHolder(Context context,ViewGroup parent,int layoutId,int position){
		this.mViews = new SparseArray<View>();
		this.position = position;
		this.mConvertview = LayoutInflater.from(context).inflate(layoutId, parent,false);
		this.mConvertview.setTag(this);
	}
	
	public static ViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId,int position){
		if(convertView == null){
			return new ViewHolder(context, parent, layoutId,position);
		}else{
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.position = position;
			return holder;
		}
	}
	
	public <T extends View> T getView(int viewId){
		View view = mViews.get(viewId);
		if(view == null){
			view = mConvertview.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T)view;
	}

	public View getConvertView(){
		return mConvertview;
	}
}
