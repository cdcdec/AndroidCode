  
package com.yzx.im_demo;  

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzx.mydefineview.YzxTopBar;
import com.yzxtcp.tools.CustomLog;

public class UserInfoActivity extends Activity implements OnClickListener {
	private YzxTopBar tel_other_user_title;
	private TextView tv_tel_other_user_name;
	private TextView tv_tel_other_user_phone;
	private LinearLayout ll_other_voice_call;
	private LinearLayout ll_other_video_call;
	private String userName;
	private String userPhone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_info);
		initView();
		initListener();
		initData();
	}

	private void initView() {
		tel_other_user_title = (YzxTopBar) findViewById(R.id.tel_other_user_title);
		tv_tel_other_user_name = (TextView) findViewById(R.id.tv_tel_other_user_name); 
		tv_tel_other_user_phone = (TextView) findViewById(R.id.tv_tel_other_user_phone); 
		ll_other_voice_call = (LinearLayout) findViewById(R.id.ll_other_voice_call);
		ll_other_video_call = (LinearLayout) findViewById(R.id.ll_other_video_call); 
	}
	

	private void initListener() {
		ll_other_voice_call.setOnClickListener(this);
		ll_other_video_call.setOnClickListener(this);
		tel_other_user_title.setBackBtnOnclickListener(this);
	}

	private void initData() {
		tel_other_user_title.setTitle("详细资料");
		if(getIntent().hasExtra("userName")) {
			userName = getIntent().getStringExtra("userName");
		}
		if(getIntent().hasExtra("userPhone")) {
			userPhone = getIntent().getStringExtra("userPhone"); 
		}
		
		if(userName != null && !"".equals(userName)) {
			tv_tel_other_user_name.setText(userName);
			tv_tel_other_user_phone.setText("手机号： " + userPhone);
		} else if(userPhone != null && !"".equals(userPhone)) {
			tv_tel_other_user_name.setText(userPhone);
			tv_tel_other_user_phone.setText("手机号： " + userPhone);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_other_voice_call:	// 音频
		    if (IMMessageActivity.checkNetwork(UserInfoActivity.this, false) == false) {
                return;
            }
			CustomLog.v("开启拨打音频电话。。。");
			Intent intentVoice = new Intent(UserInfoActivity.this,AudioConverseActivity.class);
			intentVoice.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			intentVoice.putExtra("userName",userName);
			intentVoice.putExtra("userId",userPhone);
			intentVoice.putExtra("call_phone", userPhone);
			intentVoice.putExtra("call_type", 1);//免费电话
			startActivity(intentVoice);
			break;
		case R.id.ll_other_video_call:	// 视频
		    if (IMMessageActivity.checkNetwork(UserInfoActivity.this, false) == false) {
                return;
            }
			CustomLog.v("开启拨打视频电话。。。");
			Intent intentVideo = new Intent(UserInfoActivity.this, VideoConverseActivity.class); 
			intentVideo.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			intentVideo.putExtra("userName",userName);
			intentVideo.putExtra("userId", userPhone);
			intentVideo.putExtra("call_phone", userPhone);
//			intentVideo.putExtra("call_position", "");
			startActivity(intentVideo);
			break;
		case R.id.imbtn_back:	// 返回
			 UserInfoActivity.this.finish();
			break;
		default:
			break;
		}
	}

	@Override
	protected void onResume() {
		MainApplication.getInstance().setResumeActivity(this);
		super.onResume();
	}
}
  
