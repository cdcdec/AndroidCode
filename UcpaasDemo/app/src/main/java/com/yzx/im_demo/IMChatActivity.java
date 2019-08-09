package com.yzx.im_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.yzx.db.DBObserver;
import com.yzx.db.OnDbChangeListener;
import com.yzx.db.UserInfoDBManager;
import com.yzx.db.UserSettingsDbManager;
import com.yzx.db.domain.UserSetting;
import com.yzx.im_demo.contact.ContactFrament;
import com.yzx.im_demo.fragment.ConversationFragment;
import com.yzx.im_demo.fragment.ConversationFragment.refreshUnReadMessageListener;
import com.yzx.im_demo.fragment.SettingFragment;
import com.yzx.im_demo.fragment.TeleFragment;
import com.yzx.listener.IObserverListener;
import com.yzx.model.LoginOutState;
import com.yzx.model.LoginState;
import com.yzx.model.State;
import com.yzx.mydefineview.MainBottomBar;
import com.yzx.mydefineview.MyToast;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.NotificationTools;
import com.yzx.tools.RestTools;
import com.yzxIM.IMManager;
import com.yzxIM.data.db.ChatMessage;
import com.yzxtcp.UCSManager;
import com.yzxtcp.data.UcsErrorCode;
import com.yzxtcp.data.UcsReason;
import com.yzxtcp.listener.ILoginListener;
import com.yzxtcp.listener.ISdkStatusListener;
import com.yzxtcp.tools.CustomLog;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页
 */
@SuppressLint("NewApi")
public class IMChatActivity extends FragmentActivity implements
		OnClickListener, ISdkStatusListener,
		refreshUnReadMessageListener, ILoginListener, OnDbChangeListener {
	private ImageView iv_direct;
	private ArrayList<Long> clickDirect = new ArrayList<Long>(); 
	private static boolean isDirect = false;
	private String[] actionTitle = new String[] { "消息", "通讯录", "设置" };
//	private IMManager imManager;
	private MainBottomBar bottomMsg, bottomContact, bottomSetting;
	
	private List<IObserverListener> observes = new ArrayList<IObserverListener>();
	private List<MainBottomBar> mTabIndicator = new ArrayList<MainBottomBar>();
	private YzxTopBar mActionBar;
	private UserSetting userSetting;
	private TextView conversations_cout;
	private ImageView conversations_cout_bg;
	private static final int NOTIFAY_VOICE_VIBRATOR = 406;
	public static final String TAG = "IMChatActivity";

	//是否需要连接
	private boolean isNeedConnect;
	private ConversationFragment conversationFragment;
	private TeleFragment teleFragment;
	private ContactFrament mContactFrament;
	private SettingFragment settingFragment;
	private boolean isTeleFragment = false;//当前是否为通话页面
	//网络链接成功之后，状态调用action进行相应处理
	private State state;
	
	/**
	 * 保存当前显示的是第几页 
	 */
	private int currentPage = 0;
	
	/**
	 * @Description 开启IMChatActivity类
	 * @param context	上下文
	 * @param connectTcp	true：连接TCP；false：不连接TCP
	 * @date 2016-11-29 上午9:59:30 
	 * @author xhb  
	 * @return void    返回类型
	 */
	public static void actionStart(Context context, boolean connectTcp) {
		Intent intent = new Intent(context, IMChatActivity.class);
		intent.putExtra("connectTcp", connectTcp);
		context.startActivity(intent);
	}
	
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.i(TAG,"IMChatActivity onNewIntent() taskId = "+getTaskId());
	}
	
	protected void onDestroy() {
		Log.i(TAG,"IMChatActivity onDestroy()");
		mHandler.removeCallbacks(null);
//		UserSettingsDbManager.getInstance().removeObserver(this);
		DBObserver.getInstance().removeObserver(this);
		UCSManager.removeISdkStatusListener(this);
		//setNetErrorMsg();
		super.onDestroy();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putInt("currentpage", currentPage);
		super.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		CustomLog.v("IMChatActivity onCreate() taskId = " + getTaskId());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imchat);
		if(savedInstanceState != null) {
			currentPage = savedInstanceState.getInt("currentpage");
		}
		
		DisplayMetrics outMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
		Log.i(TAG, "宽 = "+outMetrics.widthPixels+"，高 = "+outMetrics.heightPixels+"，屏幕密度 = "+outMetrics.density);
		initView();
		initDatas();

		isNeedConnect = getIntent().getBooleanExtra("connectTcp", false);
		if(isNeedConnect || !UCSManager.isConnect()){
			if(!UCSManager.isConnect()){
				CustomLog.d("------------------服务被Kill-------------------");
			}
			//链接平台
			connect();
		}else{
			if(!getIntent().hasExtra("connectTcp")){
				CustomLog.d("-------------界面被回收connectTcp == null------------");
				//链接平台
				connect();
			}else{
				//连接成功才进这里
				state = new LoginState();
			}
		}
	}

	private void initView() {
		bottomMsg = (MainBottomBar) findViewById(R.id.id_bottombar_msg);
		//通讯录
		bottomContact = (MainBottomBar) findViewById(R.id.id_bottombar_contact);
		bottomSetting = (MainBottomBar) findViewById(R.id.id_bottombar_setting);
		iv_direct = (ImageView) findViewById(R.id.iv_direct);
		iv_direct.setOnClickListener(this);
		mActionBar = (YzxTopBar) findViewById(R.id.actionBar_chat);
		mActionBar.setBackVisibility(View.GONE);
		mActionBar.setTitleVisibility(View.GONE);
		mActionBar.setConverVisibility(View.VISIBLE);
		mActionBar.setMessageBackgroudResource(R.drawable.message_view_press_bg);
		mActionBar.setMessageColor(getResources().getColor(R.color.black)); 
		mActionBar.setMessageOnclickListener(this);
		mActionBar.setTeleOnclickListener(this);
		conversations_cout = (TextView) findViewById(R.id.conversations_cout);
		conversations_cout_bg = (ImageView) findViewById(R.id.conversations_cout_bg);
	}
	
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 101:
//				//踢线踢线
//				if(MainApplication.getInstance().getResumeActivity() instanceof IMMessageBgActivity){
//					//标记IMMessageBgActivity含有dialog
//					((IMMessageBgActivity)MainApplication.getInstance().getResumeActivity()).setHaveDialog(true);
//				}
				//启动登出界面
