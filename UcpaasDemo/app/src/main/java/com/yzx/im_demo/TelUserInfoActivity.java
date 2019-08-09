package com.yzx.im_demo;  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yzx.db.TelUserInfoDBManager;
import com.yzx.db.domain.TelUsersInfo;
import com.yzx.im_demo.adapter.TelUserAdapter;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.UIDfineAction;
import com.yzxtcp.tools.CustomLog;

public class TelUserInfoActivity extends Activity implements OnClickListener {
	private ImageView iv_tel_user_head;
	private TextView tv_tel_user_name;
	private TextView tv_tel_user_phone;
	private ListView lv_call_record;
	private LinearLayout ll_voice_call;
	private LinearLayout ll_video_call;
	private String userName;
	private String userHead;
	private String userPhone;
	private static List<TelUsersInfo> usersInfo = new ArrayList<TelUsersInfo>();
	private TelUserAdapter telUserAdapter;
	private YzxTopBar tel_user_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tel_user_info);
		userName = getIntent().getStringExtra("userName");
		userHead = getIntent().getStringExtra("userHead");
		userPhone = getIntent().getStringExtra("userPhone");
		usersInfo.clear();
		initData(userPhone);
		initView();
		IntentFilter filter = new IntentFilter();
		filter.addAction(UIDfineAction.ACTION_TEL_USER_INFO_DATA_UPDATE);
		registerReceiver(receiver, filter); 
	}
	
	private BroadcastReceiver receiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction().equals(UIDfineAction.ACTION_TEL_USER_INFO_DATA_UPDATE)) {
				TelUsersInfo uInfo = (TelUsersInfo) intent.getSerializableExtra("userData");
				if(uInfo != null) {
					if(usersInfo != null && usersInfo.size() > 0) {
						Iterator<TelUsersInfo> iterator = usersInfo.iterator();
						while (iterator.hasNext()) { 
							TelUsersInfo telUsersInfo = iterator.next();
							if(uInfo.getTelephone().equals(telUsersInfo.getTelephone())) {
								if(!uInfo.getName().equals(telUsersInfo.getName())) {
									telUsersInfo.setName(uInfo.getName());
								}
							}
						}
					}
					usersInfo.add(0, uInfo);
					//如果记录多于100条，则删除较早的
					if (usersInfo.size() > 100) {
					    usersInfo.remove(100);
                    }
					if(telUserAdapter == null) {
						telUserAdapter = new TelUserAdapter(TelUserInfoActivity.this, usersInfo);
						lv_call_record.setAdapter(telUserAdapter); 
						lv_call_record.setDivider(null);
					}
					telUserAdapter.notifyDataSetChanged(usersInfo);
				}
			}
		}
	};
	
	@Override
	protected void onResume() {
		MainApplication.getInstance().setResumeActivity(this);
		super.onResume();
		CustomLog.e("telUserInfoActivity onResume() ...");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		super.onDestroy();
	}
	
	public void initView() {
		tel_user_title = (YzxTopBar) findViewById(R.id.tel_user_title); 
		iv_tel_user_head = (ImageView) findViewById(R.id.iv_tel_user_head); 
		tv_tel_user_name = (TextView) findViewById(R.id.tv_tel_user_name); 
		tv_tel_user_phone = (TextView) findViewById(R.id.tv_tel_user_phone); 
		lv_call_record = (ListView) findViewById(R.id.lv_call_record);
		ll_voice_call = (LinearLayout) findViewById(R.id.ll_voice_call);
		ll_video_call = (LinearLayout) findViewById(R.id.ll_video_call); 
		ll_voice_call.setOnClickListener(this);
		ll_video_call.setOnClickListener(this);
		tel_user_title.setBackBtnOnclickListener(this);
		tel_user_title.setTitle("通话详情");
		tv_tel_user_name.setText(userName);
		tv_tel_user_phone.setText("手机号： " + userPhone);
		if(usersInfo != null && usersInfo.size() > 0) {
			telUserAdapter = new TelUserAdapter(this, usersInfo);
			lv_call_record.setAdapter(telUserAdapter); 
			lv_call_record.setDivider(null);
		}
	} 
	
	public void initData(String telPhone) {
		String loginPhone = getSharedPreferences("YZX_DEMO", 1).getString("YZX_ACCOUNT_INDEX", "");
		List<TelUsersInfo> uInfos = TelUserInfoDBManager.getInstance().getAll(telPhone,loginPhone);
		usersInfo.addAll(uInfos);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imbtn_back:	// 返回
			 TelUserInfoActivity.this.finish();
			break;
		case R.id.ll_voice_call:	// 拨打语音电话
		    if (IMMessageActivity.checkNetwork(TelUserInfoActivity.this, false) == false) {
                return;
            }
			CustomLog.v("开启拨打音频电话。。。");
			Intent intentVoice = new Intent(TelUserInfoActivity.this,AudioConverseActivity.class);
			intentVoice.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			intentVoice.putExtra("userName",userName);
			intentVoice.putExtra("userId",userPhone);
			intentVoice.putExtra("call_phone", userPhone);
			intentVoice.putExtra("call_type", 1);//免费电话
			startActivity(intentVoice);
			break;
		case R.id.ll_video_call:	// 拨打视频电话
		    if (IMMessageActivity.checkNetwork(TelUserInfoActivity.this, false) == false) {
                return;
            }
			CustomLog.v("开启拨打视频电话。。。");
			Intent intentVideo = new Intent(TelUserInfoActivity.this, VideoConverseActivity.class); 
			intentVideo.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			intentVideo.putExtra("userName",userName);
			intentVideo.putExtra("userId", userPhone);
			intentVideo.putExtra("call_phone", userPhone);
//			intentVideo.putExtra("call_position", "");
			startActivity(intentVideo);
			break;
		default:
			break;
		}
	}
}
  
