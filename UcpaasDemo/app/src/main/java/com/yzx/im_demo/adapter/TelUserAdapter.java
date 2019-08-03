  
package com.yzx.im_demo.adapter;  

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.yzx.db.domain.TelUsersInfo;
import com.yzx.im_demo.R;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TelUserAdapter extends BaseAdapter {
	private List<TelUsersInfo> mUsersInfo;
//	private Context mContext;
	private LayoutInflater mInflater;
	public TelUserAdapter(Context context, List<TelUsersInfo> usersInfo)  {
//		mContext = context;
		mUsersInfo = usersInfo;
		mInflater = LayoutInflater.from(context);
	}

	public void notifyDataSetChanged(List<TelUsersInfo> usersInfo) {
		mUsersInfo = usersInfo;
		super.notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return mUsersInfo.size();
	}

	@Override
	public Object getItem(int position) {
		return mUsersInfo.get(position); 
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		TelUsersInfo info = mUsersInfo.get(position);
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.tel_user_adapter, null);
			holder.iv_call_content_dial_flag = (ImageView) convertView.findViewById(R.id.iv_call_content_dial_flag);
			holder.tv_call_content_time = (TextView) convertView.findViewById(R.id.tv_call_content_time);
			holder.tv_call_content_dial_mode = (TextView) convertView.findViewById(R.id.tv_call_content_dial_mode);
			holder.tv_call_content = (TextView) convertView.findViewById(R.id.tv_call_content);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(info.getDialFlag() == 0) { //呼入
			holder.iv_call_content_dial_flag.setBackgroundResource(R.drawable.in_call);
			if(!TextUtils.isEmpty(info.getDialMessage())) {
			    String [] timeSpan = info.getDialMessage().split(":");
			    if (timeSpan.length == 3)
			        holder.tv_call_content.setText("通话  " + timeSpan[0] + "小时" + timeSpan[1] + "分" + timeSpan[2] + "秒");
			    else
			        holder.tv_call_content.setText("通话 " + timeSpan[0] + "分" + timeSpan[1] + "秒");
			} 
		} else if(info.getDialFlag() == 1) { //呼出
			holder.iv_call_content_dial_flag.setBackgroundResource(R.drawable.out_call);
			if(!TextUtils.isEmpty(info.getDialMessage())) {
			    String [] timeSpan = info.getDialMessage().split(":");
                if (timeSpan.length == 3)
                    holder.tv_call_content.setText("通话 " + timeSpan[0] + "小时" + timeSpan[1] + "分" + timeSpan[2] + "秒");
                else
                    holder.tv_call_content.setText("通话 " + timeSpan[0] + "分" + timeSpan[1] + "秒");
			} else {
				holder.tv_call_content.setText("未接听");
			}
		} else if(info.getDialFlag() == 2) { // 呼入未接
			holder.iv_call_content_dial_flag.setBackgroundResource(R.drawable.in_mis_call);
			holder.tv_call_content.setText("未接听");
		} else if(info.getDialFlag() == 3) { // 呼出未接
			holder.iv_call_content_dial_flag.setBackgroundResource(R.drawable.out_call);
			holder.tv_call_content.setText("已取消");
		}
		
		// 时间
		if(!TextUtils.isEmpty(info.getTime())) {
			String time = info.getTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd-HH:mm");
			String currentTime = dateFormat.format(new Date());
			if(currentTime.split("-")[0].equals(time.split("-")[0])) { // 同一天
				holder.tv_call_content_time.setText(time.split("-")[1]);
			} else {
				String dateTime = time.split("-")[0].split(":")[0] + "-" + time.split("-")[0].split(":")[1] + "-" + time.split("-")[0].split(":")[2];
				holder.tv_call_content_time.setText(dateTime);
			}
		}
		
		// 电话聊天方式
		if(info.getTelMode() == 1) {
			holder.tv_call_content_dial_mode.setVisibility(View.GONE);
		} else if(info.getTelMode() == 2){
			holder.tv_call_content_dial_mode.setVisibility(View.VISIBLE);
		}
		

		
		return convertView;
	}
	
	private class ViewHolder {
		ImageView iv_call_content_dial_flag;
		TextView tv_call_content_time;
		TextView tv_call_content_dial_mode;
		TextView tv_call_content;
	}

}
  
