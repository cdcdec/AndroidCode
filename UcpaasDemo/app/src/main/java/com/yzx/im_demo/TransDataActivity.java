package com.yzx.im_demo;

import java.util.ArrayList;
import com.yzx.im_demo.adapter.TransDataAdapter;
import com.yzx.im_demo.adapter.domain.TransData;
import com.yzxtcp.UCSManager;
import com.yzxtcp.listener.OnSendTransRequestListener;
import com.yzxtcp.tools.tcp.packet.common.UCSTransStock;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
/**
 * 数据透传Activity
 * @author zhuqain
 */
public class TransDataActivity extends Activity {
	private EditText mTransPhone,mThransContent;
	private Button mTransSend;
	private ListView mTransData;
	private TransDataAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transdata);
		
		initViews();
	}

	/**
	 * 初始化View
	 */
	private void initViews() {
		mTransPhone = (EditText) findViewById(R.id.trans_edit_phone);
		mThransContent = (EditText) findViewById(R.id.trans_edit_content);
		mTransSend = (Button) findViewById(R.id.trans_send);
		mTransData = (ListView) findViewById(R.id.trans_data);
		mTransSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String phone = mTransPhone.getText().toString();
				if(TextUtils.isEmpty(phone) || phone.length() < 11){
					Toast.makeText(TransDataActivity.this, "请输入正确的手机号", 0).show();
					return;
				}
				final String data = mThransContent.getText().toString();
				if(TextUtils.isEmpty(data)){
					Toast.makeText(TransDataActivity.this, "透传数据不能为空", 0).show();
					return;
				}
				//发送透传数据：123
				UCSManager.sendTransData(phone, new UCSTransStock() {
					@Override
					public String onTranslate() {
						//返回要发送的数据
						return data;
					}
					@Override
					public String onPreviewImgData() {
						return "";
					}
				}, new OnSendTransRequestListener() {
					@Override
					public void onSuccess(String msgId, String ackData) {
						Toast.makeText(TransDataActivity.this, "发送透传数据成功:" + ackData, 0).show();
					}
					@Override
					public void onError(int errorCode, String msgId) {
						Toast.makeText(TransDataActivity.this, "发送透传数据失败，errorCode："+errorCode, 0).show();
					}
				});
				//情况发送
				mThransContent.setText("");
			}
		});
		
		mAdapter = new TransDataAdapter(mTransData,this, new ArrayList<TransData>(), R.layout.trans_content_item);
		mTransData.setAdapter(mAdapter);
	}
	
	@Override
	protected void onDestroy() {
		if(mAdapter != null){
			//移除监听
			mAdapter.removeOnRecvTransUCSListener();
		}
		super.onDestroy();
	}
}
