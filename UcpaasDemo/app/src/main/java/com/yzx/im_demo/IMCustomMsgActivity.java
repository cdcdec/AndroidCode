package com.yzx.im_demo;

import com.yzx.mydefineview.ResizeRelativeLayout;
import com.yzx.mydefineview.ResizeRelativeLayout.OnSizeChangeListener;
import com.yzx.mydefineview.YZXCustomMsgEditText;
import com.yzx.mydefineview.YZXCustomMsgEditText.OnTextChangeListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
/**
* @Title IMCustomMsgActivity 
* @Description 自定义消息发送页面
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-21 下午5:09:30 
*/
public class IMCustomMsgActivity extends Activity implements OnTextChangeListener {
	private ImageButton imbtn_back;
	private YZXCustomMsgEditText et_text;
	private Button send_msg;
	private ResizeRelativeLayout rl_root;
	private View block_softinput;
	private static final int ON_SEND_OK = -1;
	
	protected static final String TAG = IMCustomMsgActivity.class.getSimpleName();
	
	//匹配屏幕
	private static final int ADJUST_SIZE = 200;
	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case ADJUST_SIZE:
				int softStatus = (Integer) msg.obj;
				if(softStatus == 0){
					//输入法隐藏
					block_softinput.setVisibility(View.VISIBLE);
				}else{
					//输入法显示
					block_softinput.setVisibility(View.GONE);
				}
				break;
			default:
				break;
			}
		};
	};
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_msg);
		
		initViews();
	}

	private void initViews() {
		imbtn_back = (ImageButton) findViewById(R.id.imbtn_back);
		et_text = (YZXCustomMsgEditText) findViewById(R.id.et_custom_text);
		send_msg = (Button) findViewById(R.id.send_msg);
		rl_root = (ResizeRelativeLayout) findViewById(R.id.rl_root);
		block_softinput = findViewById(R.id.block_softinput);
		send_msg.setEnabled(false);
		send_msg.setClickable(false);
		
		//监听文字变化
		et_text.setOnTextChangeListener(this);
		rl_root.setmOnSizeChangeListener(new OnSizeChangeListener() {
			@Override
			public void onSizeChange(int h, int oldh) {
				int softStatus = 0;
				if(h > oldh){
					//输入法隐藏
					softStatus = 0;
				}else{
					//输入法显示
					softStatus = 1;
				}
				Message message = mHandler.obtainMessage(ADJUST_SIZE);
				message.obj = softStatus;
				mHandler.sendMessage(message);
			}
		});
		
		imbtn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				inputmanger.hideSoftInputFromWindow(et_text.getWindowToken(), 0);
				finish();
			}
		});
		
		send_msg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(TextUtils.isEmpty(et_text.getText().toString())){
					Toast.makeText(IMCustomMsgActivity.this, "请输入要发送的文本!", 0).show();
					return;
				}
				Intent intent = new Intent();
				intent.putExtra("send_msg", et_text.getText().toString());
				setResult(ON_SEND_OK,intent);
				InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				inputmanger.hideSoftInputFromWindow(et_text.getWindowToken(), 0);
				finish();
			}
		});
	}

	@Override
	public void onTextChange(CharSequence text, int start, int lengthBefore,
			int lengthAfter) {
		if(TextUtils.isEmpty(text.toString())){
			//文字为null不让点击
			send_msg.setEnabled(false);
			send_msg.setClickable(false);
		}else{
			send_msg.setEnabled(true);
			send_msg.setClickable(true);
		}
	};
	
}
