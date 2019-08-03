package com.yzx.im_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yzx.db.UserInfoDBManager;
import com.yzx.db.domain.UserInfo;
import com.yzx.model.SortModel;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.ContactTools;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxIM.data.db.DiscussionInfo;
import com.yzxIM.listener.DiscussionGroupCallBack;
import com.yzxtcp.data.UcsReason;
import com.yzxtcp.tools.CustomLog;

public class IMDiscussInfoActivity extends Activity implements DiscussionGroupCallBack{
	private static final String TAG = "IMDiscussInfoActivity";
	private IMManager imManager;
	private GridView mGridView;
	private List<String> memberlist = new ArrayList<String>();
	private List<String> addmembers = new ArrayList<String>();
	private String delmember="";
	private InfoAdapter adapter;
	private String discussionid;
	private Button quit_chatroom;
	private TextView clear_msgs;
	private TextView discuss_name;
	private TextView selectbg_tv;
	private RelativeLayout discuss_rename;
	private Handler mHandler;
	private Boolean delete=false;
	private Boolean isOwner=false;
	private ConversationInfo conversationinfo;
	private DiscussionInfo discussioninfo;
	private AlertDialog dialog;
	private YzxTopBar topBarDisInfo;
	private RelativeLayout imgBack;
	private ProgressDialog mProgressDialog;
	private Timer mTimer;
	private Dialog base_dialog;
	private CheckBox item_check_invite;
	private CheckBox item_check_receive;
	private UserInfo user;
	private int discussionNums;//讨论组成员数
	protected void onResume() {
		imManager.setDiscussionGroup(this);
		super.onResume();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discussinfo);
		imManager = IMManager.getInstance(this);
		imManager.setDiscussionGroup(this);
		
		
		conversationinfo = (ConversationInfo) getIntent().getSerializableExtra("conversationinfo");
		discussioninfo = imManager.getDiscussionInfo(conversationinfo.getTargetId());
		discussionid = conversationinfo.getTargetId();
		
		user = UserInfoDBManager.getInstance().getCurrentLoginUser();

