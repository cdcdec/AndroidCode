package com.yzx.mydefineview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yzx.im_demo.R;

public class YzxTopBar extends RelativeLayout {

	private RelativeLayout imgBackBtn;
	private Button imgInfoBtn;
	private TextView  tvTitle;
	private TextView tvNumber;
	private LayoutInflater layoutInflater;
	private View myView;
	private LinearLayout ll_conver;
	private TextView tv_message;
	private TextView tv_tele;
	
	public YzxTopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		layoutInflater = LayoutInflater.from(context);
		myView = layoutInflater.inflate(R.layout.view_topbar,null);
		imgBackBtn = (RelativeLayout) myView.findViewById(R.id.imbtn_back);
		imgInfoBtn = (Button) myView.findViewById(R.id.imbtn_info);
		tvTitle = (TextView)myView.findViewById(R.id.tv_title);
		ll_conver = (LinearLayout) myView.findViewById(R.id.ll_conver);
		tv_message = (TextView) myView.findViewById(R.id.tv_message);
		tv_tele = (TextView) myView.findViewById(R.id.tv_tele); 
		tvNumber = (TextView) myView.findViewById(R.id.tv_number);
		addView(myView);
	} 
	
		//éè???′?á???￠êy
	public void setUnReadCount(int unreadcount){
		if(unreadcount <= 0){
			tvNumber.setVisibility(View.GONE);
		}else{
			tvNumber.setVisibility(View.VISIBLE);
			tvNumber.setText("消息("+unreadcount+")");
		}
	}
	
	public void setMessageBackgroudResource(int resid) {
		tv_message.setBackgroundResource(resid);
	}
	
	public void setTeleBackgroudResource(int resid) {
		tv_tele.setBackgroundResource(resid);
	}
	
	public void setMessageColor(int color) {
		tv_message.setTextColor(color);
	}
	
	public void setTeleColor(int color) {
		tv_tele.setTextColor(color);
	}
	
	public void setMessageOnclickListener(OnClickListener clickListener) {
		tv_message.setOnClickListener(clickListener);
	}
	
	public void setTeleOnclickListener(OnClickListener clickListener) {
		tv_tele.setOnClickListener(clickListener);
	}
	
	public void setTitle(String title){
		tvTitle.setText(title);
	}
	public void setTitleColor(String color){
		tvTitle.setBackgroundColor(Color.parseColor(color));
	}
	
	public void setTitleVisibility(int visibility) {
		tvTitle.setVisibility(visibility);
	}
	
	public void setBackBtnBackgroudResource(int resId) {  
		imgBackBtn.setBackgroundResource(resId);  
    }  
	
	public void setInfoBtnBackgroudResource(int resId) {  
		imgInfoBtn.setBackgroundResource(resId);  
    }  
	
	public void setBackVisibility(int visibility){
		imgBackBtn.setVisibility(visibility);
	}
	
	public void setInfoVisibility(int visibility) {  
		imgInfoBtn.setVisibility(visibility);  
    }  
	
	public void setBackBtnOnclickListener(OnClickListener clickListener){
		imgBackBtn.setOnClickListener(clickListener);
	}
	
	public void setInfoBtnOnclickListener(OnClickListener clickListener){
		imgInfoBtn.setOnClickListener(clickListener);
	}
	
	public void setLayoutBackgroudColor(String color){
		myView.setBackgroundColor(Color.parseColor(color));
	}
	
	public void setConverVisibility(int visibility) {
		ll_conver.setVisibility(visibility);
	}
}