/*				Intent intent = new Intent();
				Uri uri = Uri.parse("yzx://"+getApplicationInfo().packageName).buildUpon().appendPath("login_out").build();
				CustomLog.e("收到踢线消息启动登出Activty uri = "+uri.toString());
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(uri);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				startActivity(intent);*/
				Intent intent = new Intent(IMChatActivity.this,IMLoginOutActivity.class);
				startActivity(intent);
				break;
			case 102:
				MyToast.showLoginToast(IMChatActivity.this, "token超时,请重新登陆");
				break;
			case NOTIFAY_VOICE_VIBRATOR:
				//振铃和声音
				Log.i(TAG, "收到消息，添加振铃");
				NotificationTools.showNotification(userSetting,(ChatMessage)msg.obj);
				break;
			default:
				break;
			}
		}
	};
	
	private void initDatas() {
		initTabIndicator();
		userSetting = UserSettingsDbManager.getInstance().getById(UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount());
		// 在FragmentManager里面根据Tag去找相应的fragment. 用户屏幕发生旋转，重新调用onCreate方法。否则会发生重叠
		conversationFragment = (ConversationFragment) getSupportFragmentManager().findFragmentByTag("conversation");
		teleFragment = (TeleFragment) getSupportFragmentManager().findFragmentByTag("tele");
		mContactFrament = (ContactFrament) getSupportFragmentManager().findFragmentByTag("contact");
		settingFragment = (SettingFragment) getSupportFragmentManager().findFragmentByTag("setting");
		setTabSelection(currentPage);
		
//		UserSettingsDbManager.getInstance().addObserver(this);
		DBObserver.getInstance().addObserver(this);
//		imManager = IMManager.getInstance(getApplicationContext());
//		imManager.setISdkStatusListener(this);
		UCSManager.setISdkStatusListener(this);
		conversationFragment.setRefreshUnReadMessageListener(this);
	}
	
	/**
	 * @Description 根据传入的index参数来设置选中的tab页。 
	 * @param index	每个tab页对应的下标。0表示消息，1表示电话内容，2表示联系，3表示设置。 
	 * @date 2016-11-29 下午7:38:22 
	 * @author xhb  
	 * @return void    返回类型
	 */
	private void setTabSelection(int index) {
		// 每次选中之前先清除掉上次的选中状态  
		resetOtherTabs();
		// 开启一个Fragment事务  
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况  
		hideFragments(transaction);
		switch (index) {
		case 0:
			mTabIndicator.get(0).setBottomViewNormalAlpha(0.0f);
			mActionBar.setTitleVisibility(View.GONE);
			mActionBar.setConverVisibility(View.VISIBLE);
			mActionBar.setTeleBackgroudResource(R.drawable.tele_view_bg);
			mActionBar.setTeleColor(getResources().getColor(R.color.white));
			mActionBar.setMessageBackgroudResource(R.drawable.message_view_press_bg);
			mActionBar.setMessageColor(getResources().getColor(R.color.black));
			if(conversationFragment == null) {
				// 如果conversationFragment为空，则创建一个并添加到界面上  
				conversationFragment = new ConversationFragment();
				transaction.add(R.id.id_frameLayout, conversationFragment,"conversation");
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来  
				transaction.show(conversationFragment);
			}
			break;
		case 1:
			mTabIndicator.get(0).setBottomViewNormalAlpha(0.0f);
			mActionBar.setTitleVisibility(View.GONE);
			mActionBar.setConverVisibility(View.VISIBLE);
			mActionBar.setTeleBackgroudResource(R.drawable.tele_view_press_bg);
			mActionBar.setTeleColor(getResources().getColor(R.color.black));
			mActionBar.setMessageBackgroudResource(R.drawable.message_view_bg);
			mActionBar.setMessageColor(getResources().getColor(R.color.white));
			if(teleFragment == null) {
				// 如果teleFragment为空，则创建一个并添加到界面上  
				teleFragment = new TeleFragment();
				transaction.add(R.id.id_frameLayout, teleFragment,"tele");
			} else {
				// 如果teleFragment不为空，则直接将它显示出来  
				transaction.show(teleFragment);
			}
			break;
		case 2:
			iv_direct.setVisibility(View.GONE);
			mTabIndicator.get(1).setBottomViewNormalAlpha(0.0f);
			mActionBar.setConverVisibility(View.GONE);
			mActionBar.setTitleVisibility(View.VISIBLE);
			mActionBar.setTitle(actionTitle[1]);
			if(mContactFrament == null) {
				// 如果ContactFrament为空，则创建一个并添加到界面上  
				mContactFrament = new ContactFrament();
				transaction.add(R.id.id_frameLayout, mContactFrament,"contact");
			} else {
				// 如果ContactFrament不为空，则直接将它显示出来 
				transaction.show(mContactFrament);
			}
			break;
		case 3:
		default:
			mTabIndicator.get(2).setBottomViewNormalAlpha(0.0f);
			mActionBar.setConverVisibility(View.GONE);
			mActionBar.setTitleVisibility(View.VISIBLE);
			mActionBar.setTitle(actionTitle[2]);
			if(settingFragment == null) {
				// 如果settingFragment为空，则创建一个并添加到界面上  
				settingFragment = new SettingFragment();
				transaction.add(R.id.id_frameLayout, settingFragment,"setting");
			} else {
				// 如果settingFragment不为空，则直接将它显示出来 
				transaction.show(settingFragment);
			}
			break;
		}
		transaction.commit();
	}
	
	/**
	 * @Description 将所有的Fragment都置为隐藏状态
	 * @param transaction	用于对Fragment执行操作的事务 
	 * @date 2016-11-29 下午8:16:34 
	 * @author xhb  
	 * @return void    返回类型
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if(conversationFragment != null) {
			transaction.hide(conversationFragment);
		}
		if(teleFragment != null) {
			transaction.hide(teleFragment);
		}
		if(mContactFrament != null) {
			transaction.hide(mContactFrament);
		}
		if(settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}
	
	private void initTabIndicator() {
		mTabIndicator.add(bottomMsg);
		mTabIndicator.add(bottomContact);
		mTabIndicator.add(bottomSetting);

		bottomMsg.setOnClickListener(this);
		bottomContact.setOnClickListener(this);
		bottomSetting.setOnClickListener(this);

	}
	
	protected void onResume() {
		super.onResume();
		MainApplication.getNotificationManager().cancelAll();
		MainApplication.getInstance().setResumeActivity(this);
		
		checkUnReadMsg();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_message:	// ConversationFragment
			setTabSelection(0);
			isTeleFragment = false;
			currentPage = 0;
			break;
		case R.id.tv_tele:	// TeleFragment
			setTabSelection(1);
			isTeleFragment = true;
			currentPage = 1;
			break;
		case R.id.id_bottombar_msg:
			iv_direct.setVisibility(View.GONE);
            if (!isTeleFragment) {
                // 消息页
            	setTabSelection(0);
            	currentPage = 0;
            } else {
                // 电话页
            	setTabSelection(1);
            	currentPage = 1;
            }
			break;
		case R.id.id_bottombar_contact:	// ContactFragment
			setTabSelection(2);
			currentPage = 2;
			break;
		case R.id.id_bottombar_setting:		// SettingFragment
			showDirect();
			setTabSelection(3);
			currentPage = 3;
			break;
		case R.id.iv_direct:	// 直拨入口
			Intent intent = new Intent(IMChatActivity.this, DirectEntryActivity.class);
			startActivity(intent);
			break;
		}
	}

	private void showDirect() {
		if(!isDirect) {	// 如果已经显示了,到设置栏目就直接显示
			// 在设置栏目时点击5下才有效
			if(getSupportFragmentManager().findFragmentByTag("setting") != null) {
				clickDirect.add(SystemClock.uptimeMillis());
			    if (clickDirect.size() == 5) { 
			        //5次连击打开
			        if (clickDirect.get(clickDirect.size()-1)-clickDirect.get(0) < 2000) {
			        	clickDirect.clear();
			        	// 显示直拨入口
			        	iv_direct.setVisibility(View.VISIBLE);
			        	isDirect = true;
			        } else {
			            Long tmp = clickDirect.get(clickDirect.size()-1);
			            clickDirect.clear();
			            clickDirect.add(tmp);
			        }
			    }
			}
		} else {
			iv_direct.setVisibility(View.VISIBLE);
		}
	}

	/**
	 * 重置其他的Tab
	 */
	private void resetOtherTabs() {
		for (int i = 0; i < mTabIndicator.size(); i++) {
			mTabIndicator.get(i).setBottomViewNormalAlpha(1.0f);
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			//moveTaskToBack(false);
			//返回桌面
			Intent home = new Intent(Intent.ACTION_MAIN);  
			home.addCategory(Intent.CATEGORY_HOME);   
			startActivity(home);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onSdkStatus(UcsReason reason) {
		Log.i(TAG, "onSdkStatus status = "+reason.getReason());
		CustomLog.e("onSdkStatus reason: " + reason.getReason() + "    "
				+ reason.getMsg());
		int status = 0;
		if (reason.getReason() == UcsErrorCode.NET_ERROR_KICKOUT) {// 服务器强制下线通知
			CustomLog.e("收到服务器强制下线通知");
			mHandler.sendEmptyMessage(101);
			//UCSManager.disconnect();
		} else if (reason.getReason() == UcsErrorCode.NET_ERROR_TOKENERROR) {
			CustomLog.e("token超时,请重新登录");
		} else if(reason.getReason() == UcsErrorCode.NET_ERROR_TCPCONNECTOK){
			CustomLog.e("TCPCONNECTOK errorcode = " +reason.getReason());
			status = 400;
		} else if(reason.getReason() == UcsErrorCode.NET_ERROR_TCPCONNECTFAIL){
			CustomLog.e("TCPCONNECTFAIL errorcode = " +reason.getReason());
			status = 408;
		} else if(reason.getReason() == UcsErrorCode.NET_ERROR_TCPCONNECTING){
			CustomLog.e("TCPCONNECTING errorcode = " +reason.getReason());
			status = 406;
		} else if(reason.getReason() == UcsErrorCode.PUBLIC_ERROR_NETUNCONNECT){
			CustomLog.e("NETUNCONNECT errorcode = " +reason.getReason());
			status = 402;
		} else if(reason.getReason() == UcsErrorCode.PUBLIC_ERROR_NETCONNECTED){
			CustomLog.e("NETCONNECTED errorcode = " +reason.getReason());
			if(UCSManager.isConnect()){
				status = 400;
			}else{
				//进行相应处理
				state.action(this, userSetting.getToken());
				status = 406;
			}
		}
		notifyObserver(status);
	}

	@Override
	public void onRefreshUnReadMessage() {
		checkUnReadMsg();
	}
	/**
	 * 检查未读消息
	 */
	private void checkUnReadMsg() {
		int unreadcount = IMManager.getInstance(this).getUnreadCountAll();
		Log.i(TAG, "未读消息："+unreadcount+"条");
		if (unreadcount != 0) {
			if (unreadcount > 99) {
				conversations_cout.setText("99+");
			} else {
				conversations_cout.setText(String.valueOf(unreadcount));
			}
			if (unreadcount < 10) {
				conversations_cout_bg.setVisibility(View.VISIBLE);
				conversations_cout_bg
						.setBackgroundResource(R.drawable.unreadsmall);
			} else {
				conversations_cout_bg.setVisibility(View.VISIBLE);
				conversations_cout_bg
						.setBackgroundResource(R.drawable.unreadbig);
			}
		} else {
			conversations_cout_bg.setVisibility(View.GONE);
			conversations_cout.setText("");
		}
	}

	public void onLogin(UcsReason reason) {
		//CustomLog.v("onLogin status errorCode = "+reason.getReason());
		Log.i(TAG, "onLogin status errorCode = "+reason.getReason());
		int sdkStatus = 0;
		if (reason.getReason() == UcsErrorCode.NET_ERROR_CONNECTOK){
			CustomLog.e("connect sdk successfully -----  enjoy --------");
			isNeedConnect = false;
			state = new LoginState();
			sdkStatus = 400;
		}else if(reason.getReason() == UcsErrorCode.PUBLIC_ERROR_NETUNCONNECT){
			sdkStatus = 402;
		}else{
			conversationFragment.handSdkStatus(408);
			sdkStatus = 408;
		}
		notifyObserver(sdkStatus);
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void connect() {
		state = new LoginOutState();
		new Thread(){
			public void run() {
				try {
					Thread.sleep(500);
					RestTools.queryGroupInfo(IMChatActivity.this,UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount(),null);
					String token = userSetting.getToken();
					//只要是进入了connect，表示未登录状态
					UCSManager.connect(token, IMChatActivity.this);
				} catch (InterruptedException e) {
				}
			};
		}.start();
	}
	
	public void putObserver(IObserverListener mObserver){
		synchronized (observes) {
			if(!observes.contains(mObserver)){
				boolean successful = observes.add(mObserver);
				if(successful){
					Log.d(TAG, "add mObserver successful hashCode = "+mObserver.hashCode());
				}else{
					Log.d(TAG, "add mObserver fail hashCode = "+mObserver.hashCode());
				}
			}
		}
	}
	
	public void removeObserver(IObserverListener mObserver){
		synchronized (observes) {
			if(observes.contains(mObserver)){
				boolean successful = observes.remove(mObserver);
				if(successful){
					Log.d(TAG, "remove mObserver successful hashCode = "+mObserver.hashCode());
				}else{
					Log.d(TAG, "remove mObserver fail hashCode = "+mObserver.hashCode());
				}
			}
		}
	}
	
	public void notifyObserver(int sdkStatus){
		if(observes == null || observes.size() == 0){
			return;
		}
		synchronized (observes) {
			for(IObserverListener observer : observes){
				observer.notify(sdkStatus);
			}
		}
	}
	@Override
	public void onChange(String notifyId) {
		Log.i(TAG, "reQuery userSettings onChange id = "+notifyId);
		userSetting = UserSettingsDbManager.getInstance().getById(UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount());
	}

	@Override
	public void onReceiveMessage(List<ChatMessage> msgs) {
		List<ChatMessage> messages = (List<ChatMessage>) msgs;
		Log.i(TAG, "onReceiveMessage msg size : "+msgs.size());
		if(mHandler.hasMessages(NOTIFAY_VOICE_VIBRATOR)){
			mHandler.removeMessages(NOTIFAY_VOICE_VIBRATOR);
		}
		Message msg = mHandler.obtainMessage();
		msg.obj = messages.get(messages.size() - 1);
		msg.what = NOTIFAY_VOICE_VIBRATOR;
		mHandler.sendMessage(msg);
	}
}
