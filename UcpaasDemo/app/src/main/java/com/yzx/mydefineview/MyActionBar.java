package com.yzx.mydefineview;

import com.yzx.im_demo.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyActionBar extends RelativeLayout {

	private LayoutInflater layoutInflater;
	private View myView;
	private TextView tvTitle;
	private ImageButton imSearch, imAdd;
	
	public MyActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		layoutInflater = LayoutInflater.from(context);
		myView = layoutInflater.inflate(R.layout.view_imchat_topbar, null);
		tvTitle = (TextView)myView.findViewById(R.id.tv_actionbar);
		imSearch = (ImageButton)myView.findViewById(R.id.im_actionbar_search);
		imAdd = (ImageButton)myView.findViewById(R.id.im_actionbar_add);
		
		addView(myView);
	}

	public void setTitle(String title){
		tvTitle.setText(title);
	}
}
