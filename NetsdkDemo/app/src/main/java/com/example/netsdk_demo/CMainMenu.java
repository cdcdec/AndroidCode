package com.example.netsdk_demo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sdk.NETDEV_AUDIO_SAMPLE_PARAM_S;
import com.sdk.NETDEV_CLOUD_NOACCOUNT_INFO_S;
import com.sdk.NETDEV_DEVICE_BASICINFO_S;
import com.sdk.NETDEV_FILECOND_S;
import com.sdk.NETDEV_FINDDATA_S;
import com.sdk.NETDEV_MONTH_INFO_S;
import com.sdk.NETDEV_MONTH_STATUS_S;
import com.sdk.NETDEV_PLAYBACKCOND_S;
import com.sdk.NETDEV_PLAYBACKCONTROL_S;
import com.sdk.NETDEV_PREVIEWINFO_S;
import com.sdk.NETDEV_TIME_S;
import com.sdk.NETDEV_VIDEO_CHL_DETAIL_INFO_S;
import com.sdk.NetDEVSDK;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

//import com.example.dev.LiveActivity.inputTalkThread;
//import com.sdk.NetDEVSDK.OnNotifyListener;
public class CMainMenu extends Activity {

    private static String strDevIP = null;
    private static String strCloudDevName = null;
    static Map<String, List<NETDEV_VIDEO_CHL_DETAIL_INFO_S>> NameChannelMap = new HashMap<String, List<NETDEV_VIDEO_CHL_DETAIL_INFO_S>>();
    static Map<String, Integer> ipLpUserIDMap = new HashMap<String, Integer>();
    static Map<String, Integer> nameLpUserIDMap = new HashMap<String, Integer>();
    private static boolean isLocalDevFlag;
    private static boolean isNoAccountDevFlag;
    private ActionBar m_oActionBar;
    private TextView m_oTabLiveView;
    private TextView m_oTabRecord;
    private TextView m_oTabMore;
    private FrameLayout m_oFrameLayoutParent;
    private View m_oLiveView, m_oRecordView, m_oMoreView, m_oAlarmView;

    /* Liveview */
    private Button m_oPTZSetPtrsetBtn;
    private Button m_oGetPTZPresetBtn;
    private Button m_oStartLiveViewBtn;
    private Button m_oStopLiveViewBtn;
    private Button m_oSnapshotBtn;
    private Button startTalkBackBtn;
    private Button stopTalkBackBtn;
    //private Button mRecordButton;
    private Spinner m_oChannelList;
    private Button m_oFocusFarBtn;
    private Button m_oFocusNearBtn;
    private Button m_oAddDevice;
    private Button m_oZoomInBtn;
    private Button m_oZoomOutBtn;
    public static int lpLiveViewHandle[] = new int[4];     //live video ID
    public static float scaleRatio[] = new float[4];     //live video ID
    public CPlayView m_oPlayer;        //Live GLsurfaceADMIN12345
    public CPlayView m_oPlayer1;        //Live GLsurfaceADMIN12345
    public CPlayView m_oPlayer2;        //Live GLsurfaceADMIN12345
    public CPlayView m_oPlayer3;        //Live GLsurfaceADMIN12345

    public CPlayView m_oPlayBack;        //Live GLsurfaceADMIN12345
    /*ptz derection control*/
    LayoutInflater m_oPTZPreset;
    private Button m_oUpBtn;
    private Button m_DownBtn;
    private Button m_oLeftBtn;
    private Button m_oRightBtn;
    private Button m_oLeftUpBtn;
    private Button m_oRightUpBtn;
    private Button m_oLeftdownBtn;
    private Button m_oRightdownBtn;
    private Button m_oStopPTZBtn;


    /* Playback */
    private Button m_oStartPlayBackBtn;
    private Button m_oPauseBtn;
    private Button m_oResumeBtn;
    private Button m_oStopPlayBackBtn;
    private Button m_oForwardBtn;
    private Button m_oBackwardBtn;
    private Button mDownloadButton;
    private Button mStopDownloadButton;
    private TextView m_oPlaySpeed;

    private Button m_oQueryRecordBtn;
    private NETDEV_PLAYBACKCOND_S m_stCurrentPlayInfo;    //information of current record file
    //public static int lpPlaybackHandle;                //record video ID
    public static int lpPlaybackPlayerHandle[] = new int[4];     //live video ID
    public CPlayView m_oPlaybackPlayer;        //Live GLsurfaceADMIN12345
    public CPlayView m_oPlaybackPlayer1;        //Live GLsurfaceADMIN12345
    public CPlayView m_oPlaybackPlayer2;        //Live GLsurfaceADMIN12345
    public CPlayView m_oPlaybackPlayer3;        //Live GLsurfaceADMIN12345
    //public static int lpDownloadID;
    //boolean isDownload;

    /*more*/
    LayoutInflater m_oMoreSetDevTime;
    private Button m_oDevInfoBtn;
    private Button m_oAlarmInfoBtn;
    private Button m_oDeviceTimeBtn;
    private Button m_oSetDeviceTimeBtn;
    private Button m_oCalendarQueryBtn;
    private Button m_oLogoutBtn;

    private Button m_oStopRecordBtn;
    private Button m_oRecordBtn;

    private LinearLayout m_oLiveLinear1;
    private LinearLayout m_oLiveLinear2;

    //private int mVoiceComHandle;
    //private AudioTrack mAudioPlayer;
    //private AudioRecord mAudioRecorder;
    //private boolean m_keep_running;
    protected byte[] m_stInBytes;
    //private int buf_size;
    private NetDEVSDK m_oNetDEVSDK = new NetDEVSDK();
    //public SurfaceView mViewLive;
    //public SurfaceHolder mViewHolder;
    private ArrayAdapter<String> m_oChnAdapter;
    private int m_dwChannelID;
    private int m_lpVoiceComHandle = 0;
    private boolean m_bKeepRunning;
    private AudioTrack mAudioPlayer;
    private AudioRecord mAudioRecorder;
    private boolean m_keep_running;
    protected byte[] m_in_bytes;
    private int buf_size;
    public static int PlaybackStatus[] = new int[10];

    /*
    public class ReceiveAudioDataThread extends Thread {
        @Override
        public void run() {
            ReceiveAudioData();
        }
        }

    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        m_oActionBar = getActionBar();
        m_oActionBar.hide();

        m_oTabLiveView = (TextView) findViewById(R.id.liveview);
        m_oTabRecord = (TextView) findViewById(R.id.playback);
        m_oTabMore = (TextView) findViewById(R.id.more_function);

        m_oTabLiveView.setOnClickListener(oTabListener);
        m_oTabRecord.setOnClickListener(oTabListener);
        m_oTabMore.setOnClickListener(oTabListener);

        m_oFrameLayoutParent = (FrameLayout) findViewById(R.id.fragment_container);
        m_oLiveView = getLayoutInflater().inflate(R.layout.live_view, null);
        m_oRecordView = getLayoutInflater().inflate(R.layout.playback, null);
        m_oMoreView = getLayoutInflater().inflate(R.layout.more, null);
        m_oAlarmView = getLayoutInflater().inflate(R.layout.alarm_report, null);

        m_oFrameLayoutParent.addView(m_oLiveView);
        m_oFrameLayoutParent.addView(m_oRecordView);
        m_oFrameLayoutParent.addView(m_oMoreView);
        m_oFrameLayoutParent.addView(m_oAlarmView);

        m_oLiveView.setVisibility(View.VISIBLE);
        m_oRecordView.setVisibility(View.GONE);
        m_oMoreView.setVisibility(View.GONE);
        m_oAlarmView.setVisibility(View.GONE);

        m_oTabLiveView.setSelected(true);

        m_oAddDevice = (Button) m_oLiveView.findViewById(R.id.add_device);
        m_oAddDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopLive();
                if (ipLpUserIDMap.isEmpty()) {//cloud dev
                    Intent i = new Intent(CMainMenu.this, CCloudDevlogin.class);
                    startActivity(i);
                } else {//local dev
                    isLocalDevFlag = true;
                    Intent i = new Intent(CMainMenu.this, CLocalDevLogin.class);
                    startActivity(i);
                }
            }
        });
        initView();
    }

    public void childVisibale() {
        m_oLiveView.setVisibility(View.GONE);
        m_oRecordView.setVisibility(View.GONE);
        m_oMoreView.setVisibility(View.GONE);
        m_oAlarmView.setVisibility(View.GONE);
    }

    private void initView() {
        m_oPTZPreset = LayoutInflater.from(this);
        m_oMoreSetDevTime = LayoutInflater.from(this);

        /*live*/
        m_oPTZSetPtrsetBtn = (Button) m_oLiveView.findViewById(R.id.set);
        startTalkBackBtn = (Button) m_oLiveView.findViewById(R.id.startTalkBack);
        stopTalkBackBtn = (Button) m_oLiveView.findViewById(R.id.stopTalkBack);
        m_oGetPTZPresetBtn = (Button) m_oLiveView.findViewById(R.id.get);
        m_oStartLiveViewBtn = (Button) m_oLiveView.findViewById(R.id.startLiveView);
        m_oStopLiveViewBtn = (Button) m_oLiveView.findViewById(R.id.stopLiveView);
        m_oSnapshotBtn = (Button) m_oLiveView.findViewById(R.id.capture);

