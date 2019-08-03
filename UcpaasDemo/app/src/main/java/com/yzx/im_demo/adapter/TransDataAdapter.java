package com.yzx.im_demo.adapter;

import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import com.yzx.adapter.CommonAdapter;
import com.yzx.adapter.ViewHolder;
import com.yzx.im_demo.R;
import com.yzx.im_demo.adapter.domain.TransData;
import com.yzxtcp.UCSManager;
import com.yzxtcp.listener.OnRecvTransUCSListener;
import com.yzxtcp.tools.CustomLog;

public class TransDataAdapter extends CommonAdapter<TransData>{
	
	private OnRecvTransUCSListener mOnRecvTransUCSListener;
	
	private Handler mHandler = new Handler();
	private ListView mLv;
	private class YZXOnRecvTransUCSListener extends OnRecvTransUCSListener{
		@Override
		public void onRecvTranslate(String fromUserId, String data, String callid, String previewImgUrl) {
			if(!TextUtils.isEmpty(fromUserId) && !TextUtils.isEmpty(data)){
				//添加数据
				datas.add(new TransData(data, fromUserId));
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						//更新界面
						notifyDataSetChanged();
						mLv.setSelection(datas.size() - 1);
					}
				});
			}
		}
	}

	public TransDataAdapter(ListView mLv,Context context, List<TransData> datas, int layoutId) {
		super(context, datas, layoutId);
		mOnRecvTransUCSListener = new YZXOnRecvTransUCSListener();
		this.mLv = mLv;
		UCSManager.setOnRecvTransUCSListener(mOnRecvTransUCSListener);
		UCSManager.setOnRecvTransUCSListener(new OnRecvTransUCSListener() {
			@Override
			public void onRecvTranslate(String fromUserId, String data, String callid, String previewImgUrl) {
				CustomLog.v("发送方UserId："+fromUserId+"，收到透传数据：data:"+data + ",callid:" + callid + ",previewImgUrl:" + previewImgUrl);
			}
		});
	}

	@Override
	public void convert(ViewHolder viewHolder, TransData t, int position) {
		TextView tv_account = viewHolder.getView(R.id.trans_content_count);
		TextView tv_data = viewHolder.getView(R.id.trans_content_data);
		tv_account.setText(t.getAccount());
		tv_data.setText(t.getData());
	}
	
	public void removeOnRecvTransUCSListener(){
		if(mOnRecvTransUCSListener != null){
			UCSManager.removeOnRecvTransUCSListener(mOnRecvTransUCSListener);
		}
	}

}
