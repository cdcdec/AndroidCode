package com.yzx.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/**
* @Title CommonAdapter 
* @Description 抽象的数据适配器
* @Company yunzhixun
* @author zhuqian
* @date 2015-11-18 下午2:45:13 
*/
public abstract class CommonAdapter<T> extends BaseAdapter {
	
	private Context context;
	protected List<T> datas;
	private LayoutInflater mInflater;
	private int layoutId;
	
	
	public CommonAdapter(Context context,List<T> datas,int layoutId){
		this.context = context;
		this.datas = datas;
		this.layoutId = layoutId;
		this.mInflater = (LayoutInflater) LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public T getItem(int position) {
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = ViewHolder.get(context, convertView, parent, layoutId, position);
		convert(viewHolder,getItem(position),position);
		return viewHolder.getConvertView();
	}

	public abstract void convert(ViewHolder viewHolder,T t,int position);
}