        //mRecordButton = (Button) LiveView.findViewById(R.id.record);
        m_oChannelList = (Spinner) m_oLiveView.findViewById(R.id.channelList);
        m_oPlayer = (CPlayView) m_oLiveView.findViewById(R.id.liveview_View);
        m_oPlayer1 = (CPlayView) m_oLiveView.findViewById(R.id.liveview1_View);
        m_oPlayer2 = (CPlayView) m_oLiveView.findViewById(R.id.liveview2_View);
        m_oPlayer3 = (CPlayView) m_oLiveView.findViewById(R.id.liveview3_View);
        m_oFocusFarBtn = (Button) m_oLiveView.findViewById(R.id.far);
        m_oFocusNearBtn = (Button) m_oLiveView.findViewById(R.id.near);
        m_oZoomInBtn = (Button) m_oLiveView.findViewById(R.id.zoomin);
        m_oZoomOutBtn = (Button) m_oLiveView.findViewById(R.id.zoomout);
        m_oFocusFarBtn.setOnTouchListener(oPTZCtrlListener);
        m_oFocusNearBtn.setOnTouchListener(oPTZCtrlListener);
        m_oZoomInBtn.setOnTouchListener(oPTZCtrlListener);
        m_oZoomOutBtn.setOnTouchListener(oPTZCtrlListener);

        /*ptz*/
        m_oUpBtn = (Button) m_oLiveView.findViewById(R.id.up);
        m_DownBtn = (Button) m_oLiveView.findViewById(R.id.down);
        m_oLeftBtn = (Button) m_oLiveView.findViewById(R.id.left);
        m_oRightBtn = (Button) m_oLiveView.findViewById(R.id.right);
        m_oLeftUpBtn = (Button) m_oLiveView.findViewById(R.id.left_up);
        m_oRightUpBtn = (Button) m_oLiveView.findViewById(R.id.right_up);
        m_oLeftdownBtn = (Button) m_oLiveView.findViewById(R.id.left_down);
        m_oRightdownBtn = (Button) m_oLiveView.findViewById(R.id.right_down);
        m_oStopPTZBtn = (Button) m_oLiveView.findViewById(R.id.stopptz);
        m_oStopRecordBtn = (Button) m_oLiveView.findViewById(R.id.stopRecord);
        m_oRecordBtn = (Button) m_oLiveView.findViewById(R.id.record);
        m_oUpBtn.setOnTouchListener(oPTZCtrlListener);
        m_DownBtn.setOnTouchListener(oPTZCtrlListener);
        m_oLeftBtn.setOnTouchListener(oPTZCtrlListener);
        m_oRightBtn.setOnTouchListener(oPTZCtrlListener);
        m_oLeftUpBtn.setOnTouchListener(oPTZCtrlListener);
        m_oRightUpBtn.setOnTouchListener(oPTZCtrlListener);
        m_oLeftdownBtn.setOnTouchListener(oPTZCtrlListener);
        m_oRightdownBtn.setOnTouchListener(oPTZCtrlListener);
        m_oStopPTZBtn.setOnTouchListener(oPTZCtrlListener);
        scaleRatio[0] = 1.0f;
        scaleRatio[1] = 1.0f;
        scaleRatio[2] = 1.0f;
        scaleRatio[3] = 1.0f;
        /*record*/
        m_oStartPlayBackBtn = (Button) m_oRecordView.findViewById(R.id.startPlayback);
        m_oPauseBtn = (Button) m_oRecordView.findViewById(R.id.pause);
        m_oResumeBtn = (Button) m_oRecordView.findViewById(R.id.resume);
        m_oStopPlayBackBtn = (Button) m_oRecordView.findViewById(R.id.stopPlayback);
        m_oForwardBtn = (Button) m_oRecordView.findViewById(R.id.forward);
        m_oBackwardBtn = (Button) m_oRecordView.findViewById(R.id.backward);
        m_oPlaySpeed = (TextView) m_oRecordView.findViewById(R.id.playspeed);
        mDownloadButton = (Button) m_oRecordView.findViewById(R.id.startDownload);
        mStopDownloadButton = (Button) m_oRecordView.findViewById(R.id.StopDownload);
        m_oQueryRecordBtn = (Button) m_oRecordView.findViewById(R.id.queryRecordFile);
        m_oPlaybackPlayer = (CPlayView) m_oRecordView.findViewById(R.id.playback_View);
        m_oPlaybackPlayer1 = (CPlayView) m_oRecordView.findViewById(R.id.playback1_View);
        m_oPlaybackPlayer2 = (CPlayView) m_oRecordView.findViewById(R.id.playback2_View);
        m_oPlaybackPlayer3 = (CPlayView) m_oRecordView.findViewById(R.id.playback3_View);

        m_oDevInfoBtn = (Button) m_oMoreView.findViewById(R.id.device_info);
        m_oAlarmInfoBtn = (Button) m_oMoreView.findViewById(R.id.alarm_info);
        m_oDeviceTimeBtn = (Button) m_oMoreView.findViewById(R.id.DeviceTime);
        m_oSetDeviceTimeBtn = (Button) m_oMoreView.findViewById(R.id.setDeviceTime);
        m_oCalendarQueryBtn = (Button) m_oMoreView.findViewById(R.id.CalendarQuery);
        m_oLogoutBtn = (Button) m_oMoreView.findViewById(R.id.logout);

        m_oLiveLinear1 = (LinearLayout) m_oLiveView.findViewById(R.id.live_linear1);
        m_oLiveLinear2 = (LinearLayout) m_oLiveView.findViewById(R.id.live_linear2);

        final Intent intent = getIntent();
        ArrayList<String> szIPList = intent.getStringArrayListExtra("szIP");
        ArrayList<String> szDevNameList = intent.getStringArrayListExtra("szDevName");
        ArrayList<Integer> lpUserIDList = intent.getIntegerArrayListExtra("lpUserID");
        ArrayList<Integer> cloudLpUserIDList = intent.getIntegerArrayListExtra("cloudLpUserID");
        boolean bLocalDevFlag = intent.getBooleanExtra("bLocalDevFlag", false);
        boolean bNoAccountDevFlag = intent.getBooleanExtra("bNoAccountDevFlag", false);
        if(bNoAccountDevFlag)
        {
            isNoAccountDevFlag = bNoAccountDevFlag;
        }

