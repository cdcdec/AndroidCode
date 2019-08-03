package com.yzx.mydefineview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/**
 * 监听隐藏和显示的LinearLayout
 * @author h20rz22
 *
 */
public class YZXVisibleLinearLayout extends LinearLayout {
	
	private OnVisibilityChangedListener mOnVisibilityChangedListener;

	public void setmOnVisibilityChangedListener(
			OnVisibilityChangedListener mOnVisibilityChangedListener) {
		this.mOnVisibilityChangedListener = mOnVisibilityChangedListener;
	}
	public YZXVisibleLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	protected void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
		if(mOnVisibilityChangedListener != null){
			mOnVisibilityChangedListener.onVisibilityChanged(changedView, visibility);
		}
	}
	
	public interface OnVisibilityChangedListener{
		void onVisibilityChanged(View changedView, int visibility);
	}
}
