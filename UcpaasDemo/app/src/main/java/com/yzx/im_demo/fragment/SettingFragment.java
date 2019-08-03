package com.yzx.im_demo.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.gl.softphone.UGoAPIParam;
import com.gl.softphone.UGoManager;
import com.yzx.api.UCSCall;
import com.yzx.db.UserInfoDBManager;
import com.yzx.im_demo.IMLoginV2Activity;
import com.yzx.im_demo.R;
import com.yzx.im_demo.TransDataActivity;
import com.yzxIM.IMManager;
import com.yzxtcp.UCSManager;
import com.yzxtcp.tools.CustomLog;

public class SettingFragment extends Fragment implements OnClickListener,CompoundButton.OnCheckedChangeListener {

	private String mLocalUser;
	private View mView;

	private LinearLayout mUserInfo, mChangeAccount,mLLTcpTrans;
	private TextView mQuictAccount, mTvUser, mTvLocalUser,mTcpTrans,mAbout,mMaxRate,mMinRate;

	private String mUserName;
	private CheckBox mCheckBox702p;
	private SeekBar mSeekBarMax;
	private SeekBar mSeekBarMin;
	private SeekBarListener mSeekBarListener = new SeekBarListener();

	public SettingFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mView = inflater.inflate(R.layout.fragment_setting, container, false);

		mUserInfo = (LinearLayout) mView.findViewById(R.id.id_userinfo);
		mChangeAccount = (LinearLayout) mView
				.findViewById(R.id.id_textview_changeclient);
		mQuictAccount = (TextView) mView.findViewById(R.id.id_textView_quite);
		mTvUser = (TextView) mView.findViewById(R.id.id_textview_user);
		mTcpTrans = (TextView) mView.findViewById(R.id.id_textView_tcpTrans);
		mTvLocalUser = (TextView) mView
				.findViewById(R.id.id_textView_localUser);
		mLLTcpTrans =  (LinearLayout) mView.findViewById(R.id.ll_tcp_trans);
		mLLTcpTrans.setVisibility(View.GONE);
		mAbout = (TextView) mView.findViewById(R.id.id_textView_about);
		mCheckBox702p = (CheckBox)mView.findViewById(R.id.id_checkbox_720p);
		boolean b702p = getActivity().getSharedPreferences("YZX_DEMO_DEFAULT", 0).getBoolean("YZX_720P", false);
		mCheckBox702p.setChecked(b702p);
		mCheckBox702p.setOnCheckedChangeListener(this);
		
		mUserInfo.setOnClickListener(this);
		mTcpTrans.setOnClickListener(this);
		
