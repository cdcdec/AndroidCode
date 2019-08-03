package com.yzx.mydefineview;

import android.content.Context;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.core.view.MotionEventCompat;
import com.yzx.listener.IOnSingleTouchListener;

/**
 * 
 * @author mwz
 * 
 */
public class YZXDragLinearLayout extends LinearLayout {
	private IOnSingleTouchListener onSingleTouchListener;
	private float mLastTouchX;
	private float mLastTouchY;
	int screenWidth;
	int screenHeight;
	private long lastTime = 0;

	public YZXDragLinearLayout(Context context) {
		super(context);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels - getStatusBarHeight();
	}

	public YZXDragLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels - getStatusBarHeight();
	}

	// The ‘active pointer’ is the one currently moving our object.
	private int INVALID_POINTER_ID = -1000;
	private int mActivePointerId = INVALID_POINTER_ID;

	public int getStatusBarHeight() {
		int result = 0;
		int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		int action = event.getAction() & MotionEvent.ACTION_MASK;
		// 为了使手指按在Button等可点击的控件上任可以滑动，需要拦截滑动事件
		// 并且为了使坐标准确，在此处记录按下的点
		switch (action) {
		case MotionEvent.ACTION_MOVE:
			return true;
		case MotionEvent.ACTION_DOWN:
			final int pointerIndex = MotionEventCompat.getActionIndex(event);
			mActivePointerId = MotionEventCompat.getPointerId(event, pointerIndex);

			final float x = MotionEventCompat.getX(event, pointerIndex);
			final float y = MotionEventCompat.getY(event, pointerIndex);

			// Remember where we started (for dragging)
			mLastTouchX = x;
			mLastTouchY = y;

			// Save the ID of this pointer (for dragging)
			mActivePointerId = MotionEventCompat.getPointerId(event, 0);
			mActivePointerId = MotionEventCompat.getPointerId(event, 0);
			return false;
		case MotionEvent.ACTION_UP:

			return true;
		}
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// Let the ScaleGestureDetector inspect all events.
		// mScaleDetector.onTouchEvent(ev);

		final int action = MotionEventCompat.getActionMasked(ev);
		switch (action) {
		case MotionEvent.ACTION_DOWN: {
			lastTime = System.currentTimeMillis();
			break;
		}

		case MotionEvent.ACTION_MOVE: {
			// Find the index of the active pointer and fetch its position
			final int pointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
			final float x = MotionEventCompat.getX(ev, pointerIndex);
			final float y = MotionEventCompat.getY(ev, pointerIndex);

			// Calculate the distance moved
			final float dx = x - mLastTouchX;
			final float dy = y - mLastTouchY;

			int left = (int) (getLeft() + dx);
			int top = (int) (getTop() + dy);
			int right = (int) (getRight() + dx);
			int bottom = (int) (getBottom() + dy);

			if (left < 0) {
				left = 0;
				right = left + getWidth();
			}
			if (right > screenWidth) {
				right = screenWidth;
				left = right - getWidth();
			}
			if (top < 0) {
				top = 0;
				bottom = top + getHeight();
			}
			if (bottom > screenHeight) {
				bottom = screenHeight;
				top = bottom - getHeight();
			}

			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
			layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 0);
			layoutParams.leftMargin = left;
			layoutParams.topMargin = top;
			setLayoutParams(layoutParams);
			invalidate();

			break;
		}

		case MotionEvent.ACTION_UP: {
			// 在up时判断是否按下和松手时间是否小于200ms来判断是否是单击事件
			long nowTime = System.currentTimeMillis();
			if (nowTime - lastTime < 200) {
				onSingleTouch();
				return true;
			}
			mActivePointerId = INVALID_POINTER_ID;
			break;
		}

		case MotionEvent.ACTION_CANCEL: {
			mActivePointerId = INVALID_POINTER_ID;
			break;
		}

		case MotionEvent.ACTION_POINTER_UP: {

			final int pointerIndex = MotionEventCompat.getActionIndex(ev);
			final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);

			if (pointerId == mActivePointerId) {
				// This was our active pointer going up. Choose a new
				// active pointer and adjust accordingly.
				final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
				mLastTouchX = MotionEventCompat.getX(ev, newPointerIndex);
				mLastTouchY = MotionEventCompat.getY(ev, newPointerIndex);
				mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
			}
			break;
		}
		}
		return true;
	}

	/**
	 * 单击
	 */
	public void onSingleTouch() {
		if (onSingleTouchListener != null) {
			onSingleTouchListener.onSingleTouch();
		}
	}

	public void setOnSingleTouchListener(IOnSingleTouchListener onSingleTouchListener) {
		this.onSingleTouchListener = onSingleTouchListener;
	}
}
