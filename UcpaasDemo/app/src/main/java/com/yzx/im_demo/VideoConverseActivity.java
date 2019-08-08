package com.yzx.im_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.yzx.api.RotateType;
import com.yzx.api.UCSCall;
import com.yzx.api.UCSCameraType;
import com.yzx.api.UCSFrameType;
import com.yzx.api.VideoExternFormat;
import com.yzx.listener.IOnSingleTouchListener;
import com.yzx.mydefineview.YZXDragLinearLayout;
import com.yzx.tools.CameraWindow;
import com.yzx.tools.ContactTools;
import com.yzx.tools.FileTools;
import com.yzx.tools.LoginConfig;
import com.yzx.tools.UIDfineAction;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxtcp.tools.CustomLog;
import com.yzxtcp.tools.NetWorkTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class VideoConverseActivity extends ConverseActivity implements OnClickListener {
    private LinearLayout remotelayout;
    private YZXDragLinearLayout locallayout;
    private ImageButton video_call_answer;
    private ImageButton video_call_hangup;
    private ImageButton converse_call_mute;
    private ImageButton converse_call_video;
    private ImageButton converse_call_speaker;
    private ImageButton converse_call_switch;
    private LinearLayout layout_video_function;
    private TextView converse_information;
    private TextView network_information;
    private TextView converse_client;
    private ImageView converse_network;
    private TextView network_tip;
    private LinearLayout ll_video_network_time;
    private TextView converse_time;
    private String phoneNumber;
    public String calledUid;
    public String calledPhone;
    public String userName;
    private boolean open_headset = false;
    private boolean closeVideo = false;
    private boolean inCall;
    private boolean speakerPhoneState = false;
    // private Sensor sensor;
    // private SensorEventListener lsn;
    // private SensorManager mSensor;
    private String timer; // 通话时间
    private String callStartTime = null; // 通话开始时间
    public static String IncomingCallId; // 来电时的callId，作用是防止有些时间挂断电话的信令来了，但是通话界面还没有开启，这个时候在来来电信令，电话就不挂断。
    private boolean incallAnswer = false;
    private static final int VIDIO_CONVERSE_CLOSE = 2; // 关闭界面
    private static final int VIDEO_NETWORK_STATE = 3; // 更新网络状态
    private static final int MSG_REFRESH_VIDEO_TIMER_TEXT = 5;// 刷新视频计时
    private int sound; // 触摸提示音的状态，0：关，1：开
    private boolean bOnCreate = true;// 界面激活是否来自OnCreate
    private AudioManager mAudioManager;
    private boolean bShowNetMsg = false;
    private boolean bConverseClose = false;// 会话界面是否已关闭（挂断后的关闭）
    private volatile boolean error_kickout = false; // 是否被踢线
    private final static int useExternCapture = 0;// 0: not used 1: I420 2:h264
    private static int landscape = 0; // do not change this value,it auto check
    // in code //0:portrait 1:landscape
    private OrientationEventListener mOrientationListener = null;
    private int callType;

    private Handler mHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    CustomLog.i("Video status refresh begin....");
                    // 呼出电话，对方还未接听
                    if (!inCall && !incallAnswer) {
                        UCSCall.refreshCamera(UCSCameraType.LOCALCAMERA, UCSFrameType.ORIGINAL);
                    } else if (closeVideo) { // 本地摄像头已关闭
                        //UCSCall.switchVideoMode(UCSCameraType.REMOTECAMERA);
                        UCSCall.refreshCamera(UCSCameraType.REMOTECAMERA, UCSFrameType.ORIGINAL);
                    } else {
                        converse_call_video.setBackgroundResource(R.drawable.converse_video);
                        if (TextUtils.isEmpty((CharSequence) msg.obj)) {//本端是被叫，已接听
                            UCSCall.refreshCamera(UCSCameraType.ALL, UCSFrameType.ORIGINAL);
                        } else {//界面由后台回到前台
                            UCSCall.refreshCamera(UCSCameraType.BACKGROUNDCAMERA, UCSFrameType.ORIGINAL);
                        }
                    }
                    CustomLog.i("Video status refresh end....");
                    break;
                case 1:
                    if (!bConverseClose) {
                        UCSCall.closeCamera(UCSCameraType.BACKGROUNDCAMERA);
                        CustomLog.v("Video status close ....");
                    }
                    break;
                case VIDIO_CONVERSE_CLOSE: // 关闭界面
                    bConverseClose = true;
                    VideoConverseActivity.this.finish();
                    break;
                case VIDEO_NETWORK_STATE: // 更新网络状态
                    switch (msg.arg1) {
                /*
                 * 0 nice, very good 1 well, good 2 general 3 poor 4 bad
				 */
                        case 0:
                        case 1:
                            converse_network.setBackgroundResource(R.drawable.video_signal3);
                            break;
                        case 2:
                            converse_network.setBackgroundResource(R.drawable.video_signal2);
                            break;
                        case 3:
                            converse_network.setBackgroundResource(R.drawable.video_signal1);
                            break;
                        case 4:
                            converse_network.setBackgroundResource(R.drawable.video_signal0);
                            break;

                        case 10:
                            // 对端视频处于远程视频模式
                            converse_network.setBackgroundResource(R.drawable.video_signal3);
                            break;
                        default:
                            break;
                    }
                    //网络状态太差时给出提示
                    if (msg.arg1 == 4)
                        network_tip.setText("当前通话网络状况不佳");
                    else
                        network_tip.setText("");
                    //显示实时通话质量数据
                    if (bShowNetMsg) {
                        network_information.setVisibility(View.VISIBLE);
                        //整理数据格式使界面显示更清晰
                        //network_information.setText((String) msg.obj + "\n" + UCSCall.getCpsParamterDebug(VideoConverseActivity.this));
                        if (msg.obj != null)
                            network_information.setText(((String) msg.obj).replace("\n ", "\n").replace("  ", " ").replace(", ", "\n") + "\n\n" + UCSCall.getCpsParamterDebug(VideoConverseActivity.this));
                    }
                    break;
                case MSG_REFRESH_VIDEO_TIMER_TEXT:
                    mHandler.removeMessages(MSG_REFRESH_VIDEO_TIMER_TEXT);
                    if (converse_time != null) {
                        converse_time.setText(timer);
                    }
                    break;
            }
        }
    };
    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(UIDfineAction.ACTION_DIAL_STATE)) {
                int state = intent.getIntExtra("state", 0);
                CustomLog.i("VIDEO_CALL_STATE:" + state);
                if (UIDfineAction.dialState.keySet().contains(state)) {
                    if (state == 300226) {
                        ll_video_network_time.setVisibility(View.GONE);
                        converse_information.setVisibility(View.VISIBLE);
                    }
                    converse_information.setText(UIDfineAction.dialState.get(state));
                }
                if (state == UCSCall.HUNGUP_REFUSAL || state == UCSCall.HUNGUP_MYSELF || state == UCSCall.HUNGUP_OTHER
                        || state == UCSCall.HUNGUP_MYSELF_REFUSAL || state == UCSCall.HUNGUP_RTP_TIMEOUT
                        || state == UCSCall.HUNGUP_OTHER_REASON || state == UCSCall.HUNGUP_GROUP) {
                    UCSCall.stopCallRinging(VideoConverseActivity.this);
                    mHandler.sendEmptyMessageDelayed(VIDIO_CONVERSE_CLOSE, 1000);
                } else {
                    if ((state >= 300210 && state <= 300260) && (state != 300221 && state != 300222 && state != 300247)
                            || state == UCSCall.HUNGUP_NOT_ANSWER) {
                        mHandler.sendEmptyMessageDelayed(VIDIO_CONVERSE_CLOSE, 1000);
                    }
                }
                // 本方是主叫 对方正在响铃
                if (!inCall && state == UCSCall.CALL_VOIP_RINGING_180) {
                    UCSCall.refreshCamera(UCSCameraType.LOCALCAMERA, UCSFrameType.ORIGINAL);
                }
                if (state == UCSCall.NOT_NETWORK) {
                    converse_information.setText("当前处于无网络状态");
                    UCSCall.stopRinging(VideoConverseActivity.this);
                    UCSCall.stopCallRinging(VideoConverseActivity.this);
                    mHandler.sendEmptyMessageDelayed(VIDIO_CONVERSE_CLOSE, 1000);
                }
            } else if (intent.getAction().equals(UIDfineAction.ACTION_ANSWER)) {
                if (callType == 5) { // 视频同振
                    converse_client.setText("同振通话中");
                }
                VideoConverseActivity.this.setVolumeControlStream(AudioManager.STREAM_VOICE_CALL);
                converse_information.setVisibility(View.GONE);
                ll_video_network_time.setVisibility(View.VISIBLE);
                incallAnswer = true;
                UCSCall.setSpeakerphone(VideoConverseActivity.this, true);
                converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker_down);
                UCSCall.stopCallRinging(VideoConverseActivity.this);
                UCSCall.stopRinging(VideoConverseActivity.this);
                locallayout.setVisibility(View.VISIBLE);
                remotelayout.setVisibility(View.VISIBLE);
                converse_call_mute.setVisibility(View.VISIBLE);
                converse_call_video.setVisibility(View.VISIBLE);
                converse_call_speaker.setVisibility(View.VISIBLE);
                converse_call_switch.setVisibility(View.VISIBLE);
                layout_video_function.setVisibility(View.VISIBLE);
                video_call_answer.setVisibility(View.GONE);
                open_headset = true;
                if (!UCSCall.isCameraPreviewStatu(VideoConverseActivity.this)) {
                    if (!inCall) {
                        // 本方是主叫，对方已接听
                        UCSCall.switchVideoMode(UCSCameraType.ALL);
                    } else {
                        // 刷新摄像头发送和接收，重要，一定要加这个
                        // mHandler.sendEmptyMessageDelayed(0, 1000);
                        mHandler.sendEmptyMessage(0);
                    }
                }
                // sendBroadcast(new Intent(UIDfineAction.ACTION_START_TIME));

                // 记录通话开始时间
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd-HH:mm");
                callStartTime = dateFormat.format(new Date());

                // 接通电话后按钮变为可用
                converse_call_mute.setClickable(true);
                converse_call_video.setClickable(true);
                converse_call_speaker.setClickable(true);
                converse_call_switch.setClickable(true);
                remotelayout.setClickable(true);
            } else if (intent.getAction().equals(UIDfineAction.ACTION_CALL_TIME)) {
                timer = intent.getStringExtra("timer");
                mHandler.sendEmptyMessage(MSG_REFRESH_VIDEO_TIMER_TEXT);
            } else if (intent.getAction().equals(UIDfineAction.ACTION_NETWORK_STATE)) {
                int state = intent.getIntExtra("state", 0);
                String videoMsg = intent.getStringExtra("videomsg");
                Message msg = mHandler.obtainMessage();
                msg.what = VIDEO_NETWORK_STATE;
                msg.arg1 = state;
                msg.obj = videoMsg;
                mHandler.sendMessageDelayed(msg, 0);
                // CustomLog.v("-----------------------"+state);
            } else if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                // 发现个别手机会接通电话前收到这个广播并把扬声器打开了，所以open_headset作为判断必须接通后再接收耳机插拔广播才有效
                if (intent.getIntExtra("state", 0) == 1 && open_headset) {
                    CustomLog.e("Speaker false");
                    converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker);
                    speakerPhoneState = UCSCall.isSpeakerphoneOn(VideoConverseActivity.this);
                    UCSCall.setSpeakerphone(VideoConverseActivity.this, false);
                } else if (intent.getIntExtra("state", 0) == 0 && open_headset) {
                    CustomLog.e("headset unplug");
                    if (speakerPhoneState) {
                        CustomLog.e("Speaker true");
                        converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker_down);
                        UCSCall.setSpeakerphone(VideoConverseActivity.this, true);
                    }
                }
            } else if (intent.getAction().equals(UIDfineAction.ACTION_NET_ERROR_KICKOUT)) {
                // 踢线广播
                error_kickout = true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomLog.v("1 onCreate callback....");
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            landscape = 0; // 竖屏
        } else {
            landscape = 1; // 横屏
        }

        try {
            // 如果系统触摸音是关的就不用管，开的就把它给关掉，因为在个别手机上有可能会影响音质
            mAudioManager = ((AudioManager) getSystemService(Context.AUDIO_SERVICE));
            sound = Settings.System.getInt(getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED);
            // CustomLog.v("AudioConverseActivity sound: " + sound);
            if (sound == 1) {
                Settings.System.putInt(getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0);
                mAudioManager.unloadSoundEffects();
            }
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
            CustomLog.v("SettingNotFound SOUND_EFFECTS_ENABLED ...");
        }

        // 设置窗体始终点亮
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_video_converse_new);
        initview();
        initListener();
        initData();
        IntentFilter ift = new IntentFilter();
        ift.addAction(UIDfineAction.ACTION_DIAL_STATE);
        ift.addAction(UIDfineAction.ACTION_ANSWER);
        ift.addAction(UIDfineAction.ACTION_CALL_TIME);
        ift.addAction(UIDfineAction.ACTION_NETWORK_STATE);
        ift.addAction(UIDfineAction.ACTION_NET_ERROR_KICKOUT);
        ift.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(br, ift);

        monitorRoation();
        // 初始化视频
        UCSCall.initCameraConfig(VideoConverseActivity.this, remotelayout, locallayout);
        // 将参数设置到SDK
        // VideoDecParam decParam = new VideoDecParam();
        // decParam.ucmaxFramerate = 12; // 帧率
        // VideoEncParam encParam = new VideoEncParam();
        // encParam.usWidth = 240; // 宽
        // encParam.usHeight = 320; // 高
        // encParam.usStartBitrate = 120; // 开始码率
        // encParam.usMaxBitrate = 150; // 最大码率
        // encParam.usMinBitrate = 90; // 最小码率
        // encParam.ucmaxFramerate = 15; // 帧率
        // UCSCall.setVideoAttr(decParam, encParam);
        ll_video_network_time.setVisibility(View.GONE);
        if (useExternCapture > 0) {
            CustomLog.v("useExternCapture ...");
            UCSCall.setVideoExternCapture(VideoExternFormat.h264, true);
            CustomLog.v("ExternCapture:" + UCSCall.getVideoExternCapture());
            TUGo_extern_capture_init();
        }
        if (inCall) {// 来电
            // 判断网络类型，2G时提示一下
            int netstate = NetWorkTools.getCurrentNetWorkType(this);
            if (netstate == NetWorkTools.NETWORK_EDGE)
                Toast.makeText(this, "网络状态差", Toast.LENGTH_SHORT).show();

            video_call_hangup.setVisibility(View.VISIBLE);
            video_call_answer.setVisibility(View.GONE);
            // mHandler.sendEmptyMessageDelayed(0, 1000);
            converse_information.setText("视频电话来电");
            UCSCall.setSpeakerphone(VideoConverseActivity.this, true);
            //startRing(VideoConverseActivity.this);//来电页面已经播放来电铃声故此处去掉
            CustomLog.v("IncomingCallId = " + IncomingCallId + ",callId = " + getIntent().getStringExtra("callId"));
            if (getIntent().hasExtra("callId")) {
                if (getIntent().getStringExtra("callId").equals(IncomingCallId)) {
                    // sendBroadcast(new
                    // Intent(UIDfineAction.ACTION_DIAL_STATE).putExtra("state",
                    // UCSCall.HUNGUP_OTHER));
                    converse_information.setVisibility(View.VISIBLE);
                    converse_information.setText("对方挂断电话");
                    UCSCall.stopRinging(VideoConverseActivity.this);
                    mHandler.sendEmptyMessageDelayed(VIDIO_CONVERSE_CLOSE, 1000);
                    return;
                }
            }
        } else {
            CameraWindow.show(VideoConverseActivity.this);
            video_call_answer.setVisibility(View.GONE);
            video_call_hangup.setVisibility(View.VISIBLE);
            layout_video_function.setVisibility(View.INVISIBLE);
            converse_call_switch.setVisibility(View.INVISIBLE);
            dial();
            converse_information.setText("正在呼叫");
            // UCSCall.refreshCamera(UCSCameraType.ALL);
            locallayout.setVisibility(View.VISIBLE);
            remotelayout.setVisibility(View.VISIBLE);
        }
        // 默认一开始使用前摄像头 0：后摄像头,1:前摄像头
        if (UCSCall.getCameraNum() > 1) {
            UCSCall.switchCameraDevice(1, RotateType.DEFAULT);
        } else {
            UCSCall.switchCameraDevice(0, RotateType.DEFAULT);
        }
        // 通话接通前按钮不可用
        converse_call_mute.setClickable(false);
        converse_call_video.setClickable(false);
        converse_call_speaker.setClickable(false);
        // converse_call_switch.setClickable(false);
        remotelayout.setClickable(false);

        if (inCall) {
            video_call_answer.performClick();
        }
        startOrientationEventListener();
    }

    private void initListener() {
        converse_call_mute.setOnClickListener(this); // 静音
        converse_call_video.setOnClickListener(this); // 摄像头开关
        converse_call_speaker.setOnClickListener(this); // 扬声器
        converse_call_switch.setOnClickListener(this); // 切换摄像头
        video_call_answer.setOnClickListener(this); // 接通
        video_call_hangup.setOnClickListener(this); // 挂断
        remotelayout.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) locallayout.getLayoutParams();
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        locallayout.setLayoutParams(layoutParams);
        locallayout.setOnSingleTouchListener(new IOnSingleTouchListener() {

            @Override
            public void onSingleTouch() {
                // TODO Auto-generated method stub
                if (bShowNetMsg) { // 当前为打开状态则单击关闭
                    bShowNetMsg = !bShowNetMsg;
                    network_information.setText("");
                    network_information.setVisibility(View.GONE);
                    clickList.clear();
                    return;
                }

                clickList.add(SystemClock.uptimeMillis());
                if (clickList.size() == 5) {
                    // 5次连击打开
                    if (clickList.get(clickList.size() - 1) - clickList.get(0) < 2000) {
                        clickList.clear();
                        bShowNetMsg = true;
                        network_information.setText("");
                        network_information.setVisibility(View.VISIBLE);
                    } else {
                        Long tmp = clickList.get(clickList.size() - 1);
                        clickList.clear();
                        clickList.add(tmp);
                    }
                }

				/*
				 * bShowNetMsg = !bShowNetMsg; if (!bShowNetMsg) {
				 * network_information.setText("");
				 * network_information.setVisibility(View.GONE); } else{
				 * network_information.setText("");
				 * network_information.setVisibility(View.VISIBLE); }
				 */
            }
        });
        // locallayout.setOnClickListener(this);
    }

    private void initview() {
        converse_client = (TextView) findViewById(R.id.converse_client);
        converse_information = (TextView) findViewById(R.id.converse_information);
        network_information = (TextView) findViewById(R.id.network_information);
        ll_video_network_time = (LinearLayout) findViewById(R.id.ll_video_network_time);
        converse_network = (ImageView) findViewById(R.id.converse_network);
        network_tip = (TextView) findViewById(R.id.network_tip);
        converse_time = (TextView) findViewById(R.id.converse_time);
        converse_call_switch = (ImageButton) findViewById(R.id.converse_call_switch);
        remotelayout = (LinearLayout) findViewById(R.id.remotelayout);
        locallayout = (YZXDragLinearLayout) findViewById(R.id.locallayout);
        converse_call_mute = (ImageButton) findViewById(R.id.converse_call_mute);
        converse_call_video = (ImageButton) findViewById(R.id.converse_call_video);
        converse_call_speaker = (ImageButton) findViewById(R.id.converse_call_speaker);
        video_call_answer = (ImageButton) findViewById(R.id.video_call_answer);
        video_call_hangup = (ImageButton) findViewById(R.id.video_call_hangup);
        layout_video_function = (LinearLayout) findViewById(R.id.ll_video_function);

        //720P时本地预览的宽高设置成16比9
        if (getSharedPreferences("YZX_DEMO_DEFAULT", 0).getBoolean("YZX_720P", false)) {
            LayoutParams para = (LayoutParams) locallayout.getLayoutParams();
            para.height = para.width * 16 / 9;
            locallayout.setLayoutParams(para);
        }

    }

    /**
     * @return void 返回类型
     * @Description 初始化数据
     * @date 2015-12-15 下午2:57:53
     * @author xhb
     */
    private void initData() {
        // 判断是否是来电信息，默认是去电，（来电信息是由ConnectionService中的onIncomingCall回调中发送广播，开启通话界面，inCall为true）
        if (getIntent().hasExtra("inCall")) {
            Log.e("123","hasExtra="+"inCall");
            inCall = getIntent().getBooleanExtra("inCall", false);
        }
        // 获得要拨打的号码，智能拨打和免费通话：phoneNumber代表ClientID，直拨和回拨代表ClientID绑定的手机号码
        if (getIntent().hasExtra("userId")) {
            calledUid = getIntent().getStringExtra("userId");
            Log.e("123","hasExtra="+"userId"+calledUid);
        }
        if (getIntent().hasExtra("call_phone")) {
            calledPhone = getIntent().getStringExtra("call_phone");
            Log.e("123","hasExtra="+"call_phone"+calledPhone);
        }
        if (getIntent().hasExtra("userName")) {
            userName = getIntent().getStringExtra("userName");
            Log.e("123","hasExtra="+"userName"+userName);
        }
        if (getIntent().hasExtra("phoneNumber")) {
            phoneNumber = getIntent().getStringExtra("phoneNumber");
            Log.e("123","hasExtra="+"phoneNumber"+phoneNumber);
        }

        if (getIntent().hasExtra("call_phone")) {
            phoneNumber = getIntent().getStringExtra("call_phone");
            Log.e("123","hasExtra="+"call_phone2"+phoneNumber);
            CustomLog.v("dialing phone :" + phoneNumber);
        } else if (getIntent().hasExtra("phoneNumber")) {
            phoneNumber = getIntent().getStringExtra("phoneNumber");
            Log.e("123","hasExtra="+"phoneNumber2"+phoneNumber);
        }

        if (phoneNumber != null && phoneNumber.length() > 0) {
            // 先显示通讯录中的昵称
            userName = ContactTools.getConTitle(phoneNumber);
            Log.e("123","userName="+"userName"+userName);
            // 在从IM会话中获取通话记录昵称
            if (TextUtils.isEmpty(userName)) {
                @SuppressWarnings("unchecked")
                List<ConversationInfo> conversationLists = IMManager.getInstance(this).getConversationList(
                        CategoryId.PERSONAL);
                if (conversationLists != null && conversationLists.size() > 0) {
                    for (ConversationInfo conversationInfo : conversationLists) {
                        if (phoneNumber.equals(conversationInfo.getTargetId())) {
                            CustomLog.i("conversation number ...");
                            userName = conversationInfo.getConversationTitle();
                        }
                    }
                }
            }
        }
        if (userName != null && !"".equals(userName)) {
            converse_client.setText(userName);
        } else {
            converse_client.setText(phoneNumber);
        }

        if (getIntent().hasExtra("call_type")) {
            callType = getIntent().getIntExtra("call_type", -1);
            if (callType == 5) { // 视频同振
                converse_client.setText("视频同振中");
                phoneNumber = calledUid;
            }
        }
    }

    private void dial() {
        if (phoneNumber != null && phoneNumber.length() > 0) {
            UCSCall.setSpeakerphone(VideoConverseActivity.this, false);
            if (getIntent().hasExtra("call_type")) {
                sendBroadcast(new Intent(UIDfineAction.ACTION_DIAL).putExtra(UIDfineAction.CALL_UID, phoneNumber)
                        .putExtra("type", getIntent().getIntExtra("call_type", -1)));
            } else {
                sendBroadcast(new Intent(UIDfineAction.ACTION_DIAL).putExtra(UIDfineAction.CALL_UID, phoneNumber)
                        .putExtra("type", 3));
            }
        }
    }

    @Override
    protected void onDestroy() {
        CustomLog.v("1 onDestroy callback....");
        CameraWindow.dismiss();
        if (getIntent().hasExtra("call_type") && getIntent().getIntExtra("call_type", -1) == 5) {
            // 视频同振不保存
        } else {
            if (inCall == true && incallAnswer == false) { // 呼入未接
                addCallRecord(2, inCall, userName, phoneNumber, calledPhone, 2, callStartTime, timer);
            } else if (inCall == false && incallAnswer == false) { // 呼出未接
                addCallRecord(3, inCall, userName, phoneNumber, calledPhone, 2, callStartTime, timer);
            } else {
                addCallRecord(1, inCall, userName, phoneNumber, calledPhone, 2, callStartTime, timer);
            }
        }

        if (sound == 1) { // 如果系统触摸提示音是开的，前面把它给关系，现在退出页面要把它还原
            Settings.System.putInt(getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 1);
            mAudioManager.loadSoundEffects();
        }

        // mHandler.sendEmptyMessageDelayed(1, 100);//
        // 挂断时不调用关闭摄像头操作,因为挂断时会默认把摄像头关闭
        UCSCall.stopRinging(VideoConverseActivity.this);
        UCSCall.stopCallRinging(VideoConverseActivity.this);
        unregisterReceiver(br);
        // mSensor.unregisterListener(lsn);
        mOrientationListener.disable();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        CustomLog.v("1 onResume callback....");
        if (!bOnCreate) {
            // mHandler.sendEmptyMessageDelayed(0, 1000);
            Message msg = mHandler.obtainMessage();
            msg.what = 0;
            msg.obj = "onResume";
            mHandler.sendMessage(msg);
            // mHandler.sendEmptyMessage(0);
        } else {
            bOnCreate = false;
        }

        // 重新注册上监听
        // mSensor = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Sensor sensor = mSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // mSensor.registerListener(lsn, sensor,
        // SensorManager.SENSOR_DELAY_NORMAL);
        mOrientationListener.enable();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        // mHandler.sendEmptyMessageDelayed(0, 1000);
        CustomLog.v("1 onRestart callback....");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        CustomLog.v("1 onpause callback....");
        // mHandler.sendEmptyMessageDelayed(1, 1000);
        if (!error_kickout) { // 如果是踢线，则不需要关闭视频，因为hangup默认就是关闭视频，防止出现anr异常
            // 直接关闭视频，不再延时
            mHandler.sendEmptyMessage(1);
            // mSensor.unregisterListener(lsn);
        }
        mOrientationListener.disable();
        super.onPause();
    }

    @Override
    public void finish() {
        LoginConfig.saveCurrentCall(VideoConverseActivity.this, 0);
        super.finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    /**
     * 控制视频通话页面
     */
    private void monitorRoation() {
        // 初始化旋转方向，避免图像变形问题
        // UCSCall.videoSetSendReciveRotation(360, 360);
        // UCSCall.videoSetSendReciveRotation(0, 0);

		/*
		 * mSensor = (SensorManager) getSystemService(SENSOR_SERVICE); // sensor
		 * = mSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); lsn = new
		 * SensorEventListener() {
		 * 
		 * @SuppressWarnings("deprecation")
		 * 
		 * @Override public void onSensorChanged(SensorEvent e) { float x, y, z;
		 * 
		 * x = e.values[SensorManager.DATA_X]; y =
		 * e.values[SensorManager.DATA_Y]; z = e.values[SensorManager.DATA_Z];
		 * 
		 * if ((x > -4)&&(x < 4)&&(y >= -1)) {
		 * UCSCall.videoUpdateLocalRotation(landscape, 0); } else if (x >= 6) {
		 * UCSCall.videoUpdateLocalRotation(landscape, 90); } else if (x <= -6)
		 * { UCSCall.videoUpdateLocalRotation(landscape, 270); } else if ((x >
		 * -4)&&(x < 4)&&(y < -2)) { UCSCall.videoUpdateLocalRotation(landscape,
		 * 180); }else { } }
		 * 
		 * @Override public void onAccuracyChanged(Sensor arg0, int arg1) { } };
		 */
        // mSensor.registerListener(lsn, sensor,
        // SensorManager.SENSOR_DELAY_NORMAL);
		/*
		 * 上面第三个参数为采样率：最快、游戏、普通、用户界面。当应用程序请求特定的采样率时，其实只是对传感器子系统的一个建议，不保证特定的采样率可用。
		 * 最快： SensorManager.SENSOR_DELAY_FASTEST 延迟时间：0ms
		 * 最低延迟，一般不是特别敏感的处理不推荐使用，
		 * 该种模式可能造成手机电力大量消耗，由于传递的为原始数据，算法不处理好将会影响游戏逻辑和UI的性能。 游戏：
		 * SensorManager.SENSOR_DELAY_GAME 延迟时间：20ms 游戏延迟，一般绝大多数的实时性较高的游戏都使用该级别。
		 * 普通： SensorManager.SENSOR_DELAY_NORMAL 延迟时间：200ms
		 * 标准延迟，对于一般的益智类或EASY级别的游戏可以使用，但过低的采样率可能对一些赛车类游戏有跳帧现象。 用户界面：
		 * SensorManager.SENSOR_DELAY_UI 延迟时间：60ms
		 * 一般对于屏幕方向自动旋转使用，相对节省电能和逻辑处理，一般游戏开发中我们不使用。
		 */
    }

    //
    // private void addCallRecord(int dailFlag) {
    // TelListsInfo user = new TelListsInfo();
    // user.setGravator("");
    // user.setIsTop(0);
    // if(inCall) {
    // if (userName != null && userName.length() > 0){
    // user.setName(userName);
    // } else if(phoneNumber != null && phoneNumber.length() > 0) {
    // user.setName(phoneNumber);
    // }
    // if(phoneNumber != null && phoneNumber.length() > 0) {
    // user.setTelephone(phoneNumber);
    // }
    // user.setDialFlag(dailFlag == 2 ? 2 : 0);
    // } else {
    // if (userName != null && userName.length() > 0){
    // user.setName(userName);
    // } else if(calledPhone != null && calledPhone.length() > 0) {
    // user.setName(calledPhone);
    // }
    // if(calledPhone != null && calledPhone.length() > 0) {
    // user.setTelephone(calledPhone);
    // }
    // user.setDialFlag(dailFlag);
    // }
    // user.setTelMode(2); // 1：代表语音通话,2:代表视频通话
    // if (callStartTime == null || callStartTime.length() == 0) {
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd-HH:mm");
    // callStartTime = dateFormat.format(new Date());
    // }
    // user.setTime(callStartTime);
    // user.setLoginPhone(getSharedPreferences("YZX_DEMO",
    // 1).getString("YZX_ACCOUNT_INDEX", ""));
    // int result = TelListsInfoDBManager.getInstance().insert(user);
    // user.setId(result);
    //
    // TelUsersInfo telUsersInfo = new TelUsersInfo();
    // telUsersInfo.setTelListsInfo(user);
    // telUsersInfo.setDialMessage(timer);
    // CustomLog.v("TelUsersInfo:" + telUsersInfo.toString());
    // TelUserInfoDBManager.getInstance().insert(telUsersInfo);
    // Intent listIntent = new Intent();
    // listIntent.setAction(UIDfineAction.ACTION_TEL_LIST_DATA_UPDATE);
    // listIntent.putExtra("listData", user);
    // sendBroadcast(listIntent);
    // Intent usersIntent = new Intent();
    // usersIntent.setAction(UIDfineAction.ACTION_TEL_USER_INFO_DATA_UPDATE);
    // usersIntent.putExtra("userData", telUsersInfo);
    // sendBroadcast(usersIntent);
    // }

    ArrayList<Long> clickList = new ArrayList<Long>(); // 用于打开网络信息的连击动作时间列表
    boolean isOpenBr = true;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.converse_call_mute: // 静音
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                // String localName = "local_"+phoneNumber+"_"+format.format(new
                // Date())+".jpg";
                String remoteName = "remote_" + "15219483291" + "_" + format.format(new Date()) + ".jpg";
                // UCSCall.videoCapture(UCSCameraType.LOCALCAMERA, localName,
                // FileTools.getSdCardFilePath());
                UCSCall.videoCapture(UCSCameraType.REMOTECAMERA, remoteName, FileTools.getSdCardFilePath());
                if (UCSCall.isMicMute()) {
                    converse_call_mute.setBackgroundResource(R.drawable.converse_mute);
                } else {
                    converse_call_mute.setBackgroundResource(R.drawable.converse_mute_down);
                }
                UCSCall.setMicMute(!UCSCall.isMicMute());
                break;
            case R.id.converse_call_video: // 摄像头开关
                if (closeVideo) {
                    // 开启自己的摄像头
                    closeVideo = false;
                    converse_call_video.setBackgroundResource(R.drawable.converse_video);
                    UCSCall.switchVideoMode(UCSCameraType.ALL);
                } else {
                    // 关闭自己的摄像头
                    closeVideo = true;
                    converse_call_video.setBackgroundResource(R.drawable.converse_video_down);
                    UCSCall.switchVideoMode(UCSCameraType.REMOTECAMERA);
                }
                break;
            case R.id.converse_call_speaker: // 扬声器
                if (UCSCall.isSpeakerphoneOn(VideoConverseActivity.this)) {
                    converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker);
                } else {
                    converse_call_speaker.setBackgroundResource(R.drawable.converse_speaker_down);
                }
                UCSCall.setSpeakerphone(VideoConverseActivity.this, !UCSCall.isSpeakerphoneOn(VideoConverseActivity.this));
                break;
            case R.id.converse_call_switch: // 切换摄像头
                CustomLog.e("当前摄像头：" + UCSCall.getCurrentCameraIndex());
                if (UCSCall.getCurrentCameraIndex() == 0) { // 横屏状态是RETATE_0
                    if (UCSCall.getCameraNum() > 1) {
                        UCSCall.switchCameraDevice(1, RotateType.DEFAULT);
                    }
                } else {
                    UCSCall.switchCameraDevice(0, RotateType.DEFAULT);
                }
                break;
            case R.id.video_call_answer: // 接通
                CustomLog.v("接通电话");
                converse_information.setVisibility(View.GONE);
                ll_video_network_time.setVisibility(View.VISIBLE);
                incallAnswer = true;
                UCSCall.stopRinging(VideoConverseActivity.this);
                UCSCall.answer("");
                UCSCall.setSpeakerphone(VideoConverseActivity.this, false);
                break;
            case R.id.video_call_hangup: // 挂断
                CustomLog.v("界面挂断电话");
                UCSCall.stopRinging(VideoConverseActivity.this);
                UCSCall.hangUp("");
                sendBroadcast(new Intent(UIDfineAction.ACTION_CALL_STOP_RECALL_TIMER).putExtra("isStopRecall", true));
                mHandler.sendEmptyMessageDelayed(VIDIO_CONVERSE_CLOSE, 1000);
                break;
            case R.id.remotelayout:
                toggleVideoView();
                break;
            // case R.id.locallayout: // 打开或关闭网络信息
            //
            // break;

            default:
                break;
        }
    }

    /**
     * @author zhangbin
     * @2016-1-14 @
     * @descript:切换视频通过中视图的显示
     */
    private void toggleVideoView() {
        // 切换显示视频功能按键 显示视频切换按键 挂机按键
        if (layout_video_function.getVisibility() == View.VISIBLE) {
            layout_video_function.setVisibility(View.INVISIBLE);
            converse_call_switch.setVisibility(View.INVISIBLE);
            video_call_hangup.setVisibility(View.INVISIBLE);
        } else {
            layout_video_function.setVisibility(View.VISIBLE);
            converse_call_switch.setVisibility(View.VISIBLE);
            video_call_hangup.setVisibility(View.VISIBLE);
        }
    }

    private final static int width = 352;
    private final static int height = 288;
    private byte data264[];
    private int nal_array[] = new int[10000];
    private int i_nal = 0;

    private int TUGo_extern_capture_init() {
        if (useExternCapture == 2) {
            File file = new File(FileTools.getDefaultSdCardPath() + "/out.264");
            Reader reader = null;
            long data_len;
            FileInputStream fInputStream;
            try {
                fInputStream = new FileInputStream(FileTools.getDefaultSdCardPath() + "/out.264");
            } catch (FileNotFoundException e) {
                return 0;
            }
            data_len = file.length();
            data264 = new byte[(int) data_len];
            int len = 0;
            try {
                int charread = fInputStream.read(data264);
            } catch (IOException e) {
                e.printStackTrace();
            }

            i_nal = 0;

            for (len = 0; len < data_len - 4; len++) {
                if (data264[len + 0] == 0 && data264[len + 1] == 0 && data264[len + 2] == 0 && data264[len + 3] == 1) {
                    nal_array[i_nal++] = len;
                    len += 4;
                    continue;
                }
                if (data264[len + 0] == 0 && data264[len + 1] == 0 && data264[len + 2] == 1) {
                    nal_array[i_nal++] = len;
                    len += 4;
                    continue;
                }

                len++;
            }
        }
        captureTimer.schedule(task, 1000, 200);
        return 0;
    }

    Timer captureTimer = new Timer();
    byte sendbyte[] = new byte[1];
    int sendNalIdx = 0;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (sendbyte.length < nal_array[sendNalIdx + 1] - nal_array[sendNalIdx]) {
                sendbyte = new byte[nal_array[sendNalIdx + 1] - nal_array[sendNalIdx]];
            }
            for (int i = nal_array[sendNalIdx]; i < nal_array[sendNalIdx + 1]; i++) {
                sendbyte[i - nal_array[sendNalIdx]] = data264[i];
            }
            if (i_nal > 10 && UCSCall.getVideoExternCapture()) {
                // CustomLog.v("send len " + (nal_array[sendNalIdx+1] -
                // nal_array[sendNalIdx]) );
                UCSCall.VideoIncomingFrame(sendbyte, nal_array[sendNalIdx + 1] - nal_array[sendNalIdx]);
            }
            sendNalIdx++;
            if (sendNalIdx >= i_nal - 4) {
                sendNalIdx = 0;
            }
        }
    };

    private void startOrientationEventListener() {
        mOrientationListener = new OrientationEventListener(this) {

            @Override
            public void onOrientationChanged(int orientation) {
                // Log.v("orientation", orientation + "");
                if (orientation == OrientationEventListener.ORIENTATION_UNKNOWN) {
                    if (landscape == 0) {
                        UCSCall.videoUpdateLocalRotation(landscape, 0);
                    } else if (landscape == 1) {
                        UCSCall.videoUpdateLocalRotation(landscape, 90);
                    }
                } else if (orientation <= 45 || orientation > 315) {
                    UCSCall.videoUpdateLocalRotation(landscape, 0);
                } else if (orientation > 45 && orientation <= 135) {
                    UCSCall.videoUpdateLocalRotation(landscape, 270);
                } else if (orientation > 135 && orientation <= 225) {
                    UCSCall.videoUpdateLocalRotation(landscape, 180);
                } else if (orientation > 225 && orientation <= 315) {
                    UCSCall.videoUpdateLocalRotation(landscape, 90);
                }
            }

        };
    }
}
