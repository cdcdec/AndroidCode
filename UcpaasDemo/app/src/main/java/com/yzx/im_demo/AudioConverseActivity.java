package com.yzx.im_demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.yzx.api.UCSCall;
import com.yzx.tools.ContactTools;
import com.yzx.tools.DfineAction;
import com.yzx.tools.DialConfig;
import com.yzx.tools.UIDfineAction;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxtcp.tools.CustomLog;
import com.yzxtcp.tools.NetWorkTools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

/**  
 * @Title AudioConverseActivity   
 * @Description  语音电话界面
 * @Company yunzhixun  
 * @author xhb
 * @date 2016-1-2 下午5:54:30  
 */
public class AudioConverseActivity extends ConverseActivity implements OnClickListener{
	private static final int CHAT_MODE_AUDIO = 1;//音频聊天
	private static final int CHAT_MODE_VIDEO = 2;//视频聊天
	public String calledUid ;
	public String calledPhone ;
	public String userName;
	public String phoneNumber;
	public String nickName;
	public boolean inCall = false; // true:来电；false:去电
	private int mCallType = 1; //1语音聊天  2视频聊天
	private RelativeLayout audio_main;
	private TextView converse_client;
	private TextView converse_information;
	private LinearLayout ll_network_call_time;
	private LinearLayout ll_mute_pad_speaker;
	private ImageView converse_network; 
	private TextView converse_call_time;
	private TextView dial_close;
	private EditText dial_number;
	private ImageButton converse_call_mute;
	private ImageButton converse_call_dial;
	private ImageButton converse_call_speaker;
	private ImageButton converse_call_hangup;
	private ImageButton converse_call_answer;
	private ImageButton converse_call_endcall;
	private ImageButton dial_endcall;
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
	private LinearLayout key_layout;
	private TextView key_converse_name;
	private LinearLayout converse_main;
	private boolean open_headset=false;
	private int calltype = 1;
	private boolean speakerPhoneState = false;
	public static String IncomingCallId;	// 来电时的callId，作用是防止有些时间挂断电话的信令来了，但是通话界面还没有开启，这个时候在来来电信令，电话就不挂断。
	private String timer;	// 通话时间
	private String callStartTime = null; //通话开始时间
	private String callId="";
	private boolean incallAnswer = false;
	private static final int AUDIO_CONVERSE_CLOSE = 1; // 关闭界面
	private static final int ACTION_NETWORK_STATE = 2;	// 更新网络状态
//	private static final String TAG = "AudioConverseActivity";
	private int sound; // 触摸提示音的状态，0：关，1：开
    private AudioManager mAudioManager;
    
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case AUDIO_CONVERSE_CLOSE: 	// 关闭界面
				UCSCall.setSpeakerphone(AudioConverseActivity.this, false);
				AudioConverseActivity.this.finish();
				break;
			case ACTION_NETWORK_STATE:	// 更新网络状态
				switch (msg.arg1) {
				/*
				0 nice, very good
				1  well, good
				2 general
				3 poor
				4 bad
				 */
				case 0:
				case 1:
				    converse_network.setBackgroundResource(R.drawable.audio_signal3);
					break;
				case 2:
				    converse_network.setBackgroundResource(R.drawable.audio_signal2);
					break;
				case 3:
				    converse_network.setBackgroundResource(R.drawable.audio_signal1);
					break;
				case 4:
				    converse_network.setBackgroundResource(R.drawable.audio_signal0);
					break;
				}
				audio_information.setText((String)msg.obj);
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audio_converse);
		initview();
		initListener();
		initData();
		IntentFilter ift = new IntentFilter();
		ift.addAction(UIDfineAction.ACTION_DIAL_STATE);
		ift.addAction(UIDfineAction.ACTION_ANSWER);
		ift.addAction(UIDfineAction.ACTION_CALL_TIME);
		ift.addAction(UIDfineAction.ACTION_DIAL_HANGUP);
		ift.addAction(UIDfineAction.ACTION_NETWORK_STATE);
		ift.addAction(UIDfineAction.ACTION_PREVIEW_IMG_STATE);
		ift.addAction("android.intent.action.HEADSET_PLUG");
		registerReceiver(br, ift);
		
		try {
            //如果系统触摸音是关的就不用管，开的就把它给关掉，因为在个别手机上有可能会影响音质
		    mAudioManager = ((AudioManager) getSystemService(Context.AUDIO_SERVICE));
            sound = Settings.System.getInt(getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED);
            CustomLog.v("AudioConverseActivity sound: " + sound);
            if(sound == 1) {
                Settings.System.putInt(getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0); 
                mAudioManager.unloadSoundEffects(); 
            }
        } catch (SettingNotFoundException e) {
            e.printStackTrace();  
            CustomLog.v("SettingNotFound SOUND_EFFECTS_ENABLED ...");
        }
		
		if (inCall) {
            CustomLog.v("IncomingCallId = " + IncomingCallId + ",callId = " + getIntent().getStringExtra("callId"));
            converse_information_callId.setText(getIntent().getStringExtra("callId"));
            if(getIntent().hasExtra("callId")) {
                callId = getIntent().getStringExtra("callId");
                if(callId.equals(IncomingCallId)) {
//                  sendBroadcast(new Intent(UIDfineAction.ACTION_DIAL_STATE).putExtra("state", UCSCall.HUNGUP_OTHER));
                    converse_information.setVisibility(View.VISIBLE);
                    converse_information.setText("对方已挂机");
                    UCSCall.stopRinging(AudioConverseActivity.this);
                    handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1000);
                    return;
                }
            }
        }
		
		//通话接通前按钮不可用
        converse_call_mute.setClickable(false);
        converse_call_speaker.setClickable(false);
        converse_call_dial.setClickable(false);
	}

	/**  
	 * @Description 初始化界面上控件的监听器	
	 * @date 2016-1-3 上午10:13:27 
	 * @author xhb  
	 * @return void    返回类型 
	 */
	private void initListener() {
		converse_call_mute.setOnClickListener(this);	//静音
		converse_call_speaker.setOnClickListener(this);	//扬声器
		converse_call_answer.setOnClickListener(this);	//接通
		converse_call_hangup.setOnClickListener(this);	//挂断
		converse_call_endcall.setOnClickListener(this);	//结束通话
		dial_endcall.setOnClickListener(this);			//结束通话（键盘界面中的按钮）
		converse_call_dial.setOnClickListener(this);	//打开键盘
		dial_close.setOnClickListener(this);			//关闭键盘
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

	/**  
	 * @Description 初始化view
	 * @date 2015-12-15 下午2:58:08 
	 * @author xhb  
	 * @return void    返回类型 
	 */
	private void initview() { 
		audio_main = (RelativeLayout) findViewById(R.id.audio_main);
		converse_information_callId = (TextView) findViewById(R.id.converse_information_callId);
		audio_information = (TextView) findViewById(R.id.audio_information); 
		converse_client = (TextView) findViewById(R.id.converse_name);
		converse_information = (TextView) findViewById(R.id.converse_information);
		converse_main = (LinearLayout) findViewById(R.id.converse_main);
		key_layout = (LinearLayout) findViewById(R.id.key_layout);
		key_converse_name = (TextView) findViewById(R.id.key_converse_name); 
		dial_number = (EditText) findViewById(R.id.text_dtmf_number);
		ll_network_call_time = (LinearLayout) findViewById(R.id.ll_network_call_time);
		ll_mute_pad_speaker = (LinearLayout)findViewById(R.id.id_layout_mps);
		converse_network = (ImageView) findViewById(R.id.converse_network);
		converse_call_time = (TextView) findViewById(R.id.converse_call_time); 
		
		converse_call_mute = (ImageButton) findViewById(R.id.converse_call_mute);
		converse_call_speaker = (ImageButton)findViewById(R.id.converse_call_speaker);
		converse_call_answer = (ImageButton)findViewById(R.id.audio_call_answer);
		converse_call_hangup = (ImageButton)findViewById(R.id.audio_call_hangup);
		converse_call_endcall  = (ImageButton)findViewById(R.id.audio_call_endcall);
		dial_endcall  = (ImageButton)findViewById(R.id.dial_endcall);
		converse_call_dial  = (ImageButton)findViewById(R.id.converse_call_dial);
		dial_close = (TextView) findViewById(R.id.dial_close);

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
	 * @Description 初始化数据	
	 * @date 2015-12-15 下午2:57:53 
	 * @author xhb  
	 * @return void    返回类型 
	 */
	private void initData() {
		if(getIntent().hasExtra("call_type")){//直拨 免费电话
			calltype = getIntent().getIntExtra("call_type", 1);
		}
		if(getIntent().hasExtra("callType")){//音频或视频
			mCallType = getIntent().getIntExtra("callType", 1);
		}
		//判断是否是来电信息，默认是去电，（来电信息是由ConnectionService中的onIncomingCall回调中发送广播，开启通话界面，inCall为true）
		if(getIntent().hasExtra("inCall")){
			inCall = getIntent().getBooleanExtra("inCall", false);
			//判断网络类型，2G时提示一下
			int netstate = NetWorkTools.getCurrentNetWorkType(this);
			if (netstate == NetWorkTools.NETWORK_EDGE)
			    Toast.makeText(this, "网络状态差", Toast.LENGTH_SHORT).show();
		}
		//获得要拨打的号码，智能拨打和免费通话：phoneNumber代表ClientID，直拨和回拨代表ClientID绑定的手机号码
		if(getIntent().hasExtra("userId")){
			calledUid = getIntent().getStringExtra("userId");
		}
		if(getIntent().hasExtra("call_phone")){
			calledPhone = getIntent().getStringExtra("call_phone");
		}
		if(getIntent().hasExtra("userName")) {
			userName = getIntent().getStringExtra("userName");
		}
		if(getIntent().hasExtra("phoneNumber")) {
			phoneNumber = getIntent().getStringExtra("phoneNumber");
		}
		if(getIntent().hasExtra("nickName")) {
			nickName = getIntent().getStringExtra("nickName");
		}

		if(phoneNumber != null && phoneNumber.length() > 0) {
			// 先显示通讯录中的昵称
			userName = ContactTools.getConTitle(phoneNumber);
			// 在从IM会话中获取通话记录昵称
			if(TextUtils.isEmpty(userName)) {
				@SuppressWarnings("unchecked")
				List<ConversationInfo> conversationLists = IMManager.getInstance(this).getConversationList(CategoryId.PERSONAL);
				if(conversationLists != null && conversationLists.size() > 0) {
					for (ConversationInfo conversationInfo : conversationLists) {
						if(phoneNumber.equals(conversationInfo.getTargetId())) {
							CustomLog.i("conversation number ...");
							userName = conversationInfo.getConversationTitle();
						}
					}
				}
			}
		}
		if (userName != null && !"".equals(userName)){
		    converse_client.setText(userName);
		} else if(calledUid != null && !"".equals(calledUid)){
			converse_client.setText(calledUid);
		}else if(calledPhone != null && !"".equals(calledPhone)){
			converse_client.setText(calledPhone);
		}
		
		if(calltype == 4) {
			 converse_client.setText("音频同振中");
		}
		
		if(inCall){
			//来电
			if (userName != null && !"".equals(userName)){
				converse_client.setText(userName);
			}else if(nickName != null && !"".equals(nickName)){
				converse_client.setText(nickName);
			}else if(phoneNumber != null && !"".equals(phoneNumber)){
				converse_client.setText(phoneNumber);
			}
			converse_call_answer.setVisibility(View.VISIBLE);
			converse_call_hangup.setVisibility(View.VISIBLE);
			converse_call_endcall.setVisibility(View.GONE);
			if(CHAT_MODE_AUDIO == mCallType){
				converse_information.setText("语音聊天");
			}else{
				converse_information.setText("视频聊天");
			}
			UCSCall.setSpeakerphone(AudioConverseActivity.this, true);
            startRing(AudioConverseActivity.this);
		}else{
			//去电
			converse_call_answer.setVisibility(View.GONE);
			converse_call_hangup.setVisibility(View.VISIBLE);
			converse_call_endcall.setVisibility(View.GONE);
			converse_information.setText("呼叫请求中");
			//进行拨号
			
			UCSCall.startCallRinging(AudioConverseActivity.this,"dialling_tone.pcm");
			Intent intent = new Intent(UIDfineAction.ACTION_DIAL);
			sendBroadcast(intent.putExtra(UIDfineAction.CALL_UID, calledUid).putExtra(UIDfineAction.CALL_PHONE, calledPhone).putExtra("type", calltype));
		}
	}
	
	private BroadcastReceiver br = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction().equals(UIDfineAction.ACTION_DIAL_STATE)){
				int state = intent.getIntExtra("state", 0);
				CustomLog.v(DfineAction.TAG_TCP, "AUDIO_CALL_STATE:"+state);
				if(UIDfineAction.dialState.keySet().contains(state)){
					CustomLog.v(state+UIDfineAction.dialState.get(state));
					//获得通话状态信息
					if(state == 300226){//对方挂断电话
						ll_network_call_time.setVisibility(View.GONE);
						converse_information.setVisibility(View.VISIBLE);
					}
					converse_information.setText(UIDfineAction.dialState.get(state));
				}
				if((calltype == 1 && state == UCSCall.CALL_VOIP_RINGING_180)
						|| (calltype == 5 && state == UCSCall.CALL_VOIP_TRYING_183)){
					UCSCall.setSpeakerphone(AudioConverseActivity.this, true);
					UCSCall.stopRinging(AudioConverseActivity.this);
				}
				//直拨对方响铃即停止本地回玲
				if (calltype == 2 && state == UCSCall.CALL_VOIP_RINGING_180) {
					UCSCall.stopCallRinging(AudioConverseActivity.this);
				}
				if(state == UCSCall.NOT_NETWORK){
					converse_information.setText("当前处于无网络状态");
					UCSCall.stopRinging(AudioConverseActivity.this);
					handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1000);
				}
				if(state == UCSCall.HUNGUP_REFUSAL || state == UCSCall.HUNGUP_MYSELF
						|| state == UCSCall.HUNGUP_OTHER || state == UCSCall.HUNGUP_MYSELF_REFUSAL
						|| state == UCSCall.HUNGUP_RTP_TIMEOUT || state == UCSCall.HUNGUP_OTHER_REASON
						|| state == UCSCall.HUNGUP_GROUP){
					CustomLog.v("收到挂断信息");
					UCSCall.stopRinging(AudioConverseActivity.this);
					handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1000);
				}else{
					if((state >= 300210 && state <= 300260)&&
							(state != 300221 && state != 300222 && state !=300247)
							|| state == UCSCall.HUNGUP_NOT_ANSWER || state == UCSCall.CALL_NUMBER_IS_EMPTY) {
						handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1000);
					}
				}
				
			} else if(intent.getAction().equals(UIDfineAction.ACTION_ANSWER)){
				if(calltype == 4) { // 音频同振中
					converse_client.setText("同振通话中");
				}
				converse_information_callId.setText(intent.getStringExtra("callId")); 
			    AudioConverseActivity.this.setVolumeControlStream(AudioManager.STREAM_VOICE_CALL);
				incallAnswer = true;
				ll_network_call_time.setVisibility(View.VISIBLE); 
				//接通后通知服务开启计时器
				//sendBroadcast(new Intent(UIDfineAction.ACTION_START_TIME));
				converse_information.setVisibility(View.GONE);
				//接通后关闭回铃音
				UCSCall.stopCallRinging(AudioConverseActivity.this);
				converse_call_answer.setVisibility(View.GONE);
				converse_call_hangup.setVisibility(View.GONE);
				converse_call_endcall.setVisibility(View.VISIBLE);
				ll_mute_pad_speaker.setVisibility(View.VISIBLE);
				//接通电话后按钮变为可用
				converse_call_mute.setClickable(true);
		        converse_call_speaker.setClickable(true);
		        converse_call_dial.setClickable(true);
		        
		        //记录通话开始时间
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd-HH:mm");
		        callStartTime = dateFormat.format(new Date());
				boolean isMicMute=UCSCall.isMicMute();

				UCSCall.stopRinging(AudioConverseActivity.this);
				UCSCall.setSpeakerphone(AudioConverseActivity.this, false);
				CustomLog.v("Speakerphone state:" + mAudioManager.isSpeakerphoneOn());
				converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker);
				open_headset = true;

			}else if(intent.getAction().equals(UIDfineAction.ACTION_DIAL_HANGUP)){
				handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1000);
			}else if(intent.getAction().equals(UIDfineAction.ACTION_CALL_TIME)){
				timer = intent.getStringExtra("timer");
				if(converse_call_time != null){
					converse_call_time.setText(timer);
				}
			}else if(intent.getAction().equals(UIDfineAction.ACTION_NETWORK_STATE)){
				int networkState = intent.getIntExtra("state", 0);
				String audioMsg = intent.getStringExtra("videomsg");
				Message msg = handler.obtainMessage();
				msg.what = ACTION_NETWORK_STATE;
				msg.arg1 = networkState;
				msg.obj = audioMsg;
				handler.sendMessageDelayed(msg, 1000);
			} else if(intent.getAction().equals(UIDfineAction.ACTION_PREVIEW_IMG_STATE)) {
				CustomLog.v("previewImgData ...");
				// 视频预览图片回调
				byte[] datas = intent.getByteArrayExtra("previewImgData");
				if(datas != null) {
					Bitmap bitmap = BitmapFactory.decodeByteArray(datas, 0, datas.length);
					Drawable drawable = new BitmapDrawable(bitmap);
					audio_main.setBackground(drawable);
					removeStickyBroadcast(intent); // 移除这条粘性广播
				}
			} else if(intent.getAction().equals("android.intent.action.HEADSET_PLUG")){
				//发现个别手机会接通电话前收到这个广播并把扬声器打开了，所以open_headset作为判断必须接通后再接收耳机插拔广播才有效
				if(intent.getIntExtra("state", 0) == 1 && open_headset){
					CustomLog.e(DfineAction.TAG_TCP,"Speaker false");
					converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker);
					speakerPhoneState = UCSCall.isSpeakerphoneOn(AudioConverseActivity.this);
					UCSCall.setSpeakerphone(AudioConverseActivity.this, false);
                }else if(intent.getIntExtra("state", 0) == 0 && open_headset){//headset disconnected
                	//CustomLog.e("headset unplug");
                	if(speakerPhoneState){
                		//CustomLog.e("Speaker true");
                		converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker_down);
                		UCSCall.setSpeakerphone(AudioConverseActivity.this, true);
                	} else {
                		mAudioManager.setSpeakerphoneOn(false);
						converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker);
                	}
                } 
			}
		}
	};
	private TextView converse_information_callId;
	private TextView audio_information;

	@Override
	protected void onResume() {
		super.onResume();
		CustomLog.v("AudioConverseActivity onResume() ...");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		CustomLog.v("AudioConverseActivity onPause() ...");
	}
	
	@Override
	protected void onDestroy() {
		if(calltype != 4) { // 呼叫同振的记录不保存
			if(mCallType == CHAT_MODE_AUDIO ||
					(mCallType == CHAT_MODE_VIDEO &&incallAnswer == false)){
				if(inCall == true && incallAnswer == false) { // 呼入未接
					addCallRecord(2, inCall, userName, phoneNumber, calledPhone, mCallType, callStartTime, timer);
				} else if(inCall == false && incallAnswer == false) { // 呼出未接
					addCallRecord(3, inCall, userName, phoneNumber, calledPhone, mCallType, callStartTime, timer);
				} else {
					addCallRecord(1, inCall, userName, phoneNumber, calledPhone, mCallType, callStartTime, timer);
				}
			}
		}
		unregisterReceiver(br);
		UCSCall.stopCallRinging(AudioConverseActivity.this);
		CustomLog.i("audioConverseActivity onDestroy() ...");
		if(sound == 1) {  // 如果系统触摸提示音是开的，前面把它给关系，现在退出页面要把它还原
            Settings.System.putInt(getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 1); 
            mAudioManager.loadSoundEffects();   
        }
		super.onDestroy();
	}
	
	/**  
	 * @Description 界面上控件的监听事件
	 * @author xhb
	 * @date 2016-1-3 上午11:36:19 
	 * @return void    返回类型 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)  
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.converse_call_mute:	// 静音
			if(UCSCall.isMicMute()){
				converse_call_mute.setBackgroundResource(R.drawable.converse_mute);
			}else{
				converse_call_mute.setBackgroundResource(R.drawable.converse_mute_down);
			}
			UCSCall.setMicMute(!UCSCall.isMicMute());
			break;
		case R.id.converse_call_speaker:	//扬声器 
			if(UCSCall.isSpeakerphoneOn(AudioConverseActivity.this)){
				converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker);
			}else{
				converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker_down);
			}
			UCSCall.setSpeakerphone(AudioConverseActivity.this, !UCSCall.isSpeakerphoneOn(AudioConverseActivity.this));
			break;
		case R.id.audio_call_answer:	// 接通
			if(CHAT_MODE_AUDIO == mCallType){
				incallAnswer = true;
				ll_network_call_time.setVisibility(View.VISIBLE);
				CustomLog.v(DfineAction.TAG_TCP,"接通电话");
				UCSCall.stopRinging(AudioConverseActivity.this);
				UCSCall.answer("");
			}else if(CHAT_MODE_VIDEO == mCallType){
				startVideoActivity();
			}

			break;
		case R.id.audio_call_hangup:	//挂断 接通前
			CustomLog.v("挂断 ...");
			UCSCall.stopRinging(AudioConverseActivity.this);
			UCSCall.hangUp("");
			sendBroadcast(new Intent(UIDfineAction.ACTION_CALL_STOP_RECALL_TIMER).putExtra("isStopRecall", true));
			handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1500);
			break;
		case R.id.audio_call_endcall:	// 结束通话	接通后
			CustomLog.v(DfineAction.TAG_TCP,"结束电话");
			UCSCall.stopRinging(AudioConverseActivity.this);
			UCSCall.hangUp("");
			handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1500);
			break;
		case R.id.dial_endcall:		// 结束通话（键盘界面中的按钮）
			CustomLog.v(DfineAction.TAG_TCP, "结束电话");
			UCSCall.stopRinging(AudioConverseActivity.this);
			UCSCall.hangUp("");
			handler.sendEmptyMessageDelayed(AUDIO_CONVERSE_CLOSE, 1500);
			break;
		case R.id.converse_call_dial:	//打开键盘
			CustomLog.v(DfineAction.TAG_TCP,"打开键盘");
			key_layout.setVisibility(View.VISIBLE);
			converse_main.removeView(converse_information);
			key_layout.addView(converse_information,1);
			converse_main.removeView(ll_network_call_time);
			key_layout.addView(ll_network_call_time,2);
			if(inCall) {	// 来电
				if (TextUtils.isEmpty(userName) != true){
					key_converse_name.setText(userName);
				}else if("".equals(getIntent().getStringExtra("nickName"))){
					key_converse_name.setText(getIntent().getStringExtra("phoneNumber"));
				}else {
					key_converse_name.setText(getIntent().getStringExtra("nickName"));
				}
			} else {	// 去电
				if (getIntent().getStringExtra("userName") != null){
					key_converse_name.setText(getIntent().getStringExtra("userName"));
				} else if(getIntent().getStringExtra("userId") != null){
					key_converse_name.setText(getIntent().getStringExtra("userId"));
				}else {
					key_converse_name.setText(getIntent().getStringExtra("call_phone"));
				}
			}
			converse_main.setVisibility(View.GONE);
			break;
		case R.id.dial_close:	// 关闭键盘
			CustomLog.v(DfineAction.TAG_TCP,"关闭键盘");
			key_layout.removeView(converse_information);
			key_layout.removeView(ll_network_call_time);
			key_layout.setVisibility(View.GONE);
			converse_main.setVisibility(View.VISIBLE);
			converse_main.addView(converse_information,2);
			converse_main.addView(ll_network_call_time,3);
			break;
		case R.id.digit0:	// DTMF 0
			UCSCall.sendDTMF(KeyEvent.KEYCODE_0,dial_number);
			break;
		case R.id.digit1:	// DTMF 1
			UCSCall.sendDTMF(KeyEvent.KEYCODE_1,dial_number);
			break;
		case R.id.digit2:	// DTMF 2
			UCSCall.sendDTMF(KeyEvent.KEYCODE_2,dial_number);
			break;
		case R.id.digit3:	// DTMF 3
			UCSCall.sendDTMF(KeyEvent.KEYCODE_3,dial_number);
			break;
		case R.id.digit4:	// DTMF 4
			UCSCall.sendDTMF(KeyEvent.KEYCODE_4,dial_number);
			break;
		case R.id.digit5:	// DTMF 5
			UCSCall.sendDTMF(KeyEvent.KEYCODE_5,dial_number);
			break;
		case R.id.digit6:	// DTMF 6
			UCSCall.sendDTMF(KeyEvent.KEYCODE_6,dial_number);
			break;
		case R.id.digit7:	// DTMF 7
			UCSCall.sendDTMF(KeyEvent.KEYCODE_7,dial_number);
			break;
		case R.id.digit8:	// DTMF 8
			UCSCall.sendDTMF(KeyEvent.KEYCODE_8,dial_number);
			break;
		case R.id.digit9:	// DTMF 9
			UCSCall.sendDTMF(KeyEvent.KEYCODE_9,dial_number);
			break;
		case R.id.digit_husa:	// DTMF #
			UCSCall.sendDTMF(KeyEvent.KEYCODE_POUND,dial_number);
			break;
		case R.id.digit_star:	// DTMF *
			UCSCall.sendDTMF(KeyEvent.KEYCODE_STAR,dial_number);
			break;
		default:
			break;
		}
	}

	/**
	 * @Description 开启视频聊天界面
	 * @author xhb
	 * @date 2016-1-20 上午11:36:19
	 * @return void    返回类型
	 */
	private void startVideoActivity(){
		if(inCall){ //视频来电
			Intent intentVideo = new Intent(AudioConverseActivity.this, VideoConverseActivity.class);
			intentVideo.putExtra("phoneNumber", phoneNumber).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intentVideo.putExtra("inCall", true);
			intentVideo.putExtra("nickName", nickName);
			intentVideo.putExtra("callId", callId);
			startActivity(intentVideo);
			this.finish();
		}
	}
}
