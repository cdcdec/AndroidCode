package com.yzx.im_demo;

import com.yzx.im_demo.R;
import com.yzx.mydefineview.YZXDialog;
import com.yzx.mydefineview.YZXDialog.OnAlertViewClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
* @Title IMLoginOutActivity 
* @Description 被迫下线Activity
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-18 上午9:32:09 
*/
public class IMLoginOutActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loginout);
		YZXDialog.showAlertView(this, 0, "踢线提醒", "您的账号已经在别的地方登录！", "我知道了", null, new OnAlertViewClickListener() {
			public void confirm(String result) {
				//nothing to do
			}
			public void cancel() {
				//跳转到登录页面
				Intent intent = new Intent(IMLoginOutActivity.this,
						IMLoginV2Activity.class);
				startActivity(intent);
//				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				finish();
			}
		});
	}

}