        if (bLocalDevFlag) {//true is local dev
            isLocalDevFlag = bLocalDevFlag;
            Spinner IpSpinner = (Spinner) findViewById(R.id.device_spinner);
            ArrayAdapter<String> m_oIpAdapter = new ArrayAdapter<String>(CMainMenu.this, android.R.layout.simple_spinner_item, szIPList);
            IpSpinner.setAdapter(m_oIpAdapter);
            if (szIPList.size() > 0) {
                IpSpinner.setSelection(szIPList.size() - 1, true);
            }
            strDevIP = szIPList.get(szIPList.size() - 1);
            Integer value = lpUserIDList.get(lpUserIDList.size() - 1);
            ipLpUserIDMap.put(strDevIP, value);

            List<NETDEV_VIDEO_CHL_DETAIL_INFO_S> list = new ArrayList<NETDEV_VIDEO_CHL_DETAIL_INFO_S>();
            list = NetDEVSDK.NETDEV_QueryVideoChlDetailList(ipLpUserIDMap.get(strDevIP), 64);

            m_oChnAdapter = new ArrayAdapter<String>(CMainMenu.this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<String>());
            m_oChannelList.setAdapter(m_oChnAdapter);
            for (int i = 0; i < (list == null ? 0 : list.size()); i++) {
                NETDEV_VIDEO_CHL_DETAIL_INFO_S tmp = list.get(i);
                System.out.println(i + " Status --" + tmp.bPtzSupported);
                m_oChnAdapter.add("Channel - " + tmp.dwChannelID + ": Status -" + ((tmp.enStatus != 0) ? "Online" : "Offline") + "  Ptz -" + ((tmp.bPtzSupported != 0) ? "Yes" : "No"));
            }


            IpSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int x, long l) {
                    strDevIP = adapterView.getItemAtPosition(x).toString();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            m_oChnAdapter = new ArrayAdapter<String>(CMainMenu.this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<String>());
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    m_oChannelList.setAdapter(m_oChnAdapter);
                                }
                            });
                        }
                    }).start();
                    List<NETDEV_VIDEO_CHL_DETAIL_INFO_S> list = NetDEVSDK.NETDEV_QueryVideoChlDetailList(ipLpUserIDMap.get(strDevIP), 64);
                    for (int i = 0; i < list.size(); i++) {
                        NETDEV_VIDEO_CHL_DETAIL_INFO_S tmp = list.get(i);
                        System.out.println(i + " Status --" + tmp.bPtzSupported);
                        m_oChnAdapter.add("Channel - " + tmp.dwChannelID + ": Status -" + ((tmp.enStatus != 0) ? "Online" : "Offline") + "  Ptz -" + ((tmp.bPtzSupported != 0) ? "Yes" : "No"));
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        } else {//cloud dev
            isLocalDevFlag = bLocalDevFlag;
            Spinner NameSpinner = (Spinner) findViewById(R.id.device_spinner);
            ArrayAdapter<String> m_oNameAdapter = new ArrayAdapter<String>(CMainMenu.this, android.R.layout.simple_spinner_item, szDevNameList);
            NameSpinner.setAdapter(m_oNameAdapter);
            if (szDevNameList.size() > 0) {
                NameSpinner.setSelection(szDevNameList.size() - 1, true);
            }
            strCloudDevName = szDevNameList.get(szDevNameList.size() - 1);
            Integer value = cloudLpUserIDList.get(cloudLpUserIDList.size() - 1);
            nameLpUserIDMap.put(strCloudDevName, value);

            List<NETDEV_VIDEO_CHL_DETAIL_INFO_S> chlList = new ArrayList<NETDEV_VIDEO_CHL_DETAIL_INFO_S>();
            chlList = NetDEVSDK.NETDEV_QueryVideoChlDetailList(nameLpUserIDMap.get(strCloudDevName), 64);
            m_oChnAdapter = new ArrayAdapter<String>(CMainMenu.this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<String>());
            m_oChannelList.setAdapter(m_oChnAdapter);
            for (int i = 0; i < (chlList == null ? 0 : chlList.size()); i++) {
                NETDEV_VIDEO_CHL_DETAIL_INFO_S tmp = chlList.get(i);
                System.out.println(i + " Status -" + ((tmp.enStatus != 0) ? "Online" : "Offline"));
                m_oChnAdapter.add("Channel - " + tmp.dwChannelID + ": Status -" + ((tmp.enStatus != 0) ? "Online" : "Offline") + "  Ptz -" + ((tmp.bPtzSupported != 0) ? "Yes" : "No"));
            }
            NameChannelMap.put(szDevNameList.get(szDevNameList.size() - 1), chlList);
            NameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int x, long l) {
                    strCloudDevName = adapterView.getItemAtPosition(x).toString();
                    List<NETDEV_VIDEO_CHL_DETAIL_INFO_S> list = NameChannelMap.get(strCloudDevName);
                    m_oChnAdapter = new ArrayAdapter<String>(CMainMenu.this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<String>());
                    m_oChannelList.setAdapter(m_oChnAdapter);
                    if (list == null) {
                        return;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        NETDEV_VIDEO_CHL_DETAIL_INFO_S tmp = list.get(i);
                        System.out.println(i + " Status --" + ((tmp.enStatus != 0) ? "Online" : "Offline"));
                        m_oChnAdapter.add("Channel - " + tmp.dwChannelID + ": Status -" + ((tmp.enStatus != 0) ? "Online" : "Offline") + "  Ptz -" + ((tmp.bPtzSupported != 0) ? "Yes" : "No"));
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        m_oPlayer.m_dwWinIndex = 1;
        m_oPlayer1.m_dwWinIndex = 2;
        m_oPlayer2.m_dwWinIndex = 3;
        m_oPlayer3.m_dwWinIndex = 4;
        m_oPlayer.m_bCanDrawFrame = false;
        m_oPlayer1.m_bCanDrawFrame = false;
        m_oPlayer2.m_bCanDrawFrame = false;
        m_oPlayer3.m_bCanDrawFrame = false;

        m_oPlaybackPlayer.m_dwWinIndex = 1;
        m_oPlaybackPlayer1.m_dwWinIndex = 2;
        m_oPlaybackPlayer2.m_dwWinIndex = 3;
        m_oPlaybackPlayer3.m_dwWinIndex = 4;
        m_oPlaybackPlayer.m_bCanDrawFrame = false;
        m_oPlaybackPlayer1.m_bCanDrawFrame = false;
        m_oPlaybackPlayer2.m_bCanDrawFrame = false;
        m_oPlaybackPlayer3.m_bCanDrawFrame = false;
        NetDEVSDK.gdwWinIndex = 1;
        LiveView();/*initial main interface*/


        PlaybackStatus[0] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_16_BACKWARD_IFRAME;
        PlaybackStatus[1] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_8_BACKWARD_IFRAME;
        PlaybackStatus[2] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_4_BACKWARD_IFRAME;
        PlaybackStatus[3] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_2_BACKWARD_IFRAME;
        PlaybackStatus[4] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_1_BACKWARD;
        PlaybackStatus[5] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_1_FORWARD;
        PlaybackStatus[6] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_2_FORWARD_IFRAME;
        PlaybackStatus[7] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_4_FORWARD_IFRAME;
        PlaybackStatus[8] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_8_FORWARD_IFRAME;
        PlaybackStatus[9] = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_16_FORWARD_IFRAME;

        m_oChnAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<String>());
    }

   Handler mHandler = new Handler();

    public void selected() {
        m_oTabLiveView.setSelected(false);
        m_oTabRecord.setSelected(false);
        m_oTabMore.setSelected(false);
    }

    private View.OnClickListener oTabListener = new OnClickListener() {
        public void onClick(View v) {
            // TODO Auto-generated method stub

            switch (v.getId()) {
                case R.id.liveview:
                    selected();
                    m_oTabLiveView.setSelected(true);
                    childVisibale();
                    m_oPlaybackPlayer.setVisibility(View.GONE);
                    m_oPlaybackPlayer1.setVisibility(View.GONE);
                    m_oPlaybackPlayer2.setVisibility(View.GONE);
                    m_oPlaybackPlayer3.setVisibility(View.GONE);

                    m_oPlayer.setVisibility(View.VISIBLE);
                    m_oPlayer1.setVisibility(View.VISIBLE);
                    m_oPlayer2.setVisibility(View.VISIBLE);
                    m_oPlayer3.setVisibility(View.VISIBLE);
                    m_oLiveView.setVisibility(View.VISIBLE);

                    NetDEVSDK.gdwWinIndex = 1;
                    LiveView();
                    break;

                case R.id.playback:
                    selected();
                    m_oTabRecord.setSelected(true);
                    childVisibale();
                    m_oPlayer.setVisibility(View.GONE);
                    m_oPlayer1.setVisibility(View.GONE);
                    m_oPlayer2.setVisibility(View.GONE);
                    m_oPlayer3.setVisibility(View.GONE);

                    m_oPlaybackPlayer.setVisibility(View.VISIBLE);
                    m_oPlaybackPlayer1.setVisibility(View.VISIBLE);
                    m_oPlaybackPlayer2.setVisibility(View.VISIBLE);
                    m_oPlaybackPlayer3.setVisibility(View.VISIBLE);
                    m_oRecordView.setVisibility(View.VISIBLE);
                    NetDEVSDK.gdwWinIndex = 1;
                    Playback();
                    break;

                case R.id.more_function:
                    selected();
                    m_oTabMore.setSelected(true);
                    childVisibale();
                    m_oMoreView.setVisibility(View.VISIBLE);
                    MoreFunction();
                    break;
            }
        }
    };

    private void OnPTZCtrl_Focus(int action, int para, int speed) {
        if (action == MotionEvent.ACTION_DOWN) {    // press down button
            NetDEVSDK.NETDEV_PTZControl(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], para, speed);
        } else if (action == MotionEvent.ACTION_UP) {    // release button
            switch (para) {
                case NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_FOCUSFAR:        //far
                    NetDEVSDK.NETDEV_PTZControl(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_FOCUSFAR_STOP, 6);//stop focus far
                    break;
                case NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_FOCUSNEAR:        //near
                    NetDEVSDK.NETDEV_PTZControl(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_FOCUSNEAR_STOP, 6);//stop focus near
                    break;
                default:
                    NetDEVSDK.NETDEV_PTZControl(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_ALLSTOP, 6);        //stop ptz
                    break;
            }


        }
    }

    private OnTouchListener oPTZCtrlListener = new OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            int action = event.getAction();
            int direction;
            int speed = 2;
            switch (v.getId()) {
                case R.id.up:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_TILTUP;    //up
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.down:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_TILTDOWN;//down
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.left:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_PANLEFT;//left
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.right:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_PANRIGHT;//right
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.left_up:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_LEFTUP;//left_up
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.left_down:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_LEFTDOWN;//left_down
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.right_up:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_RIGHTUP;//right_up
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.right_down:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_RIGHTDOWN;//right_down
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.far:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_FOCUSFAR;//far
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.near:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_FOCUSNEAR;//near
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.zoomin:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_ZOOMTELE;//zoom in
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.zoomout:
                    direction = NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_ZOOMWIDE;//zoom out
                    OnPTZCtrl_Focus(action, direction, speed);
                    break;

                case R.id.stopptz:
                    int iRet = NetDEVSDK.NETDEV_PTZControl(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PTZ_CMD_E.NETDEV_PTZ_ALLSTOP, 6);//stop ptz
                    if (0 != iRet) {
                        System.out.println("=====PTZ stop success");
                    }
                    break;
                default:
                    break;

            }
            return false;
        }
    };


    private void LiveView() {


        for (int i = 0; i < 4; i++) {
            if (0 != lpPlaybackPlayerHandle[i]) {
                NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[i], i + 1);
                lpPlaybackPlayerHandle[i] = 0;
            }
        }
        m_oPlaybackPlayer.m_bCanDrawFrame = false;
        m_oPlaybackPlayer1.m_bCanDrawFrame = false;
        m_oPlaybackPlayer2.m_bCanDrawFrame = false;
        m_oPlaybackPlayer3.m_bCanDrawFrame = false;

        /* channel list */
        m_oChannelList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String strItem = arg0.getItemAtPosition(arg2).toString();
                String strTemp = "Channel - ";
                m_dwChannelID = Integer.parseInt(strItem.substring(strTemp.length(), strItem.indexOf(':')));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        m_oRecordBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Date oDate = new Date();
                DateFormat oDataFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                String strFileName = oDataFormat.format(oDate);
                String strPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/android_demo/Record/" + strFileName;
                if (0 != lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1]) {
                    int iRet = NetDEVSDK.NETDEV_SaveRealData(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], strPath, 0);        //0:mp4;1:ts
                    if (0 == iRet) {
                        Toast.makeText(CMainMenu.this, "Save Realdata Fail!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CMainMenu.this, "Save Realdata Success!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                    oBuilder.setTitle("Error");
                    oBuilder.setMessage("Please start the live first!");
                    oBuilder.setCancelable(false);
                    oBuilder.setPositiveButton("OK", null);
                    oBuilder.show();
                }
            }
        });

        m_oStopRecordBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (0 != lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1]) {
                    int iRet = NetDEVSDK.NETDEV_StopSaveRealData(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1]);        //0:mp4;1:ts
                    if (0 == iRet) {
                        Toast.makeText(CMainMenu.this, "Stop Realdata Fail!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CMainMenu.this, "Stop Realdata Success!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                    oBuilder.setTitle("Error");
                    oBuilder.setMessage("Please start the video first!");
                    oBuilder.setCancelable(false);
                    oBuilder.setPositiveButton("OK", null);
                    oBuilder.show();
                }
            }
        });

        /*start live view */
        m_oStartLiveViewBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                NETDEV_PREVIEWINFO_S stPreviewInfo = new NETDEV_PREVIEWINFO_S();
                stPreviewInfo.dwChannelID = m_dwChannelID;                        //  the value can be modified at the interface
                stPreviewInfo.dwLinkMode = 1;                                // 1,/* TCP */             2,/* UDP */
                stPreviewInfo.dwStreamIndex = 0;                            // 0,/*   Main stream */       1,/*   Sub stream */       2,/*  Third stream */
                if (1 == NetDEVSDK.gdwWinIndex) {
                    m_oPlayer.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer.m_dwWinIndex - 1], m_oPlayer.m_dwWinIndex);
                } else if (2 == NetDEVSDK.gdwWinIndex) {
                    m_oPlayer1.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer1.m_dwWinIndex - 1], m_oPlayer1.m_dwWinIndex);
                } else if (3 == NetDEVSDK.gdwWinIndex) {
                    m_oPlayer2.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer2.m_dwWinIndex - 1], m_oPlayer2.m_dwWinIndex);
                } else if (4 == NetDEVSDK.gdwWinIndex) {
                    m_oPlayer3.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer3.m_dwWinIndex - 1], m_oPlayer3.m_dwWinIndex);
                }
                if (isLocalDevFlag) {
                    lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1] = NetDEVSDK.NETDEV_RealPlay(ipLpUserIDMap.get(strDevIP), stPreviewInfo, NetDEVSDK.gdwWinIndex);
                } else {
                    lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1] = NetDEVSDK.NETDEV_RealPlay(nameLpUserIDMap.get(strCloudDevName), stPreviewInfo, NetDEVSDK.gdwWinIndex);
                }
                scaleRatio[NetDEVSDK.gdwWinIndex - 1] = 1.0f;
                NetDEVSDK.Scale(scaleRatio[NetDEVSDK.gdwWinIndex - 1], 0, 0, NetDEVSDK.gdwWinIndex);
