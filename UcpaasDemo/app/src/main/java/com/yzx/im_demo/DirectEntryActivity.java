package com.yzx.im_demo;  

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @Title DirectEntryActivity   
 * @Description  直拨入口
 * @Company yunzhixun  
 * @author xhb
 * @date 2016-5-18 上午11:00:05
 */
public class DirectEntryActivity extends Activity implements OnClickListener {
	private TextView tv_direct_back;
	private EditText et_direct_phone;
	private ImageButton ib_digit0;
	private ImageButton ib_digit1;
	private ImageButton ib_digit2;
	private ImageButton ib_digit3;
	private ImageButton ib_digit4;
	private ImageButton ib_digit5;
	private ImageButton ib_digit6;
	private ImageButton ib_digit7;
	private ImageButton ib_digit8;
	private ImageButton ib_digit9;
	private ImageButton ib_digit_star;
	private ImageButton ib_digit_husa;
	private ImageButton ib_direct_call;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_direct_entry);
		initView();
		initListener();
	}

	/**
	 * @Description 初始化view	
	 * @date 2016-5-18 上午11:03:38 
	 * @author xhb  
	 * @return void    返回类型
	 */
	private void initView() {
		et_direct_phone = (EditText) findViewById(R.id.et_direct_phone);
		tv_direct_back = (TextView) findViewById(R.id.tv_direct_back);
		ib_direct_call = (ImageButton) findViewById(R.id.ib_direct_call); 
		ib_digit0 = (ImageButton) findViewById(R.id.digit0); 
		ib_digit1 = (ImageButton) findViewById(R.id.digit1);
		ib_digit2 = (ImageButton) findViewById(R.id.digit2);
		ib_digit3 = (ImageButton) findViewById(R.id.digit3);
		ib_digit4 = (ImageButton) findViewById(R.id.digit4);
		ib_digit5 = (ImageButton) findViewById(R.id.digit5); 
		ib_digit6 = (ImageButton) findViewById(R.id.digit6);
		ib_digit7 = (ImageButton) findViewById(R.id.digit7);
		ib_digit8 = (ImageButton) findViewById(R.id.digit8);
		ib_digit9 = (ImageButton) findViewById(R.id.digit9);
		ib_digit_star = (ImageButton) findViewById(R.id.digit_star);
		ib_digit_husa = (ImageButton) findViewById(R.id.digit_husa);
	}

	/**
	 * @Description 初始化监听器	
	 * @date 2016-5-18 上午11:03:52 
	 * @author xhb  
	 * @return void    返回类型
	 */
	private void initListener() {
		tv_direct_back.setOnClickListener(this);
		ib_direct_call.setOnClickListener(this);
		ib_digit0.setOnClickListener(this);				// DTMF 按键
		ib_digit1.setOnClickListener(this);
		ib_digit2.setOnClickListener(this);
		ib_digit3.setOnClickListener(this);
		ib_digit4.setOnClickListener(this);
		ib_digit5.setOnClickListener(this);
		ib_digit6.setOnClickListener(this);
		ib_digit7.setOnClickListener(this);
		ib_digit8.setOnClickListener(this);
		ib_digit9.setOnClickListener(this);
		ib_digit_star.setOnClickListener(this);
		ib_digit_husa.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_direct_back:	// 返回
			finish();
			break;
		case R.id.ib_direct_call:	// 拨打电话
		    if (IMMessageActivity.checkNetwork(DirectEntryActivity.this, false) == false) {
                return;
            }
			if(TextUtils.isEmpty(et_direct_phone.getText().toString())) {
				Toast.makeText(DirectEntryActivity.this, "请输入手机号码", 0).show();
			} else {
				String phone = et_direct_phone.getText().toString();
				Intent intentVoice = new Intent(DirectEntryActivity.this,AudioConverseActivity.class);
				intentVoice.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				intentVoice.putExtra("phoneNumber",phone);
				intentVoice.putExtra("call_phone", phone);
				intentVoice.putExtra("call_type", 2);//直拨电话
				startActivity(intentVoice);
			}
			break;
		case R.id.digit0:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "0");
			break;
		case R.id.digit1:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "1");
			break;
		case R.id.digit2:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "2");
			break;
		case R.id.digit3:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "3");
			break;
		case R.id.digit4:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "4");
			break;
		case R.id.digit5:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "5");
			break;
		case R.id.digit6:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "6");
			break;
		case R.id.digit7:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "7");
			break;
		case R.id.digit8:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "8");
			break;
		case R.id.digit9:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "9");
			break;
		case R.id.digit_star:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "*");
			break;
		case R.id.digit_husa:
			et_direct_phone.getEditableText().insert(et_direct_phone.getText().length(), "#");
			break;
		default:
			break;
		}
	}
}
  
