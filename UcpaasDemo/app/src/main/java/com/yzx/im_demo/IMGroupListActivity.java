package com.yzx.im_demo;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yzx.im_demo.userdata.GroupBean;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.RestTools;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxtcp.tools.CustomLog;

public class IMGroupListActivity extends Activity{
	
	private ListView conversationlist;
	private ImageView mImvNoMsg;
	private YzxTopBar yzxTopBar;
	private GroupListAdapter adapter;
	
	private List<GroupBean> groups;
	private String title;
	private RelativeLayout imgBackBtn;
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversationlist);

		groups = new ArrayList<GroupBean>();
		if(RestTools.getGroupInfo() != null && RestTools.getGroupInfo().size() > 0){
			groups.addAll(RestTools.getGroupInfo());
		}
		initView();
		imgBackBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	private void initView() {
		yzxTopBar = (YzxTopBar) findViewById(R.id.yzx_topbar);
		yzxTopBar.setTitle("群组列表");
		yzxTopBar.setVisibility(View.VISIBLE);
	    conversationlist = (ListView) findViewById(R.id.conversationlist);
	    mImvNoMsg = (ImageView)findViewById(R.id.id_conv_nomsg);
	    adapter = new GroupListAdapter(this,groups);
	    conversationlist.setAdapter(adapter);
	    conversationlist.setDivider(null);
	    imgBackBtn = (RelativeLayout) findViewById(R.id.imbtn_back);
	}

	@Override
    public void onPause() {
        super.onPause();
    }
    
    class GroupListAdapter extends BaseAdapter{
    	private LayoutInflater mInflater;
    	
		public GroupListAdapter(Context context,List<GroupBean> groups) {
			mInflater = LayoutInflater.from(context);
			if(groups.size() > 0){
				mImvNoMsg.setVisibility(View.GONE);
			}
		}
		public void notifyDataSetChanged() {
			super.notifyDataSetChanged();
		}
		
		@Override
		public int getCount() {
			return groups.size();
		}


		@Override
		public Object getItem(int position) {
			return groups.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder = null;
			final GroupBean group = groups.get(position);
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
				public void onClick(View arg0) {
					ConversationInfo info = getConversationInfoByGroupId(group.getGroupID());
					if(info == null){
						CustomLog.d("群组会话不存在，创建 ConversationInfo = null");
						info = new ConversationInfo();
						info.setTargetId(group.getGroupID());
						info.setCategoryId(CategoryId.GROUP);
						info.setConversationTitle(group.getGroupName());
					}
					Intent intent = new Intent(IMGroupListActivity.this, IMMessageActivity.class);
					intent.putExtra("conversation", info);
					startActivity(intent);
				}		
			});
			viewHolder.conversation_head.setBackgroundResource(R.drawable.persones);
			title = group.getGroupName();
			viewHolder.conversation_name.setText(title);
			
			return convertView;
		}
		
		class ViewHolder{
			RelativeLayout conversation_rl;
			ImageView conversation_head;
			TextView conversation_name;
		}	
	}
    
    private ConversationInfo getConversationInfoByGroupId(String id){
    	List<ConversationInfo> conversations = IMManager.getInstance(this).getConversationList(CategoryId.GROUP);
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
