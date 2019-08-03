package com.yzx.im_demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.yzx.db.UserInfoDBManager;
import com.yzx.db.domain.UserInfo;
import com.yzx.im_demo.contact.DiscussSortAdapter;
import com.yzx.im_demo.contact.SideBar;
import com.yzx.im_demo.contact.SideBar.OnTouchingLetterChangedListener;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.ContactTools;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ChatMessage;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxIM.data.db.DiscussionChat;
import com.yzxIM.data.db.DiscussionInfo;
import com.yzxIM.data.db.GroupChat;
import com.yzxIM.data.db.SingleChat;
import com.yzxIM.listener.DiscussionGroupCallBack;
import com.yzxtcp.data.UcsReason;
import com.yzxtcp.tools.CustomLog;

public class IMFriendListActivity extends Activity implements DiscussionGroupCallBack{
	private static final String TAG = IMFriendListActivity.class.getSimpleName();
	private YzxTopBar yzxTopBar;
	private RelativeLayout ib_back;
	private ListView sortListView;
	private SideBar sideBar;
	private TextView dialog;
	private DiscussSortAdapter adapter;
	private Button create_chatroom;
	private String title = "创建讨论组";
	private IMManager imManager;
	private Handler mHandler;
	private ProgressDialog mProgressDialog;
	private Timer mTimer;
	private int personNum=0;
	private UserInfo user;
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chatroom);
		
		Bundle data = getIntent().getExtras();
		if(null != data){
			title = data.getString("title");
		}
		
		user = UserInfoDBManager.getInstance().getCurrentLoginUser();
		
		initView();
		imManager = IMManager.getInstance(this);
		imManager.setDiscussionGroup(this);
		
		mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					if(mTimer != null){
						mTimer.cancel();
						mTimer = null;
					}
					Toast.makeText(IMFriendListActivity.this, "创建讨论组失败(注：非注册用户无法加入)",Toast.LENGTH_SHORT).show();
					break;
				case 2:
					if(mTimer != null){
						mTimer.cancel();
						mTimer = null;
					} 
					break;
				case 3:
					Toast.makeText(IMFriendListActivity.this, "创建讨论组超时",Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}
			}
		};
	}
	
	public void initView() {
		yzxTopBar = (YzxTopBar)findViewById(R.id.yzx_topbar);
		yzxTopBar.setTitle(title);
		
		ib_back = (RelativeLayout)findViewById(R.id.imbtn_back);
		
		ib_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		sideBar = (SideBar) findViewById(R.id.sidrbar);
		dialog = (TextView) findViewById(R.id.dialog);
		sideBar.setTextView(dialog);

		sideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {

				int position = adapter.getPositionForSection(s.charAt(0));
				if (position != -1) {
					sortListView.setSelection(position);
				}
			}
		});
		
		create_chatroom = (Button) findViewById(R.id.imbtn_info);
		create_chatroom.setBackgroundResource(R.drawable.topright_sure);
		create_chatroom.setText("确认");
		create_chatroom.setVisibility(View.VISIBLE);
		create_chatroom.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				HashMap<Integer,Integer> isSelected = adapter.getIsSelected();
				ArrayList<String> memberIDList = new ArrayList<String>();
				ArrayList<String> memberNameList = new ArrayList<String>();
				String discussionName="";
				discussionName = discussionName+user.getName()+",";
				if("创建讨论组".equals(title)){
					String memberName = getIntent().getExtras().getString("memberName");
					if(!TextUtils.isEmpty(memberName)){
						discussionName += memberName+",";
					}
				}
				CustomLog.d("讨论组自己的名称 = "+discussionName);
				for(int i=0;i<ContactTools.getSourceDateList().size();i++){
					if(isSelected.get(i) == 1){
						memberIDList.add(ContactTools.getSourceDateList().get(i).getId());
						memberNameList.add(ContactTools.getSourceDateList().get(i).getName());
						discussionName = discussionName+ContactTools.getSourceDateList().get(i).getName()+",";
					}
				}
				if(memberIDList.size()==0){
					Toast.makeText(IMFriendListActivity.this, "请至少选择一个好友！", Toast.LENGTH_SHORT).show();
					return;
				}
				if("邀请好友".equals(title)){
					Bundle data = getIntent().getExtras();
					memberNameList.removeAll(data.getStringArrayList("members"));
					Intent intent = new Intent();
					intent.putStringArrayListExtra("members", memberNameList);
					IMFriendListActivity.this.setResult(2,intent);
					finish();
				}else if ("选择好友".equals(title)){
					for(String member : memberIDList){
						ChatMessage msg = null;
						Bundle data = getIntent().getExtras();
						switch (CategoryId.valueof(data.getInt("CategoryId"))) {
						case PERSONAL:
							msg = new SingleChat();
							break;
						case GROUP:
							msg = new GroupChat();
							break;
						case DISCUSSION:
							msg = new DiscussionChat();
							break;
						default:
							break;
						}		
						msg.setMsgType(data.getInt("MsgType"));
						msg.setCategoryId(data.getInt("CategoryId"));
						msg.setContent(data.getString("Content"));
						msg.setPath(data.getString("Path"));
						msg.setTargetId(member);
						msg.setSendStatus(ChatMessage.MSG_STATUS_INPROCESS);
						imManager.sendmessage(msg);
					}
					finish();
				}else if ("创建讨论组".equals(title)){
					if(!"".equals(discussionName)){
						mTimer = new Timer();
						mTimer.schedule(new TimerTask() {
							@Override
							public void run() {
								CustomLog.d("创建讨论组超时");
								if(mProgressDialog != null){
									mProgressDialog.dismiss();
								}
								mHandler.sendEmptyMessage(3);
							}
						}, 30000);
						if(null != getIntent().getExtras()){
							//添加原有的成员
							String memberid = getIntent().getExtras().getString("memberid");
							if(!TextUtils.isEmpty(memberid)){
								memberIDList.add(memberid);
							}
						}
						imManager.createDiscussionGroup(discussionName.substring(0, discussionName.length()-1), memberIDList);
						showCreateProgress();
					}
				}	
			}
		});
		
		sortListView = (ListView) findViewById(R.id.country_lvcountry);
		
		ArrayList<String> memberList = new ArrayList<String>();
		if(null != getIntent().getExtras()){
			memberList = getIntent().getExtras().getStringArrayList("members");
		}
		adapter = new DiscussSortAdapter(this, ContactTools.getSourceDateList(),memberList);
		sortListView.setAdapter(adapter);
		
		sortListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				CheckBox box = (CheckBox)v.findViewById(R.id.item_check);
				if(adapter.getIsSelected().get(position) != 2 && box.isEnabled()){
				    box.setChecked(!box.isChecked());
				    if(box.isChecked()){
				    	adapter.updateSelect(position, 1);
				    }else{
				    	adapter.updateSelect(position, 0);
				    }
					if(box.isChecked()){
						personNum++;
					}else{
						personNum--;
					}
					if(personNum == 0){
						create_chatroom.setText("确认");
					}else{
						create_chatroom.setText("确认("+personNum+")");
					}
				}
			}
		});
	}

	private void showCreateProgress() {
		if (mProgressDialog == null) {
			mProgressDialog = new ProgressDialog(this);
		}

		mProgressDialog.setIndeterminate(true);
		mProgressDialog.setCancelable(false);
		mProgressDialog.setMessage("讨论组创建中...");
		mProgressDialog.show();

	}

	@Override
	public void onCreateDiscussion(UcsReason reason, DiscussionInfo discussionInfo) {
		
		if(mProgressDialog != null){
			mProgressDialog.dismiss();
		}
		if(reason.getReason()==0){
			mHandler.sendEmptyMessage(2);
			Intent intent = new Intent(IMFriendListActivity.this, IMMessageActivity.class);
			CustomLog.e("targetId == "+reason.getMsg());
			ConversationInfo info = imManager.getConversation(discussionInfo.getDiscussionId());
			if(null != info){
				intent.putExtra("conversation", info);
				startActivity(intent);
				finish();
			}else{
				CustomLog.e("获得讨论组会话为空");
			}
		}else {
			CustomLog.e("创建讨论组失败");
			mHandler.sendEmptyMessage(1);
		}
		
		
	}

	@Override
	public void onDiscussionAddMember(UcsReason arg0) {
		CustomLog.d(arg0.getMsg());
	}

	@Override
	public void onDiscussionDelMember(UcsReason arg0) {
		Log.i(TAG, "IMFriendListActivity onDiscussionDelMember--------------------------");
		CustomLog.d(arg0.getMsg());
	}

	@Override
	public void onQuiteDiscussion(UcsReason arg0) {
		CustomLog.d(arg0.getMsg());
	}
	public void onModifyDiscussionName(UcsReason arg0) {
		
	}
}
