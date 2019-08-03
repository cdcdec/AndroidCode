package com.yzx.im_demo.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yzx.db.DraftDbManager;
import com.yzx.db.domain.DraftMsg;
import com.yzx.im_demo.IMBroadcastActivity;
import com.yzx.im_demo.IMChatActivity;
import com.yzx.im_demo.IMMessageActivity;
import com.yzx.im_demo.R;
import com.yzx.im_demo.userdata.GroupBean;
import com.yzx.listener.IObserverListener;
import com.yzx.model.SortModel;
import com.yzx.tools.ContactTools;
import com.yzx.tools.NetWorkTools;
import com.yzx.tools.RestTools;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.MSGTYPE;
import com.yzxIM.data.db.ChatMessage;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxIM.data.db.DiscussionInfo;
import com.yzxIM.listener.IConversationListener;
import com.yzxIM.listener.MessageListener;
import com.yzxtcp.tools.CustomLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@SuppressLint("NewApi")
public class ConversationFragment extends Fragment implements
		IConversationListener, MessageListener, IObserverListener {

	public interface refreshUnReadMessageListener {
		public void onRefreshUnReadMessage();
		public void onReceiveMessage(List<ChatMessage> msgs);
	}

	private static final String TAG = "ConversationFragment";

	private ListView conversationlist;
	private ImageView mImvNoMsg;
	private LinearLayout ll_network;
	private ImageView sdk_connected_error;
	private ProgressBar sdk_connecting;
	private TextView sdk_status_text;

	private static ConversationlistAdapter adapter;
	private List<ConversationInfo> conversationLists = new ArrayList<ConversationInfo>();
	private String title;
	private AlertDialog dialog;
	private int topNum = 0;
	private refreshUnReadMessageListener mListener;
	private View mView;

	private boolean isDestoryView;
	
	private static final int HANDLER_DELE_CONVERSATION = 4;
	private static final int HANDLER_UPDATE_CONVERSATION = 5;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CustomLog.v("ConversationFragment onCreate hashCode = " + hashCode());
		IMManager.getInstance(getActivity()).setConversationListener(this);
		IMManager.getInstance(getActivity()).setSendMsgListener(this);
		((IMChatActivity) getActivity()).putObserver(this); // 增加 tcp状态监听 notify
		initdata();
	}

	public Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				// 重新加载
				if (conversationLists.size() == 0) {
					mImvNoMsg.setVisibility(View.VISIBLE);
					mView.invalidate();
					topNum = 0;
				} else {
					mImvNoMsg.setVisibility(View.GONE);
				}
				break;
			case 2:
				int sdkStatus = (Integer) msg.obj;
				updateSdkStatusUI(sdkStatus);
				break;
			case HANDLER_DELE_CONVERSATION:
				ConversationInfo delinfo = (ConversationInfo) msg.obj;
				List<ConversationInfo> lists = new ArrayList<ConversationInfo>();
				lists.addAll(conversationLists);
				synchronized (conversationLists) {
					for (int position = 0; position < lists.size(); position++) {
						ConversationInfo conversation = lists.get(position);
						if (conversation.getTargetId().equals(
								delinfo.getTargetId())) {
							conversationLists.remove(position);
							if(adapter != null) {
								adapter.notifyDataSetChanged();
							}
							break;
						}
					}
				}
				mHandler.sendEmptyMessage(1);
				break;
			case HANDLER_UPDATE_CONVERSATION:
				//要更新的会话集合
				List<ConversationInfo> updateInfos = (List<ConversationInfo>) msg.obj;
				//临时总会话集合
				List<ConversationInfo> cuInfos = new ArrayList<ConversationInfo>();
				if(conversationLists != null && conversationLists.size() > 0){
					cuInfos.addAll(conversationLists);
				}
				//将所有更新和添加的会话都放到cuInfos集合临时存储
				for(ConversationInfo info : updateInfos){
					ConversationInfo item = getInfo(info);
					if(item == null){
						//为新创建的会话设置title
						if (info.getCategoryId() == CategoryId.GROUP) {
							List<GroupBean> groups = RestTools.getGroupInfo();
							if (groups != null) {
								for (GroupBean group : groups) {
									if (info.getTargetId().equals(group.getGroupID())
											&& !group.getGroupName().equals(
													info.getConversationTitle())) {
										info.setConversationTitle(group.getGroupName());
									}
								}
							}
						}else if(info.getCategoryId() == CategoryId.PERSONAL){
							String title = ContactTools.getConTitle(info.getTargetId());
							if(!TextUtils.isEmpty(title)){
								info.setConversationTitle(title);
							}
						}
						//添加到临时集合
						cuInfos.add(topNum,info);
					}else{
						if (info.getCategoryId() == CategoryId.DISCUSSION) {
							DiscussionInfo discussion = IMManager.getInstance(getActivity())
									.getDiscussionInfo(info.getTargetId());
							if (discussion != null) {
								info.setConversationTitle(discussion.getDiscussionName());
							}
						}
						//更新临时集合
						updataCinfo(cuInfos,info, item);
					}
				}
				synchronized (conversationLists) {
					conversationLists.clear();
					conversationLists.addAll(cuInfos);
					if(adapter != null) {
						adapter.notifyDataSetChanged();
					}
				}
				sendEmptyMessage(1);
				break;
			case 6:
				if(adapter != null) {
					adapter.notifyDataSetChanged();
				}
				break;
			case 7:
				Map<String, ConversationInfo> datas = (Map<String, ConversationInfo>) msg.obj;
				Log.i(TAG, "收到一次性更新会话消息 size = " + datas.size());

				Iterator<Entry<String, ConversationInfo>> iterator = datas
						.entrySet().iterator();
				int delayIndex = 0;
				while (iterator.hasNext()) {
					Entry<String, ConversationInfo> entry = iterator.next();
					ConversationInfo conversationInfo = entry.getValue();
					Message message = mHandler.obtainMessage();
					message.what = HANDLER_UPDATE_CONVERSATION;
					message.obj = conversationInfo;
					mHandler.sendMessageDelayed(message, delayIndex * 50);
					delayIndex++;
				}
				break;
			}
		}
	};

	private void initdata() {
		conversationLists = IMManager.getInstance(
				getActivity().getApplicationContext()).getConversationList();
		List<ConversationInfo> removeinfos = new ArrayList<ConversationInfo>();
		List<ConversationInfo> lists = new ArrayList<ConversationInfo>();
		lists.addAll(conversationLists);
		int size = lists.size();
		for (int i = 0; i < size; i++) {
			// 移出没有消息的会话
			if (null == lists.get(i).getLastestMessages(0, 1)) {
				removeinfos.add(lists.get(i));
//				break; // 如果前面一个会话里面没有消息，for循环直接跳出, 应该改成continue，进行下一个判断
				continue;
			}
			List<SortModel> sourceDateList = ContactTools.getSourceDateList();
			// 为单聊会话设置title
			if (sourceDateList != null) {
				for (SortModel model : sourceDateList) {
					if (lists.get(i).getTargetId().equals(model.getId())
							&& !lists.get(i).getConversationTitle()
									.equals(model.getName())) {
						lists.get(i).setConversationTitle(model.getName());
						break;
					}
				}
			}
			// 为群聊会话设置title
			if (lists.get(i).getCategoryId() == CategoryId.GROUP) {
				CustomLog.e("Group getTargetId :" + lists.get(i).getTargetId());
				List<GroupBean> groups = RestTools.getGroupInfo();
				if (null != groups) {
					CustomLog.e("Group getGroupLength :" + groups.size());
					for (GroupBean group : groups) {
						CustomLog.e("Group getGroupID :" + group.getGroupID());
						if (lists.get(i).getTargetId()
								.equals(group.getGroupID())) {
							CustomLog.e("Group getGroupName :"
									+ group.getGroupName());
							if (!lists.get(i).getConversationTitle()
									.equals(group.getGroupName())) {
								lists.get(i).setConversationTitle(
										group.getGroupName());
							}
						}
					}
				}
			}
		}
		conversationLists.removeAll(removeinfos);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		CustomLog.v("ConversationFragment onActivityCreated hashCode = " + hashCode());
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		CustomLog.v("ConversationFragment onDestroyView contentView = null ? " + (mView == null));
		if(mView != null) {
			((ViewGroup)mView.getParent()).removeView(mView);
		}
		isDestoryView = true;
		super.onDestroyView();

	}

	@Override
	public void onStop() {
		CustomLog.v("ConversationFragment onStop hashCode = " + hashCode());
		super.onStop();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		CustomLog.v("ConversationFragment onCreateView ...");
		isDestoryView = false;
		if(mView == null) {
			mView = inflater.inflate(R.layout.activity_conversationlist, container,false);
		}
				
		conversationlist = (ListView) mView.findViewById(R.id.conversationlist);
		mImvNoMsg = (ImageView) mView.findViewById(R.id.id_conv_nomsg);
		sdk_connected_error = (ImageView) mView
				.findViewById(R.id.sdk_connected_error);
		sdk_connecting = (ProgressBar) mView.findViewById(R.id.sdk_connecting);
		sdk_status_text = (TextView) mView.findViewById(R.id.sdk_status_text);
		ll_network = (LinearLayout) mView.findViewById(R.id.ll_network);

		adapter = new ConversationlistAdapter(this.getActivity());
		conversationlist.setAdapter(adapter);
		conversationlist.setDivider(null);
		if(!NetWorkTools.isNetWorkConnect(getActivity())){
			ll_network.setVisibility(View.VISIBLE);
		}else{
			ll_network.setVisibility(View.GONE);
		}
		Log.i(TAG, "updateSdkStatusUI status = " + status);
		updateSdkStatusUI(status);
		return mView;
	}

	@Override
	public void onDestroy() {
		((IMChatActivity) getActivity()).removeObserver(this);
		CustomLog.v("ConversationFragment onDestroy hashCode = " + hashCode());
		super.onDestroy();
	}

	@Override
	public void onPause() {
		CustomLog.v("ConversationFragment onPause hashCode = " + hashCode());
		super.onPause();
	}

	public void setRefreshUnReadMessageListener(refreshUnReadMessageListener cl) {
		mListener = cl;
	}

	class ConversationlistAdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		public ConversationlistAdapter(Context context) {
			mInflater = LayoutInflater.from(context);
			if (conversationLists.size() != 0) {
				mImvNoMsg.setVisibility(View.GONE);
				topNum = getTopNum(conversationLists);
			}

			if (null != mListener) {
				mListener.onRefreshUnReadMessage();
			}
			CustomLog.e("conversationList num=" + conversationLists.size());
		}

		public void notifyDataSetChanged() {
			if (null != mListener) {
				mListener.onRefreshUnReadMessage();
			}
			List<ConversationInfo> list = new ArrayList<ConversationInfo>();
			list.addAll(conversationLists);
			synchronized (conversationLists) {
				for (ConversationInfo info : list) {
					List<SortModel> sourceDateList = new ArrayList<SortModel>();
					sourceDateList.addAll(ContactTools.getSourceDateList());
					if (sourceDateList != null) {
						for (SortModel model : sourceDateList) {
							if (info.getTargetId().equals(model.getId())
									&& !info.getConversationTitle().equals(
											model.getName())) {
								info.setConversationTitle(model.getName());
								break;
							}
						}
					}
				}
			}
			if (isDestoryView) {
				return;
			}
			super.notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return conversationLists.size();
		}

		@Override
		public Object getItem(int position) {
			return conversationLists.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ViewHolder viewHolder = null;
			final ConversationInfo cinfo = conversationLists.get(position);
			if (null == convertView) {
				viewHolder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.listitem_conversation,
						null);
				viewHolder.conversation_rl = (RelativeLayout) convertView
						.findViewById(R.id.rl_conversation_item);
				viewHolder.conversation_head = (ImageView) convertView
						.findViewById(R.id.conversation_head);
				viewHolder.conversation_name = (TextView) convertView
						.findViewById(R.id.conversation_name);
				viewHolder.conversation_content = (TextView) convertView
						.findViewById(R.id.conversation_content);
				viewHolder.conversation_time = (TextView) convertView
						.findViewById(R.id.conversation_time);
				viewHolder.conversation_cout = (TextView) convertView
						.findViewById(R.id.conversation_cout);
				viewHolder.conversation_cout_bg = (ImageView) convertView
						.findViewById(R.id.conversation_cout_bg);
				viewHolder.conversation_sendstatus = (ImageView) convertView
						.findViewById(R.id.conversation_send_status);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			if (cinfo.getIsTop()) {
				convertView.setBackgroundColor(Color.parseColor("#f0f0f0"));
			} else {
				convertView.setBackgroundColor(Color.parseColor("#ffffff"));
			}

			viewHolder.conversation_rl
					.setOnTouchListener(new OnTouchListener() {

						@Override
						public boolean onTouch(View v, MotionEvent event) {
							v.setBackgroundResource(R.drawable.item_press_selector);
							if (MotionEvent.ACTION_UP == event.getAction()) {
								if (cinfo.getIsTop()) {
									v.setBackgroundColor(Color
											.parseColor("#fffaeb"));
								} else {
									v.setBackgroundColor(Color
											.parseColor("#ffffff"));
								}
							}
							return false;
						}
					});

			viewHolder.conversation_rl
					.setOnClickListener(new View.OnClickListener() {

						public void onClick(View arg0) {
							arg0.setBackgroundResource(R.drawable.item_press_selector);
							if(cinfo.getCategoryId() != CategoryId.BROADCAST){
								//启动聊天页面
								Intent intent = new Intent(getActivity(),
										IMMessageActivity.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								intent.putExtra("conversation", cinfo);
								startActivity(intent);
							}else{
								//启动广播页面
								Intent intent = new Intent(getActivity(),
										IMBroadcastActivity.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								intent.putExtra("conversation", cinfo);
								startActivity(intent);
							}
						}
					});

			viewHolder.conversation_rl
					.setOnLongClickListener(new View.OnLongClickListener() {
						@Override
						public boolean onLongClick(View arg0) {
							dialog = new AlertDialog.Builder(getActivity())
									.create();
							dialog.show();
							dialog.setCanceledOnTouchOutside(true);
							dialog.getWindow().setContentView(
									R.layout.dialog_base1);
							TextView tv1 = (TextView) dialog.getWindow()
									.findViewById(R.id.dialog_tv1);
							TextView tv2 = (TextView) dialog.getWindow()
									.findViewById(R.id.dialog_tv2);
							final Boolean isTop = cinfo.getIsTop();
							if (isTop) {
								tv1.setText("取消置顶");
							} else {
								tv1.setText("置顶聊天");
							}
							tv1.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View v) {
									getActivity().runOnUiThread(new Runnable() {
										@Override
										public void run() {
											conversationLists.get(position)
													.setIsTop(!isTop);
											IMManager.getInstance(getActivity()).sortConversationList(conversationLists);
											topNum = getTopNum(conversationLists);
											adapter.notifyDataSetChanged();
											dialog.dismiss();
										}
									});
								}
							});

							tv2.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View v) {
									getActivity().runOnUiThread(new Runnable() {
										@Override
										public void run() {
											cinfo.delConversationInfo();
											synchronized (conversationLists) {
												conversationLists
														.remove(position);
											}
											adapter.notifyDataSetChanged();
											if (cinfo.getIsTop() && topNum > 0) {
												topNum--;
											}
											if (conversationLists.size() == 0) {
												mImvNoMsg
														.setVisibility(View.VISIBLE);
												topNum = 0;
											}
											dialog.dismiss();
										}
									});
								}
							});
							return false;
						}
					});
			viewHolder.conversation_content.setTextColor(getResources().getColor(R.color.item_content_color));
			if (cinfo.getCategoryId() == CategoryId.PERSONAL) {
				viewHolder.conversation_head
						.setBackgroundResource(R.drawable.person);
			} else if (cinfo.getCategoryId() == CategoryId.GROUP) {
				viewHolder.conversation_head
						.setBackgroundResource(R.drawable.persones);
			} else if(cinfo.getCategoryId() == CategoryId.BROADCAST){
				viewHolder.conversation_head
						.setBackgroundResource(R.drawable.broadcasts);
			} else{
				viewHolder.conversation_head
						.setBackgroundResource(R.drawable.persons);
			}

			title = cinfo.getConversationTitle();

			if (title != null) {
				viewHolder.conversation_name.setText(title);
			}

			Log.i(TAG, "DraftMsg = " + cinfo.getDraftMsg());
			viewHolder.conversation_content.setText(cinfo.getDraftMsg());
			DraftMsg df = DraftDbManager.getInstance().getByTargetId(
					cinfo.getTargetId());
			String draftMsg = "";
			if (df != null) {
				draftMsg = df.getDraftMsg();
			}
			if (draftMsg != null && !"".equals(draftMsg)) {
				viewHolder.conversation_content.setText("[草稿] " + draftMsg);
			}

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd-HH:mm");
			String time = dateFormat.format(new Date(cinfo.getLastTime()));
			String currentTime = dateFormat.format(new Date());
			if(currentTime.split("-")[0].equals(time.split("-")[0])) { // 同一天
				viewHolder.conversation_time.setText(time.split("-")[1]);
			} else {
				String dateTime = time.split("-")[0].split(":")[0] + "-" + time.split("-")[0].split(":")[1] + "-" + time.split("-")[0].split(":")[2];
				viewHolder.conversation_time.setText(dateTime);
			}
			int unreadcount = cinfo.getUnreadCount();
			if (unreadcount != 0) {
				if (unreadcount > 99) {
					viewHolder.conversation_cout.setText("99+");
				} else {
					viewHolder.conversation_cout.setText(String
							.valueOf(unreadcount));
				}

				if (unreadcount < 10) {
					viewHolder.conversation_cout_bg.setVisibility(View.VISIBLE);
					viewHolder.conversation_cout_bg
							.setBackgroundResource(R.drawable.unreadsmall);
				} else {
					viewHolder.conversation_cout_bg.setVisibility(View.VISIBLE);
					viewHolder.conversation_cout_bg
							.setBackgroundResource(R.drawable.unreadbig);
				}
			} else {
				viewHolder.conversation_cout_bg.setVisibility(View.GONE);
				viewHolder.conversation_cout.setText("");
			}

			List<ChatMessage> msgs = cinfo.getLastestMessages(0, 1);
			if (msgs != null && msgs.size() > 0) {
				if (null != msgs && msgs.size() > 0) {
					//如果最后一条消息是自定义消息，颜色重置
					if(msgs.get(0).getMsgType() == MSGTYPE.MSG_DATA_CUSTOMMSG){
						viewHolder.conversation_content.setTextColor(getResources().getColor(R.color.msg_custom_text));
					}
					switch (msgs.get(0).getSendStatus()) {
					case ChatMessage.MSG_STATUS_INPROCESS:
					case ChatMessage.MSG_STATUS_RETRY:
						if (msgs.get(0).getIsFromMyself()) {
							viewHolder.conversation_time.setText("正在发送中");
						} else {
							viewHolder.conversation_time.setText("正在接收中");
						}
						// 发送中
						viewHolder.conversation_sendstatus
								.setBackgroundResource(R.drawable.send_ing);
						viewHolder.conversation_sendstatus
								.setVisibility(View.VISIBLE);
						break;
					case ChatMessage.MSG_STATUS_SUCCESS:
						// 发送成功
						viewHolder.conversation_sendstatus
								.setVisibility(View.GONE);
						break;
					case ChatMessage.MSG_STATUS_FAIL:
					case ChatMessage.MSG_STATUS_NETERROR:
					case ChatMessage.MSG_STATUS_TIMEOUT:
						// 发送失败
						viewHolder.conversation_sendstatus
								.setBackgroundResource(R.drawable.send_fail);
						viewHolder.conversation_sendstatus
								.setVisibility(View.VISIBLE);
						break;
					}
				} else {
					viewHolder.conversation_content.setText("");
				}
			}
			return convertView;
		}

		class ViewHolder {
			RelativeLayout conversation_rl;
			ImageView conversation_head;
			TextView conversation_name;
			TextView conversation_content;
			TextView conversation_time;
			TextView conversation_cout;
			ImageView conversation_cout_bg;
			ImageView conversation_sendstatus;
		}
	}

	private int getTopNum(List<ConversationInfo> cinfos) {
		int num = 0;
		for (ConversationInfo cinfo : cinfos) {
			if (cinfo.getIsTop()) {
				num++;
			} else {
				break;
			}
		}
		return num;
	}

	private void updataCinfo(List<ConversationInfo> infos,ConversationInfo cinfoSrc,
			ConversationInfo cinfoDest) {
		synchronized (infos) {
			infos.remove(cinfoDest);
			cinfoDest.setDraftMsg(cinfoSrc.getDraftMsg());
			cinfoDest.setLastTime(cinfoSrc.getLastTime());
			if (cinfoSrc.getCategoryId() == CategoryId.DISCUSSION) {
				cinfoDest.setConversationTitle(cinfoSrc.getConversationTitle());
			} else if(cinfoSrc.getCategoryId() == CategoryId.PERSONAL){
				List<ChatMessage> mgs = cinfoDest.getLastestMessages(0, 1);
				//会话title为sendId的时候
				if(mgs!= null && mgs.size() > 0 && !TextUtils.isEmpty(mgs.get(0).getNickName())
						&& cinfoDest.getConversationTitle().equals(mgs.get(0).getSenderId())
						){
					cinfoDest.setConversationTitle(mgs.get(0).getNickName());
				}
			}
			if (cinfoDest.getIsTop()) {
				infos.add(0, cinfoDest);
			} else {
				infos.add(topNum, cinfoDest);
			}
		}
	}

	@Override
	public void onCreateConversation(ConversationInfo cinfo) {
		Log.i(TAG,
				"onCreateConversation title : " + cinfo.getConversationTitle()
						+ ",targetId : " + cinfo.getTargetId());
	}

	public void onDeleteConversation(ConversationInfo cinfo) {
		Log.i(TAG,
				"onDeleteConversation title : " + cinfo.getConversationTitle()
						+ ",targetId : " + cinfo.getTargetId());
		Message message = mHandler.obtainMessage();
		message.obj = cinfo;
		message.what = HANDLER_DELE_CONVERSATION;
		mHandler.sendMessage(message);
	}

	public void onUpdateConversation(ConversationInfo cinfo) {
		Log.i(TAG,"onUpdateConversation title : " + cinfo.getConversationTitle()
						+ ",targetId : " + cinfo.getTargetId());
	}

	public void onResume() {
		super.onResume();
		CustomLog.v("ConversationFragment onResume ...");
		updateErrorMsgUI();
	}

	@Override
	public void onDownloadAttachedProgress(String arg0, String arg1, int arg2,
			int arg3) {
	}

	@Override
	public void onReceiveMessage(List arg0) {
		if(mListener != null) {
			mListener.onReceiveMessage(arg0);
		}
	}

	@Override
	public void onSendMsgRespone(ChatMessage arg0) {
		Log.v(TAG, "onSendMsgRespone message:" + arg0.getContent());
		mHandler.sendEmptyMessage(6);
	}

	// 更新发送失败UI
	public void updateErrorMsgUI() {
		if (mListener != null) {
			mListener.onRefreshUnReadMessage();
		}
		adapter.notifyDataSetChanged();
	}

	// 没网络错误
	private static final int CONNECT_SUCCESS = 400;
	// 没网络错误
	private static final int NET_ERROR = 402;
	// 网络链接成功
	private static final int NET_CNNECT = 404;
	// SDK正在链接
	private static final int SDK_CONNECTING = 406;
	// 服务器不可用
	private static final int SERVER_ERROR = 408;

	// 更新sdk状态提示UI
	private void updateSdkStatusUI(int sdkStatus) {
		if (ll_network == null) {
			CustomLog.e("ll_network == null");
			return;
		}
		ll_network.setOnClickListener(null);
		switch (sdkStatus) {
		case NET_ERROR:
			ll_network.setVisibility(View.VISIBLE);
			sdk_connected_error.setVisibility(View.VISIBLE);
			sdk_connecting.setVisibility(View.GONE);
			sdk_status_text.setText("网络连接不可用，请连接");
			break;
		case SERVER_ERROR:
			ll_network.setVisibility(View.VISIBLE);
			sdk_connected_error.setVisibility(View.VISIBLE);
			sdk_connecting.setVisibility(View.GONE);
			sdk_status_text.setText("服务不可用，请点击连接");
			ll_network.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					updateSdkStatusUI(SDK_CONNECTING);
//					 链接服务器
					((IMChatActivity) getActivity()).connect();
				}
			});
			break;
		case SDK_CONNECTING:
			ll_network.setVisibility(View.VISIBLE);
			sdk_connected_error.setVisibility(View.GONE);
			sdk_connecting.setVisibility(View.VISIBLE);
			sdk_status_text.setText("正在连接，请稍后…");
			break;
		case NET_CNNECT:
		case CONNECT_SUCCESS:
			ll_network.setVisibility(View.GONE);
			break;
		default:
			break;
		}
	}

	private int status;

	public void handSdkStatus(int status) {
		Log.i(TAG, "handSdkStatus status = " + status);
		Message message = mHandler.obtainMessage();
		message.what = 2;
		message.obj = status;
		this.status = status;
		mHandler.sendMessage(message);
	}

	@Override
	public void notify(int sdkStatus) {
		handSdkStatus(sdkStatus);
	}

	/**
	 * 添加会话到会话集合
	 * 
	 * @param cinfo
	 */
	private void addConvertInfo(ConversationInfo cinfo) {
		if (cinfo.getCategoryId() == CategoryId.GROUP) {
			List<GroupBean> groups = RestTools.getGroupInfo();
			if (groups != null) {
				for (GroupBean group : groups) {
					if (cinfo.getTargetId().equals(group.getGroupID())
							&& !group.getGroupName().equals(
									cinfo.getConversationTitle())) {
						cinfo.setConversationTitle(group.getGroupName());
					}
				}
			}
		} else if (cinfo.getCategoryId() == CategoryId.PERSONAL) {
			String title = ContactTools.getConTitle(cinfo.getTargetId());
			if (!TextUtils.isEmpty(title)) {
				cinfo.setConversationTitle(title);
			}
		}
		synchronized (conversationLists) {
			conversationLists.add(topNum, cinfo);
			// 排序
			Collections.sort(conversationLists,
					new Comparator<ConversationInfo>() {
						public int compare(ConversationInfo lhs,
								ConversationInfo rhs) {
							int result = 0;
							if (lhs.getLastTime() == rhs.getLastTime()) {
								result = 0;
							} else if (lhs.getLastTime() > rhs.getLastTime()) {
								result = -1;
							} else {
								result = 1;
							}
							return result;
						}
					});
			adapter.notifyDataSetChanged();
		}
	}

	/**
	 * 根据会话在会话集合里面找到相同会话Id的会话
	 * 
	 * @param cinfo
	 * @return
	 */
	private ConversationInfo getInfo(ConversationInfo cinfo) {
		ConversationInfo info = null;
		List<ConversationInfo> clists = new ArrayList<ConversationInfo>();
		clists.addAll(conversationLists);
		// 为群组会话设置title
		synchronized (conversationLists) {
			for (ConversationInfo conversation : clists) {
				if (conversation.getTargetId().equals(cinfo.getTargetId())) {
					info = conversation;
					// 当群主title为空的时候更新title
					if (info.getCategoryId() == CategoryId.GROUP
							&& TextUtils.isEmpty(info.getConversationTitle())) {
						List<GroupBean> groups = RestTools.getGroupInfo();
						if (null != groups) {
							for (GroupBean group : groups) {
								if (info.getTargetId().equals(
										group.getGroupID())
										&& !group.getGroupName().equals(
												info.getConversationTitle())) {
									info.setConversationTitle(group
											.getGroupName());
								}
							}
						}
					}
					break;
				}
			}
		}
		return info;
	}

	@Override
	public void onUpdateConversation(List arg0) {
		// 遍历回调集合，区分是更新还是增加会话
		if (arg0 == null || arg0.size() <= 0) {
			CustomLog.e("onUpdateConversation lists size == 0 ?");
			return;
		}
		List<ConversationInfo> infos = (List<ConversationInfo>) arg0;
		Log.i(TAG, "onUpdateConversation size = " + arg0.size());

		Message message = mHandler.obtainMessage();
		message.obj = infos;
		message.what = HANDLER_UPDATE_CONVERSATION;
		mHandler.sendMessage(message);
	}
}