		//视频最大和最小码率
		mSeekBarMax =  (SeekBar)mView.findViewById(R.id.seekBar_max);
		mSeekBarMax.setMax(1000);
		mSeekBarMax.setOnSeekBarChangeListener(mSeekBarListener);
		mSeekBarMin =  (SeekBar)mView.findViewById(R.id.seekBar_min);
		mSeekBarMin.setMax(1000);
		mSeekBarMin.setOnSeekBarChangeListener(mSeekBarListener);
		mMaxRate = (TextView) mView.findViewById(R.id.tv_max_rate_number);
		mMinRate = (TextView) mView.findViewById(R.id.tv_min_rate_number);
		updateRateSeekBar();

		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
	}

	private void initData() {
		mUserInfo.setOnClickListener(this);
		mChangeAccount.setOnClickListener(this);
		mQuictAccount.setOnClickListener(this);
		mAbout.setOnClickListener(this);

		mUserName = UserInfoDBManager.getInstance().getCurrentLoginUser()
				.getName();
		mLocalUser = UserInfoDBManager.getInstance().getCurrentLoginUser()
				.getAccount();
		if (mUserName != null) {
			mTvUser.setText(mUserName);
		} else {
			mTvUser.setText("");
		}
		if (mLocalUser != null) {
			mTvLocalUser.setText(mLocalUser);
		}
	}

	// 定长数组(9次单击的时间不能少于2.5秒)
	private final long[] mHits = new long[9];

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_userinfo:
			// 从后往前拷贝
			System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
			mHits[mHits.length - 1] = SystemClock.uptimeMillis();
			if (mHits[0] > 0) {
				// 九击事件
				// 重置mHits
				final long[] tempHits = new long[mHits.length];
				System.arraycopy(tempHits, 0, mHits, 0, mHits.length);
				if(mLLTcpTrans.getVisibility() == View.VISIBLE){
					mLLTcpTrans.setVisibility(View.GONE);
				}else{
					mLLTcpTrans.setVisibility(View.VISIBLE);
				}
			}

			if (mHits[mHits.length - 2] > 0 && (mHits[mHits.length - 1] - mHits[mHits.length - 2]) > 1500) {
				// 间隔太长，重置mHits
				final long[] tempHits = new long[mHits.length];
				System.arraycopy(tempHits, 0, mHits, 0, mHits.length);
			}
			break;
		case R.id.id_textView_tcpTrans:
			//数据透传
			CustomLog.e("启动数据透传页面");
			startActivity(new Intent(getActivity(),TransDataActivity.class));
			break;
		case R.id.id_textView_quite:
			final AlertDialog dialog = new AlertDialog.Builder(getActivity())
					.create();
			dialog.show();
			dialog.getWindow().setContentView(R.layout.dialog_base);
			TextView tv = (TextView) dialog.getWindow().findViewById(
					R.id.dialog_tv);
			tv.setText("是否退出当前账号");
			dialog.getWindow().findViewById(R.id.dialog_tv_cencel)
					.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
					});
			dialog.findViewById(R.id.dialog_tv_sure).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog.dismiss();
							UCSManager.disconnect();
							Intent intent = new Intent(getActivity(),
									IMLoginV2Activity.class);
							startActivity(intent);
							getActivity().finish();
						}
					});

			break;
		case R.id.id_textView_about:
			final AlertDialog dialogAbout = new AlertDialog.Builder(getActivity())
					.create();
			dialogAbout.show();
			dialogAbout.getWindow().setContentView(R.layout.dialog_base_version);
			TextView tvVersion = (TextView) dialogAbout.getWindow().findViewById(
					R.id.dialog_tv);
			String demoVersion = "";
			try {
				demoVersion = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
			tvVersion.setText("DEMO: v"+ demoVersion +"\n"
					+ "VOIP SDK: v1000.2.0.4_L.1\n"
					+ "IM SDK: "+IMManager.getInstance(getActivity()).getSDKVersion()+"\n"
					+ "TCP SDK: v3.0.6.4\n"
					+ "UGo: "+UGoManager.getInstance().pub_UGoGetVersion());
			dialogAbout.findViewById(R.id.dialog_tv_sure).setOnClickListener(
					new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dialogAbout.dismiss();
						}
					});
			break;
		default:
				break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(buttonView.getId() == R.id.id_checkbox_720p){
			getActivity().getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putBoolean("YZX_720P", isChecked).commit();
			UCSCall.set720pEnable(isChecked);
			updateRateSeekBar();
		}
	}
	
	//码率滑动条监听器
	private class SeekBarListener implements OnSeekBarChangeListener {
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			if (seekBar.getId() == R.id.seekBar_max) {
				mMaxRate.setText(progress+"");
			}
			else if (seekBar.getId() == R.id.seekBar_min) {
				mMinRate.setText(progress+"");
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
		}
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
            UCSCall.setVideoBitrate(Integer.valueOf(mMinRate.getText().toString()), Integer.valueOf(mMaxRate.getText().toString()), 0);
		}
	}
	
	/**
	 * @Description 更新码率滑动条
	 * @return void    返回类型 
	 * @date 2017年9月1日 上午11:22:06 
	 * @author zhj
	 */
	private void updateRateSeekBar() {
		UGoManager.getInstance().pub_UGoGetConfig(UGoAPIParam.ME_VIDEO_ENC_CFG_MODULE_ID,UGoAPIParam.getInstance().videoEncodeConfig, 0);
		mSeekBarMax.setProgress(UGoAPIParam.getInstance().videoEncodeConfig.usMaxBitrate);
		mSeekBarMin.setProgress(UGoAPIParam.getInstance().videoEncodeConfig.usMinBitrate);
	}
}
