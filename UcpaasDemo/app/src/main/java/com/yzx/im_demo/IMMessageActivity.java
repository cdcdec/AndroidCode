package com.yzx.im_demo;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;

import androidx.fragment.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.model.LatLng;
import com.rockerhieu.emojicon.EmojiconGridFragment;
import com.rockerhieu.emojicon.EmojiconHandler;
import com.rockerhieu.emojicon.EmojiconSpan;
import com.rockerhieu.emojicon.EmojiconsFragment;
import com.rockerhieu.emojicon.emoji.Emojicon;
import com.yzx.db.ConversationBgDbManager;
import com.yzx.db.DraftDbManager;
import com.yzx.db.UserInfoDBManager;
import com.yzx.db.domain.ConversationBg;
import com.yzx.db.domain.DraftMsg;
import com.yzx.db.domain.UserInfo;
import com.yzx.model.SortModel;
import com.yzx.model.VoiceStatus;
import com.yzx.mydefineview.IMChatImageView;
import com.yzx.mydefineview.MessagePop;
import com.yzx.mydefineview.MyListView.OnRefreshListener;
import com.yzx.mydefineview.MyListView;
import com.yzx.mydefineview.ResizeRelativeLayout;
import com.yzx.mydefineview.ResizeRelativeLayout.OnSizeChangeListener;
import com.yzx.mydefineview.YZXVisibleLinearLayout;
import com.yzx.mydefineview.YZXVisibleLinearLayout.OnVisibilityChangedListener;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.BitmapTools;
import com.yzx.tools.ContactTools;
import com.yzx.tools.ContentResolverUtils;
import com.yzx.tools.CoordTools;
import com.yzx.tools.DateTools;
import com.yzx.tools.NotificationTools;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.MSGTYPE;
import com.yzxIM.data.db.ChatMessage;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxIM.data.db.CustomMsg;
import com.yzxIM.data.db.DiscussionChat;
import com.yzxIM.data.db.DiscussionInfo;
import com.yzxIM.data.db.GroupChat;
import com.yzxIM.data.db.LocationMapMsg;
import com.yzxIM.data.db.SingleChat;
import com.yzxIM.listener.MessageListener;
import com.yzxIM.listener.RecordListener;
import com.yzxtcp.UCSManager;
import com.yzxtcp.tools.CustomLog;
import com.yzxtcp.tools.FileTools;
import com.yzxtcp.tools.NetWorkTools;

