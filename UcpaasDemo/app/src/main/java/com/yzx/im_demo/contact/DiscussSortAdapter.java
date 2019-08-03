package com.yzx.im_demo.contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.yzx.im_demo.R;
import com.yzx.model.SortModel;

public class DiscussSortAdapter extends BaseAdapter implements SectionIndexer {
	private List<SortModel> list = new ArrayList<SortModel>();
	private Context mContext;
	// 用来控制CheckBox的选中状况
    private HashMap<Integer,Integer> isSelected = new HashMap<Integer, Integer>();
    //默认不能添加的好友
    private HashMap<Integer,Integer> isEnabled = new HashMap<Integer, Integer>();
	public DiscussSortAdapter(Context mContext, List<SortModel> list, ArrayList<String> memberList) {
		this.mContext = mContext;
		this.list.addAll(list);
		for(int i=0; i<list.size();i++) {
			isEnabled.put(i,0);
			isSelected.put(i,0);
	        if(null!=memberList){
		        for(String str:memberList){
					if(str.equals(list.get(i).getName())){
						isEnabled.put(i,2);
						break;
					}
		        }
	        }
	    }
	}

	 public HashMap<Integer,Integer> getIsSelected() {
	        return isSelected;
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

	public void updateSelect(int position, Integer b){
		isSelected.put(position, b);
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
			viewHolder.cbCheck = (CheckBox) view.findViewById(R.id.item_check);
			viewHolder.tvName = (TextView) view.findViewById(R.id.name);
			viewHolder.tvLetter = (TextView) view.findViewById(R.id.catalog);
			viewHolder.item_rl = (RelativeLayout) view.findViewById(R.id.item_rl);
			viewHolder.tvId = (TextView) view.findViewById(R.id.id);
			viewHolder.image = (ImageView) view.findViewById(R.id.image);
			viewHolder.image.setBackgroundDrawable(drawable);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.item_rl.setVisibility(View.VISIBLE);
		// 
		int section = getSectionForPosition(position);
		if(isEnabled.get(position) == 0){
			viewHolder.cbCheck.setEnabled(true);
		}else{
			viewHolder.cbCheck.setEnabled(false);
		}
		if(isSelected.get(position) == 0){
			viewHolder.cbCheck.setChecked(false);
		}else{
			viewHolder.cbCheck.setChecked(true);
		}
		
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
		LinearLayout item_ll;
		RelativeLayout item_rl;
		CheckBox cbCheck;
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
		} else {
			return "#";
		}
	}

	@Override
	public Object[] getSections() {
		return null;
	}
}