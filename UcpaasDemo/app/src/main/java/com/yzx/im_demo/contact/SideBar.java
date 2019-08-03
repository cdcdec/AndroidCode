package com.yzx.im_demo.contact;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.yzx.im_demo.R;

public class SideBar extends View {
	private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
	public static String[] b = { "*","A", "B", "C", "D", "E", "F", "G", "H", "I",
		"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
		"X", "Y", "Z", "#" };
	private int choose = -1;
	private Paint paint = new Paint();

	private TextView mTextDialog;
	private DisplayMetrics dm = this.getResources().getDisplayMetrics();
	
	public void setTextView(TextView mTextDialog) {
		this.mTextDialog = mTextDialog;
	}

	public SideBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SideBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SideBar(Context context) {
		super(context);
	}

	/**
	 * 
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int height = getHeight();
		int width = getWidth(); 
		int singleHeight = height / b.length;
		int paintSize = (int) (12 * dm.density);
		for (int i = 0; i < b.length; i++) {
//			paint.setColor(Color.rgb(33, 65, 98));
			paint.setColor(Color.parseColor("#646464"));
//			 paint.setColor(Color.WHITE);
//			paint.setTypeface(Typeface.DEFAULT_BOLD);
			paint.setAntiAlias(true);
			paint.setTextSize(paintSize);
			
			if (i == choose) {
				paint.setColor(Color.parseColor("#e5e5e5"));
				paint.setFakeBoldText(true);
			}
			// 
			float xPos = width / 2 - paint.measureText(b[i]) / 2;
			float yPos = singleHeight * i + singleHeight;
			canvas.drawText(b[i], xPos, yPos, paint);
			paint.reset();
		}

	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		final int action = event.getAction();
		final float y = event.getY();// 镣瑰向y鍧愭爣
		final int oldChoose = choose;
		final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
		final int c = (int) (y / getHeight() * b.length);// 镣瑰向y鍧愭爣锟?锟斤拷镐婚佩搴︾殑姣斾緥*b鏁扮粍镄勯昵搴﹀氨绛変簬镣瑰向b涓殑涓暟.

		switch (action) {
		case MotionEvent.ACTION_UP:
			setBackgroundDrawable(new ColorDrawable(0x00000000));
			choose = -1;//
			invalidate();
			if (mTextDialog != null) {
				mTextDialog.setVisibility(View.INVISIBLE);
			}
			break;

		default:
			setBackgroundResource(R.drawable.sortlistview_sidebar_background);
			if (oldChoose != c) {
				if (c >= 0 && c < b.length) {
					if (listener != null) {
						listener.onTouchingLetterChanged(b[c]);
					}
					if (mTextDialog != null) {
						mTextDialog.setText(b[c]);
						mTextDialog.setVisibility(View.VISIBLE);
					}

					choose = c;
					invalidate();
				}
			}

			break;
		}
		return true;
	}

	public void dimissDialog(){
		if (mTextDialog != null) {
			mTextDialog.setVisibility(View.INVISIBLE);
		}
	}
	
	/**
	 * 
	 * 
	 * @param onTouchingLetterChangedListener
	 */
	public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
		this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
	}

	/**
	 * 
	 * 
	 * @author coder
	 * 
	 */
	public interface OnTouchingLetterChangedListener {
		public void onTouchingLetterChanged(String s);
	}

}