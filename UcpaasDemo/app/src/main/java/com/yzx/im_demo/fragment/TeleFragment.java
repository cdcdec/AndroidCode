package com.yzx.im_demo.fragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.yzx.db.TelListsInfoDBManager;
import com.yzx.db.domain.TelListsInfo;
import com.yzx.im_demo.R;
import com.yzx.im_demo.adapter.TelListAdapter;
import com.yzx.im_demo.adapter.TelListAdapter.OnTelListListener;
import com.yzx.tools.UIDfineAction;
import com.yzxtcp.tools.CustomLog;

public class TeleFragment extends Fragment implements OnTelListListener {
	private static final String TAG = "TeleFragment";
	private View mView;
	private ListView tel_list;
	private LinearLayout ll_tel_nomsg,ll_haveMsg;
	private TelListAdapter telListApapter;
	private static List<TelListsInfo> telLists = new ArrayList<TelListsInfo>();
	private int topNum;//置顶会话的个数

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		CustomLog.i("teleFragment onAttach() ...");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CustomLog.i("teleFragment onCreate() ...");
		IntentFilter filter = new IntentFilter();
		filter.addAction(UIDfineAction.ACTION_TEL_LIST_DATA_UPDATE);
		getActivity().registerReceiver(receiver, filter);
	}

	private BroadcastReceiver receiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(
					UIDfineAction.ACTION_TEL_LIST_DATA_UPDATE)) {
				// initData();
				TelListsInfo listInfo = (TelListsInfo) intent
						.getSerializableExtra("listData");
				if (listInfo != null) {
					if (telLists != null && telLists.size() > 0) {
						Iterator<TelListsInfo> iterator = telLists.iterator();
						while (iterator.hasNext()) {
							TelListsInfo telListsInfo = iterator.next();
							if (listInfo.getTelephone().equals(
									telListsInfo.getTelephone())) {
								iterator.remove();
							}
						}
					}
					if(listInfo.getIsTop() == 1){
						telLists.add(0, listInfo);
					}else{
						telLists.add(topNum, listInfo);
					}
					// 如果记录多于100条，则删除较早的
					if (telLists.size() > 100) {
						telLists.remove(100);
					}
					if (ll_tel_nomsg != null) { //某些情况下teleFragment onCreateView()未执行，ll_tel_nomsg为空
					    ll_tel_nomsg.setVisibility(View.GONE);
					}
					if (telListApapter == null) {
						telListApapter = new TelListAdapter(telLists,
								getActivity());
						tel_list.setAdapter(telListApapter);
						tel_list.setDivider(null);
						telListApapter.setOnTelListListener(TeleFragment.this);
					}
					telListApapter.notifyDataSetChanged(telLists);
				}
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater
				.inflate(R.layout.tele_fragment_lists, container, false);
		CustomLog.i("teleFragment onCreateView() ...");
		telLists.clear();
		initData();
		initView();
		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		CustomLog.i("teleFragment onActivityCreated() ...");
	}

	@Override
	public void onStart() {
		super.onStart();
		CustomLog.i("teleFragment onStart() ...");
	}

	@Override
	public void onResume() {
		super.onResume();
		CustomLog.i("teleFragment onResume() ...");
		//解决系统日期变更后通话记录日期格式不自动更新的问题
		if (telListApapter != null) {
		    telListApapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		CustomLog.i("teleFragment onPause() ...");
	}

	@Override
	public void onStop() {
		super.onStop();
		CustomLog.i("teleFragment onStop() ...");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		CustomLog.i("teleFragment onDestroyView() ...");
	}

	@Override
	public void onDestroy() {
		if(receiver != null){
			getActivity().unregisterReceiver(receiver);
		}
		super.onDestroy();
		CustomLog.i("teleFragment onDestroy() ...");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		CustomLog.i("teleFragment onDetach() ...");
	}

	private void initData() {
		String loginPhone = getActivity().getSharedPreferences("YZX_DEMO", 1)
				.getString("YZX_ACCOUNT_INDEX", "");
		List<TelListsInfo> listsData = TelListsInfoDBManager.getInstance()
				.getAll(loginPhone);
		telLists.addAll(listsData);
		CustomLog.v(listsData.toString());
	}

	private void initView() {
		tel_list = (ListView) mView.findViewById(R.id.tel_list);
		ll_tel_nomsg = (LinearLayout) mView.findViewById(R.id.ll_tel_nomsg);
		ll_haveMsg = (LinearLayout) mView.findViewById(R.id.ll_haveMsg);
		if (telLists != null && telLists.size() != 0) {
			telListApapter = new TelListAdapter(telLists, getActivity());
			tel_list.setAdapter(telListApapter);
			tel_list.setDivider(null);
			ll_tel_nomsg.setVisibility(View.GONE);
			telListApapter.setOnTelListListener(this);
		}
		updateTopNum();
	}
	/**
	 * 更新置顶会话数量
	 */
	private void updateTopNum(){
		topNum = 0;
		if(telLists != null && telLists.size() > 0){
			for(TelListsInfo info : telLists){
				if(info.getIsTop() == 1){
					topNum ++;
				}
			}
		}else if(telLists != null || telLists.size() == 0){
			ll_tel_nomsg.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onUpdate() {
		//更新置顶会话数量
		updateTopNum();
	}
	
	@Override
	public void onDestroyOptionsMenu() {
		super.onDestroyOptionsMenu();
	}
}
