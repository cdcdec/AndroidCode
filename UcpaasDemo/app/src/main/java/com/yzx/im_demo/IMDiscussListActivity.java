package com.yzx.im_demo;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yzx.db.UserInfoDBManager;
import com.yzx.mydefineview.YzxTopBar;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxIM.data.db.DiscussionInfo;
import com.yzxtcp.tools.CustomLog;

public class IMDiscussListActivity extends Activity {
	
	private ListView conversationlist;
	private ImageView mImvNoMsg;
	private YzxTopBar yzxTopBar;
	private DiscusslistAdapter adapter;
	private Handler mHandler;
	private List<DiscussionInfo> discussionInfoLists = new ArrayList<DiscussionInfo>();
	private String title;
	private int pos=999999;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversationlist);

		initView();
        mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				switch(msg.what){
				case 1:
					adapter.notifyDataSetChanged();
					mImvNoMsg.setVisibility(View.GONE);
					break;
				}
			}
		};
		yzxTopBar.setBackBtnOnclickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		yzxTopBar.setInfoBtnOnclickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IMDiscussListActivity.this, IMFriendListActivity.class);
				Bundle data = new Bundle();
				ArrayList<String> list = new ArrayList<String>();
				list.add(UserInfoDBManager.getInstance().getCurrentLoginUser().getName());
				data.putStringArrayList("members",list);
				data.putString("title", "创建讨论组");
				intent.putExtras(data);
				startActivity(intent);
			}
		});
	}
	
	private void initView() {
		yzxTopBar = (YzxTopBar) findViewById(R.id.yzx_topbar);
		yzxTopBar.setTitle("讨论组列表");
		yzxTopBar.setVisibility(View.VISIBLE);
		yzxTopBar.setInfoVisibility(View.VISIBLE);
		yzxTopBar.setInfoBtnBackgroudResource(R.drawable.actionbar_add_icon);
		
	    conversationlist = (ListView) findViewById(R.id.conversationlist);
	    mImvNoMsg = (ImageView)findViewById(R.id.id_conv_nomsg);
	    adapter = new DiscusslistAdapter(this);
	    conversationlist.setAdapter(adapter);
	    conversationlist.setDivider(null);
	}

	@Override
	protected void onResume() {
		adapter.notifyDataSetChanged();
		super.onResume();
	}
	
	@Override
    public void onPause() {
        super.onPause();
    }
    
    class DiscusslistAdapter extends BaseAdapter{
    	private LayoutInflater mInflater;
    	private Context mContext;
		public DiscusslistAdapter(Context context) {
			mInflater = LayoutInflater.from(context);
			mContext=context;
			discussionInfoLists = IMManager.getInstance(context).getAllDiscussionInfos();
			if(discussionInfoLists.size() != 0){
				mImvNoMsg.setVisibility(View.GONE);
			}
		}
		
		public void notifyDataSetChanged() {
			discussionInfoLists = IMManager.getInstance(IMDiscussListActivity.this).getAllDiscussionInfos();
			if(discussionInfoLists.size() != 0){
				mImvNoMsg.setVisibility(View.GONE);
			}
			super.notifyDataSetChanged();
		}
		
		@Override
		public int getCount() {
			return discussionInfoLists.size();
		}


		@Override
		public Object getItem(int position) {
			return discussionInfoLists.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder = null;
			final DiscussionInfo cinfo = discussionInfoLists.get(position);
			if (null == convertView) {
				viewHolder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.listitem_group_discuss, null);
				viewHolder.conversation_rl = (RelativeLayout) convertView.findViewById(R.id.rl_conversation_item);
				viewHolder.conversation_head = (ImageView) convertView.findViewById(R.id.conversation_head);
				viewHolder.conversation_name = (TextView) convertView.findViewById(R.id.conversation_name);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			viewHolder.conversation_rl.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					ConversationInfo info = getConversationInfoByDisId(cinfo.getDiscussionId());
					if(info == null){
						CustomLog.d("讨论组会话不存在，创建 ConversationInfo = null");
						info = new ConversationInfo();
						info.setTargetId(cinfo.getDiscussionId());
						info.setCategoryId(CategoryId.DISCUSSION);
						info.setConversationTitle(cinfo.getDiscussionName());
					}
					Intent intent = new Intent(IMDiscussListActivity.this, IMMessageActivity.class);
					intent.putExtra("conversation", info);
					startActivity(intent);
				}		
			});
			viewHolder.conversation_head.setBackgroundResource(R.drawable.persons);
			title = cinfo.getDiscussionName();
			viewHolder.conversation_name.setText(title);
			return convertView;
		}
		
		class ViewHolder{
			RelativeLayout conversation_rl;
			ImageView conversation_head;
			TextView conversation_name;
		}	
	}
    
    private ConversationInfo getConversationInfoByDisId(String id){
    	List<ConversationInfo> conversations = IMManager.getInstance(this).getConversationList(CategoryId.DISCUSSION);
    	ConversationInfo tempInfo = null;
    	for(ConversationInfo info : conversations){
    		if(info.getTargetId().equals(id)){
    			tempInfo = info;
    			break;
    		}
    	}
    	return tempInfo;
    }
}