//				String strStreamUrl = NetDEVSDK.NETDEV_GetStreamUrl(NetDEVSDK.lpUserID, m_dwChannelID, 0);
//				if (strStreamUrl.isEmpty())
//				{
//					return;
//				}
//				lpLiveViewHandle[NetDEVSDK.gdwWinIndex-1] = NetDEVSDK.NETDEV_FastRealPlayByUrl(NetDEVSDK.lpUserID, strStreamUrl, stPreviewInfo, NetDEVSDK.gdwWinIndex);

            }
        });


        /* stop liveview */
        m_oStopLiveViewBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                stopLive();
            }
        });

        // Start Two-way Audio
        startTalkBackBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (0 != m_lpVoiceComHandle) {
                    return;
                }
                if (isLocalDevFlag) {
                    m_lpVoiceComHandle = NetDEVSDK.NETDEV_Android_StartInputVoiceSrv(ipLpUserIDMap.get(strDevIP), m_dwChannelID);
                } else {
                    m_lpVoiceComHandle = NetDEVSDK.NETDEV_Android_StartInputVoiceSrv(nameLpUserIDMap.get(strCloudDevName), m_dwChannelID);
                }
                if (0 == m_lpVoiceComHandle) {
                    System.out.println("StartInputVoiceSrv failed.");
                    return;
                }

                //input voice
                {
                    AudioRecordManager.getInstance()
                            .startRecording(new AudioRecordManager.OnAudioRecordListener() {

                                @Override
                                public void onVoiceRecord(byte[] data, int size) {
                                    //send data
                                    NETDEV_AUDIO_SAMPLE_PARAM_S stVoiceParam = new NETDEV_AUDIO_SAMPLE_PARAM_S();
                                    stVoiceParam.dwChannels = 1;
                                    stVoiceParam.dwSampleRate = 8000;
                                    stVoiceParam.enSampleFormat = NETDEV_AUDIO_SAMPLE_PARAM_S.NETDEV_AUDIO_SAMPLE_FORMAT_E.NETDEV_AUDIO_SAMPLE_FMT_S16;
                                    NetDEVSDK.NETDEV_InputVoiceData(m_lpVoiceComHandle, data, size, stVoiceParam);
                                }
                            });
                }
            }
        });

        // Stop Two-way Audio
        stopTalkBackBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (0 == m_lpVoiceComHandle) {
                    return;
                }
                int iRet = NetDEVSDK.NETDEV_Android_StopInputVoiceSrv(m_lpVoiceComHandle);
                if (0 == iRet) {
                    System.out.println("StopInputVoiceSrv failed.");
                } else {
                    AudioRecordManager.getInstance().stopRecording();
                    m_lpVoiceComHandle = 0;
                }
            }
        });

        /* Snapshot */
        m_oSnapshotBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Date oDate = new Date();
                DateFormat oDataFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                String strFileName = oDataFormat.format(oDate);
                String strPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/android_demo/picture/" + strFileName;
                File destDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/android_demo/picture/");
                if (!destDir.exists()) {
                    destDir.mkdirs();
                }
                if (0 != lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1]) {
                    int iRet = NetDEVSDK.NETDEV_CapturePicture(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], strPath, 1);        //0:bmp;1:jpg
                    if (0 == iRet) {
                        Toast.makeText(CMainMenu.this, "Save Fail!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CMainMenu.this, "Save Success!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    int iRet = 0;
                    if (isLocalDevFlag) {
                        isLocalDevFlag = true;
                        iRet = NetDEVSDK.NETDEV_CaptureNoPreview(ipLpUserIDMap.get(strDevIP), m_dwChannelID, 0, strPath, 1);
                    } else {
                        iRet = NetDEVSDK.NETDEV_CaptureNoPreview(nameLpUserIDMap.get(strCloudDevName), m_dwChannelID, 0, strPath, 1);
                    }
                    if (0 == iRet) {
                        Toast.makeText(CMainMenu.this, "Save Fail!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CMainMenu.this, "Save Success!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /* set preset */
        m_oPTZSetPtrsetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final View oPTZPresetDlg = m_oPTZPreset.inflate(R.layout.ptz_preset, null);
                final EditText oPresetName = (EditText) oPTZPresetDlg.findViewById(R.id.presetName);
                final EditText oPresetID = (EditText) oPTZPresetDlg.findViewById(R.id.presetID);
                AlertDialog.Builder oDlg = new AlertDialog.Builder(CMainMenu.this);
                oDlg.setTitle("PTZ Preset");
                oDlg.setView(oPTZPresetDlg);
                oDlg.setCancelable(false);
                oDlg.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        String strPresetName = oPresetName.getText().toString().trim();
                        String strPresetID = oPresetID.getText().toString().trim();
                        if (strPresetName.isEmpty() || strPresetID.isEmpty()) {
                            Toast.makeText(CMainMenu.this, "ID or Name cannot be empty!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        }

                        NetDEVSDK.NETDEV_PTZPreset(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], 0, strPresetName, Integer.parseInt(strPresetID));
                    }
                });

                oDlg.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

                oDlg.show();
            }
        });

        /* Get PTZ preset */
        m_oGetPTZPresetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final int[] dwPreset = new int[1];
                final int[] stPreset = new int[256];
                Integer dwlpUserID = 0;
                if (isLocalDevFlag) {
                    dwlpUserID = ipLpUserIDMap.get(strDevIP);
                } else {
                    dwlpUserID = nameLpUserIDMap.get(strCloudDevName);
                }
                final int dwSize = NetDEVSDK.NETDEV_GetPTZPresetList(dwlpUserID, m_dwChannelID, stPreset);
                AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                oBuilder.setTitle("Preset List");
                oBuilder.setCancelable(false);
                final String[] strPresetID;
                if (dwSize > 0) {
                    strPresetID = new String[dwSize];
                    for (int i = 0; i < dwSize; i++) {
                        strPresetID[i] = String.valueOf(stPreset[i]);
                    }

                    dwPreset[0] = stPreset[0];        /* The first is selected by default */
                } else {
                    strPresetID = new String[1];
                    strPresetID[0] = "";
                }

                oBuilder.setSingleChoiceItems(strPresetID, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (dwSize > 0) {
                            dwPreset[0] = stPreset[which];
                        }
                    }
                });
                oBuilder.setPositiveButton("Goto", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        if (dwSize > 0) {
                            NetDEVSDK.NETDEV_PTZPreset(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], 2, "", dwPreset[0]);
                        }

                    }
                });
                oBuilder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        if (dwSize > 0) {
                            NetDEVSDK.NETDEV_PTZPreset(lpLiveViewHandle[NetDEVSDK.gdwWinIndex - 1], 1, "", dwPreset[0]);
                        }

                    }
                });
                oBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                oBuilder.show();
            }
        });

    }

    private void stopLive() {
        int iRet = -1;
        if (true == m_oPlayer.m_bCanDrawFrame) {
            m_oPlayer.m_bCanDrawFrame = false;
            iRet = NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer.m_dwWinIndex - 1], m_oPlayer.m_dwWinIndex);
        }
        if (true == m_oPlayer1.m_bCanDrawFrame) {
            m_oPlayer1.m_bCanDrawFrame = false;
            iRet = NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer1.m_dwWinIndex - 1], m_oPlayer1.m_dwWinIndex);
        }
        if (true == m_oPlayer2.m_bCanDrawFrame) {
            m_oPlayer2.m_bCanDrawFrame = false;
            iRet = NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer2.m_dwWinIndex - 1], m_oPlayer2.m_dwWinIndex);
        }
        if (true == m_oPlayer3.m_bCanDrawFrame) {
            m_oPlayer3.m_bCanDrawFrame = false;
            iRet = NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[m_oPlayer3.m_dwWinIndex - 1], m_oPlayer3.m_dwWinIndex);
        }

        lpLiveViewHandle[0] = 0;
        lpLiveViewHandle[1] = 0;
        lpLiveViewHandle[2] = 0;
        lpLiveViewHandle[3] = 0;
        System.out.println("----------------------" + iRet);
    }

    private void Playback() {
        m_oPlaySpeed.setText(" ");
        for (int i = 0; i < 4; i++) {
            if (0 != lpLiveViewHandle[i]) {
                NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[i], i + 1);
                lpLiveViewHandle[i] = 0;
            }
        }
        m_oPlayer.m_bCanDrawFrame = false;
        m_oPlayer1.m_bCanDrawFrame = false;
        m_oPlayer2.m_bCanDrawFrame = false;
        m_oPlayer3.m_bCanDrawFrame = false;


        m_stCurrentPlayInfo = new NETDEV_PLAYBACKCOND_S();

        /*find record*/
        m_oQueryRecordBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int dwFileNum = 0;
                m_oPlaySpeed.setText("  ");
                NETDEV_FILECOND_S stFileCond = new NETDEV_FILECOND_S();
                EditText oBeginDateTxt = (EditText) m_oRecordView.findViewById(R.id.begindate);
                EditText oBeginTimeTxt = (EditText) m_oRecordView.findViewById(R.id.begintime);
                EditText oEndDateTxt = (EditText) m_oRecordView.findViewById(R.id.enddate);
                EditText oEndTimeTxt = (EditText) m_oRecordView.findViewById(R.id.endtime);
                SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date oBeginDate = null;
                Date oEndDate = null;
                String strBeginDate = oBeginDateTxt.getText().toString();
                String strBeginTime = oBeginTimeTxt.getText().toString();
                String strEndDate = oEndDateTxt.getText().toString();
                String strEndTime = oEndTimeTxt.getText().toString();
                ;
                /*As long as the input is empty, search the video for the last 24 hours by default*/
                if (oBeginDateTxt.getText().toString().equals("") ||
                        oBeginTimeTxt.getText().toString().equals("") ||
                        oEndDateTxt.getText().toString().equals("") ||
                        oEndTimeTxt.getText().toString().equals("")) {
                    stFileCond.dwChannelID = m_dwChannelID;
                    stFileCond.tBeginTime = (System.currentTimeMillis() / 1000) - (60 * 60 * 24);//search the video for the last 24 hours by default
                    stFileCond.tEndTime = System.currentTimeMillis() / 1000;
                } else {
                    try {
                        oBeginDate = oDateFormat.parse(strBeginDate);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    try {
                        oEndDate = oDateFormat.parse(strEndDate);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    stFileCond.dwChannelID = m_dwChannelID;
                    stFileCond.tBeginTime = oBeginDate.getTime() / 1000 + Integer.parseInt(strBeginTime.substring(0, 2)) * 3600 + Integer.parseInt(strBeginTime.substring(3, 5)) * 60 + Integer.parseInt(strBeginTime.substring(6));
                    stFileCond.tEndTime = oEndDate.getTime() / 1000 + Integer.parseInt(strEndTime.substring(0, 2)) * 3600 + Integer.parseInt(strEndTime.substring(3, 5)) * 60 + Integer.parseInt(strEndTime.substring(6));
                }

                int dwFileHandle = 0;
                if (isLocalDevFlag) {
                    dwFileHandle = NetDEVSDK.NETDEV_FindFile(ipLpUserIDMap.get(strDevIP), stFileCond);
                } else {
                    dwFileHandle = NetDEVSDK.NETDEV_FindFile(nameLpUserIDMap.get(strCloudDevName), stFileCond);
                }

                //int dwFileHandle = NetDEVSDK.NETDEV_FindFile(ipLpUserIDMap.get(strDevIP), stFileCond);
                if (dwFileHandle == 0) {
                    Toast.makeText(CMainMenu.this, "Find file failed", Toast.LENGTH_SHORT).show();
                    System.out.println("find file failed");
                } else {
                    System.out.println("Find file success");
                    final NETDEV_PLAYBACKCOND_S stPlaybackInfo = new NETDEV_PLAYBACKCOND_S();
                    String[] szRecordFile = new String[1000];
                    NETDEV_FINDDATA_S stVodFile = new NETDEV_FINDDATA_S();
                    for (int i = 0; i < 1000; i++) {
                        int iRet = NetDEVSDK.NETDEV_FindNextFile(dwFileHandle, stVodFile);
                        if (0 == iRet) {
                            System.out.println("find nextfile failed");
                            break;
                        } else {
                            dwFileNum++;
                            NetDEVSDK.m_astVodFile[i] = new NETDEV_FINDDATA_S();
                            NetDEVSDK.m_astVodFile[i].szFileName = stVodFile.szFileName;
                            NetDEVSDK.m_astVodFile[i].tBeginTime = stVodFile.tBeginTime;
                            NetDEVSDK.m_astVodFile[i].tEndTime = stVodFile.tEndTime;
                            NetDEVSDK.m_astVodFile[i].byFileType = stVodFile.byFileType;
                            String strBeginLocalTime, strEndLocalTime;
                            Date nowTime = new Date(stVodFile.tBeginTime * 1000);
                            SimpleDateFormat oBeginDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                            strBeginLocalTime = oBeginDateFormat.format(nowTime);
                            Date nowTime1 = new Date(stVodFile.tEndTime * 1000);
                            SimpleDateFormat oEndDataFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                            strEndLocalTime = oEndDataFormat.format(nowTime1);
                            System.out.println(strBeginLocalTime + "---" + strEndLocalTime);

                            szRecordFile[i] = strBeginLocalTime + "---" + strEndLocalTime;
                        }
                    }

                    String[] szRecrodFileList;
                    if (0 == dwFileNum) {
                        szRecrodFileList = new String[1];
                        szRecrodFileList[0] = "";
                    } else {
                        szRecrodFileList = new String[dwFileNum];
                        System.arraycopy(szRecordFile, 0, szRecrodFileList, 0, dwFileNum);
                        //first by default
                        stPlaybackInfo.dwChannelID = m_stCurrentPlayInfo.dwChannelID = m_dwChannelID;
                        stPlaybackInfo.tBeginTime = m_stCurrentPlayInfo.tBeginTime = NetDEVSDK.m_astVodFile[0].tBeginTime;
                        stPlaybackInfo.tEndTime = m_stCurrentPlayInfo.tEndTime = NetDEVSDK.m_astVodFile[0].tEndTime;
                        stPlaybackInfo.dwLinkMode = m_stCurrentPlayInfo.dwLinkMode = 1;
                        m_stCurrentPlayInfo = stPlaybackInfo;
                    }

                    AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                    oBuilder.setTitle("Record File List");
                    oBuilder.setCancelable(false);
                    oBuilder.setSingleChoiceItems(szRecrodFileList, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            stPlaybackInfo.dwChannelID = m_dwChannelID;
                            stPlaybackInfo.tBeginTime = NetDEVSDK.m_astVodFile[which].tBeginTime;
                            stPlaybackInfo.tEndTime = NetDEVSDK.m_astVodFile[which].tEndTime;
                            stPlaybackInfo.dwLinkMode = 1;
                        }
                    });

                    oBuilder.setPositiveButton("select", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int i) {
                            m_stCurrentPlayInfo = stPlaybackInfo;
                            dialog.dismiss();
                        }
                    });
                    oBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });

                    oBuilder.show();
                }

                int iRet = NetDEVSDK.NETDEV_FindClose(dwFileHandle);
                if (1 == iRet) {
                    System.out.println("find Close success");
                } else {
                    System.out.println("find Close failed");
                }
            }
        });

        /* start record by time */
        m_oStartPlayBackBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                m_oPlaySpeed.setText("  ");

                if (1 == NetDEVSDK.gdwWinIndex) {
                    m_oPlaybackPlayer.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer.m_dwWinIndex - 1], m_oPlaybackPlayer.m_dwWinIndex);
                } else if (2 == NetDEVSDK.gdwWinIndex) {
                    m_oPlaybackPlayer1.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer1.m_dwWinIndex - 1], m_oPlaybackPlayer1.m_dwWinIndex);
                } else if (3 == NetDEVSDK.gdwWinIndex) {
                    m_oPlaybackPlayer2.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer2.m_dwWinIndex - 1], m_oPlaybackPlayer2.m_dwWinIndex);
                } else if (4 == NetDEVSDK.gdwWinIndex) {
                    m_oPlaybackPlayer3.m_bCanDrawFrame = true;
                    NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer3.m_dwWinIndex - 1], m_oPlaybackPlayer3.m_dwWinIndex);
                }
                m_stCurrentPlayInfo.dwPlaySpeed = NetDEVSDK.NETDEV_VOD_PLAY_STATUS_E.NETDEV_PLAY_STATUS_1_FORWARD;
                if (isLocalDevFlag) {
                    lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1] = NetDEVSDK.NETDEV_PlayBackByTime(ipLpUserIDMap.get(strDevIP), m_stCurrentPlayInfo, NetDEVSDK.gdwWinIndex);
                } else {
                    lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1] = NetDEVSDK.NETDEV_PlayBackByTime(nameLpUserIDMap.get(strCloudDevName), m_stCurrentPlayInfo, NetDEVSDK.gdwWinIndex);
                }

                if (0 == lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1]) {
                    System.out.println("Play the video failed.");
                }
                //NetDEVSDK.NETDEV_SetPictureFluency(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], 1);
