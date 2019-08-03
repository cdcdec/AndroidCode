package com.yzx.mydefineview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzx.im_demo.R;

public class MainBottomBar extends LinearLayout {

	private LayoutInflater mLayoutInflater;
	private View mBottomView;
	private ImageView mIvNormal,mIvSelect;
	private TextView mTvNormal, mTvSelect;
	private int mTextSize;
	private String mText;
	private int mTextNormalColor,mTextSelectColor;
	private BitmapDrawable mNormalDrawable, mSelectDrawable;
	
	public MainBottomBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mLayoutInflater = LayoutInflater.from(context);
		mBottomView = mLayoutInflater.inflate(R.layout.main_bottom_layout, null);
		
		mIvNormal = (ImageView)mBottomView.findViewById(R.id.id_iv_normal);
		mIvSelect = (ImageView)mBottomView.findViewById(R.id.id_iv_select);
		mTvNormal = (TextView)mBottomView.findViewById(R.id.id_tv_tab_normal);
		mTvSelect = (TextView)mBottomView.findViewById(R.id.id_tv_tab_select);
		
		
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.ChangeColorIconView);

		int n = a.getIndexCount();
		for (int i = 0; i < n; i++)
		{

			int attr = a.getIndex(i);
			switch (attr)
			{
			case R.styleable.ChangeColorIconView_normal_icon:
				mNormalDrawable = (BitmapDrawable) a.getDrawable(attr);
				break;
			case R.styleable.ChangeColorIconView_select_icon:
				mSelectDrawable = (BitmapDrawable) a.getDrawable(attr);
				break;
			case R.styleable.ChangeColorIconView_text_normal_color:
				mTextNormalColor = a.getColor(attr, 0xff797979);
				break;
			case R.styleable.ChangeColorIconView_text_select_color:
				mTextSelectColor = a.getColor(attr, 0x0046ac5e);
				break;
			case R.styleable.ChangeColorIconView_text:
				mText = a.getString(attr);
				break;
			case R.styleable.ChangeColorIconView_text_size:
				mTextSize = (int) a.getDimension(attr, TypedValue
						.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15,
								getResources().getDisplayMetrics()));
				DisplayMetrics dm = this.getResources().getDisplayMetrics();
				mTextSize = (int) (mTextSize/dm.density);

				break;

			}
		}

		a.recycle();
		
		setImageViewNormalResour(mNormalDrawable);
		setImageViewSelectResour(mSelectDrawable);
		setTextViewText(mText);
		setTextViewNormalColor(mTextNormalColor);
		setTextViewSelectColor(mTextSelectColor);
		setTextViewTextSize(mTextSize);
		setBottomViewNormalAlpha(1.0f);
		
		addView(mBottomView);
	}

	/**
	 * 
	 * @author zhangbin
	 * @2015-5-9
	 * @@param resId
	 * @descript:设置图片资源
	 */
	public void setImageViewNormalResour(int resId){
		mIvNormal.setImageResource(resId);
	}
	
	public void setImageViewNormalResour(Drawable drawable){
		mIvNormal.setImageDrawable(drawable);
	}
	
	public void setImageViewSelectResour(int resId){
		mIvSelect.setImageResource(resId);
	}
	
	public void setImageViewSelectResour(Drawable drawable){
		mIvSelect.setImageDrawable(drawable);
	}
	
	public void setTextViewText(String text){
		mTvNormal.setText(text);
		mTvSelect.setText(text);
	}
	
	public void setTextViewTextSize(float textsize){
		mTvNormal.setTextSize(textsize);
		mTvSelect.setTextSize(textsize);
	}
	
	public void setTextViewNormalColor(int color){
		mTvNormal.setTextColor(color);
	}
	
	
	public void setTextViewSelectColor(int color){
		mTvSelect.setTextColor(color);
	}
	//设置透明度
	@SuppressLint("NewApi")
	public void setBottomViewNormalAlpha(float alp){
		mIvNormal.setAlpha(alp);
		mIvSelect.setAlpha(1-alp);
		mTvNormal.setAlpha(alp);
		mTvSelect.setAlpha(1-alp);
	}
}
