package com.yzx.mydefineview;

import com.yzxtcp.tools.CustomLog;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


/**
 * 监听软键盘变化RelativeLayout布局
 * @author zhuqian
 *
 */
public class ResizeRelativeLayout extends RelativeLayout {
	
	private OnSizeChangeListener mOnSizeChangeListener;
	

	public void setmOnSizeChangeListener(OnSizeChangeListener mOnSizeChangeListener) {
		this.mOnSizeChangeListener = mOnSizeChangeListener;
	}

	public ResizeRelativeLayout(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public ResizeRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		//第一次被调用时，原高度为0
		if(oldh != 0){
			if(mOnSizeChangeListener != null){
				mOnSizeChangeListener.onSizeChange(h, oldh);
			}
		}
		
		CustomLog.v("new h = "+h+",oldh="+oldh);
	}
	//高度变化监听
	public interface OnSizeChangeListener{
		void onSizeChange(int h,int oldh);
	}
}
