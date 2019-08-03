package com.yzx.im_demo;

import com.yzx.db.UserInfoDBManager;
import com.yzx.db.domain.UserInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class IMDemoActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//获取默认登录账号
		UserInfo user = UserInfoDBManager.getInstance().getCurrentLoginUser();
		if(user != null){
//			Intent intent = new Intent(this, IMChatActivity.class);
//			intent.putExtra("mLocalUser", user.getAccount());
//			//是否要链接SDK
//			intent.putExtra("connectTcp", true);
//			startActivity(intent);
			IMChatActivity.actionStart(IMDemoActivity.this,true);
			finish();
		}else{
			setContentView(R.layout.activity_welcome);

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					IMDemoActivity.this.finish();
					startActivity(new Intent(IMDemoActivity.this, IMLoginV2Activity.class));
				}
			}, 1000);
		}
	}

}
