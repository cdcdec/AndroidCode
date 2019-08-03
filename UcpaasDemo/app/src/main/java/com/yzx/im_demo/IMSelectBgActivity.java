package com.yzx.im_demo;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yzx.db.ConversationBgDbManager;
import com.yzx.db.domain.ConversationBg;
import com.yzx.mydefineview.YzxTopBar;

public class IMSelectBgActivity extends Activity{
	
	private static final String TAG = "IMSelectBgActivity";
	private YzxTopBar yzxTopBar;
	private GridView mGridView;
	private SelectBgAdapter adapter;
	private Button select_bt;
	private RelativeLayout ib_back;
	private ArrayList<String> bglist = new ArrayList<String>();
	private int pos = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectbg);
		ConversationBg bg = ConversationBgDbManager.getInstance().getById(MainApplication.getInstance().targetId);
		String background = "";
		if(bg != null){
			background = bg.getBgPath();
		}
		if(background.equals("R.drawable.message_bg1")){
			pos = 0;
		}else if(background.equals("R.drawable.message_bg2")){
			pos = 1;
		}else if(background.equals("R.drawable.message_bg3")){
			pos = 2;
		}else if(TextUtils.isEmpty(background)){
			pos = -1;
		}else{
			pos = -1;
		}
		initView();
	}

	private void initView() {
		mGridView = (GridView) findViewById(R.id.info_list);
		adapter = new SelectBgAdapter();
		mGridView.setAdapter(adapter);
		
		yzxTopBar = (YzxTopBar)findViewById(R.id.yzx_topbar);
		yzxTopBar.setTitle("选择背景图");
		select_bt = (Button) findViewById(R.id.imbtn_info);
		select_bt.setBackgroundResource(R.drawable.topright_sure);
		select_bt.setText("使用");
		select_bt.setVisibility(View.VISIBLE);
		select_bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent resultData = new Intent();
				String path = "";
				switch(pos){
				case 0:
					path = "R.drawable.message_bg1";
					break;
				case 1:
					path = "R.drawable.message_bg2";
					break;
				case 2:
					path = "R.drawable.message_bg3";
					break;
				}
				resultData.putExtra("background", path);
				setResult(RESULT_OK, resultData);
				finish();
			}
		});
		
		ib_back = (RelativeLayout)findViewById(R.id.imbtn_back);
		ib_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	class SelectBgAdapter extends BaseAdapter{
		public SelectBgAdapter() {
			bglist.add(String.valueOf(R.drawable.select_bg1));
			bglist.add(String.valueOf(R.drawable.select_bg2));
			bglist.add(String.valueOf(R.drawable.select_bg3));
		}

		@Override
		public int getCount() {
			return bglist.size();
		}

		@Override
		public Object getItem(int position) {
			return bglist.get(position);
		}


		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View view, ViewGroup parent) {
			HolderView hv ;
			if(view == null){
				hv = new HolderView();
				view = LayoutInflater.from(IMSelectBgActivity.this).inflate(R.layout.listitem_selectbg, null);
				hv.selectbg = (ImageView) view.findViewById(R.id.select_bg);
				hv.selectbt = (ImageView) view.findViewById(R.id.select_bt);
				view.setTag(hv);
			}else{
				hv = (HolderView)view.getTag();
			}
			hv.selectbt.setVisibility(View.GONE);
			if(pos == position){
				hv.selectbt.setVisibility(View.VISIBLE);
			}
			
			hv.selectbg.setBackgroundResource(Integer.valueOf(bglist.get(position)));
			hv.selectbg.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					pos = position;
					notifyDataSetChanged();
				}
			});
			return view;
		}
		
		class HolderView{
			ImageView selectbg;
			ImageView selectbt;
		}
	};

	@Override
	protected void onResume() {
		super.onResume();
		ConversationBg bg = ConversationBgDbManager.getInstance().getById(MainApplication.getInstance().targetId);
		String background = "";
		if(bg != null){
			background = bg.getBgPath();
		}
		if(background.equals("R.drawable.message_bg1")){
			pos = 0;
		}else if(background.equals("R.drawable.message_bg2")){
			pos = 1;
		}else if(background.equals("R.drawable.message_bg3")){
			pos = 2;
		}else {
			pos= -1;
		}
	}
	
	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestroy()");
		super.onDestroy();
	}
}
