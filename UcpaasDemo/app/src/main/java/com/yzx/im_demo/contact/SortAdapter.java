package com.yzx.im_demo.contact;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.yzx.im_demo.R;
import com.yzx.model.SortModel;

public class SortAdapter extends BaseAdapter implements SectionIndexer {
	private List<SortModel> list = new ArrayList<SortModel>();
	private Context mContext;
	public SortAdapter(Context mContext, List<SortModel> list) {
		this.mContext = mContext;
		if(null!=list){
			this.list.addAll(list);
		}
	}

	/**
	 * 
	 * 
	 * @param list
	 */
	public void updateListView(List<SortModel> list) {
		this.list.clear();
		this.list.addAll(list);
		notifyDataSetChanged();
	}

	public int getCount() {
		return this.list.size();
	}

	public Object getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		final SortModel mContent = list.get(position);
		if (view == null) {
			Drawable drawable = null;
			if(null!=mContent.getBitmap()){
				drawable = new BitmapDrawable(mContent.getBitmap());
			}else{
				drawable = mContext.getResources().
						getDrawable(R.drawable.person);
			}
			drawable.setBounds(10, 10, drawable.getMinimumWidth(), 
					drawable.getMinimumHeight());
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.item_sort_listview, null);
			viewHolder.tvName = (TextView) view.findViewById(R.id.name);
			viewHolder.tvLetter = (TextView) view.findViewById(R.id.catalog);
			viewHolder.tvId = (TextView) view.findViewById(R.id.id);
			viewHolder.image = (ImageView) view.findViewById(R.id.image);
			viewHolder.image.setBackgroundDrawable(drawable);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}

		// 
		int section = getSectionForPosition(position);

		// 
		if (position == getPositionForSection(section)) {
			viewHolder.tvLetter.setVisibility(View.VISIBLE);
			viewHolder.tvLetter.setText(mContent.getSortLetters());
		} else {
			viewHolder.tvLetter.setVisibility(View.GONE);
		}

		viewHolder.tvName.setText(this.list.get(position).getName());
		viewHolder.tvId.setText(this.list.get(position).getId());
		if(viewHolder.tvName.getText().toString().contains("测试账号")){
			viewHolder.tvId.setVisibility(View.GONE);
		}else{
			viewHolder.tvId.setVisibility(View.VISIBLE);
		}
		
		return view;

	}

	final static class ViewHolder {
		TextView tvLetter;
		TextView tvName;
		TextView tvId;
		ImageView image;
	}

	/**
	 * 
	 */
	public int getSectionForPosition(int position) {
		return list.get(position).getSortLetters().charAt(0);
	}

	/**
	 * 
	 */
	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = list.get(i).getSortLetters();
			char firstChar = sortStr.toUpperCase().charAt(0);
			if (firstChar == section) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 
	 * 
	 * @param str
	 * @return
	 */
	private String getAlpha(String str) {
		String sortStr = str.trim().substring(0, 1).toUpperCase();
		if (sortStr.matches("[A-Z]")) {
			return sortStr;
		} else if(sortStr.equals("*")){
			return "*";
		}else {
			return "#";
		}
	}

	@Override
	public Object[] getSections() {
		return null;
	}
}