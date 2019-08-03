package com.yzx.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.yzx.im_demo.R;
import com.yzx.tools.DateTools;
import com.yzxIM.data.db.ChatMessage;
/**
* @Title MessageAdapter 
* @Description 广播消息数据适配器
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-17 下午3:43:07 
*/
public class MessageAdapter extends CommonAdapter<ChatMessage> {
	private List<String> times;

	public MessageAdapter(Context context, List<ChatMessage> datas, int layoutId) {
		super(context, datas, layoutId);
		times = new ArrayList<String>();
		initTimes();
	}
	/**
	* @Description 初始化时间顺序
	* @date 2015-12-17 下午3:50:47 
	* @author zhuqian  
	* @return void
	 */
	public void initTimes() {
		times.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long oldTime = 0;
		for(ChatMessage msg : datas){
			//相隔四分钟的时间不显示
			if((msg.getSendTime() - oldTime) < 4 * 60 * 1000){
				times.add("");
			}else{
				String time = DateTools.formatDate(sdf.format(new Date(msg.getSendTime())),true);
				times.add(time);
			}
			oldTime = msg.getSendTime();
		}
	}
	@Override
	public void convert(ViewHolder viewHolder, ChatMessage t, int position) {
		TextView msg_time = viewHolder.getView(R.id.message_time);
		TextView msg_text = viewHolder.getView(R.id.message_content);
		String time = times.get(position);
		if(TextUtils.isEmpty(time)){
			msg_time.setVisibility(View.GONE);
		}else{
			msg_time.setVisibility(View.VISIBLE);
			msg_time.setText(time);
		}
		msg_text.setText(t.getContent());
	}
	
	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}

}
