package com.yzx.mydefineview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yzx.db.UserInfoDBManager;
import com.yzx.db.UserSettingsDbManager;
import com.yzx.db.domain.UserSetting;
import com.yzx.im_demo.R;

public class SettingCheckItem extends FrameLayout implements
		OnCheckedChangeListener, OnClickListener{
	private LayoutInflater layoutInflater;
	private View mView;

	private RelativeLayout mLayoutVoice, mLayoutVibrator;
	private CheckBox mCkMsg, mCkVoice, mCkVibrator;
	private View mLine1, mLine2;
	private Context mContext;
	private UserSetting userSetting;
	
	private TextView id_text_msgnotify,id_text_vibrator,id_text_voice;
	
	public SettingCheckItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		layoutInflater = LayoutInflater.from(context);
		mView = layoutInflater.inflate(R.layout.setting_checkbox_items, null);

		mCkMsg = (CheckBox) mView.findViewById(R.id.id_checkbox_msgnotify);
		mCkVoice = (CheckBox) mView.findViewById(R.id.id_checkbox_voice);
		mCkVibrator = (CheckBox) mView.findViewById(R.id.id_checkbox_vibrator);
		
		id_text_msgnotify = (TextView) mView.findViewById(R.id.id_text_msgnotify);
		id_text_vibrator = (TextView) mView.findViewById(R.id.id_text_vibrator);
		id_text_voice = (TextView) mView.findViewById(R.id.id_text_voice);
		id_text_msgnotify.setOnClickListener(this);
		id_text_vibrator.setOnClickListener(this);
		id_text_voice.setOnClickListener(this);

		mLayoutVoice = (RelativeLayout)mView.findViewById(R.id.setting_layout_voice);
		mLayoutVibrator = (RelativeLayout)mView.findViewById(R.id.setting_layout_vibrator);
		mLine1 = (View) mView.findViewById(R.id.id_line1);
		mLine2 = (View) mView.findViewById(R.id.id_line2);

		mCkMsg.setOnCheckedChangeListener(this);
		mCkVoice.setOnCheckedChangeListener(this);
		mCkVibrator.setOnCheckedChangeListener(this);
		userSetting = UserSettingsDbManager.getInstance().getById(UserInfoDBManager.getInstance().getCurrentLoginUser().getAccount());
		if(userSetting!=null){
			mCkMsg.setChecked(userSetting.getMsgNotify() == 1 ? true : false);
			mCkVibrator.setChecked(userSetting.getMsgVitor() == 1 ? true : false);
			mCkVoice.setChecked(userSetting.getMsgVoice() == 1 ? true : false);
			if(userSetting.getMsgNotify() == 0){
				mLayoutVoice.setVisibility(View.GONE);
				mLayoutVibrator.setVisibility(View.GONE);
				mLine1.setVisibility(View.GONE);
				mLine2.setVisibility(View.GONE);
			}
		}
		addView(mView);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.id_checkbox_msgnotify:
			if (isChecked) {
				mLayoutVoice.setVisibility(View.VISIBLE);
				mLayoutVibrator.setVisibility(View.VISIBLE);
				mLine1.setVisibility(View.VISIBLE);
				mLine2.setVisibility(View.VISIBLE);
//				animatorStart();
			} else {
				mLayoutVoice.setVisibility(View.GONE);
				mLayoutVibrator.setVisibility(View.GONE);
				mLine1.setVisibility(View.GONE);
				mLine2.setVisibility(View.GONE);
//				animatorReset();
			}
			mView.invalidate();
			userSetting.setMsgNotify(isChecked ? 1 : 0);
			break;
		case R.id.id_checkbox_voice:
			userSetting.setMsgVoice(isChecked ? 1 : 0);
			break;
		case R.id.id_checkbox_vibrator:
			userSetting.setMsgVitor(isChecked ? 1 : 0);
			break;
		default:
			break;
		}
		UserSettingsDbManager.getInstance().update(userSetting);
	}

	@SuppressLint("NewApi")
	private void animatorStart() {
		ObjectAnimator
				.ofFloat(mLine1, "translationY", 0.0F, dp2px(mContext, 41))
				.setDuration(500).start();

		ObjectAnimator
				.ofFloat(mLayoutVoice, "translationY", 0.0F,
						dp2px(mContext, 40)).setDuration(500).start();

		ObjectAnimator
				.ofFloat(mLine2, "translationY", 0.0F, dp2px(mContext, 81))
				.setDuration(500).start();

		ObjectAnimator
				.ofFloat(mLayoutVibrator, "translationY", 0.0F,
						dp2px(mContext, 80)).setDuration(500).start();
	}

	@SuppressLint("NewApi")
	private void animatorReset() {
		ObjectAnimator
				.ofFloat(mLine1, "translationY", dp2px(mContext, 40), 0.0F)
				.setDuration(500).start();
		ObjectAnimator
				.ofFloat(mLayoutVoice, "translationY", dp2px(mContext, 40),
						0.0F).setDuration(500).start();
		ObjectAnimator
				.ofFloat(mLayoutVibrator, "translationY", dp2px(mContext, 80),
						0.0F).setDuration(500).start();
		ObjectAnimator
				.ofFloat(mLine2, "translationY", dp2px(mContext, 80), 0.0F)
				.setDuration(500).start();
	}

	private int dp2px(Context context, float dpVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dpVal, context.getResources().getDisplayMetrics());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_text_msgnotify:
			mCkMsg.setChecked(!mCkMsg.isChecked());
			break;
		case R.id.id_text_voice:
			mCkVoice.setChecked(!mCkVoice.isChecked());
			break;
		case R.id.id_text_vibrator:
			mCkVibrator.setChecked(!mCkVibrator.isChecked());
			break;
		default:
			break;
		}
	}
}