/**
* @Title IMMessageActivity 
* @Description 
* @Company yunzhixun
* @author zhuqian
* @date 2015-11-16 下午5:56:42 
*/
public class IMMessageActivity extends FragmentActivity implements
		MessageListener, RecordListener,
		EmojiconGridFragment.OnEmojiconClickedListener,
		EmojiconsFragment.OnEmojiconBackspaceClickedListener,com.yzx.mydefineview.MessagePop.IMessageHandlerListener {
	public static final String NEW_MESSAGE_ACTION = "com.yzx.im.newmessage";
	private static final String TAG = "IMMessageActivity";
	private RelativeLayout imbtn_back;
	private Button imbtn_info;
	private TextView tv_number;
	private TextView tv_title;
	private TextView im_tv_record;
	private TextView im_send_btn;
	private EditText im_send_text;
	private MessageAdapter adapter;
	private MyListView messagelist;
	private LinearLayout im_ll_more;
	private ImageButton im_ll_file;
	private ImageButton im_ll_shot;
	private ImageButton im_ll_voice;
	/**
	 * 视频聊天
	 */
	private ImageButton im_ll_video;
	private ImageButton im_ll_location;
	private ImageButton im_ll_customMsg;
	private LinearLayout im_ll_record;
	private LinearLayout im_ll_images;
	private LinearLayout im_network;
	private RelativeLayout im_more;
	private RelativeLayout im_audio;
	private RelativeLayout im_key;
	private ResizeRelativeLayout im_immessage;
	private YZXVisibleLinearLayout yzx_operate;
	private ImageView im_iv_record;
	private ImageView im_iv_record_left;
	private ImageView im_iv_record_right;
	private ImageView im_send_image;
	private IMManager imManager;
	private ConversationInfo conversationinfo;
	private List<ChatMessage> currentMsgList = new ArrayList<ChatMessage>();
	private DisplayMetrics dm;
	private int screenWidth;
	private int screenHeigh;
	private Timer timer = null;
	private int num = 0;
	private long uptime = 0;
	private long buttontime = 0;
	private Boolean send_record = true;
	private Boolean toast_record = true;
	private Boolean toast_cancel_record = true;
	private Handler mUIHandler;
	private List<String> msgTimeList = new ArrayList<String>();
	private HashMap<Integer, String> msgTimeMap = new HashMap<Integer, String>();
	private int unreadcount = 0;
	private String shot_path;
	private AnimationDrawable animation;
	private String loginUser = "";
	private String sendId = "";
	
	//当前根布局的高度
	private int rootHight = 0;

	private VoiceStatus voiceStatus = new VoiceStatus();

	private String voicePath = "";
	
	private MessagePop pop;

	// 软键盘是否隐藏
	private boolean softModthIsHidden = true;
	// 代表底部三个布局显示隐藏的操作数
	private int operate_num = -1;

	private static final int YZX_RECORD_VISIBLE = 1;

	private static final int YZX_IMAGES_VISIBLE = 1 << 1;

	private static final int YZX_MORE_VISIBLE = 1 << 2;

	private static final int YZX_ACTIVITY_FINISH = 1 << 3;

	private static final int YZX_START_INFO = 1 << 4;

	private static final int YZX_START_IMAGE = 1 << 5;
	
	private static final int YZX_START_LOCATION = 1 << 6;
	
	private ConversationBg conversationBg;
	//点击要查看的位置消息
	private ChatMessage locationMsg;
	
	private DateFormat sdf;

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				// 接收消息回调处理
				long startTime = System.currentTimeMillis();
				List<ChatMessage> newMsgList = (List<ChatMessage>) msg.obj;
				CustomLog.d("onReceiveMessage unreadcount:" + unreadcount);
				// 判断输入法状态

				if (!softModthIsHidden
						|| (yzx_operate.getVisibility() == View.VISIBLE || messagelist
								.getLastVisiblePosition() == messagelist
								.getCount() - 1)) {
					messagelist
							.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
				} else {
					messagelist
							.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);
				}
				synchronized (currentMsgList) {
					if(newMsgList.size() > 20){
						currentMsgList.clear();
					}
					currentMsgList.addAll(newMsgList);
					adapter.notifyDataSetChanged();
				}
				Log.i(TAG, "来新消息共花费 = "+(System.currentTimeMillis() - startTime)+"毫秒");
				mHandler.sendEmptyMessage(10);
				break;
			case 2:
				// 关闭定时器
				stopTimer();
				imManager.stopVoiceRecord();
				mHandler.sendEmptyMessageDelayed(8, 10);
				if (toast_cancel_record == true) {
					Toast.makeText(IMMessageActivity.this, "录音时间小于1s，请重新录音",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case 3:
				// 点击表情按钮
				if (yzx_operate.getVisibility() == View.GONE) {
					yzx_operate.setVisibility(View.VISIBLE);
				}
				im_ll_record.setVisibility(View.GONE);
				im_ll_more.setVisibility(View.GONE);
				im_key.setVisibility(View.GONE);
				im_audio.setVisibility(View.VISIBLE);
				sendEmptyMessageDelayed(16, 100);
				break;
			case 16:
				im_ll_images.setVisibility(View.VISIBLE);
				break;
			case 4:
				// 点击录音按钮
				if (yzx_operate.getVisibility() == View.GONE) {
					yzx_operate.setVisibility(View.VISIBLE);
				}
				im_audio.setVisibility(View.GONE);
				im_key.setVisibility(View.VISIBLE);
				im_ll_record.setVisibility(View.VISIBLE);
				im_ll_more.setVisibility(View.GONE);
				im_ll_images.setVisibility(View.GONE);
				break;
			case 5:
				// 网络异常界面显示
				if ((Boolean) msg.obj) {
					im_network.setVisibility(View.GONE);
				} else {
					im_network.setVisibility(View.VISIBLE);
				}
				break;
			case 6:
				// 发送消息时增加消息到消息列表
				synchronized (currentMsgList) {
					currentMsgList.add((ChatMessage) msg.obj);
					adapter.notifyDataSetChanged();
					mHandler.sendEmptyMessage(10);
				}
				break;
			case 7:
				adapter.notifyDataSetChanged();
				if (unreadcount > 99) {
					tv_number.setText("消息(99+)");
				} else if (unreadcount > 0) {
					tv_number.setText("消息(" + unreadcount + ")");
				} else {
					tv_number.setText("");
				}
				break;
			case 8:
				// 语音状态恢复默认
				im_tv_record.setText("按住说话");
				im_iv_record_left
						.setBackgroundResource(R.drawable.im_record_left0);
				im_iv_record_right
						.setBackgroundResource(R.drawable.im_record_right0);
				im_iv_record.setBackgroundResource(R.drawable.im_record);
				break;
			case 9:
				// 关闭定时器
				stopTimer();
				imManager.stopVoiceRecord();
				mHandler.sendEmptyMessageDelayed(8, 10);
				if (toast_cancel_record == true) {
					Toast.makeText(IMMessageActivity.this, "录音异常,请检查录音权限是否被关闭",
							Toast.LENGTH_SHORT).show();
				}
				break;
			case 10:
				conversationinfo.clearMessagesUnreadStatus();
				unreadcount = imManager.getUnreadCountAll();
				if (unreadcount > 99) {
					tv_number.setText("消息(99+)");
				} else if (unreadcount > 0) {
					tv_number.setText("消息(" + unreadcount + ")");
				} else {
					tv_number.setText("");
				}
				break;
			case 11:
				// 显示更多
				if (yzx_operate.getVisibility() == View.GONE) {
					yzx_operate.setVisibility(View.VISIBLE);
				}
				im_ll_more.setVisibility(View.VISIBLE);
				im_ll_record.setVisibility(View.GONE);
				im_ll_images.setVisibility(View.GONE);
				break;
			case 12:
				// 退出
				Intent intent = new Intent(IMMessageActivity.this,
						IMChatActivity.class);
				startActivity(intent);
				break;
			case 13:
				// 启动信息页面
				Intent infoeIntent = new Intent(IMMessageActivity.this,
						IMDiscussInfoActivity.class);
				infoeIntent.putExtra("conversationinfo", conversationinfo);
				startActivityForResult(infoeIntent, 2);
				break;
			case 14:
				Intent imageIntent = new Intent(IMMessageActivity.this,
						IMMessageInfoActivity.class);
				imageIntent.putExtra("conversationinfo", conversationinfo);
				startActivityForResult(imageIntent, 2);
				break;
			case 15:
				// 更新错误UI
				CustomLog.d("handler update error msgs ");
				messagelist
						.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);
				adapter.notifyDataSetChanged();
				break;
			case 17:
				//启动查看地图页面
				if(locationMsg != null){
					Intent locationIntent = new Intent(IMMessageActivity.this, IMBaiduMapActivity.class);
					locationIntent.putExtra("latitude", locationMsg.getLocationMapMsg().getLatitude());
					locationIntent.putExtra("longitude", locationMsg.getLocationMapMsg().getLongitude());
					locationIntent.putExtra("address", locationMsg.getLocationMapMsg().getDetailAddr());
					startActivity(locationIntent);
				}
				break;
			case 18:
				//发送消息
				CustomLog.e("发送延迟图片消息");
				ChatMessage message = (ChatMessage) msg.obj;
				if(message != null && imManager.sendmessage(message)){
					Message addMessage = mHandler.obtainMessage();
					addMessage.obj = message;
					addMessage.what = 6;
					sendMessage(addMessage);
				}
				break;
			}
		}
	};

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.i(TAG, "IMMessageActivity onNewIntent() taskId = " + getTaskId());
		initdata(null, intent);
	}

	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "IMMessageActivity onCreate() taskId = " + getTaskId());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversation);
		
		imManager = IMManager.getInstance(this);
		imManager.setSendMsgListener(this);
		initdata(savedInstanceState, getIntent());
		
		//广播注册放在onCreate中，与onDestroy中的广播注销对应
		IntentFilter ift = new IntentFilter();
		ift.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(br, ift);
		
		//添加渲染完毕监听，获取view的高度
		ViewTreeObserver observer = im_immessage.getViewTreeObserver();
		observer.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				if(rootHight == 0){
					rootHight = im_immessage.getMeasuredHeight();
				}
			}
		});
	}

	private void initdata(Bundle savedInstanceState, Intent intent) {
		conversationinfo = (ConversationInfo) intent
				.getSerializableExtra("conversation");
		CustomLog.e("conversationinfo:" + conversationinfo.toString());
		MainApplication.getInstance().targetId = conversationinfo.getTargetId();
		
		if (savedInstanceState != null
				&& savedInstanceState.getSerializable("conversation") != null && conversationinfo == null) {
			conversationinfo = (ConversationInfo) savedInstanceState
					.getSerializable("conversation");
			Log.i(TAG, "onSaveInstanceStategetSerializable() != null,conversationinfo = "+conversationinfo.hashCode());
		}
		if(savedInstanceState != null && !TextUtils.isEmpty(savedInstanceState.getString("shot_path"))){
			Log.i(TAG, "拍摄异常，获取原来的shot_path");
			shot_path = savedInstanceState.getString("shot_path");
		}
		conversationBg = ConversationBgDbManager.getInstance().getById(conversationinfo.getTargetId());
		UserInfo user = UserInfoDBManager.getInstance().getCurrentLoginUser();

		loginUser = user.getName();
		sendId = user.getAccount();

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeigh = dm.heightPixels;

		initviews();
	}

	private BroadcastReceiver br = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, final Intent intent) {
			if (TextUtils.equals(intent.getAction(),
					ConnectivityManager.CONNECTIVITY_ACTION)) {
				CustomLog
						.e("网络连接判断"
								+ NetWorkTools
										.isNetWorkConnect(IMMessageActivity.this));
				Message msg = new Message();
				msg.what = 5;
				msg.obj = NetWorkTools.isNetWorkConnect(IMMessageActivity.this);
				mHandler.sendMessage(msg);
			}
		}
	};

	private void initviews() {
		im_immessage = (ResizeRelativeLayout) findViewById(R.id.im_immessage);

		softModthIsHidden = true;
		im_immessage.setmOnSizeChangeListener(new OnSizeChangeListener() {
			public void onSizeChange(int h, int oldh) {
				if (h > oldh || h == rootHight) {
					softModthIsHidden = true;
					if (operate_num == YZX_RECORD_VISIBLE) {
						// 点击录音按钮
						mHandler.sendEmptyMessage(4);
					} else if (operate_num == YZX_MORE_VISIBLE) {
						mHandler.sendEmptyMessage(11);
					} else if (operate_num == YZX_IMAGES_VISIBLE) {
						// 点击表情按钮
						mHandler.sendEmptyMessage(3);
					} else if (operate_num == YZX_ACTIVITY_FINISH) {
						mHandler.sendEmptyMessage(12);
					} else if (operate_num == YZX_START_INFO) {
						mHandler.sendEmptyMessage(13);
					} else if (operate_num == YZX_START_IMAGE) {
						mHandler.sendEmptyMessage(14);
					} else if(operate_num == YZX_START_LOCATION){
						mHandler.sendEmptyMessage(17);
					}
				} else {
					softModthIsHidden = false;
					//立马停止
					messagelist.smoothScrollBy(0, 0);
					//选中最后一个
					messagelist.setSelection(currentMsgList.size());
				}
				operate_num = -1;
			}
		});

		im_immessage.getRootView().setBackgroundResource(R.drawable.message_bg1);
		yzx_operate = (YZXVisibleLinearLayout) findViewById(R.id.yzx_operate);
		yzx_operate
				.setmOnVisibilityChangedListener(new OnVisibilityChangedListener() {
					public void onVisibilityChanged(View changedView,
							int visibility) {
						if (visibility == View.VISIBLE) {
							// 如果显示，输入法还在
							InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
							inputmanger.hideSoftInputFromWindow(
									changedView.getWindowToken(), 0);
						} else {
							if (changedView.getTag() != null
									&& (Integer) (changedView.getTag()) == 200) {
								// 等界面消失再弹出输入法。
								View view = getWindow().peekDecorView();
								if (view != null) {
									InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
									inputmanger.toggleSoftInput(0,
											InputMethodManager.HIDE_NOT_ALWAYS);
									inputmanger.viewClicked(view);
								}
								changedView.setTag(null);
							}
						}
					}
				});

		im_tv_record = (TextView) findViewById(R.id.im_tv_record);
		messagelist = (MyListView) findViewById(R.id.messagelist);
		messagelist.setDivider(null);
		messagelist.setTopRefresh(true);
		adapter = new MessageAdapter();
		messagelist.setAdapter(adapter);
		messagelist.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		adapter.addDbMessageAdapter(this, conversationinfo);
		messagelist.setSelection(messagelist.getCount() - 1);
		im_tv_record.setText("按住说话");

		imbtn_back = (RelativeLayout) findViewById(R.id.imbtn_back);
		imbtn_info = (Button) findViewById(R.id.imbtn_info);
		imbtn_info.setVisibility(View.VISIBLE);
		tv_number = (TextView) findViewById(R.id.tv_number);
		tv_number.setVisibility(View.VISIBLE);
		tv_title = (TextView) findViewById(R.id.tv_title);
		im_send_text = (EditText) findViewById(R.id.im_send_text);
		im_send_btn = (TextView) findViewById(R.id.im_send_btn);
		im_key = (RelativeLayout) findViewById(R.id.im_key);
		im_audio = (RelativeLayout) findViewById(R.id.im_audio);
		im_more = (RelativeLayout) findViewById(R.id.im_more);
		im_ll_file = (ImageButton) findViewById(R.id.im_ll_file);
		im_ll_shot = (ImageButton) findViewById(R.id.im_ll_shot);
		im_ll_voice = (ImageButton) findViewById(R.id.im_ll_voice); 
		im_ll_video = (ImageButton) findViewById(R.id.im_ll_video); 
		im_ll_location = (ImageButton) findViewById(R.id.im_ll_location);
		im_ll_customMsg = (ImageButton) findViewById(R.id.im_ll_customMsg);
		im_ll_more = (LinearLayout) findViewById(R.id.im_ll_more);
		im_ll_record = (LinearLayout) findViewById(R.id.im_ll_record);
		im_ll_images = (LinearLayout) findViewById(R.id.im_ll_images);
		im_iv_record = (ImageView) findViewById(R.id.im_iv_record);
		im_iv_record_left = (ImageView) findViewById(R.id.im_iv_record_left);
		im_iv_record_right = (ImageView) findViewById(R.id.im_iv_record_right);
		im_send_image = (ImageView) findViewById(R.id.im_send_image);
		YzxTopBar yzxTopBar = (YzxTopBar) findViewById(R.id.yzx_topbar);
		im_network = (LinearLayout) findViewById(R.id.im_network);
		if (NetWorkTools.isNetWorkConnect(this)) {
			im_network.setVisibility(View.GONE);
		} else {
			im_network.setVisibility(View.VISIBLE);
		}
		DraftMsg msg = DraftDbManager.getInstance().getByTargetId(conversationinfo.getTargetId());
		String draftMsg = "";
		if(msg != null){
			draftMsg = msg.getDraftMsg();
		}
		if (!"".equals(draftMsg)) {
			im_send_text.setText(draftMsg);
			im_send_text.setSelection(im_send_text.getText().length());
			im_more.setVisibility(View.GONE);
			im_send_btn.setVisibility(View.VISIBLE);
		}
		unreadcount = IMManager.getInstance(this).getUnreadCountAll();
		if (unreadcount > 99) {
			tv_number.setText("消息(99+)");
		} else if (unreadcount > 0) {
			tv_number.setText("消息(" + unreadcount + ")");
		} else {
			tv_number.setText("");
		}

		if (conversationinfo.getCategoryId() == CategoryId.GROUP) {
			yzxTopBar.setInfoVisibility(View.GONE);
		}
		initBkgs();

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		// 标题栏

		tv_title.setText(conversationinfo.getConversationTitle());

		// 返回
		imbtn_back.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				goBack();
			}
		});
		
		tv_number.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				goBack();
			}
		});

		messagelist.setonRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				new AsyncTask<Void, Void, Void>() {
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
					}

					protected void onPostExecute(Void result) {
						runOnUiThread(new Runnable() {
							public void run() {
								List<ChatMessage> msgs = conversationinfo
										.getLastestMessages(
												currentMsgList.size(), 20);
								CustomLog.d("new refresh msg size = "+ msgs.size());
								if (msgs != null && msgs.size() > 0) {
									synchronized (currentMsgList) {
										currentMsgList.addAll(0, msgs);
										messagelist.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);
										adapter.notifyDataSetChanged();
										messagelist.setSelection(msgs.size());
									}
									if (voiceStatus != null && voiceStatus.isStatus()) {
										voiceStatus.put(voiceStatus.getPos()+ msgs.size(),voiceStatus.isStatus());
									}
								}
								mHandler.sendEmptyMessage(10);
								messagelist.onRefreshComplete();
							}
						});
					}
				}.execute(null, null, null);
			}
		});

		messagelist.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {
					closeKeyPad();
				}
				return false;
			}
		});
		// 滑动时关闭弹出界面
		messagelist.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

			}

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
					closeKeyPad();
				}
				if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
					// 判断滚动到底部
					if (view.getLastVisiblePosition() == (view.getCount() - 1)) {

					}
					// 判断滚动到顶部
					if (view.getFirstVisiblePosition() == 0) {
						messagelist.onIsRefresh(true);
					}
				}
			}

		});

		// 显示用户信息
		if (conversationinfo.getCategoryId() == CategoryId.DISCUSSION) {
			imbtn_info.setBackgroundResource(R.drawable.im_infos);
		}
		imbtn_info.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (conversationinfo.getCategoryId() == CategoryId.DISCUSSION) {
					DiscussionInfo info = imManager
							.getDiscussionInfo(conversationinfo.getTargetId());
					if (null != info) {
						if (softModthIsHidden) {
							mHandler.sendEmptyMessage(13);
						} else {
							operate_num = YZX_START_INFO;
							closeKeyPad();
						}
					} else {
						CustomLog.e("DiscussionInfo == null");
					}
				} else {
					if (softModthIsHidden) {
						mHandler.sendEmptyMessage(14);
					} else {
						operate_num = YZX_START_IMAGE;
						closeKeyPad();
					}
				}
			}
		});

		im_send_image.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				if ((System.currentTimeMillis() - buttontime) < 330) {
					return;
				}
				buttontime = System.currentTimeMillis();

				View view = getWindow().peekDecorView();
				if (view != null && !softModthIsHidden) {
					operate_num = YZX_IMAGES_VISIBLE;
//					hideOperate();
					InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					inputmanger.hideSoftInputFromWindow(view.getWindowToken(),
							0);
				} else {
					if (im_ll_images.getVisibility() == View.GONE) {
						mHandler.sendEmptyMessage(3);
					} else {
						hideOperate();
						InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						inputmanger.toggleSoftInput(0,
								InputMethodManager.HIDE_NOT_ALWAYS);
					}
				}
			}
		});

		im_send_text.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View arg0, MotionEvent event) {
				//设置为可滚动
				messagelist.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					hideOperate();
				}
				if (yzx_operate.getVisibility() == View.VISIBLE) {
					hideOperate();
				}
				return false;
			}
		});

		// 文字消息输入框,监听内容变化
		im_send_text.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				if ("".equals(im_send_text.getText().toString().trim())) {
					im_send_btn.setVisibility(View.GONE);
					im_audio.setVisibility(View.VISIBLE);
					im_more.setVisibility(View.VISIBLE);
					im_key.setVisibility(View.GONE);
				} else {
					im_send_btn.setVisibility(View.VISIBLE);
					im_audio.setVisibility(View.VISIBLE);
					im_more.setVisibility(View.GONE);
					im_key.setVisibility(View.GONE);
				}
			}
		});

		// 文字消息输入框
		im_send_text.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if ("".equals(im_send_text.getText().toString().trim())) {
					im_send_btn.setVisibility(View.GONE);
					im_more.setVisibility(View.VISIBLE);
				} else {
					im_send_btn.setVisibility(View.VISIBLE);
					im_more.setVisibility(View.GONE);
				}
				im_audio.setVisibility(View.VISIBLE);
				im_key.setVisibility(View.GONE);
			}
		});

		// 发送文字消息按钮
		im_send_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final String text = convertToMsg(im_send_text.getText(),
						IMMessageActivity.this);
				new Thread(new Runnable() {
					@Override
					public void run() {
						ChatMessage msg = null;
						switch (conversationinfo.getCategoryId()) {
						case PERSONAL:
							msg = new SingleChat();
							break;
						case GROUP:
							msg = new GroupChat();
							break;
						case DISCUSSION:
							msg = new DiscussionChat();
							break;
						}
						if (null != msg) {
							msg.setTargetId(conversationinfo.getTargetId());
							msg.setNickName(loginUser);
							msg.setSenderId(sendId);
							msg.setMsgType(MSGTYPE.MSG_DATA_TEXT);
							msg.setContent(text);
							msg.setFromMyself(true);
							CustomLog.d("getCategoryId:"
									+ conversationinfo.getCategoryId());
							CustomLog.e("发送文字消息：" + text);
							if (imManager.sendmessage(msg)) {// 发送消息成功则更新会话
								CustomLog.d("start msg =" + text);
								Message message = new Message();
								message.obj = msg;
								message.what = 6;
								mHandler.sendMessage(message);
							}
						}
					}
				}).start();
				im_send_text.setText("");
			}
		});

		// 键盘按钮
		im_key.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if ((System.currentTimeMillis() - buttontime) < 330) {
					return;
				} else if (operate_num != -1) {
					return;
				}
				buttontime = System.currentTimeMillis();
				yzx_operate.setTag(200);
				hideOperate();
				im_key.setVisibility(View.GONE);
				im_audio.setVisibility(View.VISIBLE);
			}
		});

		// 录音按钮
		im_audio.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if ((System.currentTimeMillis() - buttontime) < 330) {
					return;
				}
				buttontime = System.currentTimeMillis();
				View view = getWindow().peekDecorView();
				if (view != null && !softModthIsHidden) {
					operate_num = YZX_RECORD_VISIBLE;
					InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					inputmanger.hideSoftInputFromWindow(view.getWindowToken(),
							0);
				} else {
					mHandler.sendEmptyMessage(4);
				}
			}
		});

		// 更多按钮
		im_more.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if ((System.currentTimeMillis() - buttontime) < 330) {
					return;
				}
				buttontime = System.currentTimeMillis();
				if (view != null && !softModthIsHidden) {
					operate_num = YZX_MORE_VISIBLE;
					InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					inputmanger.hideSoftInputFromWindow(view.getWindowToken(),
							0);
				} else {
					if (im_ll_more.getVisibility() == View.GONE) {
						yzx_operate.setVisibility(View.VISIBLE);
						im_ll_more.setVisibility(View.VISIBLE);
						im_ll_record.setVisibility(View.GONE);
						im_ll_images.setVisibility(View.GONE);
					} else {
						hideOperate();
						InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						inputmanger.toggleSoftInput(0,
								InputMethodManager.HIDE_NOT_ALWAYS);
					}
				}
			}
		});

		// 传递图片按钮
		im_ll_file.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openImage(1);
			}
		});

		// 拍一张照片按钮
		im_ll_shot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openImage(2);
			}
		});
		
		// TODO 拨打音频电话
		im_ll_voice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkNetwork(IMMessageActivity.this, false) == false) {
					return;
				}
				if(conversationinfo.getCategoryId() == CategoryId.DISCUSSION) {
					StringBuilder memberList = new StringBuilder();
					DiscussionInfo discussionInfo = imManager.getDiscussionInfo(conversationinfo.getTargetId());
					String[] members = discussionInfo.getDiscussionMembers().split(",");
					UserInfo userInfo = UserInfoDBManager.getInstance().getCurrentLoginUser();
					String ownerId = userInfo.getAccount();
					for(int i=0; i<members.length; i++) {
						if(!members[i].equals(ownerId)) {
							memberList.append(members[i] + ","); 
						}
					}
					CustomLog.v("开启拨打音频同振。。。被叫号码：" + memberList.toString());
					Intent intent = new Intent(IMMessageActivity.this,AudioConverseActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
					intent.putExtra("userId", memberList.substring(0, memberList.length() - 1));
					intent.putExtra("call_type", 4);//音频同振
					startActivity(intent);
				} else { // 单聊
					CustomLog.v("开启拨打音频电话。。。");
					Intent intent = new Intent(IMMessageActivity.this,AudioConverseActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
					intent.putExtra("userName",conversationinfo.getConversationTitle());
					intent.putExtra("userId",conversationinfo.getTargetId());
					intent.putExtra("call_phone", conversationinfo.getTargetId());
					intent.putExtra("call_type", 1);//免费电话
					startActivity(intent);
				}
			}
		});
		
		// TODO 拨打视频电话
		im_ll_video.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkNetwork(IMMessageActivity.this, false) == false) {
					return;
				}
				if(conversationinfo.getCategoryId() == CategoryId.DISCUSSION) {
					StringBuilder memberList = new StringBuilder();
					DiscussionInfo discussionInfo = imManager.getDiscussionInfo(conversationinfo.getTargetId());
					String[] members = discussionInfo.getDiscussionMembers().split(",");
					UserInfo userInfo = UserInfoDBManager.getInstance().getCurrentLoginUser();
					String ownerId = userInfo.getAccount();
					for(int i=0; i<members.length; i++) {
						if(!members[i].equals(ownerId)) {
							memberList.append(members[i] + ","); 
						}
					}
					CustomLog.v("开启拨打视频同振。。。被叫号码：" + memberList.toString());
					Intent intent = new Intent(IMMessageActivity.this,VideoConverseActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
					intent.putExtra("userId", memberList.substring(0, memberList.length() - 1));
					intent.putExtra("call_type", 5);//视频同振
					startActivity(intent);
				} else { // 单聊
					CustomLog.v("开启拨打视频电话。。。");
					Intent intent = new Intent(IMMessageActivity.this, VideoConverseActivity.class); 
					intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//					intent.putExtra("userName",conversationinfo.getConversationTitle());
//					intent.putExtra("userId", conversationinfo.getTargetId());
//					intent.putExtra("call_phone", conversationinfo.getTargetId());
//					intent.putExtra("call_position", "");
					Log.e("123","userName="+conversationinfo.getConversationTitle());
					Log.e("123","userId="+conversationinfo.getTargetId());
					Log.e("123","call_phone="+conversationinfo.getTargetId());

					intent.putExtra("userName","smt0209");
					intent.putExtra("userId", "smt0209");
					intent.putExtra("call_phone", "smt0209");
					startActivity(intent);
				}
			}
		});
		
		//如果不是单聊隐藏视频音频按钮
		if(conversationinfo.getCategoryId() != CategoryId.PERSONAL){
			((LinearLayout)im_ll_voice.getParent()).setVisibility(View.INVISIBLE);
			((LinearLayout)im_ll_video.getParent()).setVisibility(View.INVISIBLE);
		}
		
		// TODO 如果是讨论组，开启音视频同振入口
		if(conversationinfo.getCategoryId() == CategoryId.DISCUSSION){
			((LinearLayout)im_ll_voice.getParent()).setVisibility(View.VISIBLE);
			((LinearLayout)im_ll_video.getParent()).setVisibility(View.VISIBLE);
			
			TextView im_tv_voice = (TextView) findViewById(R.id.im_tv_voice);
			im_tv_voice.setText("语音同振");
			TextView im_tv_video = (TextView) findViewById(R.id.im_tv_video);
			im_tv_video.setText("视频同振");
		}
		
		// 发送位置按钮
		im_ll_location.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IMMessageActivity.this, IMBaiduMapActivity.class);
				intent.putExtra("conversationinfo", conversationinfo);
				startActivityForResult(intent, SEND_LOCATION);
				hideOperate();
			}
		});
		//发送自定义消息
		im_ll_customMsg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IMMessageActivity.this, IMCustomMsgActivity.class);
				startActivityForResult(intent, SEND_CUSTOM_MSG);
				hideOperate();
			}
		});
		
		// 开始录音按钮
		im_iv_record.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					if ((System.currentTimeMillis() - uptime) < 1000) {
						return true;
					}
					// 如果正在播放声音，停止播放声音
					if (voiceStatus.getPos() >= 0 && voiceStatus.isStatus()) {
						imManager.stopPlayerVoice();
						animation.selectDrawable(0);
						animation.stop();
						voiceStatus.clear();
					}
					
					imManager.stopPlayerVoice();
					mHandler.sendEmptyMessage(7);

					toast_cancel_record = true;
					startRecordTimer();
					String path = FileTools
							.createAudioFileName(conversationinfo.getTargetId());
					send_record = true;
					imManager.startVoiceRecord(path, new RecordListener() {
						@Override
						public void onFinishedRecordingVoice(int time) {
							if (send_record) {
								if (time < 1) {
									mHandler.sendEmptyMessage(2);
									return;
								}
								if (time == 100) {
									mHandler.sendEmptyMessage(9);
									return;
								}
								toast_record = true;
								Log.i(TAG, "recode time is : " + time);
								Log.i(TAG, "recode file is : "
										+ im_iv_record.getTag().toString());
								ChatMessage msg = null;
								switch (conversationinfo.getCategoryId()) {
								case PERSONAL:
									msg = new SingleChat();
									break;
								case GROUP:
									msg = new GroupChat();
									break;
								case DISCUSSION:
									msg = new DiscussionChat();
									break;
								}
								if (null != msg) {
									msg.setTargetId(conversationinfo
											.getTargetId());
									msg.setMsgType(MSGTYPE.MSG_DATA_VOICE);
									msg.setPath(im_iv_record.getTag()
											.toString());
									msg.setContent(String.valueOf(time));
									msg.setFromMyself(true);
									msg.setSenderId(sendId);
									msg.setNickName(loginUser);
									CustomLog.d("getCategoryId:"
											+ conversationinfo.getCategoryId());
									if (imManager.sendmessage(msg)) {
										Message message = new Message();
										message.obj = msg;
										message.what = 6;
										mHandler.sendMessage(message);
									}
								}
							}
						}

						public void onFinishedPlayingVoice() {
						}
					});
					im_iv_record.setTag(path);
					break;
				case MotionEvent.ACTION_UP:
					messagelist
							.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
					if ((System.currentTimeMillis() - uptime) < 1000) {
						if (toast_record) {
							Toast.makeText(IMMessageActivity.this,
									"你有必要点的这么快吗！请慢点！", Toast.LENGTH_SHORT)
									.show();
							toast_record = false;
						}
						return true;
					} else {
						uptime = System.currentTimeMillis();
					}
					stopTimer();
					imManager.stopVoiceRecord();
					mHandler.sendEmptyMessageDelayed(8, 10);
					break;
				case MotionEvent.ACTION_MOVE:
					float y = event.getY();
					if (y < 0) {
						send_record = false;
					} else {
						send_record = true;
					}
					break;
				case MotionEvent.ACTION_CANCEL:
					messagelist
							.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
					toast_cancel_record = false;
					stopTimer();
					imManager.stopVoiceRecord();
					mHandler.sendEmptyMessageDelayed(8, 10);
					break;
				}
				return true;
			}
		});

		mUIHandler = new Handler(new Handler.Callback() {
			@Override
			public boolean handleMessage(Message msg) {
				IMMessageActivity.this.handleMessage(msg);
				return true;
			}
		});
	}

	private void initBkgs() {
		String path = "";
		if(conversationBg != null){
			path = conversationBg.getBgPath();
			Log.i(TAG, "path = "+path);
		}
		if (!"".equals(path)) {
			if (path.contains("R.drawable")) {
				switch (Integer.valueOf(path.substring(path.length() - 1))) {
				case 1:
					im_immessage.getRootView().setBackgroundResource(
							R.drawable.message_bg1);
					break;
				case 2:
					im_immessage.getRootView().setBackgroundResource(
							R.drawable.message_bg2);
					break;
				case 3:
					im_immessage.getRootView().setBackgroundResource(
							R.drawable.message_bg3);
					break;
				default:
					im_immessage.getRootView().setBackgroundResource(
							R.drawable.message_bg3);
					break;
				}
			} else {
				Bitmap bitmap = BitmapTools.loadImageBitmap(path, screenWidth,
						screenHeigh);
				if (null != bitmap) {
					Drawable drawable = new BitmapDrawable(bitmap);
					im_immessage.getRootView().setBackgroundDrawable(drawable);
				} else {
					im_immessage.getRootView().setBackgroundResource(
							R.drawable.message_bg3);
					if(conversationBg != null){
						conversationBg.setBgPath("R.drawable.message_bg3");
						ConversationBgDbManager.getInstance().insert(conversationBg);
					}
				}
			}
		} else {
			im_immessage.getRootView().setBackgroundResource(
					R.drawable.message_bg3);
			if(conversationBg == null){
				conversationBg = new ConversationBg();
				conversationBg.setTargetId(conversationinfo.getTargetId());
				conversationBg.setAccount(UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount());
			}
			conversationBg.setBgPath("R.drawable.message_bg3");
			ConversationBgDbManager.getInstance().insert(conversationBg);
		}
	}
	
	private void goBack() {
		imManager.stopPlayerVoice();
		conversationinfo.clearMessagesUnreadStatus();
		if (softModthIsHidden) {
			mHandler.sendEmptyMessage(12);
		} else {
			operate_num = YZX_ACTIVITY_FINISH;
			closeKeyPad();
		}
	}
	@SuppressLint("WrongConstant")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if ((resultCode == Activity.RESULT_OK && requestCode == SELECT_PIC)
				|| (resultCode == Activity.RESULT_OK && requestCode == SELECT_PIC_KITKAT)) {
			Uri uri = data.getData();
			ContentResolver cr = this.getContentResolver();
			Cursor cursor = cr.query(uri, null, null, null, null);// 根据Uri从数据库中找
			int angle = 0;
			if (cursor != null && requestCode == SELECT_PIC) {
				cursor.moveToFirst();
				if (cursor.getColumnIndex("orientation") != -1) {
					String orientation = cursor.getString(cursor
							.getColumnIndex("orientation"));// 获取旋转的角度
					if (orientation != null)
						angle = Integer.valueOf(orientation);
					Log.i(TAG, "图片旋转角度：" + angle);
				}

			}
			CustomLog.e("RESULT_PATH:" + uri.toString());
			String path = "";
			if (requestCode == SELECT_PIC) {
				path = getFilePathFromUri(uri);
			} else {
				path = ContentResolverUtils.getPath(this, uri);
			}
			CustomLog.e("android version is older then 4.4 : "
					+ (requestCode == SELECT_PIC)
					+ "，select image imagePath = " + path);
			try {
				path = BitmapTools.getNewPath(path, angle, screenWidth,
						screenHeigh, conversationinfo.getTargetId());
				if(TextUtils.isEmpty(path)){
					Toast.makeText(this, "您选择的图片异常，请重新选择!", 0).show();
					return;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			CustomLog.e("RESULT_PATH:" + path);
			File file = new File(path);
			CustomLog.e("RESULT_PATH_EXISTS:" + file.exists());
			if (file.exists()) {
				ChatMessage msg = null;
				switch (conversationinfo.getCategoryId()) {
				case PERSONAL:
					msg = new SingleChat();
					break;
				case GROUP:
					msg = new GroupChat();
					break;
				case DISCUSSION:
					msg = new DiscussionChat();
					break;
				}
				if (null != msg) {
					msg.setTargetId(conversationinfo.getTargetId());
					msg.setMsgType(MSGTYPE.MSG_DATA_IMAGE);
					msg.setContent(path);
					msg.setSenderId(sendId);
					msg.setNickName(loginUser);
					msg.setPath(path);
					CustomLog.d("getCategoryId:"
							+ conversationinfo.getCategoryId());
					CustomLog.e("发送图片消息：" + path);
					if (imManager.sendmessage(msg)) {
						Message message = new Message();
						message.obj = msg;
						message.what = 6;
						mHandler.sendMessage(message);
					}
				}
			} else {
				Toast.makeText(IMMessageActivity.this,
						"文件路径异常或发送文件不存在或者文件不能为中文", Toast.LENGTH_SHORT).show();
			}
			//隐藏更多操作栏
			hideOperate();
		}
		if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
			Log.d(TAG, "拍照返回");
			try {
				 //防止获取到的图片始终是横屏
				//Uri uri = data.getData();
				if(TextUtils.isEmpty(shot_path)){
					CustomLog.e("------拍摄异常-------");
					return;
				}
				int degree = BitmapTools.readImageDegree(shot_path);
				Log.i(TAG, "read image path degree = "+degree);
				shot_path = BitmapTools.getNewPath(shot_path, degree,
						screenWidth, screenWidth,
						conversationinfo.getTargetId());
			} catch (IOException e) {
				e.printStackTrace();
			}
			CustomLog.e("RESULT_PATH:" + shot_path);
			File file = new File(shot_path);
			CustomLog.e("RESULT_PATH_EXISTS:" + file.exists());
			if (file.exists()) {
				ChatMessage msg = null;
				switch (conversationinfo.getCategoryId()) {
				case PERSONAL:
					msg = new SingleChat();
					break;
				case GROUP:
					msg = new GroupChat();
					break;
				case DISCUSSION:
					msg = new DiscussionChat();
					break;
				}
				if (null != msg) {
					msg.setTargetId(conversationinfo.getTargetId());
					msg.setMsgType(MSGTYPE.MSG_DATA_IMAGE);
					msg.setContent(shot_path);
					msg.setPath(shot_path);
					msg.setSenderId(sendId);
					msg.setNickName(loginUser);
					CustomLog.d("getCategoryId:"
							+ conversationinfo.getCategoryId());
					if(UCSManager.isConnect() && imManager.sendmessage(msg)){
						Message message = mHandler.obtainMessage();
						message.obj = msg;
						message.what = 6;
						mHandler.sendMessage(message);
					}else{
						if(!UCSManager.isConnect()){
							CustomLog.e("---------拍照后，页面被回收，延迟发送------");
							Message message = mHandler.obtainMessage();
							message.obj = msg;
							message.what = 18;
							mHandler.sendMessageDelayed(message, 800);
						}
					}
				}
			}
			//隐藏更多操作栏
			hideOperate();
			//发送完成。将图片路径设为""
			shot_path = "";
		} else if (resultCode == Activity.RESULT_OK && requestCode == 2) {
			String path = "";
			if(data != null && data.hasExtra("background")){
				path = data.getStringExtra("background");
			}
			Log.i(TAG, "data == null ?"+(data == null));
			Log.i(TAG, "getBackground:" + path);
			if (!"".equals(path)) {
				if (path.contains("R.drawable")) {
					switch (Integer.valueOf(path.substring(path
							.length() - 1))) {
					case 1:
						im_immessage.getRootView().setBackgroundResource(
								R.drawable.message_bg1);
						break;
					case 2:
						im_immessage.getRootView().setBackgroundResource(
								R.drawable.message_bg2);
						break;
					case 3:
						im_immessage.getRootView().setBackgroundResource(
								R.drawable.message_bg3);
						break;
					default:
						break;
					}
				} else {
					Bitmap bitmap = BitmapFactory.decodeFile(path);
					if (null != bitmap) {
						Drawable drawable = new BitmapDrawable(bitmap);
						im_immessage.getRootView().setBackgroundDrawable(
								drawable);
					} else {
						//拍摄或者选择图片出错
						Log.i(TAG, "BitmapFactory.decodeFile == null,选择原来的图片");
						initBkgs();
						return;
					}
				}
				insertBkg(path);
			}
		} else if (resultCode == Activity.RESULT_FIRST_USER && requestCode == 2) {
			finish();
		} else if(resultCode == Activity.RESULT_OK && requestCode == SEND_LOCATION){
			Log.i(TAG, "发送百度坐标:latitude = "+data.getDoubleExtra("latitude", 0)+"，longitude = "+data.getDoubleExtra("longitude", 0));
			LatLng latLng = CoordTools.bd_decrypt(data.getDoubleExtra("latitude", 0), data.getDoubleExtra("longitude", 0));
			Log.i(TAG, "发送火星坐标:latitude = "+latLng.latitude+"，longitude = "+latLng.longitude+",path = "+data.getStringExtra("path"));
			LocationMapMsg locationMsg = new LocationMapMsg(latLng.latitude, latLng.longitude, data.getStringExtra("address"), data.getStringExtra("path"));
			
            ChatMessage msg = null;
            switch (conversationinfo.getCategoryId()) {
			case PERSONAL:
				msg = new SingleChat();
				break;
			case GROUP:
				msg = new GroupChat();
				break;
			case DISCUSSION:
				msg = new DiscussionChat();
				break;
			}
			if (null != msg) {
				msg.setTargetId(conversationinfo.getTargetId())
				.setNickName(loginUser)
				.setSenderId(sendId)
				.setMsgType(MSGTYPE.MSG_DATA_LOCALMAP)
				.setLocationMapMsg(locationMsg)
				.setContent(locationMsg.getThumbnailPath())
				.setFromMyself(false);
				Log.i(TAG, "发送位置消息 : "+locationMsg.getDetailAddr());
				Message message = new Message();
				message.obj = msg;
				message.what = 6;
				mHandler.sendMessage(message);
				imManager.sendmessage(msg);
			}
		} else if(requestCode == 2 && resultCode == 3){
			currentMsgList.clear();
			adapter.notifyDataSetChanged();
		} else if(requestCode == SEND_CUSTOM_MSG && resultCode ==  Activity.RESULT_OK){
			String sendMsg = data.getStringExtra("send_msg");
			CustomMsg customMsg = null;
			try {
				sendMsg = convertToMsg(sendMsg, this);
				sendMsg = Base64.encodeToString(sendMsg.getBytes("UTF-8"), Base64.DEFAULT);
				Log.i(TAG, "custom msg text = "+sendMsg);
				customMsg = new CustomMsg(sendMsg.getBytes("UTF-8"), sendMsg.getBytes("UTF-8").length);
			} catch (Exception e) {
				//no reach
			}
			
			ChatMessage msg = null;
            switch (conversationinfo.getCategoryId()) {
			case PERSONAL:
				msg = new SingleChat();
				break;
			case GROUP:
				msg = new GroupChat();
				break;
			case DISCUSSION:
				msg = new DiscussionChat();
				break;
			}
			if (null != msg && customMsg != null) {
				try {
					msg.setTargetId(conversationinfo.getTargetId())
					.setNickName(loginUser)
					.setSenderId(sendId)
					.setMsgType(MSGTYPE.MSG_DATA_CUSTOMMSG)
					.setCustomMsg(customMsg)
					.setContent(sendMsg)
					.setFromMyself(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Log.i(TAG, "发送自定义消息 : "+sendMsg);
				Message message = new Message();
				message.obj = msg;
				message.what = 6;
				mHandler.sendMessage(message);
				imManager.sendmessage(msg);
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void insertBkg(String path) {
		//保存背景记录到数据库
		ConversationBg bg = new ConversationBg();
		bg.setAccount(UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount());
		bg.setTargetId(conversationinfo.getTargetId());
		bg.setBgPath(path);
		ConversationBgDbManager.getInstance().insert(bg);
	}

	private void startRecordTimer() {
		stopTimer();
		if (timer == null) {
			timer = new Timer();
		}
		num = 0;
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				mUIHandler.obtainMessage(num).sendToTarget();
				num++;
			}
		}, 0, 1000);
	}

	private void stopTimer() {
		if (timer != null) {
			timer.cancel();
			timer = null;
		}
	}

	// 4.4以下手机选择图片返回码
	private static final int SELECT_PIC = 106;
	// 4.4以上手机选择图片返回码
	private static final int SELECT_PIC_KITKAT = 108;
	//发送位置请求码
	private static final int SEND_LOCATION = 202;
	//发送自定义消息请求码
	private static final int SEND_CUSTOM_MSG = 303;

	private void openImage(int code) {
		switch (code) {
		case 1:
			// Intent intent = new Intent(
			// Intent.ACTION_PICK,
			// android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.addCategory(Intent.CATEGORY_OPENABLE);
			intent.setType("image/jpeg");
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
				startActivityForResult(intent, SELECT_PIC_KITKAT);
			} else {
				startActivityForResult(intent, SELECT_PIC);
			}
			hideOperate();
			break;
		case 2:
			shot_path = "/sdcard/yunzhixun/image/yzx_image_"
					+ System.currentTimeMillis() + ".jpg";
			File file = new File(shot_path);
			Intent intent2 = new Intent();
			intent2.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
			intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
			startActivityForResult(intent2, 101);
			hideOperate();
			break;
		}
	}

	/**
	 * 根据Uri 获取文件实际路径
	 * 
	 * @param fileUrl
	 * @return
	 */
	public String getFilePathFromUri(Uri fileUrl) {
		CustomLog.e("IMMessageActivity select image uri : " + fileUrl);
		String fileName = "";
		if (fileUrl != null) {
			if (fileUrl.getScheme().toString().compareTo("content") == 0) {
				Cursor cursor = getContentResolver().query(fileUrl, null, null,
						null, null);
				if (cursor != null && cursor.moveToFirst()) {
					if (cursor.getColumnIndex(MediaStore.Images.Media.DATA) > -1) {
						int column_index = cursor
								.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
						fileName = cursor.getString(column_index);
						if (!fileName.startsWith("/data")
								&& !fileName.startsWith("/storage")
								&& !fileName.startsWith("/mnt")) {
							fileName = "/mnt" + fileName;
						}
					}
					cursor.close();
				}
			} else if (fileUrl.getScheme().compareTo("file") == 0) {
				fileName = fileUrl.toString();
				fileName = fileUrl.toString().replace("file://", "");
				if (!fileName.startsWith("/storage")) {
					int index = fileName.indexOf("/sdcard");
					fileName = index == -1 ? fileName : fileName
							.substring(index);
					if (!fileName.startsWith("/mnt")) {
						fileName = "/mnt" + fileName;
					}
				}
			}
		}
		return fileName;
	}

	class MessageAdapter extends BaseAdapter {

		private WeakReference<IMMessageActivity> weak;
		private final static int LEFTVIEW = 1;
		private final static int RIGHTVIEW = 0;

		public void addDbMessageAdapter(Context context,
				ConversationInfo conversationinfo) {
			weak = new WeakReference<IMMessageActivity>(
					(IMMessageActivity) context);
			if (null != conversationinfo) {
				if (null != conversationinfo.getConversationTitle()) {
					currentMsgList = conversationinfo.getLastestMessages(0, 20);
					conversationinfo.clearMessagesUnreadStatus();
					initMsgTimeList();
				}
			}
			super.notifyDataSetChanged();
		}

		public void notifyDataSetChanged() {
			initMsgTimeList();
			//关闭复制删除pop
			if(pop!= null && pop.isShowing()){
				pop.dismiss();
			}
			super.notifyDataSetChanged();
		}

		private void initMsgTimeList() {
			msgTimeList.clear();
			msgTimeMap.clear();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String nowtime = format.format(new Date());
			int oldtime = 0;
			synchronized (currentMsgList) {
				int size = currentMsgList.size();
				for (int i = 0; i < size; i++) {
					Date d1 = new Date(currentMsgList.get(i).getSendTime());
					String time = format.format(d1);
					msgTimeList.add(time);
					if (i > 0
							&& msgTimeList.get(i - 1).substring(0, 10)
									.equals(time.substring(0, 10))) {
						//同一天
						int newtime = Integer.valueOf(time.substring(11, 13))
								* 60 + Integer.valueOf(time.substring(14, 16));
						//大于四分钟的才显示时间
						if ((newtime - oldtime) > 4) {
							oldtime = newtime;
							if (time.subSequence(0, 4).equals(nowtime.substring(0, 4))) {
								if (time.subSequence(0, 10).equals(nowtime.subSequence(0, 10))) {
									msgTimeMap.put(i, time.substring(11));
								} else {
									msgTimeMap.put(i, time.substring(5));
								}
							} else {
								msgTimeMap.put(i, time);
							}
						}
					} else {
						//不同天
						oldtime = Integer.valueOf(time.substring(11, 13)) * 60
								+ Integer.valueOf(time.substring(14, 16));
						if (time.subSequence(0, 4).equals(
								nowtime.substring(0, 4))) {
							if (time.subSequence(0, 10).equals(
									nowtime.subSequence(0, 10))) {
								msgTimeMap.put(i, time.substring(11));
							} else {
								msgTimeMap.put(i, time.substring(5));
							}
						} else {
							//不同年
							CustomLog.d("不同年："+time);
							msgTimeMap.put(i, time);
						}
					}
				}
			}
		}

		@Override
		public int getCount() {
			return currentMsgList.size();
		}

		@Override
		public Object getItem(int position) {
			return currentMsgList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public int getViewTypeCount() {
			return 2;
		}

		@Override
		public int getItemViewType(int position) {
			ChatMessage message = currentMsgList.get(position);
			if (message.getIsFromMyself()) {
				return RIGHTVIEW;
			} else {
				return LEFTVIEW;
			}
		}

		@Override
		public View getView(final int position, View view, ViewGroup parent) {
			final ChatMessage message = currentMsgList.get(position);
			HolderView hv = null;
			HolderViewDirection hvDirection;
			if (position == 0) {
				messagelist.onIsRefresh(true);
			} else {
				messagelist.onIsRefresh(false);
			}
			final int type = getItemViewType(position);
			if (view == null) {
				hvDirection = new HolderViewDirection();
				if (type == RIGHTVIEW) {
					view = LayoutInflater.from(IMMessageActivity.this).inflate(
							R.layout.listitem_message_right, null);
					hv = setHolderView(hvDirection.rightHolderView, view);
				} else {
					view = LayoutInflater.from(IMMessageActivity.this).inflate(
							R.layout.listitem_message_left, null);
					hv = setHolderView(hvDirection.leftHolderView, view);
				}
				view.setTag(hv);
			} else {
				hv = (HolderView) view.getTag();
			}
			if (type == LEFTVIEW) {
				hv.msgSystem.setVisibility(View.GONE);
			}
			hv.msghead.setVisibility(View.VISIBLE);
			hv.msghead.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					//点击查看用户详情
					String username = ((TextView)((RelativeLayout)v.getParent()).getChildAt(1)).getText().toString();
					Intent intent = new Intent(IMMessageActivity.this, UserInfoActivity.class);
					intent.putExtra("userName", username);
					intent.putExtra("userPhone", message.getSenderId());
					IMMessageActivity.this.startActivity(intent);
				}
			});
			hv.msgname.setVisibility(View.VISIBLE);
			hv.msgvoicetext.setVisibility(View.GONE);
			hv.msgvoiceimage.setVisibility(View.GONE);
			hv.msgrepeat.setVisibility(View.GONE);
			hv.msgimage.setVisibility(View.GONE);
			hv.msgtext.setVisibility(View.GONE);
			hv.msgvoiceunread.setVisibility(View.GONE);
			hv.msgpb.setVisibility(View.GONE);
			hv.customText.setVisibility(View.GONE);
			// 匹配为先是通讯录，再试昵称，再是sendId
			//匹配通讯录
			String name = ContactTools.getConTitle(message.getSenderId());
			if(!TextUtils.isEmpty(name)){
				hv.msgname.setText(name);
			}
			//匹配昵称
			if(TextUtils.isEmpty(name) && !TextUtils.isEmpty(message.getNickName())){
				name = message.getNickName();
				hv.msgname.setText(name);
			}
			//匹配sendId
			if(TextUtils.isEmpty(name) && !TextUtils.isEmpty(message.getSenderId())){
				name = message.getSenderId();
				hv.msgname.setText(name);
			}
			if ("".equals(hv.msgname.getText().toString())) {
				hv.msgname.setText("系统消息");
			}

			if (message.getIsFromMyself()) {
				hv.msghead.setBackgroundResource(R.drawable.person);
				hv.msgname.setText(loginUser);
				switch (message.getSendStatus()) {
				// 网络错误，尝试继续发送
				case ChatMessage.MSG_STATUS_INPROCESS:
				case ChatMessage.MSG_STATUS_RETRY:
					// 发送中
					hv.msgpb.setVisibility(View.VISIBLE);
					hv.msgrepeat.setVisibility(View.GONE);
					break;
				case ChatMessage.MSG_STATUS_SUCCESS:
					hv.msgpb.setVisibility(View.GONE);
					hv.msgrepeat.setVisibility(View.GONE);
					// 发送成功
					break;
				case ChatMessage.MSG_STATUS_FAIL:
				case ChatMessage.MSG_STATUS_NETERROR:
				case ChatMessage.MSG_STATUS_TIMEOUT:
					CustomLog.d("MSG_STATUS_FAIL");
					hv.msgpb.setVisibility(View.GONE);
					hv.msgrepeat.setVisibility(View.VISIBLE);
					// 发送失败
					break;
				}
			} else {
				// 接收
				CustomLog.d("getIsFromMyself +" + message.getContent() + "  "
						+ message.getIsFromMyself());
				hv.msghead.setBackgroundResource(R.drawable.person);
				List<SortModel> sourceDateList = new ArrayList<SortModel>();
				sourceDateList.addAll(ContactTools.getSourceDateList());
			}

			// 单聊设置名称不可见
			if (conversationinfo.getCategoryId() == CategoryId.PERSONAL) {
				hv.msgname.setVisibility(View.GONE);
			}

			if(sdf == null){
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			}
			String msgTime = "";
			if(position == 0){
				//第一条消息
				msgTime = DateTools.getMsgDate(sdf.format(new Date(message.getSendTime())), "");
			}else{
				msgTime = DateTools.getMsgDate(sdf.format(new Date(message.getSendTime())), 
						sdf.format(new Date(currentMsgList.get(position - 1).getSendTime())));
			}
			
			if(TextUtils.isEmpty(msgTime)){
				hv.msgtime.setVisibility(View.GONE);
			}else{
				hv.msgtime.setVisibility(View.VISIBLE);
				hv.msgtime.setText(msgTime);
			}

			switch (message.getMsgType()) {
			// 文本
			case MSG_DATA_TEXT:
				hv.msghead.setVisibility(View.VISIBLE);
				hv.msgtext.setVisibility(View.VISIBLE);
				hv.msgtext.setText(message.getContent());
				hv.msgtext.setOnLongClickListener(new View.OnLongClickListener() {
							@Override
							public boolean onLongClick(View view) {
								pop = new MessagePop(IMMessageActivity.this, IMMessageActivity.this, conversationinfo, message, 2);
								pop.setText(((TextView)view).getText().toString());
								int[] location = new int[2];
								view.getLocationOnScreen(location);
								pop.showAtLocation(view, Gravity.NO_GRAVITY, location[0] + view.getWidth() / 2 - pop.getWidth() / 2, location[1]-pop.getHeight());
								return false;
							}
						});
				hv.msgtext.setOnClickListener(null);
				break;
			// 图片
			case MSG_DATA_IMAGE:
				hv.msghead.setVisibility(View.VISIBLE);
				hv.msgimage.setVisibility(View.VISIBLE);
				hv.msgimage.setLocation(false);
				BitmapTools.loadChatImageBitmap(weak.get(),
						message.getContent(), hv.msgimage, screenWidth,
						screenHeigh, message.getIsFromMyself());
				hv.msgimage.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent(IMMessageActivity.this,
								IMImageActivity.class);
						intent.putExtra("imagepath", message.getContent());
						intent.putExtra("msgParentID", message.getParentID());
						if (message.getIsFromMyself()) {
							intent.putExtra("imagedownpath", "");
						} else {
							intent.putExtra("imagedownpath", message.getPath());
						}
						intent.putExtra("msgid", message.getMsgid());
						startActivity(intent);
					}
				});
				hv.msgimage
						.setOnLongClickListener(new View.OnLongClickListener() {
							@Override
							public boolean onLongClick(View view) {
								pop = new MessagePop(IMMessageActivity.this, IMMessageActivity.this, conversationinfo, message, 1);
								int[] location = new int[2];
								view.getLocationOnScreen(location);
								pop.showAtLocation(view, Gravity.NO_GRAVITY, location[0] + view.getWidth() / 2 - pop.getWidth() / 2, location[1]-pop.getHeight());
								return false;
							}
						});
				break;
			// 语音
			case MSG_DATA_VOICE:
				hv.msghead.setVisibility(View.VISIBLE);
				hv.msgtext.setVisibility(View.VISIBLE);
				if(message.getSendStatus() == ChatMessage.MSG_STATUS_INPROCESS){
					hv.msgvoicetext.setVisibility(View.GONE);
				}
				hv.msgvoicetext.setVisibility(View.VISIBLE);
				hv.msgvoiceimage.setVisibility(View.VISIBLE);
				hv.msgvoicetext.setText(message.getContent() + "\"");
				if (!message.getIsFromMyself()) {
					if(message.getSendStatus() == ChatMessage.MSG_STATUS_INPROCESS){
						//语音正在接收
						hv.msgvoiceunread.setVisibility(View.GONE);
						hv.msgvoicetext.setVisibility(View.GONE);
						hv.msgrepeat.setVisibility(View.GONE);
						hv.msgpb.setVisibility(View.VISIBLE);
					}else if(message.getSendStatus() == ChatMessage.MSG_STATUS_SUCCESS){
						//语音接受成功
						if (message.getReadStatus() == ChatMessage.MSG_STATUS_UNREAD) {
							hv.msgvoiceunread.setVisibility(View.VISIBLE);
						} else {
							hv.msgvoiceunread.setVisibility(View.GONE);
						}
						hv.msgvoicetext.setVisibility(View.VISIBLE);
						hv.msgrepeat.setVisibility(View.GONE);
						hv.msgpb.setVisibility(View.GONE);
					}else if(message.getSendStatus() == ChatMessage.MSG_STATUS_TIMEOUT || message.getSendStatus() == ChatMessage.MSG_STATUS_FAIL
					|| message.getSendStatus() == ChatMessage.MSG_STATUS_NETERROR){
						hv.msgvoiceunread.setVisibility(View.GONE);
						hv.msgrepeat.setVisibility(View.VISIBLE);
						hv.msgrepeat.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								Log.i(TAG, "重新下载语音");
								message.setSendStatusTodb(ChatMessage.MSG_STATUS_INPROCESS);
								//显示下载
								if(imManager.downloadVoice(message)){
									v.setVisibility(View.GONE);
									((RelativeLayout)v.getParent()).getChildAt(3).setVisibility(View.VISIBLE);
								}else{
									message.setSendStatusTodb(ChatMessage.MSG_STATUS_FAIL);
									Toast.makeText(IMMessageActivity.this, "下载语音失败", Toast.LENGTH_SHORT).show();
								}
							}
						});
						hv.msgpb.setVisibility(View.GONE);
					}
				}
				int msgvoicetime = Integer.valueOf(message.getContent());
				if (msgvoicetime > 30) {
					String str = "                              ";
					for (int i = 30; i < msgvoicetime; i = i + 2) {
						str = str + " ";
					}
					hv.msgtext.setText(str);
				} else {
					String str = "";
					for (int i = 0; i < msgvoicetime; i++) {
						str = str + " ";
					}
					hv.msgtext.setText(str);
				}
				final String path = message.getPath();
				Log.i(TAG, "语音path = "+path);
				final AnimationDrawable anima = (AnimationDrawable) hv.msgvoiceimage
						.getBackground();

				if (voiceStatus.getPos() >= 0
						&& voiceStatus.getPos() == position
						&& voiceStatus.isStatus()) {
					anima.selectDrawable(0);
					anima.start();
					animation = anima;
				} else {
					anima.stop();
				}
				final ImageView msgvoiceunread = hv.msgvoiceunread;
				if(!message.getIsFromMyself() && (message.getSendStatus() == ChatMessage.MSG_STATUS_INPROCESS 
						|| message.getSendStatus() == ChatMessage.MSG_STATUS_FAIL)){
					hv.msgtext.setOnClickListener(null);
				}else{
					hv.msgtext.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							if(message.getSendStatus() == ChatMessage.MSG_STATUS_FAIL ||
									message.getSendStatus() == ChatMessage.MSG_STATUS_INPROCESS 
									|| message.getSendStatus() == ChatMessage.MSG_STATUS_TIMEOUT ){
								Toast.makeText(IMMessageActivity.this, "语音下载失败，请点击下载!", Toast.LENGTH_SHORT).show();
								return;
							}
							message.setVoiceReadStatus(ChatMessage.MSG_STATUS_READED);
							if (!message.getIsFromMyself()) {
								msgvoiceunread.setVisibility(View.GONE);
							}

							if (voiceStatus.getPos() >= 0
									&& voiceStatus.getPos() == position
									&& voiceStatus.isStatus()) {
								messagelist
										.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);
								imManager.stopPlayerVoice();
								animation.selectDrawable(0);
								animation.stop();

								voiceStatus.put(voiceStatus.getPos(), false);
							} else {

								if (voiceStatus.getPos() > 0) {
									imManager.stopPlayerVoice();
									if (animation != null) {
										animation.selectDrawable(0);
										animation.stop();
									}
								}
								animation = anima;
								imManager.startPlayerVoice(path,
										IMMessageActivity.this);
								animation.start();

								voicePath = path;
								voiceStatus.put(position, true);
							}
						}
					});
				}
				hv.msgtext
						.setOnLongClickListener(new View.OnLongClickListener() {

							@Override
							public boolean onLongClick(View view) {
								pop = new MessagePop(IMMessageActivity.this, IMMessageActivity.this, conversationinfo, message, 1);
								int[] location = new int[2];
								view.getLocationOnScreen(location);
								pop.showAtLocation(view, Gravity.NO_GRAVITY, location[0] + view.getWidth() / 2 - pop.getWidth() / 2, location[1] - pop.getHeight());
								return false;
							}
						});
				break;
			// 位置消息
			case MSG_DATA_LOCALMAP:
				hv.msghead.setVisibility(View.VISIBLE);
				hv.msgimage.setVisibility(View.VISIBLE);
				hv.msgimage.setLocation(true);
				hv.msgimage.setLocationText(message.getLocationMapMsg().getDetailAddr());
				BitmapTools.loadChatLocationBitmap(IMMessageActivity.this, message.getLocationMapMsg().getThumbnailPath(), hv.msgimage, screenWidth, screenHeigh);
				
				hv.msgimage.setOnLongClickListener(new View.OnLongClickListener() {
					@Override
					public boolean onLongClick(View view) {
						pop = new MessagePop(IMMessageActivity.this, IMMessageActivity.this, conversationinfo, message, 1);
						int[] location = new int[2];
						view.getLocationOnScreen(location);
						pop.showAtLocation(view, Gravity.NO_GRAVITY, location[0] + view.getWidth() / 2 - pop.getWidth() / 2, location[1]-pop.getHeight());
						return false;
					}
				});
				
				hv.msgimage.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if(softModthIsHidden){
							hideOperate();
							Intent intent = new Intent(IMMessageActivity.this, IMBaiduMapActivity.class);
							intent.putExtra("latitude", message.getLocationMapMsg().getLatitude());
							intent.putExtra("longitude", message.getLocationMapMsg().getLongitude());
							intent.putExtra("address", message.getLocationMapMsg().getDetailAddr());
							startActivity(intent);
						}else{
							operate_num = YZX_START_LOCATION;
							locationMsg = message;
							//隐藏软键盘和更多
							InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
							inputmanger.hideSoftInputFromWindow(im_send_text.getWindowToken(),
									0);
						}
					}
				});
				break;
			// 系统消息
			case MSG_DATA_SYSTEM:
				hv.msghead.setVisibility(View.GONE);
				hv.msgname.setVisibility(View.GONE);
				hv.msgtext.setVisibility(View.GONE);
				hv.msgSystem.setVisibility(View.VISIBLE);
				hv.msgSystem.setText(message.getContent());
				break;
				//自定义消息
			case MSG_DATA_CUSTOMMSG:
				hv.customText.setVisibility(View.VISIBLE);
				hv.customText.setText(new String(Base64.decode(message.getCustomMsg().getContent(), Base64.DEFAULT)));
				hv.customText.setOnLongClickListener(new View.OnLongClickListener() {
					@Override
					public boolean onLongClick(View view) {
						pop = new MessagePop(IMMessageActivity.this, IMMessageActivity.this, conversationinfo, message, 2);
						pop.setText(((TextView)view).getText().toString());
						int[] location = new int[2];
						view.getLocationOnScreen(location);
						pop.showAtLocation(view, Gravity.NO_GRAVITY, location[0] + view.getWidth() / 2 - pop.getWidth() / 2, location[1]-pop.getHeight());
						return false;
					}
				});
				hv.msgtext.setOnClickListener(null);
				break;
			}
			if(message.getIsFromMyself()){
				hv.msgrepeat.setTag(message);
				hv.msgrepeat.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//用户可以选择两种重发效果。
						//1，重发的消息显示在最下面。那么得先删除之前发送失败的消息，再当做新消息来发送
						//2，重发的消息显示在原来位置，那么直接设置setSendStatus(ChatMessage.MSG_STATUS_RETRY);，
						//下面只演示第一种实现方式
						ChatMessage message = (ChatMessage) view.getTag();
						message.deleteMessage();
						message.setSendStatus(ChatMessage.MSG_STATUS_INPROCESS);
						Boolean sendstatus = false;
						switch (message.getCategoryId()) {
						case PERSONAL:
							sendstatus = imManager
									.sendmessage((SingleChat) message);
							break;
						case GROUP:
							sendstatus = imManager.sendmessage((GroupChat) message);
							break;
						case DISCUSSION:
							sendstatus = imManager
									.sendmessage((DiscussionChat) message);
							break;
						}
						//如果该条消息是语音消息并且是当前正在播放的语音，停止动画
						if(message.getMsgType() == MSGTYPE.MSG_DATA_VOICE
								&& voiceStatus != null && voiceStatus.getPos() == position){
							imManager.stopPlayerVoice();
							voiceStatus.clear();
						}
						if (sendstatus) {
							synchronized (currentMsgList) {
								currentMsgList.remove(message);
								currentMsgList.add(message);
								notifyDataSetChanged();
							}
						}
					}
				});
			}else{
//				hv.msgrepeat.setOnClickListener(null);
			}
			return view;
		}

		class HolderView {
			public TextView msgSystem;
			public TextView msgtime;
			public RelativeLayout msgitem;
			public ImageView msghead;
			public TextView msgtext;
			public TextView customText;
			public IMChatImageView msgimage;
			public TextView msgvoicetext;
			public ImageView msgvoiceimage;
			public ImageView msgvoiceunread;
			public TextView msgname;
			public ProgressBar msgpb;
			public ImageView msgrepeat;
		}

		class HolderViewDirection {
			public HolderView leftHolderView;
			public HolderView rightHolderView;
		}

		private HolderView setHolderView(HolderView hv, View view) {
			hv = new HolderView();
			hv.msgSystem = (TextView) view
					.findViewById(R.id.message_list_system_msg);
			hv.customText = (TextView) view.findViewById(R.id.message_custom_tv);
			hv.msgtime = (TextView) view.findViewById(R.id.message_list_time);
			hv.msgitem = (RelativeLayout) view.findViewById(R.id.message_list);
			hv.msghead = (ImageView) view.findViewById(R.id.message_list_head);
			hv.msgimage = (IMChatImageView) view
					.findViewById(R.id.message_list_iv);
			hv.msgtext = (TextView) view.findViewById(R.id.message_list_tv);
			hv.msgvoicetext = (TextView) view
					.findViewById(R.id.message_voice_time);
			hv.msgname = (TextView) view.findViewById(R.id.message_list_name);
			hv.msgvoiceimage = (ImageView) view
					.findViewById(R.id.message_voice_image);
			hv.msgvoiceunread = (ImageView) view
					.findViewById(R.id.message_voice_unread);
			hv.msgpb = (ProgressBar) view.findViewById(R.id.message_list_pb);
			hv.msgrepeat = (ImageView) view
					.findViewById(R.id.message_list_repeat);
			return hv;
		}
	};

	protected void handleMessage(Message msg) {
		if (msg.what == 60) {
			im_tv_record.setText("按住说话");
			im_iv_record_left.setBackgroundResource(R.drawable.im_record_left0);
			im_iv_record_right
					.setBackgroundResource(R.drawable.im_record_right0);
			im_iv_record.setBackgroundResource(R.drawable.im_record);
			stopTimer();
			return;
		}

		int num = msg.what % 6 + 1;
		if (msg.what > 50) {
			im_tv_record.setText("您还有" + (60 - msg.what) + "秒可以说话");
		} else if (msg.what < 10) {
			im_tv_record.setText("00:0" + msg.what);
		} else {
			im_tv_record.setText("00:" + msg.what);
		}
		if (send_record) {
			im_iv_record.setBackgroundResource(R.drawable.im_record_down);
		} else {
			im_iv_record.setBackgroundResource(R.drawable.im_record_up);
		}
		switch (num) {
		case 1:
			im_iv_record_left.setBackgroundResource(R.drawable.im_record_left0);
			im_iv_record_right
					.setBackgroundResource(R.drawable.im_record_right0);
			break;
		case 2:
			im_iv_record_left.setBackgroundResource(R.drawable.im_record_left1);
			im_iv_record_right
					.setBackgroundResource(R.drawable.im_record_right1);
			break;
		case 3:
			im_iv_record_left.setBackgroundResource(R.drawable.im_record_left2);
			im_iv_record_right
					.setBackgroundResource(R.drawable.im_record_right2);
			break;
		case 4:
			im_iv_record_left.setBackgroundResource(R.drawable.im_record_left3);
			im_iv_record_right
					.setBackgroundResource(R.drawable.im_record_right3);
			break;
		case 5:
			im_iv_record_left.setBackgroundResource(R.drawable.im_record_left4);
			im_iv_record_right
					.setBackgroundResource(R.drawable.im_record_right4);
			break;
		case 6:
			im_iv_record_left.setBackgroundResource(R.drawable.im_record_left5);
			im_iv_record_right
					.setBackgroundResource(R.drawable.im_record_right5);
			break;
		}
	}

	private void closeKeyPad() {
		View view = getWindow().peekDecorView();
		if (view != null && !softModthIsHidden) {
			InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
		} else {
			hideOperate();
			im_key.setVisibility(View.GONE);
			im_audio.setVisibility(View.VISIBLE);
		}
	}

	public static String convertToMsg(CharSequence cs, Context mContext) {
		SpannableStringBuilder ssb = new SpannableStringBuilder(cs);
		EmojiconSpan[] spans = ssb.getSpans(0, cs.length(), EmojiconSpan.class);
		for (int i = 0; i < spans.length; i++) {
			EmojiconSpan span = spans[i];
			String c = EmojiconHandler.getEmojiCode(span.getmResourceId());
			int a = ssb.getSpanStart(span);
			int b = ssb.getSpanEnd(span);
			ssb.replace(a, b, c);
		}
		ssb.clearSpans();
		return ssb.toString();
	}

	private static String convertUnicode(String emo) {
		emo = emo.substring(emo.indexOf("_") + 1);
		if (emo.length() < 6) {
			return new String(Character.toChars(Integer.parseInt(emo, 16)));
		}
		String[] emos = emo.split("_");
		char[] char0 = Character.toChars(Integer.parseInt(emos[0], 16));
		char[] char1 = Character.toChars(Integer.parseInt(emos[1], 16));
		char[] emoji = new char[char0.length + char1.length];
		for (int i = 0; i < char0.length; i++) {
			emoji[i] = char0[i];
		}
		for (int i = char0.length; i < emoji.length; i++) {
			emoji[i] = char1[i - char0.length];
		}
		return new String(emoji);
	}

	@Override
	protected void onResume() {
		NotificationTools.clearUnreadNum();
		tv_title.setText(conversationinfo.getConversationTitle());
		if (conversationinfo.getCategoryId() == CategoryId.DISCUSSION) {
			DiscussionInfo info = imManager.getDiscussionInfo(conversationinfo
					.getTargetId());
			if (null != info) {
				tv_title.setText(imManager.getDiscussionInfo(
						conversationinfo.getTargetId()).getDiscussionName());
			}
		}

		// reStartVoice();
		super.onResume();
	}

	@Override
	protected void onPause() {
		DraftMsg t = new DraftMsg(UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount(), conversationinfo.getTargetId(), im_send_text.getText().toString().trim());
		DraftDbManager.getInstance().insert(t);
		// stopVoice();
		// 暂停
		if (voiceStatus != null && voiceStatus.getPos() >= 0) {
			imManager.stopPlayerVoice();
			messagelist.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);
			voiceStatus.clear();
			animation = null;
			mHandler.sendEmptyMessage(7);
		}
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, "IMMessageActivity onDestroy()");
		unregisterReceiver(br);
		voiceStatus.clear();
		imManager.removeSendMsgListener(this);
		super.onDestroy();
	}

	// 停止声音
	private void stopVoice() {
		if (voiceStatus.getPos() >= 0 && voiceStatus.isStatus()) {
			imManager.stopPlayerVoice();
			animation.selectDrawable(0);
			animation.stop();

			voiceStatus.put(voiceStatus.getPos(), false);
		}
	}

	private void reStartVoice() {
		if (voiceStatus.getPos() >= 0 && !voiceStatus.isStatus()) {
			imManager.startPlayerVoice(voicePath, IMMessageActivity.this);
			if (animation != null) {
				animation.start();
			}

			voiceStatus.put(voiceStatus.getPos(), true);
		}
	}

	@Override
	public void onReceiveMessage(List msglist) {
		Log.i(TAG, "onReceiveMessage msg size = "+msglist.size()+",threadid == "+Thread.currentThread().getName());
		
		List<ChatMessage> messages = (List<ChatMessage>) msglist;
		List<ChatMessage> newMsgList = new ArrayList<ChatMessage>();
		int otherConvertMsgCount = 0;
		
		for (int i = messages.size() - 1;i>=0 ; i--) {
			ChatMessage message = messages.get(i);
			if ((message.getParentID()).equals(conversationinfo
					.getTargetId())) {
				//当前会话
				newMsgList.add(0,message);
				CustomLog.d("onReceiveMessage content:"
						+ message.getContent());
				if(newMsgList.size() > 20){
					//当前会话消息超过20条
					CustomLog.e("接受到当前会话消息太多，只添加20条");
					break;
				}
			}else{
				//别的会话
				otherConvertMsgCount ++;
				if(otherConvertMsgCount > 20){
					//其他会话消息超过20条
					CustomLog.e("接受到其他会话消息太多，break 防止Handle 卡死");
					break;
				}
			}
			if (message.getMsgType() == MSGTYPE.MSG_DATA_TEXT) {
				CustomLog.d("收到文字消息:" + message.getContent());
			}
			if (message.getMsgType() == MSGTYPE.MSG_DATA_IMAGE) {
				CustomLog.d("收到图片消息:" + message.getPath());
			}
		}
		Message message = new Message();
		message.obj = newMsgList;
		message.what = 1;

		mHandler.sendMessage(message);
	}

	@Override
	public void onSendMsgRespone(ChatMessage msg) {
		messagelist.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		mHandler.sendEmptyMessage(7);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.i(TAG, "onSaveInstanceState,conversation="+conversationinfo.hashCode());
		outState.putSerializable("conversation", conversationinfo);
		if(!TextUtils.isEmpty(shot_path)){
			outState.putString("shot_path", shot_path);
		}
//		outState.putSerializable("targetId", conversationinfo.getTargetId());
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onFinishedPlayingVoice() {
		Log.i(TAG, "------onFinishedPlayingVoice----------");
		messagelist.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);

		voiceStatus.clear();

		mHandler.sendEmptyMessage(7);
	}

	@Override
	public void onFinishedRecordingVoice(int arg0) {

	}

	@Override
	public void onEmojiconClicked(Emojicon emojicon) {
		EmojiconsFragment.input(im_send_text, emojicon);
	}

	@Override
	public void onEmojiconBackspaceClicked(View v) {
		EmojiconsFragment.backspace(im_send_text);
	}

	@Override
	public void onDownloadAttachedProgress(String msgId, String filePaht,
			int sizeProgrss, int currentProgress) {

	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if (yzx_operate.getVisibility() == View.VISIBLE) {
				hideOperate();
				return false;
			} else {
				conversationinfo.clearMessagesUnreadStatus();
				imManager.stopPlayerVoice();
				Intent intent = new Intent(this, IMChatActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	* @Description 隐藏底部操作栏
	* @date 2015-11-16 下午5:56:17 
	* @author zhuqian  
	* @return void
	 */
	private void hideOperate() {
		yzx_operate.setVisibility(View.GONE);
		im_ll_record.setVisibility(View.GONE);
		im_ll_more.setVisibility(View.GONE);
		im_ll_images.setVisibility(View.GONE);
	}
	@Override
	public void msgHandle(ChatMessage msg) {
		if (voiceStatus != null && voiceStatus.isStatus()) {
			for (int i = 0; i < currentMsgList.size(); i++) {
				if (currentMsgList.get(i).equals(msg)
						&& i <= voiceStatus.getPos()) {
					if (i == voiceStatus.getPos()) {
						imManager.stopPlayerVoice();
						voiceStatus.clear();
					} else {
						voiceStatus.put(voiceStatus.getPos() - 1,
								voiceStatus.isStatus());
					}
				}
			}
		}
		synchronized (currentMsgList) {
			currentMsgList.remove(msg);
			messagelist.setTranscriptMode(ListView.TRANSCRIPT_MODE_DISABLED);
			adapter.notifyDataSetChanged();
		}
	}
	
	
	public static  boolean  checkNetwork(Context context, boolean edgeCanDial) {
		//int netstate = NetWorkTools.getCurrentNetWorkType(context);//TCP中的网络判断不准确，下个版本再把TCP中的统一过来
	    int netstate = getCurrentNetWorkType(context);
		if(netstate == NetWorkTools.NETWORK_ON){
			Toast.makeText(context, "网络连接错误，请检查网络是否已连接", Toast.LENGTH_SHORT).show();
			return false;
		}else if (netstate == NetWorkTools.NETWORK_EDGE && !edgeCanDial) {
			//Toast.makeText(context, "2G 网络下无法呼叫", Toast.LENGTH_SHORT).show();
		    Toast.makeText(context, "呼叫失败(网络状态差)", Toast.LENGTH_SHORT).show();
			return false;
		}else if(edgeCanDial){
			TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);  
        	int simState = mTelephonyManager.getSimState();
        	if(TelephonyManager.SIM_STATE_READY != simState){
        		Toast.makeText(context, "SIM 卡状态错误", Toast.LENGTH_SHORT).show();
        		return false;
        	}
		}
		return true;
	}
	
	
	/**
     * 无网络联接
     */
    public static final int NETWORK_ON = 0;
    /**
     * WIFI网络
     */
    public static final int NETWORK_WIFI = 1;
    /**
     * 2G网络(包含:2.75G  2.5G 2G)
     */
    public static final int NETWORK_EDGE = 2;
    /**
     * 3G网络(包含:3G  3.5G  3.75G)
     */
    public static final int NETWORK_3G = 3;
    /**
     * 以太网络
     */
    public static final int NETWORK_ETHERNET = 4;
    
    
    /**
     * 获取当前的网络类型
     * @param mContext
     * @author: xiaozhenhua
     * @data:2014-4-9 下午3:15:07
     */
    public static int getCurrentNetWorkType(Context mContext){
        int currentNetWorkType = NETWORK_ON;
        NetworkInfo activeNetInfo =  getNetworkInfo(mContext);
        int netSubtype = -1;
        if (activeNetInfo != null) {
            netSubtype = activeNetInfo.getSubtype();
            CustomLog.v("getCurrentNetWorkType getTypeName():" + activeNetInfo.getTypeName());
            CustomLog.v("getCurrentNetWorkType getSubtype():" + activeNetInfo.getSubtype());
        }
        else
        {
            CustomLog.v("activeNetInfo == null");
        }
        
        if (activeNetInfo != null && activeNetInfo.isConnected()) {
            if ("WIFI".equalsIgnoreCase(activeNetInfo.getTypeName())) {
                currentNetWorkType = NETWORK_WIFI;
            } else if (activeNetInfo.getTypeName() != null 
                    && activeNetInfo.getTypeName().toLowerCase().contains("mobile")) {// 3g,双卡手机有时为mobile2
                if (netSubtype == TelephonyManager.NETWORK_TYPE_UMTS
                        || netSubtype == TelephonyManager.NETWORK_TYPE_EVDO_0
                        || netSubtype == TelephonyManager.NETWORK_TYPE_EVDO_A
                        || netSubtype == TelephonyManager.NETWORK_TYPE_EVDO_B
                        || netSubtype == TelephonyManager.NETWORK_TYPE_EHRPD
                        || netSubtype == TelephonyManager.NETWORK_TYPE_HSDPA
                        || netSubtype == TelephonyManager.NETWORK_TYPE_HSUPA
                        || netSubtype == TelephonyManager.NETWORK_TYPE_HSPA
                        || netSubtype == TelephonyManager.NETWORK_TYPE_LTE
                        // 4.0系统 H+网络为15 TelephonyManager.NETWORK_TYPE_HSPAP
                        || netSubtype == 15) {
                    currentNetWorkType = NETWORK_3G;
                }  else {
                    currentNetWorkType = NETWORK_EDGE;
                }
            } else if (activeNetInfo.getTypeName() != null && activeNetInfo.getTypeName().toUpperCase().contains("ETHERNET")) {
                currentNetWorkType = NETWORK_ETHERNET;
            } else {
                currentNetWorkType = NETWORK_3G;
            }
        }
        return currentNetWorkType;
    }
    
    private static NetworkInfo getNetworkInfo(Context mContext){
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }
}