//				String strStreamUrl = NetDEVSDK.NETDEV_GetReplayUrl(NetDEVSDK.lpUserID, m_dwChannelID, 0);
//				if (strStreamUrl.isEmpty())
//				{
//					return;
//				}
//				lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex-1]  = NetDEVSDK.NETDEV_FastPlayBackByUrl(NetDEVSDK.lpUserID, strStreamUrl, m_stCurrentPlayInfo, NetDEVSDK.gdwWinIndex);
//				if(0 == lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex-1])
//				{
//					System.out.println("Play the video failed.");
//				}

            }
        });

        /* Stop playback */
        m_oStopPlayBackBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                m_oPlaySpeed.setText("  ");
                int iRet = -1;
                if (true == m_oPlaybackPlayer.m_bCanDrawFrame) {
                    m_oPlaybackPlayer.m_bCanDrawFrame = false;
                    iRet = NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer.m_dwWinIndex - 1], m_oPlaybackPlayer.m_dwWinIndex);
                }
                if (true == m_oPlaybackPlayer1.m_bCanDrawFrame) {
                    m_oPlaybackPlayer1.m_bCanDrawFrame = false;
                    iRet = NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer1.m_dwWinIndex - 1], m_oPlaybackPlayer1.m_dwWinIndex);
                }
                if (true == m_oPlaybackPlayer2.m_bCanDrawFrame) {
                    m_oPlaybackPlayer2.m_bCanDrawFrame = false;
                    iRet = NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer2.m_dwWinIndex - 1], m_oPlaybackPlayer2.m_dwWinIndex);
                }
                if (true == m_oPlaybackPlayer3.m_bCanDrawFrame) {
                    m_oPlaybackPlayer3.m_bCanDrawFrame = false;
                    iRet = NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[m_oPlaybackPlayer3.m_dwWinIndex - 1], m_oPlaybackPlayer3.m_dwWinIndex);
                }

                lpPlaybackPlayerHandle[0] = 0;
                lpPlaybackPlayerHandle[1] = 0;
                lpPlaybackPlayerHandle[2] = 0;
                lpPlaybackPlayerHandle[3] = 0;
            }
        });

        /* pause */
        m_oPauseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                m_oPlaySpeed.setText("  ");
                Integer dwlpUserID = 0;
                if (isLocalDevFlag) {
                    dwlpUserID = ipLpUserIDMap.get(strDevIP);
                } else {
                    dwlpUserID = nameLpUserIDMap.get(strCloudDevName);
                }
                if ((lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1] != 0) && (dwlpUserID != 0)) {
                    NETDEV_PLAYBACKCONTROL_S PlayBackControlenSpeed = new NETDEV_PLAYBACKCONTROL_S();
                    int iRet = NetDEVSDK.NETDEV_PlayBackControl(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PLAY_CTRL_E.NETDEV_PLAY_CTRL_PAUSE, PlayBackControlenSpeed);

                    if (1 != iRet) {
                        System.out.println("pause play failed.");
                    }
                }
            }
        });

        /* Resume */
        m_oResumeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                m_oPlaySpeed.setText("  ");
                Integer dwlpUserID = 0;
                if (isLocalDevFlag) {
                    dwlpUserID = ipLpUserIDMap.get(strDevIP);
                } else {
                    dwlpUserID = nameLpUserIDMap.get(strCloudDevName);
                }
                if ((lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1] != 0) && (dwlpUserID != 0)) {
                    NETDEV_PLAYBACKCONTROL_S PlayBackControlenSpeed = new NETDEV_PLAYBACKCONTROL_S();
                    int iRet = NetDEVSDK.NETDEV_PlayBackControl(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PLAY_CTRL_E.NETDEV_PLAY_CTRL_RESUME, PlayBackControlenSpeed);
                    if (1 != iRet) {
                        System.out.println("pause play failed.");
                    }
                }
            }
        });

        /* forward */
        m_oForwardBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                NETDEV_PLAYBACKCONTROL_S stPlaybackCtrl = new NETDEV_PLAYBACKCONTROL_S();

                int iRet = NetDEVSDK.NETDEV_PlayBackControl(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PLAY_CTRL_E.NETDEV_PLAY_CTRL_GETPLAYTIME, stPlaybackCtrl);
                if (0 == iRet) {
                    System.out.println("Get play time failed.");
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    long timeLong = Long.valueOf(stPlaybackCtrl.enSpeed);
                    String strTime = sdf.format(new Date(timeLong * 1000L));
                    System.out.println("Get play time :" + strTime);
                }

                iRet = NetDEVSDK.NETDEV_PlayBackControl(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PLAY_CTRL_E.NETDEV_PLAY_CTRL_GETPLAYSPEED, stPlaybackCtrl);
                if (0 == iRet) {
                    System.out.println("Get play time failed.");
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    long timeLong = Long.valueOf(stPlaybackCtrl.enSpeed);
                    String strTime = sdf.format(new Date(timeLong * 1000L));
                    System.out.println("Get play time :" + strTime);
                }

                int i = 0;
                for (; i < 10; i++) {
                    if (PlaybackStatus[i] == stPlaybackCtrl.enSpeed) {
                        break;
                    }
                }
                i++;
                if (i > 9) {
                    i = 0;
                }

                switch (i) {
                    case 0:
                        m_oPlaySpeed.setText("-16×");
                        break;
                    case 1:
                        m_oPlaySpeed.setText("-8×");
                        break;
                    case 2:
                        m_oPlaySpeed.setText("-4×");
                        break;
                    case 3:
                        m_oPlaySpeed.setText("-2×");
                        break;
                    case 4:
                        m_oPlaySpeed.setText("-1×");
                        break;
                    case 5:
                        m_oPlaySpeed.setText("1×");
                        break;
                    case 6:
                        m_oPlaySpeed.setText("2×");
                        break;
                    case 7:
                        m_oPlaySpeed.setText("4×");
                        break;
                    case 8:
                        m_oPlaySpeed.setText("8×");
                        break;
                    case 9:
                        m_oPlaySpeed.setText("16×");
                        break;
                    default:
                        break;
                }

                stPlaybackCtrl.enSpeed = PlaybackStatus[i];
                iRet = NetDEVSDK.NETDEV_PlayBackControl(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PLAY_CTRL_E.NETDEV_PLAY_CTRL_SETPLAYSPEED, stPlaybackCtrl);
                if (0 == iRet) {
                    System.out.println("Set play speed failed.");
                }
            }
        });

        /* backward */
        m_oBackwardBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                NETDEV_PLAYBACKCONTROL_S PlayBackControlenSpeed = new NETDEV_PLAYBACKCONTROL_S();
                PlayBackControlenSpeed.enSpeed = 0;
                int iRet = NetDEVSDK.NETDEV_PlayBackControl(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PLAY_CTRL_E.NETDEV_PLAY_CTRL_GETPLAYSPEED, PlayBackControlenSpeed);
                if (0 == iRet) {
                    System.out.println("Get play speed failed.");
                }

                int i = 0;
                for (; i < 10; i++) {
                    if (PlaybackStatus[i] == PlayBackControlenSpeed.enSpeed) {
                        break;
                    }
                }
                i--;
                if (i < 0) {
                    i = 9;
                }

                switch (i) {
                    case 0:
                        m_oPlaySpeed.setText("-16×");
                        break;
                    case 1:
                        m_oPlaySpeed.setText("-8×");
                        break;
                    case 2:
                        m_oPlaySpeed.setText("-4×");
                        break;
                    case 3:
                        m_oPlaySpeed.setText("-2×");
                        break;
                    case 4:
                        m_oPlaySpeed.setText("-1×");
                        break;
                    case 5:
                        m_oPlaySpeed.setText("1×");
                        break;
                    case 6:
                        m_oPlaySpeed.setText("2×");
                        break;
                    case 7:
                        m_oPlaySpeed.setText("4×");
                        break;
                    case 8:
                        m_oPlaySpeed.setText("8×");
                        break;
                    case 9:
                        m_oPlaySpeed.setText("16×");
                        break;
                    default:
                        break;
                }
                PlayBackControlenSpeed.enSpeed = PlaybackStatus[i];
                iRet = NetDEVSDK.NETDEV_PlayBackControl(lpPlaybackPlayerHandle[NetDEVSDK.gdwWinIndex - 1], NetDEVSDK.NETDEV_VOD_PLAY_CTRL_E.NETDEV_PLAY_CTRL_SETPLAYSPEED, PlayBackControlenSpeed);
                if (0 == iRet) {
                    System.out.println("Set play speed failed.");
                }
            }

        });

        //download record by time
        mDownloadButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //if isDownload is true, this chick has no response
                //if( !isDownload )
                {
                    NETDEV_PLAYBACKCOND_S stPlayBackInfo = new NETDEV_PLAYBACKCOND_S();
                    stPlayBackInfo.dwDownloadSpeed = 3;
                    stPlayBackInfo.dwChannelID = m_stCurrentPlayInfo.dwChannelID;

                    stPlayBackInfo.tBeginTime = m_stCurrentPlayInfo.tBeginTime;
                    stPlayBackInfo.tEndTime = m_stCurrentPlayInfo.tEndTime;

                    Date date = new Date();
                    DateFormat format = new SimpleDateFormat("yyyy-MM-ddHH_mm_ss");
                    String fileName = format.format(date);
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/android_demo/record/" + fileName;
                    File destDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/android_demo/record/");
                    if (!destDir.exists()) {
                        destDir.mkdirs();
                    }

                    if (isLocalDevFlag) {
                        NetDEVSDK.lpDownloadID = NetDEVSDK.NETDEV_DownloadFile(ipLpUserIDMap.get(strDevIP), stPlayBackInfo, path, 0);
                    } else {
                        NetDEVSDK.lpDownloadID = NetDEVSDK.NETDEV_DownloadFile(nameLpUserIDMap.get(strCloudDevName), stPlayBackInfo, path, 0);
                    }
                    if (0 == NetDEVSDK.lpDownloadID) {
                        System.out.println("Download failed.");
                    }
                }
            }
        });

        //stop download
        mStopDownloadButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //if isDownload is false, this chick has no response
                //if(0 !=  NetDEVSDK.lpDownloadID )
                {
                    int iRet = 0;
                    if(0 != NetDEVSDK.lpDownloadID)
                    {
                        iRet = NetDEVSDK.NETDEV_StopDownloadFile(NetDEVSDK.lpDownloadID);
                    }
//                    if (isLocalDevFlag) {
//                        iRet = NetDEVSDK.NETDEV_StopDownloadFile(ipLpUserIDMap.get(strDevIP));
//                    } else {
//                        iRet = NetDEVSDK.NETDEV_StopDownloadFile(nameLpUserIDMap.get(strCloudDevName));
//                    }
                    if (0 == iRet) {
                        System.out.println(" Stop download failed.");
                    }
                    else
                    {
                        System.out.println(" Stop download succeed.");
                    }
                    NetDEVSDK.lpDownloadID = 0;
                }

            }
        });
    }

    /* More Function */
    private void MoreFunction() {
        for (int i = 0; i < 4; i++) {
            if (0 != lpLiveViewHandle[i]) {
                NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[i], i + 1);
                lpLiveViewHandle[i] = 0;
            }
            if (0 != lpPlaybackPlayerHandle[i]) {
                NetDEVSDK.NETDEV_StopPlayBack(lpPlaybackPlayerHandle[i], i + 1);
                lpPlaybackPlayerHandle[i] = 0;
            }
        }
        m_oPlayer.m_bCanDrawFrame = false;
        m_oPlayer1.m_bCanDrawFrame = false;
        m_oPlayer2.m_bCanDrawFrame = false;
        m_oPlayer3.m_bCanDrawFrame = false;
        m_oPlaybackPlayer.m_bCanDrawFrame = false;
        m_oPlaybackPlayer1.m_bCanDrawFrame = false;
        m_oPlaybackPlayer2.m_bCanDrawFrame = false;
        m_oPlaybackPlayer3.m_bCanDrawFrame = false;


        final Intent oIntentLog = new Intent(this, CLocalDevLogin.class);
        m_oDevInfoBtn.setOnClickListener(new OnClickListener() {
            NETDEV_DEVICE_BASICINFO_S stDevInfo = new NETDEV_DEVICE_BASICINFO_S();

            @Override
            public void onClick(View v) {
                if (isLocalDevFlag) {
                    NetDEVSDK.NETDEV_GetDeviceInfo(ipLpUserIDMap.get(strDevIP), m_dwChannelID, stDevInfo);
                } else {
                    NetDEVSDK.NETDEV_GetDeviceInfo(nameLpUserIDMap.get(strCloudDevName), m_dwChannelID, stDevInfo);
                }
                String strInfo = "Device name : \r\n		" + stDevInfo.szDeviceName + "\r\n";
                strInfo += "Device model : \r\n		" + stDevInfo.szDevModel + "\r\n";
                strInfo += "Hardware serial number : \r\n		" + stDevInfo.szSerialNum + "\r\n";
                strInfo += "Software version : \r\n		" + stDevInfo.szFirmwareVersion + "\r\n";
                strInfo += "MAC address of IPv4 : \r\n		" + stDevInfo.szMacAddress + "";

                AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                oBuilder.setTitle("Device Information");
                oBuilder.setMessage(strInfo);

                oBuilder.setCancelable(false);
                oBuilder.setPositiveButton("OK", null);
                oBuilder.show();

            }
        });

        final Intent oIntentDeviceTime = new Intent(this, CLocalDevLogin.class);
        m_oDeviceTimeBtn.setOnClickListener(new OnClickListener() {
            NETDEV_TIME_S stDeviceTime = new NETDEV_TIME_S();

            @Override
            public void onClick(View v) {
                if (isLocalDevFlag) {
                    NetDEVSDK.NETDEV_GetSystemTimeCfg(ipLpUserIDMap.get(strDevIP), stDeviceTime);
                } else {
                    NetDEVSDK.NETDEV_GetSystemTimeCfg(nameLpUserIDMap.get(strCloudDevName), stDeviceTime);
                }
                String strInfo = stDeviceTime.dwYear + "-";
                strInfo += stDeviceTime.dwMonth + "-";
                strInfo += stDeviceTime.dwDay + " ";
                strInfo += stDeviceTime.dwHour + ":";
                strInfo += stDeviceTime.dwMinute + ":";
                strInfo += stDeviceTime.dwSecond;
                AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                oBuilder.setTitle("Device Time");
                oBuilder.setMessage(strInfo);

                oBuilder.setCancelable(false);
                oBuilder.setPositiveButton("OK", null);
                oBuilder.show();

            }
        });

        /*set Device time*/
        final Intent oIntentSetDeviceTime = new Intent(this, CLocalDevLogin.class);
        m_oSetDeviceTimeBtn.setOnClickListener(new OnClickListener() {
            NETDEV_TIME_S stDeviceTime = new NETDEV_TIME_S();
            int dwRet = 0;
            @Override
            public void onClick(View v) {
                final View oMoreDlg = m_oMoreSetDevTime.inflate(R.layout.more_set_devtime, null);
                final EditText oDevDateYear = (EditText) oMoreDlg.findViewById(R.id.devDateYear);
                final EditText oDevDateMonth = (EditText) oMoreDlg.findViewById(R.id.devDateMonth);
                final EditText oDevDateDay = (EditText) oMoreDlg.findViewById(R.id.devDateDay);
                final EditText oDevTimeHour = (EditText) oMoreDlg.findViewById(R.id.devTimeHour);
                final EditText oDevTimeMinute = (EditText) oMoreDlg.findViewById(R.id.devTimeMinute);
                final EditText oDevTimeSecond = (EditText) oMoreDlg.findViewById(R.id.devTimeSecond);

                if (isLocalDevFlag) {
                    NetDEVSDK.NETDEV_GetSystemTimeCfg(ipLpUserIDMap.get(strDevIP), stDeviceTime);
                } else {
                    NetDEVSDK.NETDEV_GetSystemTimeCfg(nameLpUserIDMap.get(strCloudDevName), stDeviceTime);
                }
                oDevDateYear.setText(String.valueOf(stDeviceTime.dwYear));
                oDevDateMonth.setText(String.valueOf(stDeviceTime.dwMonth));
                oDevDateDay.setText(String.valueOf(stDeviceTime.dwDay));
                oDevTimeHour.setText(String.valueOf(stDeviceTime.dwHour));
                oDevTimeMinute.setText(String.valueOf(stDeviceTime.dwMinute));
                oDevTimeSecond.setText(String.valueOf(stDeviceTime.dwSecond));

                AlertDialog.Builder oDlg = new AlertDialog.Builder(CMainMenu.this);
                oDlg.setTitle("Set Device Time");
                oDlg.setView(oMoreDlg);
                oDlg.setCancelable(false);
                oDlg.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        String strDevDateYear = oDevDateYear.getText().toString().trim();
                        String strDevDateMonth = oDevDateMonth.getText().toString().trim();
                        String strDevDateDay = oDevDateDay.getText().toString().trim();
                        String strDevTimeHour = oDevTimeHour.getText().toString().trim();
                        String strDevTimeMinute = oDevTimeMinute.getText().toString().trim();
                        String strDevTimeSecond = oDevTimeSecond.getText().toString().trim();
                        if (strDevDateYear.isEmpty() || strDevDateMonth.isEmpty() || strDevDateDay.isEmpty() || strDevTimeHour.isEmpty()
                                || strDevTimeMinute.isEmpty() || strDevTimeSecond.isEmpty()) {
                            Toast.makeText(CMainMenu.this, "Date or Time cannot be empty!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        }
                        stDeviceTime.dwYear = Integer.parseInt(strDevDateYear);
                        stDeviceTime.dwMonth = Integer.parseInt(strDevDateMonth);
                        stDeviceTime.dwDay = Integer.parseInt(strDevDateDay);
                        stDeviceTime.dwHour = Integer.parseInt(strDevTimeHour);
                        stDeviceTime.dwMinute = Integer.parseInt(strDevTimeMinute);
                        stDeviceTime.dwSecond = Integer.parseInt(strDevTimeSecond);
                        if (stDeviceTime.dwMonth < 0 || stDeviceTime.dwMonth > 13) {
                            Toast.makeText(CMainMenu.this, "Month setting error!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        }
                        if (stDeviceTime.dwDay < 0 || stDeviceTime.dwDay > 32) {
                            Toast.makeText(CMainMenu.this, "Day setting error!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        }
                        if (stDeviceTime.dwHour < 0 || stDeviceTime.dwHour > 24) {
                            Toast.makeText(CMainMenu.this, "Hour setting error!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        }
                        if (stDeviceTime.dwMinute < 0 || stDeviceTime.dwMinute > 60) {
                            Toast.makeText(CMainMenu.this, "Minute setting error!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        }
                        if (stDeviceTime.dwSecond < 0 || stDeviceTime.dwSecond > 60) {
                            Toast.makeText(CMainMenu.this, "Second setting error!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            return;
                        }
                        if (isLocalDevFlag) {
                            dwRet = NetDEVSDK.NETDEV_SetSystemTimeCfg(ipLpUserIDMap.get(strDevIP), stDeviceTime);
                        } else {
                            dwRet = NetDEVSDK.NETDEV_SetSystemTimeCfg(nameLpUserIDMap.get(strCloudDevName), stDeviceTime);
                        }
                        if (1 != dwRet){
                            AlertDialog.Builder oBuilder =new  AlertDialog.Builder(CMainMenu.this);
                            oBuilder.setTitle("Fail" );
                            oBuilder.setMessage("Set system time is failed!" );
                            oBuilder.setPositiveButton("OK" ,  null );
                            oBuilder.show();
                        }
                    }
                });

                oDlg.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                oDlg.show();
            }
        });


        final Intent oIntentCalendarQueryBtn = new Intent(this, CLocalDevLogin.class);
        m_oCalendarQueryBtn.setOnClickListener(new OnClickListener() {
            NETDEV_TIME_S stDeviceTime = new NETDEV_TIME_S();

            @Override
            public void onClick(View v) {
                NETDEV_MONTH_INFO_S oMonthInfo = new NETDEV_MONTH_INFO_S();
                oMonthInfo.udwMonth = 5;
                oMonthInfo.udwYear = 2019;
                oMonthInfo.udwPosition = 1;

                NETDEV_MONTH_STATUS_S oMonthStatus = new NETDEV_MONTH_STATUS_S();
                int ret[] = null;
                if (isLocalDevFlag) {
                    ret = NetDEVSDK.NETDEV_QuickSearch(ipLpUserIDMap.get(strDevIP), m_dwChannelID, oMonthInfo, oMonthStatus);
                } else {
                    ret = NetDEVSDK.NETDEV_QuickSearch(nameLpUserIDMap.get(strCloudDevName), m_dwChannelID, oMonthInfo, oMonthStatus);
                }
                if (null == ret) {
                    System.out.println("Quick Search failed.");
                } else {
                    String strInfo = "2019-05:\n";
                    for (int i = 0; i < 31; i++) {
                        if (0 != ret[i]) {
                            strInfo += i + "Day:" + ret[i];   //ret  0:No video 1:Event video 2:Normal video
                            strInfo += "\n";
                        }

                    }
                    AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                    oBuilder.setTitle("Calendar Query");
                    oBuilder.setMessage(strInfo);

                    oBuilder.setCancelable(false);
                    oBuilder.setPositiveButton("OK", null);
                    oBuilder.show();
                }
            }
        });
        /* Alarm information */
        final Intent oIntentAlarm = new Intent(this, CAlarmReport.class);
        m_oAlarmInfoBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(oIntentAlarm);
            }
        });

        /* logout */
        final Intent oIntentMainMenu = new Intent(CMainMenu.this, CMainMenu.class);
        m_oLogoutBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer dwlpUserID = 0;
                if (true == isLocalDevFlag) {
                    dwlpUserID = ipLpUserIDMap.get(strDevIP);
                    ipLpUserIDMap.remove(strDevIP);
                    NetDEVSDK.NETDEV_Logout(dwlpUserID);
                    CLocalDevLogin.DevIpList.remove(strDevIP);
                    CLocalDevLogin.lpUserIDList.remove(dwlpUserID);
                } else {
                    dwlpUserID = nameLpUserIDMap.get(strCloudDevName);
                    nameLpUserIDMap.remove(strCloudDevName);
                    NetDEVSDK.NETDEV_Logout(dwlpUserID);
                    CCloudDevlogin.cloudDevNameList.remove(strCloudDevName);
                    CCloudDevlogin.cloudLpUserIDList.remove(dwlpUserID);

                    if(true == isNoAccountDevFlag){
                        NETDEV_CLOUD_NOACCOUNT_INFO_S stCloudNoAccountInfo = new NETDEV_CLOUD_NOACCOUNT_INFO_S();
                        stCloudNoAccountInfo.szDeviceSN = strCloudDevName;
                        stCloudNoAccountInfo.szDeviceName = "";
                        int iRet = NetDEVSDK.NETDEV_NoAccountCancel(NetDEVSDK.glpcloudID,stCloudNoAccountInfo);
                        if(0 == iRet)
                        {
                            AlertDialog.Builder oBuilder = new Builder(CMainMenu.this);
                            oBuilder.setMessage("NETDEV_NoAccountCancel fail  !");
                            oBuilder.setTitle("");
                            oBuilder.setPositiveButton("OK", null);
                            oBuilder.show();
                        }
                    }
                }

                startActivity(oIntentLog);

                finish();
            }
        });

    }
	

	/*
	public void playAudioData()
	{
		m_oNetDEVSDK.setNotifyListener(new OnNotifyListener() 
		{
		   @Override
            public void nativeNotifyDecodeAudioData(byte[] voiceData, int u32WaveFormat, int length, int type) 
            {	
			   try {
				   
				   if (mAudioPlayer == null)
	        			{
	        				mAudioPlayer = new AudioTrack(AudioManager.STREAM_MUSIC, 8000,
	        						AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT,
	        						length, AudioTrack.MODE_STREAM);
	        			}
	        			mAudioPlayer.write(voiceData, 0, length);
	        			mAudioPlayer.play();

        			} catch (Exception e) 
        			{
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        			} 
            } 

		});
	}
	
	
	//输入语音
	public void ReceiveAudioData()
	{
        buf_size = AudioRecord.getMinBufferSize(8000,AudioFormat.CHANNEL_CONFIGURATION_MONO,AudioFormat.ENCODING_PCM_16BIT);
		  
       mAudioRecorder = new AudioRecord(MediaRecorder.AudioSource.MIC,8000,AudioFormat.CHANNEL_CONFIGURATION_MONO,AudioFormat.ENCODING_PCM_16BIT,
    buf_size) ;
       m_in_bytes = new byte [buf_size]; 
      try
      {
    	  NETDEV_AUDIO_SAMPLE_PARAM_S oVoiceParam = new NETDEV_AUDIO_SAMPLE_PARAM_S();
    	  oVoiceParam.dwChannels = m_dwChannelID;
    	  oVoiceParam.dwSampleRate = 8000;
    	  oVoiceParam.enSampleFormat = NETDEV_AUDIO_SAMPLE_FORMAT_E.NETDEV_AUDIO_SAMPLE_FMT_S16;
    	  
          mAudioRecorder.startRecording() ;
             while(m_bKeepRunning)
             {
            	 mAudioRecorder.read(m_in_bytes, 0, buf_size) ;
                 NetDEVSDK.NETDEV_InputVoiceData(m_lpVoiceComHandle,m_in_bytes,buf_size,oVoiceParam);
             }
     
             mAudioRecorder.stop() ;
             mAudioRecorder = null ;
             m_in_bytes = null ;	             
      }	      
      catch(Exception e)
      {
       e.printStackTrace();
      }
		
	}
	*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onDestroy() {
        super.onDestroy();
        int iRet = NetDEVSDK.NETDEV_StopRealPlay(lpLiveViewHandle[0], 1);
        lpLiveViewHandle[0] = 0;
        System.out.println("----------------------" + iRet);
    }


    /*** return key  */
    public boolean onKeyDown(int keyCode, KeyEvent event) {  // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); //exit application after double click
        }
        return false;
    }

    /*** function of exit after 2 click  */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true;
            // prepare exiting
            Toast.makeText(this, "Press again to exit the app", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // cancel exit
                }
            }, 2000); // If the return key is not pressed for 2 seconds, the timer is started to cancel the task that was just executed
        } else {
            finish();

            System.exit(0);
        }
    }
}
