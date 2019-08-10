package com.yzx.im_demo.contact;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yzx.db.UserInfoDBManager;
import com.yzx.im_demo.IMDiscussListActivity;
import com.yzx.im_demo.IMGroupListActivity;
import com.yzx.im_demo.IMMessageActivity;
import com.yzx.im_demo.R;
import com.yzx.im_demo.contact.SideBar.OnTouchingLetterChangedListener;
import com.yzx.model.SortModel;
import com.yzx.mydefineview.MyListView;
import com.yzx.mydefineview.MyListView.OnRefreshListener;
import com.yzx.tools.ContactTools;
import com.yzx.tools.RestTools;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxtcp.tools.CustomLog;

/***
 * 通讯录
 */
public class ContactFrament extends Fragment {
	private MyListView sortListView;
	private SideBar sideBar;
	private TextView dialog;
	private SortAdapter adapter;
	private View mView;
	private String mLocalUser;
    private TextView group;
    private TextView chatroom;
    private TextView invite_tv;
    private Builder invite_dialog;
    private Dialog base_dialog;
    private LinearLayout mChatRoomView;
    private static final String TAG = ContactFrament.class.getSimpleName();
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mLocalUser = UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount();
		if(mLocalUser != null){
			System.out.println("mLocalUser:"+mLocalUser);
		}else{
			System.err.println("获取登陆账号失败");
		}
		mView = inflater.inflate(R.layout.fragment_contact, container, false);
		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(ContactTools.getSourceDateList().size()<1){
					ContactTools.initContacts(getActivity());
					mHandler.sendEmptyMessage(1);
				}
			}
		}).start();
	}
	
	 @SuppressLint("HandlerLeak")
	 public Handler mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				switch(msg.what){
					case 1:
						if(adapter!=null){
							adapter.updateListView(ContactTools.getSourceDateList()); 
						}
					break;
				}
			}
	 };
	 
	public void initView() {
		
		sideBar = (SideBar) mView.findViewById(R.id.sidrbar);
		dialog = (TextView) mView.findViewById(R.id.dialog);
		sideBar.setTextView(dialog);

		sideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {

				int position = adapter.getPositionForSection(s.charAt(0));
				if (position != -1) {
					sortListView.setSelection(position+2);
				}

			}
		});

		adapter = new SortAdapter(getActivity(), ContactTools.getSourceDateList());
		sortListView = (MyListView) mView.findViewById(R.id.country_lvcountry);
		sortListView.setTopRefresh(false);
		sortListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 这里要利用adapter.getItem(position)来获取当前position所对应的对象
				Log.e("men_jin","ContactFrament adapter 点击=进入,IMMessageActivity.class");
				Intent intent = new Intent(getActivity(), IMMessageActivity.class);
				ConversationInfo info = new ConversationInfo();
				CustomLog.e("position == "+position);
				if(position>=2){
					info.setConversationTitle(info.getTargetId());
					info.setTargetId(ContactTools.getSourceDateList().get(position-2).getId());
					info.setCategoryId(CategoryId.PERSONAL.ordinal());
					for(SortModel model:ContactTools.getSourceDateList()){
						if(info.getTargetId().equals(model.getId())){
							info.setConversationTitle(model.getName());
							break;
						}
					}
					intent.putExtra("conversation", info);
					startActivity(intent);
				}
			}
		});
		
		sortListView.setonRefreshListener(new OnRefreshListener() {  
			  
            @Override  
            public void onRefresh() {  
                new AsyncTask<Void, Void, Void>() {  
                    protected Void doInBackground(Void... params) { 
                    	try {  
                            Thread.sleep(2000);  
                        } catch (Exception e) {  
                            e.printStackTrace();  
                        } 
                        ContactTools.initContacts(getActivity()); 
                        RestTools.queryGroupInfo(getActivity(),mLocalUser,null);            
                        return null;  
                    }  
  
                    @Override  
                    protected void onPostExecute(Void result) {  
                    
                        adapter.updateListView(ContactTools.getSourceDateList());  
                        sortListView.onRefreshComplete();  
                    }  
                }.execute(null, null, null);  
            }  
        });  
	
		LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mChatRoomView = (LinearLayout) inflater.inflate(R.layout.chatroom_item, null);
		group = (TextView) mChatRoomView.findViewById(R.id.group);
		group.setCompoundDrawablePadding(dp2px(getActivity(),10));
		group.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getActivity(), IMGroupListActivity.class));
			}
		});
		
		chatroom = (TextView) mChatRoomView.findViewById(R.id.chatroom);
		chatroom.setCompoundDrawablePadding(dp2px(getActivity(),10));
		chatroom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getActivity(), IMDiscussListActivity.class));
			}
		});
		
		invite_tv = (TextView) mChatRoomView.findViewById(R.id.input_numbers);
		invite_tv.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View arg0) {
				base_dialog = new Dialog(getActivity(),R.style.basedialog);
				base_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				base_dialog.setContentView(R.layout.dialog_base);
				TextView tv= (TextView) base_dialog.findViewById(R.id.dialog_tv);
				tv.setText("输入你想要联系的用户账号");
				tv.setTextSize(16);
				final EditText et = (EditText) base_dialog.findViewById(R.id.dialog_et);
				et.setVisibility(View.VISIBLE);
				base_dialog.setOnShowListener(new DialogInterface.OnShowListener() {
					@Override
					public void onShow(DialogInterface dialog) {
						//在对话框显示之后弹出输入法
						InputMethodManager inputmanger = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
						inputmanger.toggleSoftInput(0,
								InputMethodManager.HIDE_NOT_ALWAYS);
					}
				});
				base_dialog.show();
				base_dialog.findViewById(R.id.dialog_tv_cencel)
					.setOnClickListener(new View.OnClickListener() {  
	                    public void onClick(View v) {  
	                    	//隐藏键盘
							InputMethodManager inputmanger = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
	            			inputmanger.hideSoftInputFromWindow(et.getWindowToken(), 0);
	                    	base_dialog.dismiss();
	                    }
					});
				base_dialog.findViewById(R.id.dialog_tv_sure)
					.setOnClickListener(new View.OnClickListener() {  
	                    @Override  
	                    public void onClick(View v) { 
	                    	if(!"".equals(et.getText().toString().trim())){
		                    	Intent intent = new Intent(getActivity(), IMMessageActivity.class);
		        				ConversationInfo info = new ConversationInfo();
		        				info.setTargetId(et.getText().toString().trim());
		        				info.setCategoryId(CategoryId.PERSONAL);
		        				info.setConversationTitle(info.getTargetId());
		        				intent.putExtra("conversation", info);
		        				startActivity(intent);
		        				//隐藏键盘
								InputMethodManager inputmanger = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		            			inputmanger.hideSoftInputFromWindow(et.getWindowToken(), 0);
		        				base_dialog.dismiss();
	                    	}
	                    }
					});
				}
		});
		
		sortListView.addHeaderView(mChatRoomView);
		sortListView.setAdapter(adapter);
	}
	
	public int dp2px(Context context, float dpVal)
	{
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dpVal, context.getResources().getDisplayMetrics());
	}
	
	public void dismissSideBarDialog(){
		if(null!=sideBar){
			sideBar.dimissDialog();
		}
	}
	
	public void resumeSortList(){
		if(sortListView != null){
			sortListView.onRefreshComplete();
		}else{
//			Toast.makeText(getActivity(), "MyListView is null", 0).show();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
}