		CustomLog.e(discussioninfo.getDiscussionMembers());
		CustomLog.e("owner="+discussioninfo.getOwnerId());
		CustomLog.e("loginuser="+user.getAccount());
		if(user.getAccount().equals(discussioninfo.getOwnerId())){
			isOwner = true;
		}
		
		
		initdata();
		initviews();
		mHandler = new Handler(new Handler.Callback() {
			@Override
			public boolean handleMessage(Message msg) {
				if(mTimer != null){
					mTimer.cancel();
					mTimer = null;
				}
				switch(msg.what){
				case 1:
					//更新讨论组信息
					discussioninfo = imManager.getDiscussionInfo(conversationinfo.getTargetId());
					discussionNums += addmembers.size();
					memberlist.addAll(addmembers);
					topBarDisInfo.setTitle("讨论组信息("+discussionNums+")");
					adapter.notifyDataSetChanged();
					break;
				case 2:
					//更新讨论组信息
					discussioninfo = imManager.getDiscussionInfo(conversationinfo.getTargetId());
					discussionNums -= 1;
					topBarDisInfo.setTitle("讨论组信息("+discussionNums+")");
					memberlist.remove(delmember);
					adapter.notifyDataSetChanged();
					break;
				case 3:
					Toast.makeText(IMDiscussInfoActivity.this, "添加成员失败(注：非注册用户无法加入)", Toast.LENGTH_SHORT).show();
					break;
				case 4:
					Toast.makeText(IMDiscussInfoActivity.this, "删除成员失败", Toast.LENGTH_SHORT).show();
					break;
				case 5:
					Toast.makeText(IMDiscussInfoActivity.this, "退出讨论组失败", Toast.LENGTH_SHORT).show();
					break;
				}
				return true;
			}
		});
	}
	
	private void initdata() {
		discussionNums = discussioninfo.getMemberCount();
		String members[] = discussioninfo.getDiscussionMembers().split(",");
		Log.i(TAG, "DiscussionMembers() = "+discussioninfo.getDiscussionMembers());
		int length = members.length;
		String localId = user.getAccount();
//		memberlist.add(localId);
		for(int i=0;i<length;i++){
			if(members[i].equals(localId)){
				//如果是当前账号
				memberlist.add(user.getName());
				continue;
			}
			Boolean b=false;
			List<SortModel> lists = new ArrayList<SortModel>();
			lists.addAll(ContactTools.getSourceDateList());
			for(SortModel model:lists){
				if(members[i].equals(model.getId())){
					memberlist.add(model.getName());
					b=true;
					break;
				}
			}
			if(!b){
				List<ConversationInfo> persons = imManager.getConversationList(CategoryId.PERSONAL);
				String person = members[i];
				if(persons != null && persons.size() > 0){
					for(ConversationInfo info : persons){
						if(info.getTargetId().equals(members[i])){
							person = info.getConversationTitle();
							break;
						}
					}
				}
				memberlist.add(person);
			}
		}
	}

	private void initviews() {
		topBarDisInfo = (YzxTopBar)findViewById(R.id.yzx_topbar_disinfo);
		topBarDisInfo.setTitle("讨论组信息("+discussionNums+")");
		imgBack = (RelativeLayout)findViewById(R.id.imbtn_back);
		imgBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		mGridView = (GridView) findViewById(R.id.info_list);	
		adapter = new InfoAdapter();
		mGridView.setAdapter(adapter);
		quit_chatroom = (Button) findViewById(R.id.quit_chatroom);
		quit_chatroom.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog = new AlertDialog.Builder(IMDiscussInfoActivity.this).create(); 
				dialog.show();
				dialog.getWindow().setContentView(R.layout.dialog_base);
				TextView tv= (TextView) dialog.getWindow().findViewById(R.id.dialog_tv);
				tv.setText("删除并退出后,将不再接收此讨论组信息");
				dialog.getWindow()
					.findViewById(R.id.dialog_tv_cencel)
					.setOnClickListener(new View.OnClickListener() {  
	                    @Override  
	                    public void onClick(View v) {  
	                    	dialog.dismiss();
	                    }
					});
				dialog.findViewById(R.id.dialog_tv_sure)
					.setOnClickListener(new View.OnClickListener() {  
	                    @Override  
	                    public void onClick(View v) {  
	                    	 dialog.dismiss();  
	                    	 imManager.quitDiscussionGroup(discussionid);
	                    	 mTimer = new Timer();
		 					 mTimer.schedule(new TimerTask() {
		 						@Override
		 						public void run() {
		 							// TODO Auto-generated method stub
		 							CustomLog.d("退出讨论组超时");
		 							if(mProgressDialog != null){
		 								mProgressDialog.dismiss();
		 							}
		 							mHandler.sendEmptyMessage(5);
		 						}
		 					}, 30000);
		 					showProgress("正在退出");
	                    }
					});
				}
		});
		clear_msgs = (TextView) findViewById(R.id.clear_msgs);
		clear_msgs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog = new AlertDialog.Builder(IMDiscussInfoActivity.this).create(); 
				dialog.show();
				dialog.getWindow().setContentView(R.layout.dialog_base);
				TextView tv= (TextView) dialog.getWindow().findViewById(R.id.dialog_tv);
				tv.setText("确定清空该聊天记录吗？");
				dialog.getWindow()
					.findViewById(R.id.dialog_tv_cencel)
					.setOnClickListener(new View.OnClickListener() {  
	                    @Override  
	                    public void onClick(View v) {  
	                    	dialog.dismiss();  
	                    }
					});
				dialog.findViewById(R.id.dialog_tv_sure)
					.setOnClickListener(new View.OnClickListener() {  
	                    @Override  
	                    public void onClick(View v) {  
	                    	conversationinfo.clearMessages(); 
	                    	conversationinfo.setDraftMsg("");
	                    	setResult(3);
	                    	dialog.dismiss();
	                    }
					});
				}
		});
		discuss_name = (TextView) findViewById(R.id.discuss_name);
		discuss_name.setText(discussioninfo.getDiscussionName());
		
		discuss_rename = (RelativeLayout) findViewById(R.id.discuss_rename);
		discuss_rename.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				base_dialog = new Dialog(IMDiscussInfoActivity.this,R.style.basedialog);
				base_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				base_dialog.setContentView(R.layout.dialog_base2);
				TextView tv= (TextView) base_dialog.findViewById(R.id.dialog_tv);
				tv.setText("输入新的讨论组名称");
				tv.setTextSize(16);
				final EditText et = (EditText) base_dialog.findViewById(R.id.dialog_et);
				et.setVisibility(View.VISIBLE);
				if(!TextUtils.isEmpty(discussioninfo.getDiscussionName())){
					et.setText(discussioninfo.getDiscussionName());
				}
				base_dialog.findViewById(R.id.dialog_tv_cencel)
					.setOnClickListener(new View.OnClickListener() {  
	                    @Override  
	                    public void onClick(View v) {  
	                    	base_dialog.dismiss();
	                    }
					});
				base_dialog.setOnShowListener(new DialogInterface.OnShowListener() {
					@Override
					public void onShow(DialogInterface dialog) {
						et.setSelection(et.getText().toString().length());
						//在对话框显示之后弹出输入法
						InputMethodManager inputmanger = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
						inputmanger.toggleSoftInput(0,
								InputMethodManager.HIDE_NOT_ALWAYS);
					}
				});
				base_dialog.show();
				base_dialog.findViewById(R.id.dialog_tv_sure)
					.setOnClickListener(new View.OnClickListener() {  
	                    @Override  
	                    public void onClick(View v) { 
	                    	imManager.modifyDiscussionTitle(discussionid, et.getText().toString());
	                    	discuss_name.setText(et.getText().toString());
	                    	base_dialog.dismiss(); 
	                    }
					});
			}
		});
		selectbg_tv =  (TextView) findViewById(R.id.selectbg_tv);
		selectbg_tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				MainApplication.getInstance().targetId = conversationinfo.getTargetId();
				startActivityForResult(new Intent(IMDiscussInfoActivity.this, IMMessageBgActivity.class),2);
			}
		});
		
		item_check_invite = (CheckBox) findViewById(R.id.item_check_invite);
		item_check_invite.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				
			}
		});
		item_check_receive = (CheckBox) findViewById(R.id.item_check_receive);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && null!=data) {
			imManager.setDiscussionGroup(this);
			addmembers = data.getStringArrayListExtra("members");
			ArrayList<String> infos = new ArrayList<String>();
			List<SortModel> lists = new ArrayList<SortModel>();
			lists.addAll(ContactTools.getSourceDateList());
			for(SortModel model:lists){
				for(String info:addmembers){
					if(info.equals(model.getName())){
						infos.add(model.getId());
						break;
					}
				}	
			}
			imManager.addDiscussionGroupMember(discussionid, infos);
			delete = false;
			showProgress("正在添加");
			mTimer = new Timer();
			mTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					CustomLog.d("添加成员超时");
					if(mProgressDialog != null){
						mProgressDialog.dismiss();
					}
					mHandler.sendEmptyMessage(3);
				}
			}, 30000);
		}else if(requestCode == 2){
			setResult(RESULT_OK,data);
			finish();
		}
		
	}

	class InfoAdapter extends BaseAdapter{
		private List<String> showlist = new ArrayList<String>();
		public InfoAdapter() {
			showlist.addAll(memberlist);
			showlist.add("add");
			if(isOwner){
				showlist.add("delete");
			}
		}
		
		public void addDbMessageAdapter(ConversationInfo conversationinfo) {
			super.notifyDataSetChanged();
		}
		
		public void notifyDataSetChanged() {
			showlist.clear();
			showlist.addAll(memberlist);
			showlist.add("add");
			if(isOwner){
				showlist.add("delete");
			}
			super.notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return showlist.size();
		}

		@Override
		public Object getItem(int position) {
			return showlist.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View view, ViewGroup parent) {
			final String memberid = showlist.get(position);
			final HolderView hv ;

			if(view == null){
				hv = new HolderView();
				view = LayoutInflater.from(IMDiscussInfoActivity.this).inflate(R.layout.listitem_member_info, null);
				hv.memberimage = (ImageView) view.findViewById(R.id.member_info_iv);
				hv.membername = (TextView) view.findViewById(R.id.member_info_tv);
				hv.memberdelete = (ImageView) view.findViewById(R.id.member_info_delete);
				view.setTag(hv);
			}else{
				hv = (HolderView)view.getTag();
			}

			if(delete && position>0){
				hv.memberdelete.setVisibility(View.VISIBLE);
				hv.memberdelete.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						List<String> list = new ArrayList<String>();
						discussioninfo = imManager.getDiscussionInfo(conversationinfo.getTargetId());
						String members[] = discussioninfo.getDiscussionMembers().split(",");
						String result = "";
						for(String item : members){
							result += item+",";
						}
						Log.i(TAG, "讨论组成员="+result);
						if(position > (members.length - 1)){
							mHandler.sendEmptyMessage(4);
							return;
						}
						delmember = memberid;
						Log.i(TAG, "正在删除="+members[position]);
						list.add(members[position]);
						showProgress("正在删除");
						mTimer = new Timer();
						mTimer.schedule(new TimerTask() {
							@Override
							public void run() {
								CustomLog.d("删除成员超时");
								if(mProgressDialog != null){
									mProgressDialog.dismiss();
								}
								mHandler.sendEmptyMessage(4);
							}
						}, 30000);
						imManager.delDiscussionGroupMember(discussionid, list);
					}
				});
			}else {
				hv.memberdelete.setVisibility(View.GONE);
			}
			
			if("add".equals(memberid)||"delete".equals(memberid)){
				hv.memberdelete.setVisibility(View.GONE);
				hv.membername.setVisibility(View.INVISIBLE);
				if("add".equals(memberid)){
					hv.memberimage.setBackgroundResource(R.drawable.add_member);
					hv.memberimage.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							 new AsyncTask<Void, Void, Void>() {  
				                    protected Void doInBackground(Void... params) { 
				                    	// 如果没有去获取数据，此初始化一次
				                    	if(ContactTools.getSourceDateList().size() == 0) {
				                    		ContactTools.initContacts(IMDiscussInfoActivity.this); 
				                    	}
				                        return null;  
				                    }  
				  
				                    @Override  
				                    protected void onPostExecute(Void result) {
										CustomLog.e("discussionid="+discussionid);
										Intent intent = new Intent(IMDiscussInfoActivity.this, IMFriendListActivity.class);
										Bundle data = new Bundle();
										ArrayList<String> list = new ArrayList<String>();
										List<SortModel> lists = new ArrayList<SortModel>();
										lists.addAll(ContactTools.getSourceDateList());
										for(String str:memberlist){
											for(SortModel model:lists){
												if(str.equals(model.getName())){
													list.add(str);
													break;
												}
											}
									    }
										data.putStringArrayList("members", (ArrayList<String>) list);
										data.putString("title", "邀请好友");
										data.putString("discussionID", discussionid);
										intent.putExtras(data);
										startActivityForResult(intent, 1);
				                    }  
				                }.execute(null, null, null);  
						}
					});
				}else {
					hv.memberimage.setBackgroundResource(R.drawable.delete_member);
					hv.memberimage.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							delete = !delete;
							adapter.notifyDataSetChanged();
						}
					});
				}
			}else{
				hv.membername.setVisibility(View.VISIBLE);
				hv.memberimage.setBackgroundResource(R.drawable.person);
//				if(position==0){
//					hv.membername.setText("我");
//				}else {
//				}
				hv.membername.setText(memberlist.get(position));
			}
			return view;
		}
		
		class HolderView{
			ImageView memberimage;
			TextView membername;
			ImageView memberdelete;
		}
	};
	
	
	
	private void showProgress(String content) {
		if (mProgressDialog == null) {
			mProgressDialog = new ProgressDialog(this);
		}

		mProgressDialog.setIndeterminate(true);
		mProgressDialog.setCancelable(false);
		mProgressDialog.setMessage(content);
		mProgressDialog.show();

	}

	@Override
	public void onCreateDiscussion(UcsReason reason, DiscussionInfo info) {
		
	}

	@Override
	public void onDiscussionAddMember(UcsReason reason) {
		CustomLog.e("onDiscussionAddMember start reason "+reason.getReason());
		if(mProgressDialog != null){
			mProgressDialog.dismiss();
		}
		if(reason.getReason()==0){
			mHandler.sendEmptyMessage(1);
		}else{
			mHandler.sendEmptyMessage(3);
		}
	}

	@Override
	public void onDiscussionDelMember(UcsReason reason) {
		CustomLog.e("onDiscussionDelMember start reason "+reason.getReason());
		if(mProgressDialog != null){
			mProgressDialog.dismiss();
		}
		if(reason.getReason()==0){
			mHandler.sendEmptyMessage(2);
		}else{
			mHandler.sendEmptyMessage(4);
		}
	}


	@Override
	public void onQuiteDiscussion(UcsReason reason) {
		CustomLog.e("onQuiteDiscussion start reason "+reason.getReason());
		if(mProgressDialog != null){
			mProgressDialog.dismiss();
		}
		if(reason.getReason() == 0){
			mHandler.sendEmptyMessage(6);
			setResult(RESULT_FIRST_USER);
			finish();
		}else{
			mHandler.sendEmptyMessage(5);
		}
	}
	public void onModifyDiscussionName(UcsReason arg0) {
		
	}
}
