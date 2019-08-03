package com.yzx.im_demo;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yzx.model.SortModel;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.ContactTools;
import com.yzxIM.data.db.ConversationInfo;

public class IMMessageInfoActivity extends Activity{
	
	private List<String> memberlist = new ArrayList<String>();
	private ConversationInfo conversationinfo;
	private InfoAdapter adapter;
	private GridView mGridView;
	private TextView clear_msgs;
	private TextView selectbg_tv;
	private YzxTopBar yzxTopBar;
	private RelativeLayout ib_back;
	private AlertDialog dialog;
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("imMessageinfoActivity onCreate");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messageinfo);
		conversationinfo = (ConversationInfo) getIntent().getSerializableExtra("conversationinfo");
		memberlist.add(conversationinfo.getConversationTitle());
		initviews();
	}
	
	private void initviews() {
		yzxTopBar = (YzxTopBar) findViewById(R.id.yzx_topbar);
		yzxTopBar.setTitle("聊天信息");
		mGridView = (GridView) findViewById(R.id.info_list_gv);	
		adapter = new InfoAdapter();
		mGridView.setAdapter(adapter);
		selectbg_tv =  (TextView) findViewById(R.id.selectbg_tv);
		selectbg_tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				MainApplication.getInstance().targetId = conversationinfo.getTargetId();
				startActivityForResult(new Intent(IMMessageInfoActivity.this, IMMessageBgActivity.class),2);
			}
		});
		
		ib_back = (RelativeLayout)findViewById(R.id.imbtn_back);
		ib_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		clear_msgs = (TextView) findViewById(R.id.clear_msgs);
		clear_msgs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog = new AlertDialog.Builder(IMMessageInfoActivity.this).create(); 
				dialog.show();
				dialog.getWindow().setContentView(R.layout.dialog_base);
				TextView tv= (TextView) dialog.getWindow().findViewById(R.id.dialog_tv);
				tv.setText("确定清空该群的聊天记录吗？");
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
	                    	finish();
	                    }
					});
				}
		});
	}

	class InfoAdapter extends BaseAdapter{
		private List<String> showlist = new ArrayList<String>();
		public InfoAdapter() {
			showlist.addAll(memberlist);
			showlist.add("add");
		}
		
		public void addDbMessageAdapter(ConversationInfo conversationinfo) {
			super.notifyDataSetChanged();
		}
		
		public void notifyDataSetChanged() {
			showlist.clear();
			showlist.addAll(memberlist);
			showlist.add("add");
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
		public View getView(int position, View view, ViewGroup parent) {
			final String memberid = showlist.get(position);
			final HolderView hv ;

			if(view == null){
				hv = new HolderView();
				view = LayoutInflater.from(IMMessageInfoActivity.this).inflate(R.layout.listitem_member_info, null);
				hv.memberimage = (ImageView) view.findViewById(R.id.member_info_iv);
				hv.membername = (TextView) view.findViewById(R.id.member_info_tv);
				view.setTag(hv);
			}else{
				hv = (HolderView)view.getTag();
			}
			
			if("add".equals(memberid)){
				hv.membername.setVisibility(View.INVISIBLE);
				hv.memberimage.setBackgroundResource(R.drawable.add_member);
				hv.memberimage.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						 new AsyncTask<Void, Void, Void>() {  
			                    protected Void doInBackground(Void... params) { 
			                    	// 如果没有去获取数据，此初始化一次
			                    	if(ContactTools.getSourceDateList().size() == 0) {
			                    		ContactTools.initContacts(IMMessageInfoActivity.this); 
			                    	}
			                        return null;  
			                    }  
			  
			                    @Override  
			                    protected void onPostExecute(Void result) {  
									Intent intent = new Intent(IMMessageInfoActivity.this, IMFriendListActivity.class);
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
									data.putString("memberid", conversationinfo.getTargetId());
									data.putString("memberName", conversationinfo.getConversationTitle());
									data.putString("title", "创建讨论组");
									intent.putExtras(data);
									startActivity(intent);
									finish();
			                    }  
			                }.execute(null, null, null);  
					}
				});
			}else{
				hv.membername.setVisibility(View.VISIBLE);
				hv.memberimage.setBackgroundResource(R.drawable.person);
				hv.membername.setText(memberid);
			}
			return view;
		}
		
		class HolderView{
			ImageView memberimage;
			TextView membername;
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		setResult(RESULT_OK,data);
		finish();
	}
}
